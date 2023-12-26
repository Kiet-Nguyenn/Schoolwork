# include "TemperatureDatabase.h"
# include <iostream>

using std::cout, std::endl;

int main(int argc, char** argv) {
	
	if (argc < 3) {
		cout << "Usage: " << argv[0] << " data_file query_file" << endl;
		return 1;
	} else {
		TemperatureDatabase database;
		database.loadData(argv[1]);
		//database.outputData(argv[1]); // comment out before submitting Part 2
		//database.performQuery(argv[2]); // will be done in Part 2
	}
	
	
	/*
	LinkedList list;
	//Node node1("mac", 2015, 7, 22.3);
	//Node node2("mac", 2011, 6, 18.5);
	//Node node3("mac", 2015, 5, 19.2);
	//Node node4("zeb", 1995, 2, 5);

	list.insert("mac", 2015, 7, 22.3);
	list.insert("mac", 2011, 6, 18.5);
	list.insert("mac", 2015, 5, 19.2);
	list.insert("zeb", 1995, 2, 5);

	cout << "Actual:\n";
	cout << list.print();

	cout << "Expected:\n";
	cout << "mac 2011 6 18.5\nmac 2015 5 19.2\nmac 2015 7 22.3\nzeb 1995 2 5\n";

	//cout << "NODE TESTING:" << endl;
	//std::cout << "comparing: " << node1.data.id << " " << node1.data.year << " " << node1.data.month << " " << node1.data.temperature << " < " << node2.data.id << " " << node2.data.year << " " << node2.data.month << " " << node2.data.temperature << " = " << (node1 < node2) << std::endl;
	//std::cout << "	breakdown: id: " << node1.data.id << " < " << node2.data.id << " = " << (node1.data.id < node2.data.id) << std::endl;
	//std::cout << "		   year: " << node1.data.year << " < " << node2.data.year << " = " << (node1.data.year < node2.data.month) << std::endl;
	//std::cout << "		   month: " << node1.data.month << " < " << node2.data.month << " = " << (node1.data.month < node2.data.month) << std::endl;
	*/
	
}
