#pragma once

#include <functional> // std::less
#include <iostream>
#include <queue> // std::queue
#include <utility> // std::pair

template <typename K, typename V, typename Comparator = std::less<K>>
class BinarySearchTree
{
  public:
    using key_type        = K;
    using value_type      = V;
    using key_compare     = Comparator;
    using pair            = std::pair<key_type, value_type>;
    using pointer         = pair*;
    using const_pointer   = const pair*;
    using reference       = pair&;
    using const_reference = const pair&;
    using difference_type = ptrdiff_t;
    using size_type       = size_t;

  private:
    struct BinaryNode
    {
        pair element;
        BinaryNode *left;
        BinaryNode *right;

        BinaryNode( const_reference theElement, BinaryNode *lt, BinaryNode *rt )
          : element{ theElement }, left{ lt }, right{ rt } { }
        
        BinaryNode( pair && theElement, BinaryNode *lt, BinaryNode *rt )
          : element{ std::move( theElement ) }, left{ lt }, right{ rt } { }
    };

    using node           = BinaryNode;
    using node_ptr       = node*;
    using const_node_ptr = const node*;

    node_ptr _root;
    size_type _size;
    key_compare comp;

  public:
    BinarySearchTree() {
        //std::cout << "DEFAULT" << std::endl;
        _root = nullptr;
        _size = 0;
    }
    BinarySearchTree( const BinarySearchTree & rhs ) {
        //std::cout << "COPY CONSTRUCTOR" << std::endl;
        if (rhs._root != nullptr){
            _root = clone(rhs._root);
        } else {
            _root = nullptr;
        }
        _size = rhs._size;
    }
    BinarySearchTree( BinarySearchTree && rhs ) {
        if (rhs._root != nullptr){
            _root = rhs._root;
            rhs._root = nullptr;
        } else {
            _root = nullptr;
        }
        _size = rhs._size;
        rhs._size = 0;
    }
    ~BinarySearchTree() {
        //std::cout << "DECONSTRUCTOR" << std::endl;
        clear();
    }

    const_reference min() const { return min( _root )->element; }
    const_reference max() const { return max( _root )->element; }
    const_reference root() const {
        //std::cout << "CALLING ROOT: " << &_root << std::endl;
        return _root->element;
    }
    bool contains( const key_type & x ) const { return contains( x, _root ); }
    value_type & find( const key_type & key ) { return find( key, _root )->element.second; }
    const value_type & find( const key_type & key ) const { return find( key, _root )->element.second; }
    bool empty() const {
        //std::cout << "EMPTY: " << (_root == nullptr) << std::endl;
        return (_root == nullptr);
    }
    size_type size() const {
        //std::cout << "SIZE" << std::endl;
        //std::cout << _size << std::endl;
        return _size;
    }

    void clear() {
        //std::cout << "PUBLIC CLEAR" << std::endl;
        clear( _root );
        _size = 0;
    }
    void insert( const_reference x ) { insert( x, _root ); }
    void insert( pair && x ) { insert( std::move( x ), _root ); }
    void erase( const key_type & x ) { erase(x, _root); }

    BinarySearchTree & operator=( const BinarySearchTree & rhs ) {
        //std::cout << "COPY ASSIGNMENT" << std::endl;
        if (this != &rhs){
            clear();
            if (rhs._root != nullptr){
                _root = clone(rhs._root);
            }
            _size = rhs._size;
        }
        return *this;
    }
    BinarySearchTree & operator=( BinarySearchTree && rhs ) {
        //std::cout << "MOVE ASSIGNMENT" << std::endl;
        if (this != &rhs){
            clear();
            if (rhs._root != nullptr){
                _root = rhs._root;
                rhs._root = nullptr;
            }
            _size = rhs._size;
            rhs._size = 0;
        }
        return *this;
    }

