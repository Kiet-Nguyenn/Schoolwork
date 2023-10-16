# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Name:         Kiet Nguyen
# Section:      509
# Assignment:   Lab 2
# Date:         9/3/22
#

import math

#Force
mass = 3 #kg
acceleration = 5.5 #m/s^2

#Wavelength
distance = 0.025 #nm
angle = 25 #degrees

#Radon-222 Half Life
time = 3 #days
initial_amount = 5 #g
half_life = 3.8 #days

#Pressure
amount_idealGas = 5 #moles
volume = 0.25 #m^3
temp = 415 #K
gas_constant = 8.314 #m^3/K*mol

print("Force is", mass * acceleration,"N")
print("Wavelength is", 2 * distance * math.sin(angle * (math.pi/180)), "nm")
print("Radon-222 left is", initial_amount*2**(-time/half_life), "g")
print("Pressure is", (amount_idealGas*gas_constant*temp)/(volume * 1000), "kPa")