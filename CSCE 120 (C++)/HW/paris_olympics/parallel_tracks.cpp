#include <iostream>
#include <iomanip>
#include <cstring>
#include "parallel_tracks.h"

using std::cin, std::cout, std::endl;

//-------------------------------------------------------
// Name: prep_double_array
// PreCondition:  an array of doubles is passed in
// PostCondition: data in the array is 'zeroed' out
//---------------------------------------------------------
void prep_double_array(double ary[])
// making sure all values within the array are set to 0.0;
{
  for (int i = 0; i < 9; i++){
	ary[i] = 0.0;
  }
}

//-------------------------------------------------------
// Name: prep_unsigned_int_array
// PreCondition:  an array of unsigned ints is passed in
// PostCondition: data in the array is 'zeroed' out
//---------------------------------------------------------
void prep_unsigned_int_array(unsigned int ary[])
// making sure all values within the array are set to 0;
{
  for (int i = 0; i < 9; i++){
	ary[i] = 0;
  }
}

//-------------------------------------------------------
// Name: prep_string_array
// PreCondition:  an array of strings is passed in
// PostCondition: each element in the array is set to "N/A"
//---------------------------------------------------------
void prep_string_array(char ary[][STRING_SIZE])
// making sure all values within the array are set to "N/A";
{
	for (int i = 0; i < 9; i++){
		ary[i][0] = 'N';
		ary[i][1] = '/';
		ary[i][2] = 'A';
		ary[i][3] = '\0';
    }
}

//-------------------------------------------------------
// Name: trim
// PreCondition:  the cstring
// PostCondition: whitespace has been removed from beginning and end of string
//---------------------------------------------------------
void trim(char str[STRING_SIZE]) {
	int initial = 0;
	int final = 0;
	int count = 0;

	for (unsigned int i = 0; i < STRING_SIZE; i++){
		if (str[i] != ' ' && str[i] != '\t'){
			initial = i;
			break;
		}
	}

	for (int i = STRING_SIZE - 1; i >= 0; i--){
		if (str[i] != ' ' && str[i] != '\t' && str[i] != '\0'){
			final = i;
			break;
		}
	}

	for (int i = initial; i <= final; i++){
		str[count] = str[i];
		count++;
	}
	str[count] = '\0';
}

//-------------------------------------------------------
// Name: get_runner_data
// PreCondition:  the prepped parallel arrays
// PostCondition: all arrays contain data from standard in
//---------------------------------------------------------
bool get_runner_data(double timeArray[], char countryArray[][STRING_SIZE], 
		unsigned int numberArray[], char lastnameArray[][STRING_SIZE]) 
{
  	for (unsigned int i = 0; i < SIZE; i++){
		double time;
		cin >> time;
		if (time <= 0){
			return false;
		}
		timeArray[i] = time;

		cin >> countryArray[i];
		if (countryArray[i][3] != '\0'){
			return false;
		}
		for (int j = 0; j < 3; j++){
			if(countryArray[i][j] < 65 || countryArray[i][j] > 90){
				return false;
			}
		}

		int number;
		cin >> number;
		if (number > 99 || number < 0){
			return false;
		}
		numberArray[i] = number;

		cin >> lastnameArray[i];
		trim(lastnameArray[i]);

		for(unsigned int j = 0; j < STRING_SIZE; j++){
			if (lastnameArray[i][j] == '\0'){
				break;
			}
			if(lastnameArray[i][j] < 65 || lastnameArray[i][j] > 122){
				if (lastnameArray[i][j] != ' '){
					return false;
				}
			}
			if (lastnameArray[i][j] > 90 && lastnameArray[i][j] < 97){
				if (lastnameArray[i][j] != ' '){
					return false;
				}
			}
		}

		if(lastnameArray[i][0] == '\0' || lastnameArray[i][1] == '\0'){
			return false;
		}

	}
  return true; // set so it will compile
}

