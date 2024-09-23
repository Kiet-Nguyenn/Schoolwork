#ifndef VECTOR_H
#define VECTOR_H

#include <algorithm> // std::random_access_iterator_tag
#include <cstddef> // size_t
#include <stdexcept> // std::out_of_range
#include <type_traits> // std::is_same

template <class T>
class Vector {
public:
    class iterator;
private:
    T* array;
    size_t _capacity, _size;

    // You may want to write a function that grows the vector
    void grow() {
        if (array != nullptr){
            int newCap = _capacity * 2;
            T* newArray = new T[newCap];
            for (size_t i = 0; i < _size; i++){
                newArray[i] = std::move(array[i]);
            }
            _capacity = newCap;
            delete[] array;
            array = newArray;
        } else {
            array = new T[1];
            _capacity = 1;
        }
    }

public:
    Vector() noexcept{
        array = nullptr;
        _size = 0;
        _capacity = 0;
    }
    Vector(size_t count, const T& value) {
        _capacity = count;
        _size = count;
        array = new T[_capacity];
        for (size_t i = 0; i < _size; i++){
            array[i] = value;
        }
    }
    explicit Vector(size_t count) {
        _capacity = count;
        _size = count;
        array = new T[_capacity];
        for (size_t i = 0; i < _size; i++){
            array[i] = T();
        }
    }
    Vector(const Vector& other) {
        this->_capacity = other._capacity;
        this->_size = other._size;
        array = new T[other._capacity];
        for(size_t i = 0; i < other._size; i++){
                array[i] = other.array[i];
        }
    }
    Vector(Vector&& other) noexcept {
        this->_capacity = other._capacity;
        this->_size = other._size;
        this->array = other.array;
        other.array = nullptr;
        other._capacity = 0;
        other._size = 0;
    }

    ~Vector() {
        delete[] array;
        _size = 0;
        _capacity = 0;
    }

    Vector& operator=(const Vector& other) {
        if (this == &other){
            return *this;
        }
        delete[] array;

        this->_capacity = other._capacity;
        this->_size = other._size;
        array = new T[_capacity];

        for (size_t i = 0; i < _size; i++){
            array[i] = other.array[i];
        }
        return *this;
    }
    Vector& operator=(Vector&& other) noexcept {
        if (this == &other){
            return *this;
        }
        
        delete[] array;
        this->_capacity = other._capacity;
        this->_size = other._size;
        array = other.array;
        other.array = nullptr;
        return *this;
    }

    iterator begin() noexcept {
        return iterator(array);
    }
    iterator end() noexcept {
        return iterator(array + _size);
    }

    [[nodiscard]] bool empty() const noexcept {
        if (_size == 0){
            return true;
        }
        return false;
    }
    size_t size() const noexcept {
        return _size;
    }
    size_t capacity() const noexcept {
        return _capacity;
    }

    T& at(size_t pos) {
        if (pos >= _size || pos < 0){
            throw std::out_of_range("");
        }
        return (array[pos]);
    }
    const T& at(size_t pos) const {
        if (pos >= _size || pos < 0){
            throw std::out_of_range("");
        }
        return (array[pos]);
    }
    T& operator[](size_t pos) {
        return array[pos];
    }
    const T& operator[](size_t pos) const {
        return array[pos];
    }
    T& front() {
        return array[0];
    }
    const T& front() const {
        return array[0];
    }
    T& back() {
        return array[_size - 1];
    }
    const T& back() const {
        return array[_size - 1];
    }

    void push_back(const T& value) {
        if(_size == _capacity){
            grow();
        }
        array[_size++] = value;
    }
    void push_back(T&& value) {
        if(_size == _capacity){
            grow();
        }
        array[_size++] = std::move(value);
    }
    void pop_back() {
        erase(end() - 1);
    }

