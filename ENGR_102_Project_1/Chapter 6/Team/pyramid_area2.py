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
# Date:         10/3/22
#

import math

length = float(input('Enter the side length in meters: '))
n = int(input('Enter the number of layers: '))
total_foil = 0

tri = math.sqrt(3)/4 * length**2  # Area of top
square = length**2  # Area of side

total_foil += (3 * n * (3 * n + 3) / 6) * square  # visible squares * square area
total_foil += n**2 * tri  # visible triangles * triangle area

print(f'You need {total_foil:.2f} m^2 of gold foil to cover the pyramid')

