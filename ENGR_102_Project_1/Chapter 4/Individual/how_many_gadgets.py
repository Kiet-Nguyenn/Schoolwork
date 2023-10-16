# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Name:         Kiet Nguyen
# Section:      509
# Assignment:   Lab 4 - 1
# Date:         9/22/22
#

import math

day = int(input('Please enter a positive value for day: '))
gadgets = 0

if day > 0:
    if day < 11:
        gadgets += day * 5
    elif day < 61:
        gadgets += 50  # from first 10 days
        gadgets += (day - 10) * 50
    elif day < 101:
        gadgets += 2550  # from first 60 days
        b1 = 49
        b2 = 50 - (day - 60)
        h = day - 60
        gadgets += ((b1 + b2) // 2) * h
    else:
        gadgets = 3730
    print(f'The total number of gadgets produced on day {day} is {gadgets}')
else:
    print('You entered an invalid number!')