    iterator insert(iterator pos, const T& value) {
        size_t offset = pos - begin();
        
        if(_size == _capacity){
            grow();
        }

        
        pos = begin() + offset;
        for(iterator i = end(); i != pos; --i){
            *i = std::move(*(i-1));
        }
        *pos = value;
        _size++;
        return pos;
    }
    iterator insert(iterator pos, T&& value) {
        size_t offset = pos - begin();

        if(_size == _capacity){
            grow();
        }

        
        pos = begin() + offset;
        for(iterator i = end(); i != pos; --i){
            *i = std::move(*(i-1));
        }
        *pos = std::move(value);
        _size++;
        return pos;
    }
    iterator insert(iterator pos, size_t count, const T& value) {
        /*
        if(_size + count >= _capacity){
            grow();
        }
        size_t offset_begin = pos - begin();
        size_t offset_end = offset_begin + count;
        pos = begin() + offset_end;
        for(iterator i = pos; i != begin() + offset_begin; i--){
            *i = *(i -= count);
        }

        for(iterator i = begin() + offset_begin; i != pos; i++){
            *i = value;
        }
        _size += count;
        return pos;
        */
        for (size_t i = 0; i < count; i++){
            pos = insert(pos, value);
        }
        return pos;
    }
    iterator erase(iterator pos) {
        for (iterator i = pos; i != (end()-1); i++){
            *i = std::move(*(i+1));
        }
        _size--;
        return pos;
    }
    iterator erase(iterator first, iterator last) {
        int diff = last - first;
        for (iterator i = first; i != (end() - diff); i++){
            *i = std::move(*(i + diff));
        }
        _size -= diff;
        return first;
    }

    class iterator {
    public:
        using iterator_category = std::random_access_iterator_tag;
        using value_type        = T;
        using difference_type   = ptrdiff_t;
        using pointer           = T*;
        using reference         = T&;
    private:
        // Points to some element in the vector (or nullptr)
        T* _ptr;

    public:
        iterator() : _ptr(nullptr) {}
        iterator(T* ptr) {
            _ptr = ptr;
        }

        // This assignment operator is done for you, please do not add more
        iterator& operator=(const iterator&) noexcept = default;

        [[nodiscard]] reference operator*() const noexcept {
            return *_ptr;
        }
        [[nodiscard]] pointer operator->() const noexcept {
            return _ptr;
        }

        // Prefix Increment: ++a
        iterator& operator++() noexcept {
            _ptr++;
            return *this;
        }
        // Postfix Increment: a++
        iterator operator++(int) noexcept {
            iterator val = *this;
            _ptr++;
            return val;
        }
        // Prefix Decrement: --a
        iterator& operator--() noexcept {
            _ptr--;
            return *this;
        }
        // Postfix Decrement: a--
        iterator operator--(int) noexcept {
            iterator val = *this;
            _ptr--;
            return val;
        }

        iterator& operator+=(difference_type offset) noexcept {
            _ptr += offset;
            return *this;
        }
        [[nodiscard]] iterator operator+(difference_type offset) const noexcept {
            iterator val = *this;
            val += offset;
            return val;
        }
        
        iterator& operator-=(difference_type offset) noexcept {
            _ptr -= offset;
            return *this;
        }
        [[nodiscard]] iterator operator-(difference_type offset) const noexcept {
            iterator val = *this;
            val -= offset;
            return val;
        }
        [[nodiscard]] difference_type operator-(const iterator& rhs) const noexcept {
            return (_ptr - rhs._ptr);
        }

        [[nodiscard]] reference operator[](difference_type offset) const noexcept {
            return *(_ptr + offset);
        }

        [[nodiscard]] bool operator==(const iterator& rhs) const noexcept {
            return _ptr == rhs._ptr;
        }
        [[nodiscard]] bool operator!=(const iterator& rhs) const noexcept {
            return _ptr != rhs._ptr;
        }
        [[nodiscard]] bool operator<(const iterator& rhs) const noexcept {
            return _ptr < rhs._ptr;
        }
        [[nodiscard]] bool operator>(const iterator& rhs) const noexcept {
            return _ptr > rhs._ptr;
        }
        [[nodiscard]] bool operator<=(const iterator& rhs) const noexcept {
            return _ptr <= rhs._ptr;
        }
        [[nodiscard]] bool operator>=(const iterator& rhs) const noexcept {
            return _ptr >= rhs._ptr;
        }
    };


    void clear() noexcept {
        delete[] array;
        array = nullptr;
        _size = 0;
    }
};

// This ensures at compile time that the deduced argument _Iterator is a Vector<T>::iterator
// There is no way we know of to back-substitute template <typename T> for external functions
// because it leads to a non-deduced context
namespace {
    template <typename _Iterator>
    using is_vector_iterator = std::is_same<typename Vector<typename _Iterator::value_type>::iterator, _Iterator>;
}

template <typename _Iterator, bool _enable = is_vector_iterator<_Iterator>::value>
[[nodiscard]] _Iterator operator+(typename _Iterator::difference_type offset, _Iterator const& iterator) noexcept {
    return (iterator + offset);
}

#endif
