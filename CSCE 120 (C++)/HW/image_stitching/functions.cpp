#include <iostream>
#include <sstream>
#include <fstream>
#include <cmath>
#include "functions.h"

using namespace std;

void loadCorners(std::string filename, Corner imageCorners[MAX_CORNERS], unsigned int& numberOfCorners){
    // Read load corners file
    ifstream inFS;
    string temp;
    stringstream corners;
    int count = 0;
    bool empty = false;

    inFS.open(filename);
    if (!inFS.is_open()){
        throw runtime_error("Failed to open " + filename);
    }

    while (!empty){
        temp = "";
        inFS >> temp;
        if (temp == ""){
            empty = true;
            break;  
        }
        corners << temp << " ";

        //cout << "x: " << temp;

        temp = "";
        inFS >> temp;
        if (temp == ""){
            empty = true;
            break;  
        }
        corners << temp <<  " ";

        //cout << "y: " << temp;

        count ++;
    }

    numberOfCorners = count;
    if (numberOfCorners > MAX_CORNERS){
            throw runtime_error("Too many corners in " + filename);
        }

    for (unsigned int i = 0; i < numberOfCorners; i++){
        corners >> imageCorners[i].x;
        //cout << "x: " << imageCorners[i].x << " ";
        corners >> imageCorners[i].y;
        //cout << "y: " << imageCorners[i].y << " ";
    }
    
}

double errorCalculation(Pixel image1[][MAX_HEIGHT], const unsigned int width1, const unsigned int height1,
                      Corner image1corner,
                      Pixel image2[][MAX_HEIGHT], const unsigned int width2, const unsigned int height2,
                      Corner image2corner){
            
    // Error calculation
    int x1left = image1corner.x - (ERROR_NEIGHBORHOOD_SIZE / 2);
    unsigned int x1right = image1corner.x + (ERROR_NEIGHBORHOOD_SIZE / 2);
    int y1bottom = image1corner.y - (ERROR_NEIGHBORHOOD_SIZE / 2);
    unsigned int y1top = image1corner.y + (ERROR_NEIGHBORHOOD_SIZE / 2);

    int x2left = image2corner.x - (ERROR_NEIGHBORHOOD_SIZE / 2);
    unsigned int x2right = image2corner.x + (ERROR_NEIGHBORHOOD_SIZE / 2);
    int y2bottom = image2corner.y - (ERROR_NEIGHBORHOOD_SIZE / 2);
    unsigned int y2top = image2corner.y + (ERROR_NEIGHBORHOOD_SIZE / 2);

    //cout << x1left << " " << x1right << " " << y1top << " " << y1bottom << " " << x2left << " " << x2right << " " << y2top << " " << y2bottom;

    if(x1left < 0 || x1right > width1 || y1top > height1 || y1bottom < 0 || x2left < 0 || x2right > width2 || y2top > height2 || y2bottom < 0){
        return INFINITY;
    }

    double error_estimate = 0;
    //cout << "NEIGHBORHOOD SIZE: " << ERROR_NEIGHBORHOOD_SIZE << endl;

    for (unsigned int i = 0; i < ERROR_NEIGHBORHOOD_SIZE; i++){
        for (unsigned int j = 0; j < ERROR_NEIGHBORHOOD_SIZE; j++){
            error_estimate += abs(image1[x1left + j][y1top - i].r - image2[x2left + j][y2top - i].r);
            //cout << "red: " << image1[x1left + j][y1top - i].r - image2[x2left + j][y2top - i].r << endl;
            error_estimate += abs(image1[x1left + j][y1top - i].g - image2[x2left + j][y2top - i].g);
            //cout << "green: " << image1[x1left + j][y1top - i].g - image2[x2left + j][y2top - i].g << endl;
            error_estimate += abs(image1[x1left + j][y1top - i].b - image2[x2left + j][y2top - i].b);
            //cout << "blue: " << image1[x1left + j][y1top - i].b - image2[x2left + j][y2top - i].b << endl;
        }
    }

    return error_estimate;
}

