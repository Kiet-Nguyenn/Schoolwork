#include <iostream>
#include <sstream>
#include <fstream>
#include <cmath>
#include "functions.h"

using namespace std;

// Copy code from last week for local run. Gradescope will use it's own copy

void loadImage(string filename, Pixel image[][MAX_HEIGHT], unsigned int& width, unsigned int& height) {
  // Reading file
  ifstream inFS;
  stringstream width_height;
  string fileType;
  string temp_width;
  string temp_height;


  inFS.open(filename);
  if (!inFS.is_open()){
    throw runtime_error("Failed to open " + filename);
  }

  inFS >> fileType;
  if (!(fileType == "P3" || fileType == "p3")){
    throw runtime_error("Invalid Type" + fileType);
  }

  inFS >> temp_width >> temp_height;
  for (unsigned int i = 0; i < temp_width.length(); i++){
    if (!isdigit(temp_width[i])){
      throw runtime_error("Invalid dimensions");
    }
  }
  for (unsigned int i = 0; i < temp_height.length(); i++){
    if (!isdigit(temp_height[i])){
      throw runtime_error("Invalid dimensions");
    }
  }
  width_height << temp_width + " " + temp_height;
  width_height >> width >> height;

  if (width > MAX_WIDTH || height > MAX_HEIGHT){
    throw runtime_error("Invalid dimensions");
  }

  short max_color_val;
  inFS >> max_color_val;

  for (unsigned int i = 0; i < height; i++){
    for (unsigned int j = 0; j < width; j++){
      stringstream rgb;
      string temp_r;
      string temp_g;
      string temp_b;
      short red = -1;
      short green = -1;
      short blue = -1;

      inFS >> temp_r >> temp_g >> temp_b;

      for (unsigned int i = 0; i < temp_r.length(); i++){
        if (!isdigit(temp_r[i])){
          throw runtime_error("Invalid color value");
        }
      }
      for (unsigned int i = 0; i < temp_g.length(); i++){
        if (!isdigit(temp_g[i])){
          throw runtime_error("Invalid color value");
        }
      }
      for (unsigned int i = 0; i < temp_b.length(); i++){
        if (!isdigit(temp_b[i])){
          throw runtime_error("Invalid color value");
        }
      }
      rgb << temp_r + " " + temp_g + " " + temp_b;
      rgb >> red >> green >> blue;

      if (red > max_color_val || red < 0 || green > max_color_val || green < 0 || blue > max_color_val || blue < 0){
        throw runtime_error("Invalid color value");
      }
      
      image[j][i].r = red;
      image[j][i].g = green;
      image[j][i].b = blue;
    }
  }  

  short remainder = -1;
  inFS >> remainder;
  if (remainder != -1){
    throw runtime_error("Too many values");
  }
}


void outputImage(string filename, Pixel image[][MAX_HEIGHT], unsigned int width, unsigned int height) {
  ofstream outFS; 

  outFS.open(filename);
  if (!outFS.is_open()){
    throw runtime_error("Failed to open " + filename);
  }

  outFS << "P3" << endl << width << " " << height << endl << "255" << endl;

  for (unsigned int i = 0; i < height; i++){
    for (unsigned int j = 0; j < width; j++){
      outFS << image[j][i].r << " " << image[j][i].g << " " << image[j][i].b << " ";
    }
  }
}


Pixel bilinear_interpolation(Pixel image[][MAX_HEIGHT], unsigned int width, unsigned int height, double x, double y) {
  unsigned int x_ceil = ceil(x);
  unsigned int x_floor = floor(x);
  unsigned int y_ceil = ceil(y);
  unsigned int y_floor = floor(y);
  short red;
  short green;
  short blue;

  //corner cases
  if (x_ceil == x_floor && y_ceil == y_floor){
    red = round(image[x_floor][y_floor].r);
    green = round(image[x_floor][y_floor].g);
    blue = round(image[x_floor][y_floor].b);
  }

  //edge cases
  //left and right
  else if (x_floor == x_ceil || x == width || x == 0){
    red = round(((y_ceil - y) * image[x_floor][y_floor].r) + ((y - y_floor) * image[x_floor][y_ceil].r));
    green = round(((y_ceil - y) * image[x_floor][y_floor].g) + ((y - y_floor) * image[x_floor][y_ceil].g));
    blue = round(((y_ceil - y) * image[x_floor][y_floor].b) + ((y - y_floor) * image[x_floor][y_ceil].b));
  }

  //top and bottom
  else if (y_floor == y_ceil || y == height || y == 0){
    red = round(((x_ceil - x) * image[x_floor][y_floor].r) + ((x - x_floor) * image[x_ceil][y_floor].r));
    green = round(((x_ceil - x) * image[x_floor][y_floor].g) + ((x - x_floor) * image[x_ceil][y_floor].g));
    blue = round(((x_ceil - x) * image[x_floor][y_floor].b) + ((x - x_floor) * image[x_ceil][y_floor].b));
    
    //cout << "P2: " << image[x_ceil][y_floor].r << "  P1: " << image[x_floor][y_floor].r << "  red: " << red << endl;
    //cout << "P2: " << image[x_ceil][y_floor].g << "  P1: " << image[x_floor][y_floor].g << "  green: " << green << endl;
    //cout << "P2: " << image[x_ceil][y_floor].b << "  P1: " << image[x_floor][y_floor].b << "  blue: " << blue << endl;

  }

  //middle interpolation
  //red
  else {
    double i1r = ((x - x_floor) * image[x_ceil][y_floor].r) + ((x_ceil - x) * image[x_floor][y_floor].r);
    double i2r = ((x - x_floor) * image[x_ceil][y_ceil].r) + ((x_ceil - x) * image[x_floor][y_ceil].r);
    red = round(((y_ceil - y) * i1r) + ((y-y_floor) * i2r));
    //green
    double i1g = ((x - x_floor) * image[x_ceil][y_floor].g) + ((x_ceil - x) * image[x_floor][y_floor].g);
    double i2g = ((x - x_floor) * image[x_ceil][y_ceil].g) + ((x_ceil - x) * image[x_floor][y_ceil].g);
    green = round(((y_ceil - y) * i1g) + ((y-y_floor) * i2g));
    //blue
    double i1b = ((x - x_floor) * image[x_ceil][y_floor].b) + ((x_ceil - x) * image[x_floor][y_floor].b);
    double i2b = ((x - x_floor) * image[x_ceil][y_ceil].b) + ((x_ceil - x) * image[x_floor][y_ceil].b);
    blue = round(((y_ceil - y) * i1b) + ((y-y_floor) * i2b));
  }

  Pixel result;
  result.r = red;
  result.g = green;
  result.b = blue;
  return result;
}

