# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Name:         Kiet Nguyen
# Section:      509
# Assignment:   Lab 6 - 1
# Date:         10/5/22
#

import math
# prompt
howdy = int(input('Enter an integer: '))
whoop = int(input('Enter another integer: '))
# loop
for i in range(1, 101):
    # check for division
    if i % howdy == 0 or i % whoop == 0:
        if i % howdy == 0:
            print('Howdy ', end='')
        if i % whoop == 0:
            print('Whoop', end='')
        print()
    else:
        print(i)
