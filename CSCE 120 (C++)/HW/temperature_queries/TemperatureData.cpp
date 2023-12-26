# include "TemperatureData.h"
using std::string;

TemperatureData::TemperatureData() : id(""), year(0), month(0), temperature(-99.99) {
	// TODO: implement this function
}

TemperatureData::TemperatureData(string id, int year, int month, double temperature) : id(id), year(year), month(month), temperature(temperature) {
	// TODO: implement this function
}

TemperatureData::~TemperatureData() {}

bool TemperatureData::operator<(const TemperatureData& b) {
	if (this->id == b.id){
		if (this->year == b.year){
			return this->month < b.month;
		}
		return this->year < b.year;
	}
	return this->id < b.id;
}

