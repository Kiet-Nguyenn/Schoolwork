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

# collecting inputs
t1 = float(input('Enter time 1: '))
x1 = float(input('Enter the x position of the object at time 1: '))
y1 = float(input('Enter the y position of the object at time 1: '))
z1 = float(input('Enter the z position of the object at time 1: '))
t2 = float(input('Enter time 2: '))
x2 = float(input('Enter the x position of the object at time 2: '))
y2 = float(input('Enter the y position of the object at time 2: '))
z2 = float(input('Enter the z position of the object at time 2: '))

# establish difference between times and points
t = t2-t1
add_t = t/4
t = t1
x = x2 - x1
add_x = x/4
x = x1
y = y2 - y1
add_y = y/4
y = y1
z = z2 - z1
add_z = z/4
z = z1

while t <= t2:
    print(f"At time {t:.2f} seconds the object is at ({x:.3f}, {y:.3f}, {z:.3f})")
    t += add_t
    x += add_x
    y += add_y
    z += add_z