  private:
    void insert( const_reference x, node_ptr & t ) {
        //std::cout << "NOT MOVE INSERT" << std::endl;
        if (t == nullptr){
            BinaryNode* newNode = new BinaryNode(x, nullptr, nullptr);
            t = newNode;
            _size++;
        } else if (comp(x.first, t->element.first)) {
            insert(x, t->left);
        } else if (comp(t->element.first, x.first)){
            insert(x, t->right);
        } else {
            t->element.second = x.second;
        }
    }
    void insert( pair && x, node_ptr & t ) {
        //std::cout << "MOVE INSERT" << std::endl;
        //std::cout << "t: " << &t << std::endl;
        if (t != nullptr){
            //std::cout << "t value: " << t->element.first << std::endl;
        }
        //std::cout << "x value: " << x.first << std::endl;
        if (t == nullptr){
            //std::cout << "INSERT NEW NODE" << std::endl;
            BinaryNode* newNode = new BinaryNode(std::move(x), nullptr, nullptr);
            t = newNode;
            _size++;
        } else if (comp(x.first, t->element.first)) {
            //std::cout << "SEARCH LEFT" << std::endl;
            //std::cout << "comparison: " << comp(x.first, t->element.first) << std::endl;
            insert(std::move(x), t->left);
        } else if (comp(t->element.first, x.first)){
            //std::cout << "SEARCH RIGHT" << std::endl;
            //std::cout << "comparison: " << comp(t->element.first, x.first) << std::endl;
            //std::cout << "t->right null?: " << (t->right == nullptr) << std::endl;
            insert(std::move(x), t->right);
            //std::cout << "FINISH SEARCH RIGHT" << std::endl;
        } else {
            //std::cout << "ALREADY EXISTS" << std::endl;
            t->element = std::move(x);
        }
    }

    void erase( const key_type & x, node_ptr & t ) {
        //std::cout << "ERASE" << std::endl;
        //std::cout << "t: " << t->element.first << std::endl;
        //std::cout << "t children?: " << (t->left != nullptr) << (t->right != nullptr) << std::endl;
        if (comp(x, t->element.first)) {
            erase(x, t->left);
        } else if (comp(t->element.first, x)){
            erase(x, t->right);
        } else {
            //no children
            if (t->left == nullptr && t->right == nullptr){
                //std::cout << "NO CHILDREN" << std::endl;
                //std::cout << "t: in no children: " << &t << std::endl;
                //std::cout << "t is empty: " << (t == nullptr) << std::endl;
                delete t;
                t = nullptr;
                //std::cout << "t: in no children after deletion: " << &t << std::endl;
                //std::cout << "t is empty: " << (t == nullptr) << std::endl;
                _size--;

            }
            //one child
            else if ((t->left != nullptr && t->right == nullptr) || (t->left == nullptr && t->right != nullptr)){
                node_ptr temp = t;
                //std::cout << "temp: " << temp->element.first << std::endl;
                //left child
                if (t->left != nullptr && t->right == nullptr){
                    //std::cout << "LEFT CHILD: " << std::endl;
                    //std::cout << "t: " << t->element.first << std::endl;
                    //std::cout << "t->left: " << (t->left)->element.first << std::endl;
                    t = t->left;
                    //std::cout << "new t: " << t->element.first << std::endl;
                }
                //right child
                else if (t->left == nullptr && t->right != nullptr){
                    //std::cout << "RIGHT CHILD" << std::endl;
                    //std::cout << "t: " << t->element.first << std::endl;
                    //std::cout << "t->right: " << (t->right)->element.first << std::endl;
                    t = t->right;
                    //std::cout << "new t: " << t->element.first << std::endl;
                }
                delete temp;
                temp = nullptr;
                _size--;
            }
            //two children
            else if (t->left != nullptr && t->right != nullptr){
                //std::cout << "TWO CHILDREN START" << std::endl;

                //std::cout << "min value: " << min(const_node_ptr(t->right))->element.first << std::endl;

                const_node_ptr temp = min(const_node_ptr(t->right));
                //std::cout << "t: " << t->element.first << std::endl;
                //std::cout << "TEMP: " << temp->element.first << std::endl;
                //std::cout << "min children?: " << (min(const_node_ptr(t->right))->left != nullptr) << (min(const_node_ptr(t->right))->right != nullptr) << std::endl;
                //std::cout << "min: " << min(const_node_ptr(t->right)) << std::endl;

                erase(temp->element.first, t->right);
                //std::cout << "ERASED: " << t->element.first << std::endl;
                //std::cout << "t: " << t->element.first << std::endl;
                //std::cout << "TEMP: " << temp->element.first << std::endl;

                t->element = temp->element;
                //std::cout << "t REPLACED WITH TEMP: " << std::endl;
                //std::cout << "t: " << t->element.first << std::endl;
                //std::cout << "TEMP: " << temp->element.first << std::endl;
                //std::cout << "TWO CHILDREN END" << std::endl << std::endl;
            }
        }
    }

