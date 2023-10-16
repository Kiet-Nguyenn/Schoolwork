#include <iostream>
#include "cstring.h"

unsigned int length(char str[]) {
  // returns the length of the string including zero (0)
  int count = 0;
  while (str[count] != '\0') {
    count++;
  }
  
  return count;
}

unsigned int find(char str[], char character) {
  // returns 
  //  - the index of the first occurence of character in str
  //  - the size if the character is not found
  int index = 0;
  while (str[index] != character && str[index] != '\0') {
    index++;
  }

  return index;
}

bool equalStr(char str1[], char str2[]) {
  // returns true if they are equal and false if they are not
  bool same = true;
  int count = 0;
  while (same && (str1[count] != '\0' || str2[count] != '\0')) {
    if (str1[count] != str2[count]) {
      same = false;
    } else {
      count++;
    }
  }

  return same;
}