void matchCorners(CornerPair matchedPairs[MAX_CORNERS], unsigned int &matched_count,
                  Pixel image1[][MAX_HEIGHT], const unsigned int width1, const unsigned int height1,
                  Corner image1corners[], unsigned int image1CornerCount,
                  Pixel image2[][MAX_HEIGHT], const unsigned int width2, const unsigned int height2,
                  Corner image2corners[], unsigned int image2CornerCount){

    // Greedy corner matching goes here
    int count = 0;
    for (unsigned int i = 0; i < image1CornerCount; i++){
        double minimum_error = INFINITY;
        int corner1;
        int corner2;
        double temp_error;
        for (unsigned int j = 0; j < image2CornerCount; j++){
            if (!image2corners[j].used){
                temp_error = errorCalculation(image1, width1, height1, image1corners[i], image2, width2, height2, image2corners[j]);
                if (temp_error < minimum_error){
                    minimum_error = temp_error;
                    corner1 = i;
                    corner2 = j;
                }
            }

            //cout << "i: " << i << " j: " << j << " temp: " << temp_error << " corner1: " << corner1 << " corner2: " << corner2 << " min: " << minimum_error << endl;
        }
        //cout << endl;
        
        if (minimum_error != INFINITY){
            matchedPairs[count].image1Corner = image1corners[corner1];
            matchedPairs[count].image2Corner = image2corners[corner2];
            matchedPairs[count].error = minimum_error;
            image2corners[corner2].used = true;
            count += 1;
        }
    }
    matched_count = count;
    //cout << "matched: " << matched_count << endl;
    for (unsigned int i = 0; i < matched_count; i++){
        //cout << "error: " << matchedPairs[i].error << " corner1: " << matchedPairs[i].image1Corner.x << " " << matchedPairs[i].image1Corner.y << " corner2: " << matchedPairs[i].image2Corner.x << " " << matchedPairs[i].image2Corner.y << endl;
    }
}

void mapCoordinates(const double H[3][3], unsigned int x, unsigned int y,
                    double& mapped_x, double& mapped_y){

    // Mapping function for this week
    double xprime = (H[0][0] * x) + (H[0][1] * y) + (H[0][2]);
    double yprime = (H[1][0] * x) + (H[1][1] * y) + (H[1][2]);
    double zprime = (H[2][0] * x) + (H[2][1] * y) + (H[2][2]);

    mapped_x = xprime / zprime;
    mapped_y = yprime / zprime;
}

void mergeImages( Pixel image1[][MAX_HEIGHT], unsigned int &width1, unsigned int &height1,
                  Pixel image2[][MAX_HEIGHT], const unsigned int width2, const unsigned int height2,
                  double H[3][3] ){
        
    // Similar to image scaling function from last week with some additional steps.
    double newx = 0;
    double newy = 0;
    Pixel I1_pixel;
    Pixel I2_pixel;
    bool I1_ib;
    bool I2_ib;
    for (unsigned int i = 0; i < MAX_WIDTH; i++){
        for (unsigned int j = 0; j < MAX_HEIGHT; j++){
            
            mapCoordinates(H, i, j, newx, newy);
            I1_ib= false;
            I2_ib= false;

            if (newx >= 0 && newx < width2 && newy >= 0 && newy < height2){
                I2_ib = true;
                I2_pixel = bilinear_interpolation(image2, width2, height2, newx, newy);
            }
            
            if (i < width1 && j < height1){
                I1_ib = true;
                I1_pixel = image1[i][j];
            }
            
            if (I1_ib && I2_ib){
                image1[i][j].r = (I1_pixel.r + I2_pixel.r) / 2.0;
                image1[i][j].g = (I1_pixel.g + I2_pixel.g) / 2.0;
                image1[i][j].b = (I1_pixel.b + I2_pixel.b) / 2.0;
            } else if (I2_ib){
                image1[i][j] = I2_pixel;
            } else if (I1_ib){
                image1[i][j] = I1_pixel;
            }
        }
    }
    width1 = MAX_WIDTH;
    height1 = MAX_HEIGHT;
}