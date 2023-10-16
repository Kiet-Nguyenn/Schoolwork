# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Name:         Kiet Nguyen
# Section:      509
# Assignment:   Lab 12
# Date:         11/29/22
#

import numpy as np
import matplotlib.pyplot as plt
import math

v = np.array([0, 1])
m = np.array([[1.01, 0.09], [-0.09, 1.01]])
points = []

for i in range(100):
    new_v = v @ m
    points.append(new_v)
    v = new_v

x_vals = []
y_vals = []

for i in range(100):
    x_vals.append(points[i][0])
    y_vals.append(points[i][1])

plt.plot(x_vals, y_vals)
plt.title('Swirl')
plt.xlabel('x')
plt.ylabel('y')
plt.show()
