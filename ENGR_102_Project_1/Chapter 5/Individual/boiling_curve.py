# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Name:         Kiet Nguyen
# Section:      509
# Assignment:   Lab 5
# Date:         9/28/22
#

import math
# Point A
ax = 1.3
ay = 1000
# Point B
bx = 5
by = 7000
# Point C
cx = 30
cy = 1.5 * 10**6
# Point D
dx = 120
dy = 2.5 * 10**4
# Point E
ex = 1200
ey = 1.5 * 10**6
# Calc slopes
AB_slope = math.log10(by / ay) / math.log10(bx / ax)
BC_slope = math.log10(cy / by) / math.log10(cx / bx)
CD_slope = math.log10(dy / cy) / math.log10(dx / cx)
DE_slope = math.log10(ey / dy) / math.log10(ex / dx)

# Prompt
temp = float(input('Enter the excess temperature: '))

# if temp above or below threshold
if temp < ax or temp > ex:
    print('Surface heat flux is not available')
else:  # if temp within threshold
    if temp < bx:  # first section
        surface_heat_flux = ay * ((temp / ax)**AB_slope)
    elif temp < cx:  # second section
        surface_heat_flux = by * ((temp / bx)**BC_slope)
    elif temp < dx:  # third section
        surface_heat_flux = cy * ((temp / cx)**CD_slope)
    else:  # fourth section
        surface_heat_flux = dy * ((temp / dx)**DE_slope)
    # print only if in threshold
    print(f'The surface heat flux is approximately {surface_heat_flux:.0f} W/m^2')
