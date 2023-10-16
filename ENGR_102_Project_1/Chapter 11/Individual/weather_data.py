# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Name:         Kiet Nguyen
# Section:      509
# Assignment:   Lab 11 - 2
# Date:         11/14/22
#

with open('WeatherDataCLL.csv', 'r') as f:
    file = f.read()
    days = file.split('\n')
    day_data = []

    maximum = 60  # estimate
    minimum = 60  # estimate
    total_precipitate = 0
    for i in range(1, len(days) - 1):  # Yearly max and min
        day_data = days[i].split(',')
        total_precipitate += float(day_data[2])
        if int(day_data[4]) > maximum:
            maximum = int(day_data[4])
        if int(day_data[5]) < minimum:
            minimum = int(day_data[5])
    avg_precipitate = total_precipitate / len(days)

    print(f'3-year maximum temperature: {maximum} F')
    print(f'3-year minimum temperature: {minimum} F')
    print(f'3-year average precipitation: {avg_precipitate:.3f} inches')
    print()
    month = input('Please enter a month: ')
    year = input('Please enter a year: ')
    print()
    print(f'For {month} {year}:')
    months_dict = {'January': 1,
                   'February': 2,
                   'March': 3,
                   'April': 4,
                   'May': 5,
                   'June': 6,
                   'July': 7,
                   'August': 8,
                   'September': 9,
                   'October': 10,
                   'November': 11,
                   'December': 12
                   }

    months_days_dict = {'January': 31,
                        'February': 28,
                        'March': 31,
                        'April': 30,
                        'May': 31,
                        'June': 30,
                        'July': 31,
                        'August': 31,
                        'September': 30,
                        'October': 31,
                        'November': 30,
                        'December': 31
                        }

    day_data = []
    monthly_temps = 0
    monthly_wind_speeds = 0
    days_with_precipitation = 0
    for i in range(1, len(days) - 1):  # Monthly means
        day_data = days[i].split(',')
        if int(day_data[0][:day_data[0].index('/')]) == months_dict[month]:
            if day_data[0][-4:] == year:
                monthly_temps += int(day_data[4])
                monthly_wind_speeds += float(day_data[1])
                if float(day_data[2]) != 0:
                    days_with_precipitation += 1

    mean_daily_temp = monthly_temps / months_days_dict[month]
    mean_wind_speeds = monthly_wind_speeds / months_days_dict[month]
    mean_precipitation = (days_with_precipitation / months_days_dict[month]) * 100

    print(f'Mean maximum daily temperature: {mean_daily_temp:.1f} F')
    print(f'Mean daily wind speed: {mean_wind_speeds:.2f} mph')
    print(f'Percentage of days with precipitation: {mean_precipitation:.1f}%')
