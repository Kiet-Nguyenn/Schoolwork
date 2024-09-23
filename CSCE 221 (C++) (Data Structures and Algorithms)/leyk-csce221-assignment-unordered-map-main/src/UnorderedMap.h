#include <cstddef>    // size_t
#include <functional> // std::hash
#include <ios>
#include <utility>    // std::pair
#include <iostream>

#include "primes.h"



template <typename Key, typename T, typename Hash = std::hash<Key>, typename Pred = std::equal_to<Key>>
class UnorderedMap {
    public:

    using key_type = Key;
    using mapped_type = T;
    using const_mapped_type = const T;
    using hasher = Hash;
    using key_equal = Pred;
    using value_type = std::pair<const key_type, mapped_type>;
    using reference = value_type &;
    using const_reference = const value_type &;
    using pointer = value_type *;
    using const_pointer = const value_type *;
    using size_type = size_t;
    using difference_type = ptrdiff_t;

    private:

    struct HashNode {
        HashNode *next;
        value_type val;

        HashNode(HashNode *next = nullptr) : next{next} {}
        HashNode(const value_type & val, HashNode * next = nullptr) : next { next }, val { val } { }
        HashNode(value_type && val, HashNode * next = nullptr) : next { next }, val { std::move(val) } { }
    };

    size_type _bucket_count;
    HashNode **_buckets;

    HashNode * _head;
    size_type _size;

    Hash _hash;
    key_equal _equal;

    static size_type _range_hash(size_type hash_code, size_type bucket_count) {
        return hash_code % bucket_count;
    }

    public:

    template <typename pointer_type, typename reference_type, typename _value_type>
    class basic_iterator {
    public:
        using iterator_category = std::forward_iterator_tag;
        using value_type = _value_type;
        using difference_type = ptrdiff_t;
        using pointer = value_type *;
        using reference = value_type &;

    private:
        friend class UnorderedMap<Key, T, Hash, key_equal>;
        using HashNode = typename UnorderedMap<Key, T, Hash, key_equal>::HashNode;

        const UnorderedMap * _map;
        HashNode * _ptr;

        explicit basic_iterator(UnorderedMap const * map, HashNode *ptr) noexcept {
            _map = map;
            _ptr = ptr;
        }

    public:
        basic_iterator() {
            _map = nullptr;
            _ptr = nullptr;
        };

        basic_iterator(const basic_iterator &) = default;
        basic_iterator(basic_iterator &&) = default;
        ~basic_iterator() = default;
        basic_iterator &operator=(const basic_iterator &) = default;
        basic_iterator &operator=(basic_iterator &&) = default;
        reference operator*() const {return _ptr->val;}
        pointer operator->() const {return &(_ptr->val);}
        basic_iterator &operator++() {
            if(_ptr != nullptr){
                if(_ptr->next != nullptr){
                    _ptr = _ptr->next;
                }
                else{
                    size_type next_bucket = _map->_bucket(_ptr->val.first) + 1;
                    while ((next_bucket < _map->_bucket_count) && (_map->_buckets[next_bucket] == nullptr)) {
                        ++next_bucket;
                    }
                    if (next_bucket < _map->_bucket_count) {
                        _ptr = _map->_buckets[next_bucket];
                    }
                    else {
                        _ptr = nullptr;
                    }
                }
            }
            return *this;
        }
        basic_iterator operator++(int) {
            basic_iterator temp = *this;
            ++(*this);
            return temp;
        }
        bool operator==(const basic_iterator &other) const noexcept {
            return _ptr == other._ptr;
        }
        bool operator!=(const basic_iterator &other) const noexcept {
            return _ptr != other._ptr;
        }
    };

    using iterator = basic_iterator<pointer, reference, value_type>;
    using const_iterator = basic_iterator<const_pointer, const_reference, const value_type>;

