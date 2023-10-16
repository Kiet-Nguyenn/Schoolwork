# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Name:         Kiet Nguyen
# Section:      509
# Assignment:   Lab 3
# Date:         9/14/22
#

import math

# Force
print("This program calculates the applied force given mass and acceleration")
mass = float(input("Please enter the mass (kg): \n"))
acceleration = float(input("Please enter the acceleration (m/s^2): \n"))
print(f"Force is {mass * acceleration:.1f} N\n")

# Wavelength
print("This program calculates the wavelength given distance and angle")
distance = float(input("Please enter the distance (nm): \n"))
angle = float(input("Please enter the angle (degrees): \n"))
print(f"Wavelength is {2 * distance * math.sin(angle * (math.pi/180)):.4f} nm\n")

# Radon-222 Half Life
print("This program calculates how much Radon-222 is left given time and initial amount")
time = float(input("Please enter the time (days): \n"))
initial_amount = float(input("Please enter the initial amount (g): \n"))
half_life = 3.8  # days
print(f"Radon-222 left is {initial_amount*2**(-time/half_life):.2f} g\n")

# Pressure
print("This program calculates the pressure given moles, volume, and temperature")
amount_idealGas = float(input("Please enter the number of moles: \n"))
volume = float(input("Please enter the volume (m^3): \n"))
temp = float(input("Please enter the temperature (K): \n"))
gas_constant = 8.314  # m^3/K*mol
print(f"Pressure is {(amount_idealGas*gas_constant*temp)/(volume * 1000):.0f} kPa\n")