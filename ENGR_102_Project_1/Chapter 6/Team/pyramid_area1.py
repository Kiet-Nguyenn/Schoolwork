# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Names:        Kiet Nguyen
#               Brandon Le
#               Michael Chrisanthus
#               Nathan Yandell
# Section:      509
# Assignment:   Lab 6
# Date:         9/30/22
#

import math

# Prompt
length = float(input('Enter the side length in meters: '))
n = int(input('Enter the number of layers: '))
total_foil = 0

# area of equilateral triangle
top = math.sqrt(3)/4 * length**2
# area of square
side = length**2

for i in range(n):
    total_foil += top + (top * i * 2)
    total_foil += (i + 1) * 3 * side

print(f'You need {total_foil:.2f} m^2 of gold foil to cover the pyramid')
