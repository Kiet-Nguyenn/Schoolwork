#include "executable.h"
#include "generate_tree_data.h"

TEST(clear_and_empty) {
    Typegen t;
    for(size_t i = 0; i < TEST_ITER; i++) {
        //std::cout << "1" << std::endl;
        size_t sz = i == 0 ? 0ULL : t.range<size_t>(1, 256);
        
        //std::cout << "2" << std::endl;
        auto pairs = generate_kv_pairs<double, double>(t, sz, true);

        Memhook mh;
        //std::cout << "3" << std::endl;
        BinarySearchTree<double, double> bst;

        //std::cout << "4" << std::endl;
        for(auto const & pair : pairs)
            bst.insert(pair);
        
        //std::cout << "5" << std::endl;
        ASSERT_TREE_PAIRS_CONTAINED_AND_FOUND(pairs, bst);
        ASSERT_EQ(sz, bst.size());
        ASSERT_EQ(sz, mh.n_allocs());

        //std::cout << "6" << std::endl;
        if(sz) ASSERT_FALSE(bst.empty());


        //std::cout << "7" << std::endl;
        bst.clear();

        //std::cout << "8" << std::endl;
        ASSERT_EQ(sz, mh.n_frees());
        ASSERT_EQ(0ULL, bst.size());
        ASSERT_TRUE(bst.empty());
    }
}