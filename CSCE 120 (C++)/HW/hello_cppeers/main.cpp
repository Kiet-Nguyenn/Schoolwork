# include <iostream>
# include <string>
# include <stdexcept>
# include "Network.h"

using std::cout, std::cin, std::endl, std::string, std::vector;

void printMenu() {
    cout << "Welcome to CPPeers" << endl;
    cout << "The options are: " << endl;
    cout << "1. load data file and add information" << endl;
    cout << "2. show posts by user" << endl;
    cout << "3. show posts with hashtag" << endl;
    cout << "4. show most popular hashtag" << endl;
    cout << "9. quit" << endl;
    cout << "--------> Enter your option: ";
}

void processLoad(Network& cppeers) {
    string fileName = "";
    cout << "Enter filename: ";
    cin >> fileName;
    cppeers.loadFromFile(fileName);
}

void processPostsByUser(Network& cppeers) {
    // TODO: implement
    string username;
    cout << "Enter username: ";
    cin >> username;

    vector<Post*> posts = cppeers.getPostsByUser(username);

    for (unsigned int i = 0; i < posts.size(); i++){
        cout << posts.at(i)->getPostText() << endl;
    }
}

void processPostsWithHashtags(Network& cppeers) {
    // TODO: implement
    string tagname;
    cout << "Enter tagname: ";
    cin >> tagname;

    vector<Post*> posts = cppeers.getPostsWithTag(tagname);

    for (unsigned int i = 0; i < posts.size(); i++){
        cout << posts.at(i)->getPostText() << endl;
    }
}

void processMostPopularHashtag(Network& cppeers) {
    // TODO: implement
    vector<string> tagnames = cppeers.getMostPopularHashtag();

    for (unsigned int i = 0; i < tagnames.size(); i++){
        cout << tagnames.at(i) << endl;
    }
}

int main() {
    // TODO: uncomment at the end

    try {
         Network cppeers;

        int choice = 0;

        do {
            printMenu();
            cin >> choice;
            switch(choice) {
                case 1: {
                    processLoad(cppeers);
                    break;
                }
                case 2: {
                    processPostsByUser(cppeers);
                    break;
                }
                case 3: {
                    processPostsWithHashtags(cppeers);
                    break;
                }
                case 4: {
                    processMostPopularHashtag(cppeers);
                    break;
                }
            }
        } while (choice != 9);
    } catch (std::exception& exc) {
        std::cout << exc.what() << endl;
    }

    return 0;
}
