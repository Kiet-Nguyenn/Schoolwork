# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Names:        Kiet Nguyen
#               Brandon Le
#               Michael Chrisanthus
#               Nathan Yandell
# Section:      509
# Assignment:   Lab 3 - 1
# Date:         9/9/22
#

# calcs
num = float(input("Please enter the quantity to be converted: "))
newtons = num * 4.448222
feet = num * 3.28084
kilopascals = num * 101.325
btu = num * 3.412142
gal_per_min = num * 15.850323141489
fahrenheit = (num * (9/5)) + 32


# print
print(f'{num:.2f}', 'pounds force is equivalent to', f'{newtons:.2f}', 'Newtons')
print(f'{num:.2f}', 'meters is equivalent to', f'{feet:.2f}', 'feet')
print(f'{num:.2f}', 'atmospheres is equivalent to', f'{kilopascals:.2f}', 'kilopascals')
print(f'{num:.2f}', 'watts is equivalent to', f'{btu:.2f}', 'BTU per hour')
print(f'{num:.2f}', 'liters per second is equivalent to', f'{gal_per_min:.2f}', 'US gallons per minute')
print(f'{num:.2f}', 'degrees Celsius is equivalent to', f'{fahrenheit:.2f}', 'degrees Fahrenheit')

