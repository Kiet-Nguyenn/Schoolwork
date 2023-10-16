# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Name:         Kiet Nguyen
# Section:      509
# Assignment:   Lab 3
# Date:         9/14/22
#


### DO NOT MODIFY THE 7 LINES BELOW ###
from math import *

def printresult(shape, side, area):
    '''Print the result of the calculation'''
    print(f'A {shape} with side {side:.2f} has area {area:.3f}')

### DO NOT MODIFY THE 7 LINES ABOVE ###

# example function call:
# printresult(<string of the shape name>, <float of side length>, <float of calculated area>)
#
# For example, to use this function to print the results for a square with a side length of 2.236
# and a calculated area of 5, we would use the line below.
# printresult('square', 2.236, 5)
# Remember, your program will be calculating the area for each shape, then using
# the printresult() function to print the result.

# Your code goes here


side = float(input("Please enter the side length: "))
printresult("triangle", side, ((sqrt(3)/4) * side**2))
printresult("square", side, side**2)
printresult("pentagon", side, sqrt(5 * (5 + 2 * sqrt(5))) / 4 * side**2)
printresult("dodecagon", side, 3 * (2 + sqrt(3)) * side**2)

