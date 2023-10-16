# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Names:        Kiet Nguyen
#               Brandon Le
#               Michael Chrisanthus
#               Nathan Yandell
# Section:      509
# Assignment:   THE ASSIGNMENT NUMBER (e.g. Lab 1b-2)
# Date:         9/7/22
#

import math

radius = 6745
circumference = 2 * math.pi * radius
# First Point
time1 = 10  # min
dist1 = 2026  # km
# Second Point
time2 = 55  # min
dist2 = 23026  # km

# Solve
slope = (dist2 - dist1) / (time2 - time1)
time = 25
dist = slope * (time - time1) + dist1
print("Part 1:")
print("For t =", time, "minutes, the position p =", dist, "kilometers")

time = 300
dist = slope * (time - time1) + dist1
while dist >= circumference:
    dist -= circumference
print("Part 2:")
print("For t =", time, "minutes, the position p =", dist, "kilometers")
