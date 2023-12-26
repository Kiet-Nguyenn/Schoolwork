# include <iostream>
# include <string>
# include <stdexcept>
# include "Post.h"

using std::string, std::vector;

Post::Post(unsigned int postId, string userName, string postText) : postId(postId), userName(userName), postText(postText) {
    if (postId == 0 || userName == "" || postText == "") {
        throw std::invalid_argument("post constructor: invalid parameter values");
    }

}

unsigned int Post::getPostId() {
    return postId;
}

string Post::getPostUser() {
    return userName;
}

string Post::getPostText() {
    return postText;
}

vector<string> Post::findTags() {
    // TODO: extracts candidate tags based on occurrences of # in the post
    vector <unsigned int> tagIDs;
    //tagIDs contains tag index followed by tag length
    vector <string> tags_unfiltered;
    vector <string> tags;


    //if post is a single character
    if (postText.size() == 1){
        //if post is a single hashtag
        if (postText == "#"){
            tags.push_back("#");
            return tags;
        }
    }

    //find IDs
    for (unsigned int i = 0; i < postText.length(); i++){
        if (postText[i] == '#'){
            //start
            tagIDs.push_back(i);
            if (postText[i] != postText.back()){
                for (unsigned int j = i + 1; j < postText.length(); j++){
                    if (postText[j] == ' ' || postText[j] == '#' || postText[j] == postText.back()){
                        //end
                        unsigned int sub_size = j - i;
                        if (postText[j] == postText.back()){
                            sub_size++;
                        }

                        tagIDs.push_back(sub_size);
                        break;
                    }
                }
            } else {
                tagIDs.push_back(1);
            }
        }
    }

    //find tags
    for (unsigned int i = 0; i < tagIDs.size(); i += 2){
        string new_tag;
        new_tag = postText.substr(tagIDs.at(i), tagIDs.at(i+1));
        tags_unfiltered.push_back(new_tag);
    }
   
    /*
    //print unfiltered
    std::cout << "Unfiltered: " <<std::endl;
    for (unsigned int i = 0; i < tags_unfiltered.size(); i++){
        std::cout << tags_unfiltered.at(i) << ", ";
    }
    std::cout << std::endl;
    */

    //filter tags
    for (unsigned int i = 0; i < tags_unfiltered.size(); i++){
        string filtered_tag = tags_unfiltered.at(i);

        //punctuation check
        while (filtered_tag.back() == '!' || filtered_tag.back() == ',' || filtered_tag.back() == '.' || filtered_tag.back() == '?') {
            filtered_tag.pop_back();
        }
        
        //uppercase to lowercase
        for (unsigned int i = 0; i < filtered_tag.length(); i++){
            if (filtered_tag[i] >= 65 && filtered_tag[i] <= 90){
                filtered_tag[i] += 32;
            }
        }

        //check for duplicates
        bool duplicate = false;
        for (unsigned int i = 0; i < tags.size(); i++){
            if (filtered_tag == tags.at(i)){
                duplicate = true;
            }
        }
        if (!duplicate){
            tags.push_back(filtered_tag);
        }

        //for comparison
        tags_unfiltered.at(i) = filtered_tag;
    }

    /*
    //print unfiltered (after filter)
    std::cout << "Unfiltered (after filter): " <<std::endl;
    for (unsigned int i = 0; i < tags_unfiltered.size(); i++){
        std::cout << tags_unfiltered.at(i) << ", ";
    }
    std::cout << std::endl;

    //print true filtered
    std::cout << "Filtered: " <<std::endl;
    for (unsigned int i = 0; i < tags.size(); i++){
        std::cout << tags.at(i) << ", ";
    }
    std::cout << std::endl;
    */

    return tags;
}
