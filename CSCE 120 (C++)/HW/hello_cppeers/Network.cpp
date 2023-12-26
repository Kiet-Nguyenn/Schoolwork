# include <iostream>
# include <fstream>
# include <sstream>
# include <stdexcept>
# include "Network.h"

using std::string, std::vector;

Network::Network() : users({}), posts({}), tags({}) {}

void Network::loadFromFile(string fileName) {
    // TODO: load user and post information from file
    std::ifstream inFS;
    bool empty = false;

    inFS.open(fileName);
    if (!inFS.is_open()){
        throw std::invalid_argument("Network loadFromFile: Could not open file.");
    }

    while (!empty){
        string get_action = "";
        string user = "";
        unsigned int post_Id;
        string post_text = "";

        inFS >> get_action;
        if (get_action == "User"){
            inFS >> user;

            //std::cout << get_action << ": " << user << std::endl; 

            try{
                addUser(user);
            } catch (std::invalid_argument()) {
                throw std::runtime_error("Network loadFromFile: Invalid Username.");
            }
        } else if (get_action == "Post"){
            inFS >> post_Id;
            inFS >> user;
            getline(inFS, post_text);
            if (post_text[0] == ' '){
                post_text = post_text.substr(1, post_text.length() - 1);
            }

            //std::cout << get_action << ": " << post_Id << ": " << user << ": " << post_text << std::endl; 

            try{
                addPost(post_Id, user, post_text);
            } catch (std::invalid_argument()) {
                throw std::runtime_error("Network loadFromFile: Invalid Post.");
            }
        } else if (get_action == ""){
            empty = true;
        } else {
            throw std::runtime_error("Network loadFromFile: Invalid Input");
        }

    }
    inFS.close();

}

void Network::addUser(string userName) {
    // TODO: create user and add it to network

    //uppercase to lowercase
    string lc_userName = userName;   
    for (unsigned int i = 0; i < lc_userName.length(); i++){
        if (lc_userName[i] >= 65 &&lc_userName[i] <= 90){
            lc_userName[i] += 32;
        }
    }

    bool username_taken = false;
    for (unsigned int i = 0; i < users.size(); i++){
        if (users.at(i)->getUserName() == lc_userName){
            username_taken = true;
        }
    }

    //user constructor
    if (!username_taken){

        User* new_user = new User(lc_userName);

        users.push_back(new_user);

        std::cout << "Added User " << lc_userName << std::endl;
    } else {
        throw std::invalid_argument("Network addUser: This Username is already taken.");
    }
}

void Network::addPost(unsigned int postId, string userName, string postText) {
    // TODO: create post and add it to network
    bool user_found = false;
    unsigned int user_ID;

    for (unsigned int i = 0; i < users.size(); i++){
        if (users.at(i)->getUserName() == userName){
            user_found = true;
            user_ID = i;
        }
    }
    if (!user_found){
        throw std::invalid_argument("Network addPost: This user does not exist.");
    }

    for (unsigned int i = 0; i < posts.size(); i++){
        if (posts.at(i)->getPostId() == postId){
            throw std::invalid_argument("Network addPost: This post ID already exists. ");
        }
    }

    //create new post
    Post* new_post = new Post(postId, userName, postText);
    posts.push_back(new_post);

    //add post to user
    users.at(user_ID)->addUserPost(new_post);

    //find duplicate tags
    vector<string> candidate_tags = new_post->findTags();
    vector<string> existing_tags;
    vector<string> new_tags;
    for (unsigned int i = 0; i < candidate_tags.size(); i++){
        bool duplicate = false;
        for (unsigned int j = 0; j < tags.size(); j++){
            if (candidate_tags.at(i) == tags.at(j)->getTagName()){
                duplicate = true;
            }
        }
        if (duplicate){
            existing_tags.push_back(candidate_tags.at(i));
        } else {
            new_tags.push_back(candidate_tags.at(i));
        }
    }

    //create tags
    if (new_tags.size() != 0){
        for (unsigned int i = 0; i < new_tags.size(); i++){
            try{
                Tag* new_tag = new Tag(new_tags.at(i));
                tags.push_back(new_tag);
                new_tag->addTagPost(new_post);
            } catch(std::invalid_argument()){}
        }
    }

    //add info to existing
    if (existing_tags.size() != 0){
        unsigned int existing_tag_count = 0;
        for (unsigned int i = 0; i < tags.size(); i++){
            if (tags.at(i)->getTagName() == existing_tags.at(existing_tag_count)){
                tags.at(existing_tag_count)->addTagPost(new_post);
                existing_tag_count++;
            }
        }
    }

    

    std::cout << "Added Post " << postId << " by " << userName << std::endl;
}