    const_node_ptr min( const_node_ptr t ) const {
        //std::cout << "MIN" << std::endl;
        if (t->left == nullptr){
            return t;
        }
        return min(t->left);
    }
    const_node_ptr max( const_node_ptr t ) const {
        //std::cout << "MAX" << std::endl;
        if (t->right == nullptr){
            return t;
        }
        return max(t->right);
    }

    bool contains( const key_type & x, const_node_ptr t ) const {
        //std::cout << "CONTAINS" << std::endl;
        //std::cout << "CONTAINS SEARCH FOR: " << x << std::endl;
        return (find(x, t) != nullptr);
        
    }
    node_ptr find( const key_type & key, node_ptr t ) {
        if (t != nullptr){
            if (comp(key, t->element.first)) {
                return find(key, t->left);
            }
            if (comp(t->element.first, key)){
                return find(key, t->right);
            } 
            if (t->element.first == key){
                return t;
            }
            else {
                return nullptr;
            }
        } else {
            return nullptr;
        }
    }
    const_node_ptr find( const key_type & key, const_node_ptr t ) const {
        if (t != nullptr){
            if (comp(key, t->element.first)) {
                return find(key, t->left);
            }
            if (comp(t->element.first, key)){
                return find(key, t->right);
            } 
            if (t->element.first == key){
                return t;
            }
            else {
                return nullptr;
            }
        } else {
            return nullptr;
        }
    }

    void clear( node_ptr & t ) {
        //std::cout << "CLEAR" << std::endl;
        if (t != nullptr){
            if (t->left != nullptr){
                clear(t->left);
            }
            if (t->right != nullptr){
                clear(t->right);
            }
            delete t;
            t = nullptr;
        }
        //std::cout << "CLEAR END" << std::endl;
    }
    
    node_ptr clone ( const_node_ptr t ) const {
        //std::cout << "CLONE" << std::endl;
        BinaryNode* newNode = new BinaryNode(t->element, nullptr, nullptr);
        if (t->left != nullptr){
            newNode->left = clone(t->left);
        }
        if (t->right != nullptr){
            newNode->right = clone(t->right);
        }
        return newNode;
    }

  public:
    template <typename KK, typename VV, typename CC>
    friend void printLevelByLevel( const BinarySearchTree<KK, VV, CC>& bst, std::ostream & out );

    template <typename KK, typename VV, typename CC>
    friend std::ostream& printNode(std::ostream& o, const typename BinarySearchTree<KK, VV, CC>::node& bn);

    template <typename KK, typename VV, typename CC>
    friend void printTree( const BinarySearchTree<KK, VV, CC>& bst, std::ostream & out );

    template <typename KK, typename VV, typename CC>
    friend void printTree(typename BinarySearchTree<KK, VV, CC>::const_node_ptr t, std::ostream & out, unsigned depth );

    template <typename KK, typename VV, typename CC>
    friend void vizTree(
        typename BinarySearchTree<KK, VV, CC>::const_node_ptr node, 
        std::ostream & out,
        typename BinarySearchTree<KK, VV, CC>::const_node_ptr prev
    );

