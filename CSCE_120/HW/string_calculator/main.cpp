#include <iostream>
#include <string>
#include <limits>
#include "./string_calculator.h"

using std::cout, std::endl, std::cin;
using std::string;

int main() {
    cout << "String Calculator" << endl;
    cout << "\"q\" or \"quit\" or ctrl+d to exit" << endl;
    string input = "0";

    while (input != "q" || input != "quit"){
        getline(cin, input);
        if (input == "q" || input == "quit"){
            cout << endl << "farvel!" << endl << endl;
            break;
        }

        if (input.find("+") != string::npos){
            string lhs = input.substr(0, input.find(" "));
            string rhs = input.substr(input.find("+") + 2, input.size() - (input.find("+") + 2));
            cout << endl << "ans =" << endl << endl << "    " << add(lhs, rhs) << endl << endl;
        }

        if (input.find("*") != string::npos){
            string lhs = input.substr(0, input.find(" "));
            string rhs = input.substr(input.find("*") + 2, input.size() - (input.find("+") + 2));
            cout << endl << "ans =" << endl << endl << "    " << multiply(lhs, rhs) << endl << endl;
        }
    }
    
    
}