//-------------------------------------------------------
// Name: get_ranking
// PreCondition:  just the time array is passed in, and has valid data
// PostCondition: after a very inefficient nested loop to determine the placements 
// and places the ranks in a new array. That new array is returned
//---------------------------------------------------------
void get_ranking(const double timeArray[], unsigned int rankArray[])
{
	double rankedTimes[SIZE];
	prep_double_array(rankedTimes);

	for(unsigned int time_i = 0; time_i < SIZE; time_i++){
		for(unsigned int rankTime_i = 0; rankTime_i < SIZE; rankTime_i++){
			//print
			// cout << "time_i = " << time_i << endl;
			// cout << "rankTime_i = " << time_i << endl;
			// 
			// cout << endl;

			// cout << "Before Change Ranked Times: " << endl;
			// for(int i = 0; i < SIZE; i++){
			// 	cout << rankedTimes[i] << " ";
			// }
			// cout << endl << "Ranks: " << endl;
			// for(int i = 0; i < SIZE; i++){
			// 	cout << rankArray[i] << " ";
			// }
			// cout << endl << endl;

			if(timeArray[time_i] < rankedTimes[rankTime_i] || rankedTimes[rankTime_i] == 0){
				for(unsigned int i = SIZE - 1; i > rankTime_i; i--){
					//rankArray[rankArray_i] = rankArray[rankArray_i - 1];
					rankedTimes[i] = rankedTimes[i - 1];
				}
				//rankArray[rankTime_i] = time_i;
				rankedTimes[rankTime_i] = timeArray[time_i];

								
				//print
				// cout << "After Change Ranked Times: ";
				// for(int i = 0; i < SIZE; i++){
				// 	cout << rankedTimes[i] << " ";
				// }
				// cout << endl << "Ranks: " << endl;
				// for(int i = 0; i < SIZE; i++){
				// 	cout << rankArray[i] << " ";
				// }
				// cout << endl;
				// cout << endl << endl;
				break;
			}
			// cout << endl << endl;
		}
		
	}
	// cout << "times: ";
	// for (unsigned int i = 0; i < SIZE; i++){
	// 	cout << timeArray[i] << " ";
	// }
	// cout << endl << "Ranks: " << endl;
	// 	for(unsigned int i = 0; i < SIZE; i++){
	// 	cout << rankArray[i] << " ";
	// }

	unsigned int tempRankArray[SIZE];
	prep_unsigned_int_array(tempRankArray);
	for(unsigned int i = 0; i < SIZE; i++){
		for(unsigned int j = 0; j < SIZE; j++){
			if(timeArray[i] == rankedTimes[j]){
				rankArray[i] = j + 1;
				break;
			}
		}
	}
}


//-------------------------------------------------------
// Name: print_results
// PreCondition:  all parallel arrays are passed in and have valid data
// PostCondition: after a very inefficient nested loop to determine the ranks
// it then displays them along with a delta in time from the start
//---------------------------------------------------------
void print_results(const double timeArray[], const char countryArray[][STRING_SIZE],
		const char lastnameArray[][STRING_SIZE], const unsigned int rankArray[])
{

	std::cout << "Final results!!";
	std::cout << std::setprecision(2) << std::showpoint << std::fixed << std::endl;
	double best_time = 0.0;
		
	// print the results, based on rank, but measure the time difference_type
	for(unsigned int j = 1; j <= SIZE; j++)
	{
		
		// go thru each array, find who places in "i" spot
		for(unsigned int i = 0; i < SIZE; i++)
		{
			if(rankArray[i] == 1) // has to be a better way, but need the starting time
			{
				best_time = timeArray[i];
			}
			
			
			if(rankArray[i] == j) // then display this person's data
			{
				// this needs precision display
				std::cout << "[" << j << "]  " << timeArray[i] << " " << std::setw(15) << std::left << lastnameArray[i] << "\t" << "(" << countryArray[i] << ")  +" << (timeArray[i] - best_time) << std::endl; 
			}
			
		}
	}	
}