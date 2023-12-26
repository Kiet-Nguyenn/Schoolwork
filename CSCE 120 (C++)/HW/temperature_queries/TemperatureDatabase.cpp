# include "TemperatureDatabase.h"
# include <fstream>
# include <sstream>

using std::cout, std::endl, std::string, std::ofstream;

TemperatureDatabase::TemperatureDatabase() : records() {}
TemperatureDatabase::~TemperatureDatabase() {}

void TemperatureDatabase::loadData(const string& filename) {
	std::ifstream inFS;
	std::stringstream test_stream;
	string temp;
	bool empty = false;
	bool valid = false;
	string id;
	int year;
	int month;
	double temperature;
	string temp_id = "";
	string temp_year = "";
	string temp_month = "";
	string temp_temperature = "";

	inFS.open(filename);

	if(!inFS.is_open()){
		cout << "Error: Unable to open " << filename << endl;
		empty = true;
	}
	
	while (!empty){
		valid = true;
		temp_id = "";
		temp_year = "";
		temp_month = "";
		temp_temperature = "";

		//cout << "Initial: " << endl;
		//cout << "valid: " << valid << endl << "id: " << id << endl << "year: " << year << endl << "month: " << month << endl << "temperature: " << temperature << endl;
		//cout << endl;
		
		temp = "";
		getline(inFS, temp);
		if (temp == ""){
			empty = true;
			cout << "FILE EMPTY" << endl;
			break;
		}

		cout << "TEMP: " << temp << endl;
		test_stream << temp;
		test_stream >> temp_id >> temp_year >> temp_month >> temp_temperature;
		cout << "TEMP VALUES: " << "id: " << temp_id << " " << "year: " << temp_year << " " << "month: " << temp_month << " " << "temperature: " << temp_temperature << endl;
		if (temp_id == "" || temp_year == "" || temp_month == "" || temp_temperature == ""){
			cout << "Error: Other invalid input" << endl;
			valid = false;
		}
		cout << endl;

		//cout << "After temp inialization: " << endl;
		//cout << "valid: " << valid << endl << "id: " << id << endl << "year: " << year << endl << "month: " << month << endl << "temperature: " << temperature << endl;
		//cout << endl;

		if (valid){
		//id check
			id = temp_id;

		//cout << "After id check: " << endl;
		//cout << "valid: " << valid << endl << "id: " << id << endl << "year: " << year << endl << "month: " << month << endl << "temperature: " << temperature << endl;
		//cout << endl;

		//cout << "TEMP: " << temp << endl;
		//cout << "TEMP VALUES: " << "id: " << temp_id << " " << "year: " << temp_year << " " << "month: " << temp_month << " " << "temperature: " << temp_temperature << endl;
		//cout << endl;

		//year check
			year = stoi(temp_year);
			if (year < 1800 || year > 2023){
				valid = false;
				cout << "Error: Invalid year " << year << endl;
			}
		
		//cout << "After year check: " << endl;
		//cout << "valid: " << valid << endl << "id: " << id << endl << "year: " << year << endl << "month: " << month << endl << "temperature: " << temperature << endl;
		//cout << endl;

		//cout << "TEMP: " << temp << endl;
		//cout << "TEMP VALUES: " << "id: " << temp_id << " " << "year: " << temp_year << " " << "month: " << temp_month << " " << "temperature: " << temp_temperature << endl;
		//cout << endl;

		//month check
			month = stoi(temp_month);
			if (month < 1 || month > 12){
				valid = false;
				cout << "Error: Invalid month " << month << endl;
			}

		//cout << "After month check: " << endl;
		//cout << "valid: " << valid << endl << "id: " << id << endl << "year: " << year << endl << "month: " << month << endl << "temperature: " << temperature << endl;
		//cout << endl;

		//cout << "TEMP: " << temp << endl;
		//cout << "TEMP VALUES: " << "id: " << temp_id << " " << "year: " << temp_year << " " << "month: " << temp_month << " " << "temperature: " << temp_temperature << endl;
		//cout << endl;

		//temperature check
			temperature = stod(temp_temperature);
			if (temperature < -50.0 || temperature > 50.0){
				valid = false;
			cout << "Error: Invalid temperature " << temperature << endl;
			}
		

		//cout << "After temperature check / final: " << endl;
		//cout << "valid: " << valid << endl << "id: " << id << endl << "year: " << year << endl << "month: " << month << endl << "temperature: " << temperature << endl;
		//cout << endl;

		//cout << "TEMP: " << temp << endl;
		//cout << "TEMP VALUES: " << "id: " << temp_id << " " << "year: " << temp_year << " " << "month: " << temp_month << " " << "temperature: " << temp_temperature << endl;
		//cout << endl;

			cout << "Tried: " << id << " " << year << " " << month << " " << temperature << endl;
			records.insert(id, year, month, temperature);
			cout << "Recorded: " << id << " " << year << " " << month << " " << temperature << endl;
		}
		
		cout << endl << endl << endl;
	}

	inFS.close();

}

void TemperatureDatabase::outputData(const string& filename) {
	ofstream dataout("sorted." + filename);
	
	if (!dataout.is_open()) {
		cout << "Error: Unable to open " << filename << endl;
		exit(1);
	}

	dataout << records.print();
}

void TemperatureDatabase::performQuery(const string& filename) {
	// TODO: implement this function
}
