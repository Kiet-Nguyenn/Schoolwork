// TODO: Implement this source file
# include "MyString.h"
# include <iostream>

    //default constructor 
    MyString::MyString() : len(0), cap(1), str{} {
        str = new char[1];
        str[0] = '\0';
    }

    //copy constructor
    MyString::MyString(const MyString& other) : len(0), cap(1), str{} {
        this->len = other.len;
        this->cap = other.cap;
        
        str = new char[cap];

        for (unsigned int i = 0; i < other.len; i++){
            this->str[i] = other.str[i];
        }
        str[len] = '\0';
    }

    //from c-string
    MyString::MyString (const char* s) : len(0), cap(1), str{} {
        int i = 0;
        while (s[i] != '\0'){
            i++;
        }

        len = i;
        cap = i + 1;
        
        str = new char[cap];

        for (unsigned int j = 0; j < len; j++){
            str[j] = s[j];
        }

        str[i] = '\0';
    }

    //destructor
    MyString::~MyString() {
        if (str != nullptr){
            delete[] str;
        }
        str = nullptr;
        len = 0;
        cap = 0;
    }

    //resize
    void MyString::resize (size_t num){
        char* tempstr = new char[num];
        cap = num;

        for (unsigned int i = 0; i < len; i++){
            tempstr[i] = str[i];
        }
        delete[] str;
        str = tempstr;
    }

    //capacity
    size_t MyString::capacity() const{
        return cap;
    }

    //size
    size_t MyString::size() const{
        return len;
    }  

    //length
    size_t MyString::length() const{
        return len;
    }

    //data
    const char* MyString::data() const{
        return str;
    }

    //empty
    bool MyString::empty() const{
        if (len == 0){
            return true;
        }
        return false;
    }

    //front
    const char& MyString::front() const{
        return str[0];
    }

    //at
    const char& MyString::at(size_t pos) const{
        if (pos >= len){
            throw std::out_of_range("");
        }
        if (len <= 0){
            throw std::out_of_range("");
        }

        return str[pos];
    }

    //clear
    void MyString::clear(){
        delete[] str;
        len = 0;
        str = new char[cap];
        str[0] = '\0';
    }

    //operator<<
    std::ofstream& operator<<(std::ostream& os, const MyString& str){
        for (size_t i = 0; i < str.length(); i++){
            os << str.str[i];
        }
        return os;
    }

    //operator=
    MyString& MyString::operator=(const MyString& other){
        this->len = other.len;
        this->cap = other.cap;
        delete[] this->str;
        str = new char[cap];
        for (unsigned int i = 0; i < other.cap; i++){
            this->str[i] = other.str[i];
        }

        return *this;
    }

    //operator+=
    MyString& MyString::operator+= (const MyString& str){
        cap = this->cap + str.cap - 1;
        char* tempstring = new char[this->cap];

        for(unsigned int i = 0; i < this->len; i++){
            tempstring[i] = this->str[i];
        }

        int j = 0;
        for(unsigned int i = this->len; i < this->cap; i++){
            tempstring[i] = str.str[j];
            j++;
        }

        this->len = cap - 1;
        tempstring[this->len] = '\0';

        delete[] this->str;
        this->str = tempstring;

        return *this;
    }

    //find
    size_t MyString::find(const MyString& str, size_t pos) const{
        if(pos >= len){
            return -1;
        }

        for (unsigned int i = 0; i < len; i++){
            if (pos >= len){
                int match = 0;
                for (unsigned int j = 0; j < str.len; j++){
                    if (i+j < len){
                        if (this->str[i+j] == str.str[j]){
                            match += 1;
                        }
                    }
                }

                if (match == str.len){
                    return i;
                }
            }
        }
        return -1;
    }


        //extra credit
        //operator==
        //bool MyString::operator==(const MyString& lhs, const MyString& rhs){}

        /*
        //operator+
        //MyString MyString::operator+ (const MyString& lhs, const MyString& rhs);


        //already provided
        //operator>>
        // helper function for insertion allows reading from input stream to MyString
        friend std::istream& operator>>(std::istream& is, MyString& str) {
        str.clear();
            while (!is.eof()) {
                char c;
                is >> std::noskipws >> c; // use the noskipws manipulator
                if (isspace(c) || is.fail()) break; // if whitespace, can stop adding to string
                const char* newstr = new char[2] {c, '\0'};
                MyString newc = MyString(newstr); // MyString: copy constructor
                delete[] newstr;
                str += newc; // MyString: operator+=()
            }
            return is;
        }
        
        //stoi
        // helper function "stoi" to converts MyString to int, works a lot like number slicing in reverse
        int stoi(const MyString& str) { // just doing base 10 here
        int result = 0;
        for (unsigned int i = 0; i < str.size(); i++) { // MyString: size()
            if (str.at(i) >= '0' && str.at(i) <= '9') { // MyString: at()
                result *= 10; // increase digit (reverse of number slicing)
                result += str.at(i) - 48; // using ascii for conversion
                }
            }
            return result;
        }
        */