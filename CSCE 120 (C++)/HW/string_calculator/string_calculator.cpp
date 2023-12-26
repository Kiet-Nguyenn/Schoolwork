#include <iostream>
#include <string>
#include "./string_calculator.h"

using std::cout, std::endl;
using std::string;

unsigned int digit_to_decimal(char digit) {
    unsigned int decimal = 0;
    if (static_cast<unsigned int>(digit) < 48 || static_cast<unsigned int>(digit) > 57){
        throw std::invalid_argument("");
    }
    decimal = static_cast<unsigned int>(digit) - 48;
    return decimal;
}

char decimal_to_digit(unsigned int decimal) {
    unsigned int int_digit = 0;
    if (decimal / 10 > 0){
        throw std::invalid_argument("");
    }
    int_digit = decimal + 48;
    char digit = static_cast<char>(int_digit);
    return digit;
}

string trim_leading_zeros(string num) {
    int i = 0;
    while (num[i] == '0'){
        i++;
    }
    string str = num.substr(i, num.size() -  i);
    if (str == ""){
        str = "0";
    }
    return str;
}

string add(string lhs, string rhs) {
    string trim_lhs = trim_leading_zeros(lhs);
    string trim_rhs = trim_leading_zeros(rhs);
    unsigned int carry = 0;
    string result = "";
    unsigned int size;

    //which side has more digits
    if (trim_lhs.size() > trim_rhs.size()){
        size = trim_lhs.size();
        string dummy_str = "";
        for (unsigned int i = trim_rhs.size(); i < size; i++){
            dummy_str += decimal_to_digit(carry);
        }
        trim_rhs.insert(0, dummy_str);
    } else {
        size = trim_rhs.size();
        string dummy_str = "";
        for (unsigned int i = trim_lhs.size(); i < size; i++){
            dummy_str += decimal_to_digit(carry);
        }
        trim_lhs.insert(0, dummy_str);
    }
    if (size == 0){
        trim_lhs = "0";
        trim_rhs = "0";
    }

    //set result size
    for (unsigned int i = 0; i < size; i++){
            result += "0";
    }
    

    //add
    for (int i = size - 1; i >= 0; i--){
        //cout << digit_to_decimal(trim_lhs[i]) << " + " << digit_to_decimal(trim_rhs[i]) << endl;
        string dummy_str = "";
        unsigned int temp_sum = digit_to_decimal(trim_lhs[i]) + digit_to_decimal(trim_rhs[i]) + carry;
        carry = temp_sum / 10;
        unsigned int num = temp_sum % 10;
        //cout << decimal_to_digit(num) << endl << decimal_to_digit(carry);
        dummy_str += decimal_to_digit(num);
        result.replace(i, 1, dummy_str);
    }
    if (carry > 0){
        string dummy_str = "";
        dummy_str += decimal_to_digit(carry);
        result.insert(0, dummy_str);
    }

    if (result == ""){
        result = "0";
    }
    return result;
}

string multiply(string lhs, string rhs) {
    string trim_lhs = trim_leading_zeros(lhs);
    string trim_rhs = trim_leading_zeros(rhs);
    unsigned int carry = 0;
    string default_result = "";
    unsigned int size;
    string power = "";

    //set size
    size = trim_lhs.size() * trim_rhs.size();
    if (size == 0){
        return 0;
    }

    //set result size
    for (unsigned int i = 0; i <= size; i++){
            default_result += "0";
    }
    string result = default_result;

    //multiply
    //nested for loop to multiply each digit
    for (int i = trim_lhs.size() - 1; i >= 0; i--){
        int place = result.size();
        string dummy_str = "";
        string temp_result = default_result;
        for (int j = trim_rhs.size() - 1; j >= 0; j--){
            unsigned int temp_product = (digit_to_decimal(trim_lhs[i]) * digit_to_decimal(trim_rhs[j])) + (carry);
            carry = temp_product / 10;
            unsigned int num = temp_product % 10;
            dummy_str += decimal_to_digit(num);
            temp_result.replace(place, 1, dummy_str);
            place--;
        }
    power += "0";
    //per lhs digit, add multiplication with all rhs
    result = add(result, temp_result.append(power)); 
    }

    if (carry > 0){
        string dummy_str = "";
        dummy_str += decimal_to_digit(carry);
        result.insert(0, dummy_str);
    } 

    return trim_leading_zeros(result);
}
