#include <iostream>
using namespace std;

int count_digits(int input)
{
    if (input == 0) return 1;
    int number = input;
    int count = 0;
    if (number < 0) number = -number;
    for(;number > 0; count++){
        number = number / 10;
    }
    return count;
}

bool even_digit_count(int input)
{
    return (count_digits(input) % 2) == 0;
}

int main() {
    int input;
    cout << "Enter a number: ";
    cin >> input;
    cout << "  - Number of digits in " << input << " is " 
         << count_digits(input) << endl;
    cout << "  - Even number of digits in " << input << " ?"
         << (even_digit_count(input)? " True": " False") <<endl;
    cout << "Have a nice day!" << endl; 
}