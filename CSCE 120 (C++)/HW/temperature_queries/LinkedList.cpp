# include <iostream>
# include <string>
# include "LinkedList.h"
# include "Node.h"
# include <sstream>

using std::string, std::ostream;

LinkedList::LinkedList() : head(nullptr), tail(nullptr) {
}

LinkedList::~LinkedList() {
	clear();
}

LinkedList::LinkedList(const LinkedList& source) : head(), tail() {
	clear();

	Node* current_source = source.head;
	Node* current_local = nullptr;
	while (current_source != nullptr){
		Node* newNode = new Node();
		newNode->data.id = current_source->data.id;
		newNode->data.year = current_source->data.year;
		newNode->data.month = current_source->data.month;
		newNode->data.temperature = current_source->data.temperature;

		if(head == nullptr){
			head = newNode;
			current_local = head;
		} else {
			current_local->next = newNode;
			current_local = current_local->next;
		}
		current_source = current_source->next;
	}
	tail = current_local;
}

LinkedList& LinkedList::operator=(const LinkedList& source) {
	if (this == &source){
		return *this;
	}

	clear();
	
	Node* current_source = source.head;
	Node* current_local = nullptr;
	while (current_source != nullptr){
		Node* newNode = new Node();
		newNode->data.id = current_source->data.id;
		newNode->data.year = current_source->data.year;
		newNode->data.month = current_source->data.month;
		newNode->data.temperature = current_source->data.temperature;

		if(head == nullptr){
			head = newNode;
			current_local = head;
		} else {
			current_local->next = newNode;
			current_local = current_local->next;
		}
		current_source = current_source->next;
	}
	tail = current_local;
	return *this;
}

void LinkedList::insert(string location, int year, int month, double temperature) {
	Node* newNode = new Node(location, year, month, temperature);
	Node* current = head;
	Node* prev = nullptr;
	bool is_tail = false;
	bool is_head = true;
	if (current != nullptr){
		while ((*current < *newNode) && (!is_tail)){
			//std::cout << "comparing: " << current->data.id << " " << current->data.year << " " << current->data.month << " " << current->data.temperature << " < " << newNode->data.id << " " << newNode->data.year << " " << newNode->data.month << " " << newNode->data.temperature << " = " << (*current < *newNode) << std::endl;
			//std::cout << "	breakdown: id: " << current->data.id << " < " << newNode->data.id << " = " << (current->data.id < newNode->data.id) << std::endl;
			//std::cout << "		   year: " << current->data.year << " < " << newNode->data.year << " = " << (current->data.year < newNode->data.month) << std::endl;
			//std::cout << "		   month: " << current->data.month << " < " << newNode->data.month << " = " << (current->data.month < newNode->data.month) << std::endl;
			//std::cout << "comparing: " << newNode->data.id << " " << newNode->data.year << " " << newNode->data.month << " " << newNode->data.temperature << " < " << current->data.id << " " << current->data.year << " " << current->data.month << " " << current->data.temperature << " = " << (newNode < current) << std::endl;
			is_head = false;
			prev = current;
			if (current->next == nullptr){
				is_tail = true;
			} else {
				current = current->next;
			}
		}
		//std::cout << "result: " << current->data.id << " " << current->data.year << " " << current->data.month << " " << current->data.temperature << " < " << newNode->data.id << " " << newNode->data.year << " " << newNode->data.month << " " << newNode->data.temperature << " = " << (*current < *newNode) << std::endl;
	}
	//std::cout << "tail: " << is_tail << "    head: " << is_head << std::endl;
	//std::cout << "BEFORE: " << std::endl << print() << std::endl;

	if(tail == nullptr || is_tail == true) {
		tail = newNode;
	} else {
		newNode->next = current;
	}
	if(head == nullptr || is_head == true){
		newNode->next = head;
		head = newNode;
	} else {
		prev->next = newNode;
	}

	//std::cout << "AFTER: " << std::endl << print() << std::endl;
		
	

}

void LinkedList::clear() {
	Node* current = head;
	while (current != nullptr){
		Node* nextNode = current->next;
		delete current;
		current = nextNode;
	}

	head = nullptr;
	tail = nullptr;
}

Node* LinkedList::getHead() const {
	return head;
}

string LinkedList::print() const {
	string outputString;
	std::ostringstream ostring;
	Node* current = head;
	while (current != nullptr){
		Node* nextNode = current->next;
		ostring << current->data.id << " " << current->data.year << " " << current->data.month << " " << current->data.temperature << std::endl;
		current = nextNode;
	}
	outputString = ostring.str();
	
	return outputString;
}

ostream& operator<<(ostream& os, const LinkedList& ll) {
	os << ll.print();
	return os;
}
