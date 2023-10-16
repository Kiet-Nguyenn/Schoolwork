# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Name:         Kiet Nguyen
# Section:      509
# Assignment:   Lab 2 - 2
# Date:         9/3/22
#

import math

#First Point
start_time = 12
start_x = 8
start_y = 6
start_z = 7
#End Point
end_time = 85
end_x = -5
end_y = 30
end_z = 9
#Slope Calculations
total_time_elapsed = end_time - start_time
slope_x = (end_x - start_x) / (total_time_elapsed)
slope_y = (end_y - start_y) / (total_time_elapsed)
slope_z = (end_z - start_z) / (total_time_elapsed)

#Interpolations
#Point 1
time = 30.0 - start_time
x = (slope_x * time) + start_x
y = (slope_y * time) + start_y
z = (slope_z * time) + start_z
print("At time", time + start_time,"seconds:")
print("x1 =",x,"m")
print("y1 =",y,"m")
print("z1 =",z,"m")
print("-----------------------")

#Point 2
time += 7.5
x = (slope_x * time) + start_x
y = (slope_y * time) + start_y
z = (slope_z * time) + start_z
print("At time", time + start_time,"seconds:")
print("x2 =",x,"m")
print("y2 =",y,"m")
print("z2 =",z,"m")
print("-----------------------")

#Point 3
time += 7.5
x = (slope_x * time) + start_x
y = (slope_y * time) + start_y
z = (slope_z * time) + start_z
print("At time", time + start_time,"seconds:")
print("x3 =",x,"m")
print("y3 =",y,"m")
print("z3 =",z,"m")
print("-----------------------")

#Point 4
time += 7.5
x = (slope_x * time) + start_x
y = (slope_y * time) + start_y
z = (slope_z * time) + start_z
print("At time", time + start_time,"seconds:")
print("x4 =",x,"m")
print("y4 =",y,"m")
print("z4 =",z,"m")
print("-----------------------")

#Point 5
time += 7.5
x = (slope_x * time) + start_x
y = (slope_y * time) + start_y
z = (slope_z * time) + start_z
print("At time", time + start_time,"seconds:")
print("x5 =",x,"m")
print("y5 =",y,"m")
print("z5 =",z,"m")
