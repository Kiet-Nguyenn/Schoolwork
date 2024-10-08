#pragma once

#include <cstddef> // size_t
#include <iterator> // std::bidirectional_iterator_tag
#include <type_traits> // std::is_same, std::enable_if

template <class T>
class List {
    private:
    struct Node {
        Node *next, *prev;
        T data;
        explicit Node(Node* prev = nullptr, Node* next = nullptr)
        : next{next}, prev{prev} {}
        explicit Node(const T& data, Node* prev = nullptr, Node* next = nullptr)
        : next{next}, prev{prev}, data{data} {}
        explicit Node(T&& data, Node* prev = nullptr, Node* next = nullptr)
        : next{next}, prev{prev}, data{std::move(data)} {}
    };

    template <typename pointer_type, typename reference_type>
    class basic_iterator {
    public:
        using iterator_category = std::bidirectional_iterator_tag;
        using value_type        = T;
        using difference_type   = ptrdiff_t;
        using pointer           = pointer_type;
        using reference         = reference_type;
    private:
        friend class List<value_type>;
        using Node = typename List<value_type>::Node;

        Node* node;

        explicit basic_iterator(Node* ptr) noexcept : node{ptr} {}
        explicit basic_iterator(const Node* ptr) noexcept : node{const_cast<Node*>(ptr)} {}

    public:
        basic_iterator() {node = nullptr;};
        basic_iterator(const basic_iterator&) = default;
        basic_iterator(basic_iterator&&) = default;
        ~basic_iterator() = default;
        basic_iterator& operator=(const basic_iterator&) = default;
        basic_iterator& operator=(basic_iterator&&) = default;

        reference operator*() const {
            return node->data;
        }
        pointer operator->() const {
            return &(node->data);
        }

        // Prefix Increment: ++a
        basic_iterator& operator++() {
            node = node->next;
            return *this;
        }
        // Postfix Increment: a++
        basic_iterator operator++(int) {
            basic_iterator val = *this;
            node = node->next;
            return val;
        }
        // Prefix Decrement: --a
        basic_iterator& operator--() {
            node = node->prev;
            return *this;
        }
        // Postfix Decrement: a--
        basic_iterator operator--(int) {
            basic_iterator val = *this;
            node = node->prev;
            return val;
        }

        bool operator==(const basic_iterator& other) const noexcept {
            return this->node == other.node;
        }
        bool operator!=(const basic_iterator& other) const noexcept {
            return this->node != other.node;
        }
    };

public:
    using value_type      = T;
    using size_type       = size_t;
    using difference_type = ptrdiff_t;
    using reference       = value_type&;
    using const_reference = const value_type&;
    using pointer         = value_type*;
    using const_pointer   = const value_type*;
    using iterator        = basic_iterator<pointer, reference>;
    using const_iterator  = basic_iterator<const_pointer, const_reference>;

private:
    Node head, tail;
    size_type _size;

public:
    List() {
        _size = 0;
        head.next = &tail;
        tail.prev = &head;
    }
    List( size_type count, const T& value ) {
        head.next = &tail;
        tail.prev = &head;
        _size = 0;
        //std::cout << "TOTAL COUNT: " << count << std::endl;
        for (size_type i = 0; i < count; i++){
            //std::cout << "IN THE FOR LOOP " << i << std::endl << std::endl;
            //std::cout << "LOOP CON: " << (i < count) << std::endl;
            //std::cout << "INDEX: " << i << std::endl;
            push_back(value);
        }
        //std::cout << "TOTAL COUNT: " << count << std::endl;
        //std::cout << "TOTAL SIZE: " << _size << std::endl;
    }
    explicit List( size_type count ) {
        head.next = &tail;
        tail.prev = &head;
        _size = 0;
        for (size_type i = 0; i < count; i++){
            push_back(T());
        }
    }
    List( const List& other ) {
        head.next = &tail;
        tail.prev = &head;
        _size = 0;

        if (this != &other) {
            clear();
        } 

        for (const_iterator i = other.begin(); i != other.end(); i++) {
            push_back(*i);
        }

    }
    List( List&& other ) {
        head.next = &tail;
        tail.prev = &head;

        _size = other._size;
        head.next = other.head.next;
        tail.prev = other.tail.prev;

        other.head.next->prev = &head;
        other.tail.prev->next = &tail;

        other.head.next = &other.tail;
        other.tail.prev = &other.head;

        other._size = 0;
    }
    ~List() {
        Node *prevNode, *node = head.next;
        while (node != &tail) {
            prevNode = node;
            node = node->next;
            delete prevNode;
        }
        head.next = &tail;
        tail.prev = &head;

    }
    List& operator=( const List& other ) {
        if (this != &other) {
            clear();
            for (const_iterator i = other.begin(); i != other.end(); i++) {
            push_back(*i);
            }
        }
        return *this;
    }
    List& operator=( List&& other ) noexcept {
        if (this != &other) {
            clear();

            head.next = other.head.next;
            tail.prev = other.tail.prev;

            other.head.next->prev = &head;
            other.tail.prev->next = &tail;

            other.head.next = &other.tail;
            other.tail.prev = &other.head;

            _size = other._size;
            other._size = 0;
        }
        return *this;
    }