    template <typename KK, typename VV, typename CC>
    friend void vizTree(
        const BinarySearchTree<KK, VV, CC> & bst, 
        std::ostream & out
    );
};

template <typename KK, typename VV, typename CC>
std::ostream& printNode(std::ostream & o, const typename BinarySearchTree<KK, VV, CC>::node & bn) {
    return o << '(' << bn.element.first << ", " << bn.element.second << ')';
}

template <typename KK, typename VV, typename CC>
void printLevelByLevel( const BinarySearchTree<KK, VV, CC>& bst, std::ostream & out = std::cout ) {
    
    //using node = typename BinarySearchTree<KK, VV, CC>::node;
    using node_ptr = typename BinarySearchTree<KK, VV, CC>::node_ptr;
    //using const_node_ptr = typename BinarySearchTree<KK, VV, CC>::const_node_ptr;

    node_ptr temp;
    std::queue<node_ptr> q;
    std::stringstream p;
    int size;
    bool isNull;

    q.push(bst._root);
    size = q.size();
    //std::cout << "INITIAL SIZE: " << size << std::endl;
    while (true){
        //std::cout << "SIZE: " << size << std::endl;
        isNull = true;
        for (int i = 0; i < size; i++){
            temp = q.front();
            q.pop();

            if (temp == NULL){
                //std::cout << "null";
                p << "null";
                q.push(NULL);
                q.push(NULL);
            } else {
                //std::cout << "(" << temp->element.first << ", " << temp->element.second << ") ";
                p << "(" << temp->element.first << ", " << temp->element.second << ") ";
                isNull = false;
                q.push(temp->left);
                q.push(temp->right);
            }
        }
        //std::cout << "NULL? " << isNull << std::endl;
        if (isNull == true){
            break;
        }
        //std::cout << "NOT BROKEN" << std::endl;

        size = q.size();
        out << p.str() << "\n";
        //std::cout << std::endl;
        p.str("");
    }
}

template <typename KK, typename VV, typename CC>
void printTree( const BinarySearchTree<KK, VV, CC> & bst, std::ostream & out = std::cout ) { printTree<KK, VV, CC>(bst._root, out ); }

template <typename KK, typename VV, typename CC>
void printTree(typename BinarySearchTree<KK, VV, CC>::const_node_ptr t, std::ostream & out, unsigned depth = 0 ) {
    if (t != nullptr) {
        printTree<KK, VV, CC>(t->right, out, depth + 1);
        for (unsigned i = 0; i < depth; ++i)
            out << '\t';
        printNode<KK, VV, CC>(out, *t) << '\n';
        printTree<KK, VV, CC>(t->left, out, depth + 1);
    }
}

template <typename KK, typename VV, typename CC>
void vizTree(
    typename BinarySearchTree<KK, VV, CC>::const_node_ptr node, 
    std::ostream & out,
    typename BinarySearchTree<KK, VV, CC>::const_node_ptr prev = nullptr
) {
    if(node) {
        std::hash<KK> khash{};

        out << "\t" "node_" << (uint32_t) khash(node->element.first)
            << "[label=\"" << node->element.first 
            << " [" << node->element.second << "]\"];" << std::endl;
        
        if(prev)
            out << "\tnode_" << (uint32_t) khash(prev->element.first) <<  " -> ";
        else
            out << "\t";
        
        out << "node_" << (uint32_t) khash(node->element.first) << ";" << std::endl;
    
        vizTree<KK, VV, CC>(node->left, out, node);
        vizTree<KK, VV, CC>(node->right, out, node);
    }
}

template <typename KK, typename VV, typename CC>
void vizTree(
    const BinarySearchTree<KK, VV, CC> & bst, 
    std::ostream & out = std::cout
) {
    out << "digraph Tree {" << std::endl;
    vizTree<KK, VV, CC>(bst._root, out);
    out << "}" << std::endl;
}
