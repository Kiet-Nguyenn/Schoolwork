# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Names:        Kiet Nguyen
#               Brandon Le
#               Michael Chrisanthus
#               Nathan Yandell
# Section:      509
# Assignment:   Lab 4 - 3
# Date:         9/19/22
#

############ Part A ############
setA = input("Enter True or False for a: ")
setB = input("Enter True or False for b: ")
setC = input("Enter True or False for c: ")

# Set Variables
if setA == 'True' or setA == 'T' or setA == 't':
    a = True
else:
    a = False

if setB == 'True' or setB == 'T' or setB == 't':
    b = True
else:
    b = False

if setC == 'True' or setC == 'T' or setC == 't':
    c = True
else:
    c = False

############ Part B ############
print("a and b and c: ", a and b and c)
print("a or b or c: ", a or b or c)

############ Part C ############
# XOR
if(a == b):
    xor = False
else:
    xor = True
print("XOR: ", xor)
# Odd number
count = 0
if a == True:
    count += 1
if b == True:
    count += 1
if c == True:
    count += 1
if count % 2 == 0:
    odd = False
else:
    odd = True
print("Odd number: ", odd)
