// TODO: Implement this header file
#ifndef filename
#define filename
# include <iostream>

class MyString {
    private:
        size_t len;
        size_t cap;
        char* str;

    public:
        MyString();
        MyString(const MyString& other);
        MyString (const char* s);
        ~MyString();
        void resize (size_t num);
        size_t capacity() const;
        size_t size() const;
        size_t length() const;
        const char* data() const;
        bool empty() const;
        const char& front() const;
        const char& at (size_t pos) const;
        void clear();
        friend std::ofstream& operator<<(std::ostream& os, const MyString& str);
        MyString& operator=(const MyString& other);
        MyString& operator+= (const MyString& str);
        size_t find(const MyString& str, size_t pos = 0) const;
};

#endif