    reference front() {
        return head.next->data;
    }
    const_reference front() const {
        return const_reference(head.next->data);
    }
	
    reference back() {
        return (tail.prev)->data;
    }
    const_reference back() const {
        return const_reference((tail.prev)->data);
    }
	
    iterator begin() noexcept {
        return iterator(head.next);
    }
    const_iterator begin() const noexcept {
        return const_iterator(head.next);
    }
    const_iterator cbegin() const noexcept {
        return const_iterator(head.next);
    }

    iterator end() noexcept {
        return iterator(&tail);
    }
    const_iterator end() const noexcept {
        return const_iterator(&tail);
    }
    const_iterator cend() const noexcept {
        return const_iterator(&tail);
    }

    bool empty() const noexcept {
        return (_size == 0);
    }

    size_type size() const noexcept {
        return _size;
    }

    void clear() noexcept {
        while (_size != 0) {
            pop_back();
        }
    }

    iterator insert( const_iterator pos, const T& value ) {
        Node* newNode = new Node(value, pos.node->prev, pos.node);

        newNode->next = pos.node;
        newNode->prev = pos.node->prev;
        pos.node->prev = newNode;

        newNode->prev->next = newNode;
        _size++;
        return iterator(newNode);
    }
    iterator insert( const_iterator pos, T&& value ) {
        //std::cout << "REACHES INSERT" << std::endl;
        Node* newNode = new Node(std::move(value), pos.node->prev, pos.node);

        newNode->next = pos.node;
        newNode->prev = pos.node->prev;

        pos.node->prev = newNode;

        newNode->prev->next = newNode;
        _size++;
        return iterator(newNode);
    }

    iterator erase( const_iterator pos ) {
        Node* temp = pos.node->next;
        //std::cout << "REACHES ERASE" << std::endl;
        //std::cout << "REACHES 1" << std::endl;
        (pos.node->prev)->next = pos.node->next;
        //std::cout << "REACHES 2" << std::endl;
        (pos.node->next)->prev = pos.node->prev;
        //std::cout << "REACHES 3" << std::endl;
        
        //std::cout << "REACHES 4" << std::endl;
        delete pos.node;
        //std::cout << "REACHES 5" << std::endl;
        _size--;
        //std::cout << "ENDS ERASE" << std::endl;
        return iterator(temp);
    }

    void push_back( const T& value ) {
        insert(end(), value);
    }
    void push_back( T&& value ) {
        insert(end(), std::move(value));
    }

    void pop_back() {
        erase(iterator(tail.prev));
    }
	
    void push_front( const T& value ) {
        insert(begin(), value);
    }
	void push_front( T&& value ) {
        insert(begin(), std::move(value));
    }

    void pop_front() {
        erase(begin());
    }

    /*
      You do not need to modify these methods!
      
      These method provide the non-const complement 
      for the const_iterator methods provided above.
    */
    iterator insert( iterator pos, const T & value) { 
        return insert((const_iterator &) (pos), value);
    }

    iterator insert( iterator pos, T && value ) {
        return insert((const_iterator &) (pos), std::move(value));
    }

    iterator erase( iterator pos ) {
        return erase((const_iterator&)(pos));
    }
};


/*
    You do not need to modify these methods!

    These method provide a overload to compare const and 
    non-const iterators safely.
*/
 
namespace {
    template<typename Iter, typename ConstIter, typename T>
    using enable_for_list_iters = typename std::enable_if<
        std::is_same<
            typename List<typename std::iterator_traits<Iter>::value_type>::iterator, 
            Iter
        >{} && std::is_same<
            typename List<typename std::iterator_traits<Iter>::value_type>::const_iterator,
            ConstIter
        >{}, T>::type;
}

template<typename Iterator, typename ConstIter>
enable_for_list_iters<Iterator, ConstIter, bool> operator==(const Iterator & lhs, const ConstIter & rhs) {
    return (const ConstIter &)(lhs) == rhs;
}

template<typename Iterator, typename ConstIter>
enable_for_list_iters<Iterator, ConstIter, bool> operator==(const ConstIter & lhs, const Iterator & rhs) {
    return (const ConstIter &)(rhs) == lhs;
}

template<typename Iterator, typename ConstIter>
enable_for_list_iters<Iterator, ConstIter, bool> operator!=(const Iterator & lhs, const ConstIter & rhs) {
    return (const ConstIter &)(lhs) != rhs;
}

template<typename Iterator, typename ConstIter>
enable_for_list_iters<Iterator, ConstIter, bool> operator!=(const ConstIter & lhs, const Iterator & rhs) {
    return (const ConstIter &)(rhs) != lhs;
}