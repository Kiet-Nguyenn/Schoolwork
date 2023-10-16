# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Name:         Kiet Nguyen
# Section:      509
# Assignment:   Lab 2 - 3
# Date:         9/3/22
#

#1
x = 1
z = 0
z += x  #z = 1
print(z)

#26
y = 10
z += y  #z = 11
z += y  #z = 21
x += 1  #x = 2
x += 1  #x = 3
x += 1  #x = 4
x += 1  #x = 5
z += x  #z = 26
print(z)

#102
y *= x  #y = 50
x = y   #x = 50
y += x  #y = 100
x = 1
z = 0
z += y  #z = 100
z += x  #z = 101
z += x  #z = 102
print(z)

#1,000,000,000
x = y   #x = 100
y *= x  #y = 10,000
y *= x  #y = 1,000,000
y *= x  #y = 100,000,000
x = 1   #x = 1
x += 1  #x = 2
x += 1  #x = 3
x += 1  #x = 4
x += 1  #x = 5
x += 1  #x = 6
x += 1  #x = 7
x += 1  #x = 8
x += 1  #x = 9
x += 1  #x = 10
y *= x  #y = 1,000,000,000
z = 0
z += y  #z = 1,000,000,000
print(z)

#8675
y = 10
y *= x  #y = 100
x = 1   #x = 1
x += 1  #x = 2
x += 1  #x = 3
x += 1  #x = 4
x += 1  #x = 5
z = 0
z += x  #z = 5
x += 1  #x = 6
y *= x  #y = 600
z += y  #z605
y = 10
z += y  #z = 615
y *= x  #y = 60
z += y  #z = 675
x += 1  #x = 7
x += 1  #x = 8
y = 10
y *= x  #y = 80
x += 1  #x = 9
x += 1  #x = 10
y *= x  #y = 800
y *= x  #y = 8000
z += y  #z = 8675
print(z)