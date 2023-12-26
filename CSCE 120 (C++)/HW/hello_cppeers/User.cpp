# include <string>
# include <stdexcept>
# include "User.h"

using std::string, std::vector;

User::User(string userName) : userName{userName}, userPosts{} {
    // TODO: implement constructor checks
    if (userName == "" || userName[0] < 97 || userName[0] > 122){
        throw std::invalid_argument("userName constructor: Usernames must begin with a lowercase letter.");
    }

    for(unsigned int i = 0; i < userName.length(); i++){
        if (userName[i] >= 65 && userName[i] <= 90){
            throw std::invalid_argument("userName constructor: Usernames cannot contain capital letters.");
        }
    }
}

string User::getUserName() {
    return this->userName;
}

vector<Post*>& User::getUserPosts() {
    return this->userPosts;
}

void User::addUserPost(Post* post) {
    // TODO: add post to user posts
    if (post != nullptr){
        userPosts.push_back(post);
    } else {
        throw std::invalid_argument("");
    }
}