vector<Post*> Network::getPostsByUser(string userName) {
    // TODO: return posts created by the given user
    if (userName == ""){
        throw std::invalid_argument("Network getPostsByUser: Invalid Username");
    }

    bool found = false;
    for (unsigned int i = 0; i < users.size(); i++){
        if (userName == users.at(i)->getUserName()){
            found = true;
        }
    }
    if (!found){
        throw std::invalid_argument("Network getPostsByUser: Username not found");
    }

    vector<Post*> user_posts;
    unsigned int user_Id;
    for (unsigned int i = 0; i < users.size(); i++){
        if (users.at(i)->getUserName() == userName){
            user_Id = i;
        }
    }

    user_posts = users.at(user_Id)->getUserPosts();

    return user_posts;
}

vector<Post*> Network::getPostsWithTag(string tagName) {
    // TODO: return posts containing the given tag
    if (tagName == ""){
        throw std::invalid_argument("Network getPostsWithTag: Invalid tag name");
    }

    bool found = false;
    for (unsigned int i = 0; i < users.size(); i++){
        if (tagName == users.at(i)->getUserName()){
            found = true;
        }
    }
    if (!found){
        throw std::invalid_argument("Network getPostsWithTag: Tag name not found");
    }

    vector<Post*> tagged_posts;

    unsigned int tag_Id;
    for (unsigned int i = 0; i < tags.size(); i++){
        if (tags.at(i)->getTagName() == tagName){
            tag_Id = i;
        }
    }

    tagged_posts = users.at(tag_Id)->getUserPosts();
    
    return tagged_posts;
}

vector<string> Network::getMostPopularHashtag() {
    // TODO: return the tag occurring in most posts
    vector<string> popular_tags;
    if (tags.size() == 0){
        return popular_tags;
    }

    vector<unsigned int> tied_tags;
    unsigned int popular_tag_id = 0;
    tied_tags.push_back(0);

    for (unsigned int i = 1; i < tags.size(); i++){
        if (tags.at(popular_tag_id)->getTagPosts().size() == tags.at(i)->getTagPosts().size()){
            tied_tags.push_back(i);
            popular_tag_id = i;
            for (unsigned int j = 0; j < tied_tags.size(); j++){
                //std::cout << tied_tags.at(j) << ", ";
            }
            //std::cout << std::endl;
        }

        if (tags.at(popular_tag_id)->getTagPosts().size() < tags.at(i)->getTagPosts().size()){
            while (tied_tags.size() != 0){
                tied_tags.pop_back();
            }
            tied_tags.push_back(popular_tag_id);
            popular_tag_id = i;
            for (unsigned int j = 0; j < tied_tags.size(); j++){
                //std::cout << tied_tags.at(j) << ", ";
            }
            //std::cout << std::endl;
        }
    }

    //std::cout << "Final: " << std::endl;
    for (unsigned int i = 0; i < tied_tags.size(); i++){
        popular_tags.push_back(tags.at(tied_tags.at(i))->getTagName());
        //std::cout << tied_tags.at(i) << ", ";
    }
    //std::cout << std::endl;

    return popular_tags;
}

Network::~Network() {
    for (unsigned int i = 0; i < users.size(); ++i) {
        delete users.at(i);
    }

    for (unsigned int i = 0; i < tags.size(); ++i) {
        delete tags.at(i);
    }
    
    for (unsigned int i = 0; i < posts.size(); ++i) {
        delete posts.at(i);
    }
}
