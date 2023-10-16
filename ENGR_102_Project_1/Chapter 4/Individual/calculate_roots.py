# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Name:         Kiet Nguyen
# Section:      509
# Assignment:   Lab 4 - 1
# Date:         9/22/22
#
from math import *

a = int(input('Please enter the coefficient A: '))
b = int(input('Please enter the coefficient B: '))
c = int(input('Please enter the coefficient C: '))

if a != 0:  # function is quadratic
    discriminant = b**2 - 4 * a * c
    if discriminant > 0:  # discriminant is positive
        root_pos = (-b + sqrt(discriminant)) / (2 * a)
        root_neg = (-b - sqrt(discriminant)) / (2 * a)
        print(f'The roots are x = {root_pos} and x = {root_neg}')
    elif discriminant < 0:  # discriminant is negative.
        real = -b / (2 * a)
        imaginary = sqrt(abs(b**2 - (4 * a * c))) / (2 * a)
        print(f'The roots are x = {real} + {imaginary}i and x = {real} - {imaginary}i')
    else:  # discriminant is zero
        root = (-b + discriminant) / (2 * a)
        print(f'The root is x = {root}')
elif b != 0:  # function is not quadratic
    print(f'The root is x = {-c/b}')
else:
    print('You entered an invalid combination of coefficients!')