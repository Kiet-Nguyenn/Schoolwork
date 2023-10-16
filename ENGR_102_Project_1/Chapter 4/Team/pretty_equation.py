# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Names:        Kiet Nguyen
#               Brandon Le
#               Michael Chrisanthus
#               Nathan Yandell
# Section:      509
# Assignment:   Lab 4 - 2
# Date:         9/19/22
#

#Print and Prompt
a = input("Please enter the coefficient A: ")
b = input("Please enter the coefficient B: ")
c = input("Please enter the coefficient C: ")
print("The quadratic equation is ", end='')
#  Create Equation
equation = ''
if int(a) != 0:
    if int(a) < 0:
        equation += '- '
    if not(-1 <= int(a) <= 1):
        equation += f'{abs(int(a))}x^2 '
    else:
        equation += 'x^2 '

if int(b) != 0:
    if int(a) != 0:
        if int(b) < 0:
            equation += '- '
        else:
            equation += '+ '
    if not(-1 <= int(b) <= 1):
        equation += f'{abs(int(b))}x '
    else:
        equation += 'x '

if int(c) != 0:
    if int(a) != 0 or int(b) != 0:
        if int(c) < 0:
            equation += '- '
        else:
            equation += '+ '
    if not(-1 <= int(c) <= 1):
        equation += f'{abs(int(c))} '
    else:
        equation += c
equation += '= 0'
print(equation)
