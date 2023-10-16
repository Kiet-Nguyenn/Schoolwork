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

num = int(input('Enter a value for n: '))
left = 0
right = 0
# r serves as counter
r = 1

# left
for i in range(1, num):
    left += i

# right
while right < left:
    right += num + r
    if right != left:
        r += 1

if right > left:
    print(f'{num} is not a balancing number')
else:
    print(f'{num} is a balancing number with r={r}')