    class local_iterator {
        public:
            using iterator_category = std::forward_iterator_tag;
            using value_type = std::pair<const key_type, mapped_type>;
            using difference_type = ptrdiff_t;
            using pointer = value_type *;
            using reference = value_type &;

        private:
            friend class UnorderedMap<Key, T, Hash, key_equal>;
            using HashNode = typename UnorderedMap<Key, T, Hash, key_equal>::HashNode;

            HashNode * _node;

            explicit local_iterator( HashNode * node ) noexcept {_node = node;}

        public:
            local_iterator() {_node = nullptr;}

            local_iterator(const local_iterator &) = default;
            local_iterator(local_iterator &&) = default;
            ~local_iterator() = default;
            local_iterator &operator=(const local_iterator &) = default;
            local_iterator &operator=(local_iterator &&) = default;
            reference operator*() const {return _node->val;}
            pointer operator->() const {return &(_node->val);}
            local_iterator & operator++() {
                _node = _node->next;
                return *this;
            }
            local_iterator operator++(int) {
                local_iterator temp = *this;
                _node = _node->next;
                return temp;
            }

            bool operator==(const local_iterator &other) const noexcept {
                return this->_node == other._node;
            }
            bool operator!=(const local_iterator &other) const noexcept {
                return this->_node != other._node;
            }
    };

private:

    size_type _bucket(size_t code) const {return _range_hash(code, bucket_count());}
    size_type _bucket(const Key & key) const {return _bucket(_hash(key));}
    size_type _bucket(const value_type & val) const {return _bucket(_hash(val.first));}

    HashNode*& _find(size_type code, size_type bucket, const Key & key) {
        HashNode ** current = &(_buckets[bucket]);
        while (*current != nullptr){
            if(_equal(key, (*current)->val.first)){
                return *current; 
            }
            current = &((*current)->next);
        }

        return *current;
    }

    HashNode*& _find(const Key & key) {
        return _find(_hash(key), _bucket(key), key);
    }

    HashNode * _insert_into_bucket(size_type bucket, value_type && value) {
        HashNode* current = new HashNode(std::move(value));
        current->next = _buckets[bucket];
        _buckets[bucket] = current;

        if (_head == nullptr || _bucket(_head->val) >= bucket){
            _head = current;
        }
        _size++;
        return current;
    }

    void _move_content(UnorderedMap & src, UnorderedMap & dst) {
        if (src._head == nullptr) {
            return;
        }

        dst._head = src._head;
        dst._bucket_count = src._bucket_count;
        dst._size = src._size;
        dst._buckets = src._buckets;
        dst._hash = src._hash;
        dst._equal = src._equal;

        src._buckets = new HashNode*[src._bucket_count]{};

        src._size = 0;
        src._head = nullptr;
    }

public:
    explicit UnorderedMap(size_type bucket_count, const Hash & hash = Hash { },
                const key_equal & equal = key_equal { }) {

        _bucket_count = bucket_count;
        if (_bucket_count != next_greater_prime(_bucket_count)){
            _bucket_count = next_greater_prime(_bucket_count);
        }

        _size = 0;
        _hash = hash;
        _equal = equal;

        _head = nullptr;

        _buckets = new HashNode*[_bucket_count]{};
    }

    ~UnorderedMap() {
        clear();
        delete[] _buckets;
    }

    UnorderedMap(const UnorderedMap & other) {
        _head = nullptr;
        _size = 0;

        _hash = other._hash;
        _equal = other._equal;
        _bucket_count = other._bucket_count;

        _buckets = new HashNode*[_bucket_count]();
        const_iterator current = other.cbegin();
        while (current != other.cend()) {
            insert(*current);
            ++current;
        }
    }

    UnorderedMap(UnorderedMap && other) {
        _move_content(other, *this);
    }

    UnorderedMap & operator=(const UnorderedMap & other) {
        if (this == &other) {
            return *this;
        }

        clear();
        delete[] _buckets;

        
        _hash = other._hash;
        _equal = other._equal;
        _bucket_count = other._bucket_count;

        _head = nullptr;
        _size = 0;

        _buckets = new HashNode*[_bucket_count]();
        const_iterator it = other.cbegin();
        while (it != other.cend()) {
            insert(*it);
            it++;
        }
        return *this;
    }

