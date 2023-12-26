# include <string>
# include <stdexcept>
# include "Tag.h"

using std::string, std::vector;

Tag::Tag(string tagName) : tagName{tagName}, tagPosts{} {
    // TODO: implement constructor checks
    if (tagName.length() < 2 || tagName[0] != '#' || tagName[1] < 97 || tagName[1] > 122){
        throw std::invalid_argument("tag constructor: Tags must begin with \"#\".");
    }

    for(unsigned int i = 0; i < tagName.length(); i++){
        if (tagName[i] >= 65 && tagName[i] <= 90){
            throw std::invalid_argument("tag constructor: Tags cannot contain capital letters.");
        }
    }

    if (tagName.back() == '!' || tagName.back() == ',' || tagName.back() == '.' || tagName.back() == '?') {
        throw std::invalid_argument("tag constructor: Tags cannot end with punctuation.");
    }
}

string Tag::getTagName() {
    // TODO: implement getter
    return tagName;
}

vector<Post*>& Tag::getTagPosts() {
    // TODO: implement getter
    return tagPosts;
}

void Tag::addTagPost(Post* post) {
    // TODO: add post to tag posts
    if (post != nullptr){
        tagPosts.push_back(post);
    } else {
        throw std::invalid_argument("");
    }
}
