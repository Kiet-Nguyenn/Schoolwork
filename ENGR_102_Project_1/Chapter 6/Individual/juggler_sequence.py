# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Name:         Kiet Nguyen
# Section:      509
# Assignment:   Lab 6 - 2
# Date:         10/5/22
#

import math

# prompt
num = int(input('Enter a positive integer: '))
count = 0

print(f'The Juggler sequence starting at {num} is:')
print(num, end='')
while num != 1:
    if num % 2 == 0:
        num = int(math.sqrt(num))
    else:
        num = int(num**(3/2))
    count += 1

    print(f', {num}', end='')
print()
print(f'It took {count} iterations to reach 1')
