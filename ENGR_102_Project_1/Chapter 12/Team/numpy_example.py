# As a team, we have gone through all required sections of the
# tutorial, and each team member understands the material
# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Names:        Brandon Le
#               Kiet Nguyen
#               Michael Chrisanthus
#               Nathan Yandell
# Section:      Section 509
# Assignment:   Lab - 12.14
# Date:         29 November 2022
import numpy
import numpy as np
import math
a = np.arange(12).reshape(3,4)
b = np.arange(8).reshape(4,2)
c = np.arange(6).reshape(2,3)
d = a @ b @ c #multiplying matrices
dt = d.T
e = numpy.sqrt(d)/2
print(f'A = {a}')
print(f'B = {b}')
print(f'C = {c}')
print(f'D = {d}')
print(f'D^T = {dt}')
print(f'E = {e}')