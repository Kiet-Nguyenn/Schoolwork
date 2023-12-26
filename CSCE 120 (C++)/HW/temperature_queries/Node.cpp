# include <string>
# include "Node.h"

using std::string;

Node::Node() : data(), next() {
	TemperatureData* tempData = new TemperatureData();
	data.id = tempData->id;
	data.year = tempData->year;
	data.month = tempData->month;
	data.temperature = tempData->temperature;
	delete tempData;

	next = nullptr;
}

Node::Node(string id, int year, int month, double temperature) : data(), next() {
	TemperatureData* tempData = new TemperatureData(id, year, month, temperature);
	data.id = tempData->id;
	data.year = tempData->year;
	data.month = tempData->month;
	data.temperature = tempData->temperature;
	delete tempData;

	next = nullptr;
}

bool Node::operator<(const Node& b) {	
	return this->data < b.data;
}