    UnorderedMap & operator=(UnorderedMap && other) {
        if (this == &other) {
            return *this;
        }
        clear();
        delete[] _buckets;
        _move_content(other, *this);
        return *this;
    }

    void clear() noexcept {
        while (_head != nullptr){
            erase(iterator(this, _head));
        }
    }

    size_type size() const noexcept {return _size;}

    bool empty() const noexcept {return _size == 0;}

    size_type bucket_count() const noexcept {return _bucket_count;}

    iterator begin() {return iterator(this, _head);}
    iterator end() { return iterator(this, nullptr);}

    const_iterator cbegin() const {return const_iterator(this, _head);};
    const_iterator cend() const {return const_iterator(this, nullptr);};

    local_iterator begin(size_type n) {
        if (n >= _bucket_count || _buckets[n] == nullptr) {
            return local_iterator(nullptr);
        }
        return local_iterator(_buckets[n]);
    }
    local_iterator end(size_type n) {
        return local_iterator(nullptr);
    }

    size_type bucket_size(size_type n) {
        size_type count = 0;
        for (local_iterator i = local_iterator(_buckets[n]); i != end(n); i++){
            count++;
        }

        return count;
    }

    float load_factor() const {
        return ((float)size() / bucket_count());
    }

    size_type bucket(const Key & key) const {return _bucket(key);}

    std::pair<iterator, bool> insert(value_type && value) {
        HashNode* searched = _find(value.first);
        if (searched != nullptr){
            return std::make_pair(iterator(this, searched), false);
        } else {
            return std::make_pair(iterator(this, _insert_into_bucket(_bucket(value), std::move(value))), true);
        }
    }

    std::pair<iterator, bool> insert(const value_type & value) {
        HashNode* searched = _find(value.first);
        if (searched != nullptr){
            return std::make_pair(iterator(this, searched), false);
        } else {
            value_type temp = value;
            return std::make_pair(iterator(this, _insert_into_bucket(_bucket(value), std::move(temp))), true);
        }
    }

    iterator find(const Key & key) {
        return iterator(this, _find(key));
    }

    T& operator[](const Key & key) {
        HashNode*& node = _find(key);
        if (node == nullptr) {
            node = new HashNode(std::make_pair(key, T()), nullptr);
            _size++;
        }
        return node->val.second;
    }

    iterator erase(iterator pos) {
        HashNode*& temp = _find(pos->first);
        if (temp == nullptr){
            return end();
        }
        HashNode* del = temp;
        iterator next = ++iterator(this, del);
        if (_head == del){
            _head = next._ptr;
        }
        temp = temp->next;
        delete del;
        _size--;
        return next;
    
    }

    size_type erase(const Key & key) {
        HashNode*& current = _find(key);
        if (current == nullptr) {
            return 0;
        }

        HashNode* del = current;
        iterator next = ++iterator(this, del);
        if (_head == del) {
            _head = next._ptr;
        }
        current = current->next;

        delete del;
        del = nullptr;
        --_size;
        return 1;
    }

    template<typename KK, typename VV>
    friend void print_map(const UnorderedMap<KK, VV> & map, std::ostream & os);
};

template<typename K, typename V>
void print_map(const UnorderedMap<K, V> & map, std::ostream & os = std::cout) {
    using size_type = typename UnorderedMap<K, V>::size_type;
    using HashNode = typename UnorderedMap<K, V>::HashNode;

    for(size_type bucket = 0; bucket < map.bucket_count(); bucket++) {
        os << bucket << ": ";

        HashNode const * node = map._buckets[bucket];

        while(node) {
            os << "(" << node->val.first << ", " << node->val.second << ") ";
            node = node->next;
        }

        os << std::endl;
    }
}
