# include "functions.h"
// add any includes

using std::cout, std::cin, std::endl, std::string;

void deobfuscate() {
    string str;
    string details;
    int index = 0;

    cout << "Please enter obfuscated sentence: ";
    cin >> str;
    cout << "Please enter deobfuscation details: ";
    cin >> details;

    for (unsigned int i = 0; i < details.size(); i++){
        int num = static_cast<int>(details[i]) - 48;
        index = index + num;
        str.insert(index, " ");
        index++;
    }
    
    cout << "Deobfuscated sentence: " << str << endl;
}

void wordFilter() {
    string str;
    string filter;
    cout << "Please enter the sentence: ";
    getline(cin, str);
    cout << "Please enter the filter word: ";
    cin >> filter;

    for (unsigned int i = 0; i < str.size() - filter.size() + 1; i++){
        if (str.substr(i, filter.size()) == filter){
            for(unsigned int j = i; j < i + filter.size(); j++){
                str.replace(j, 1, "#");
            }
        }
    }

    cout << "Filtered sentence: " << str << endl;
}

void passwordConverter() {
    // TODO
}

void wordCalculator() {
    // TODO

}

void palindromeCounter() {
    // TODO
}