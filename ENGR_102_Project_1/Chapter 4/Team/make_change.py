# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Names:        Kiet Nguyen
#               Brandon Le
#               Michael Chrisanthus
#               Nathan Yandell
# Section:      509
# Assignment:   Lab 4 - 1
# Date:         9/16/22
#

import math
#  prompt
pay = float(input("How much did you pay? "))  #comment
cost = float(input("How much did it cost? "))  #comment
change = round((pay - cost) * 100, 2)
print(f"You received ${change / 100:.2f} in change. That is...")
#  solve
#  quarters
if change // 25 > 0:  #comment
    quarters = change // 25
    change -= quarters * 25
    if quarters == 1:
        print(f"{quarters:.0f} quarter")
    else:
        print(f"{quarters:.0f} quarters")
#  dimes
if change // 10 > 0:
    dimes = change // 10
    change -= dimes * 10
    if dimes == 1:
        print(f"{dimes:.0f} dime")
    else:
        print(f"{dimes:.0f} dimes")
#  nickels
if change // 5 > 0:
    nickels = change // 5
    change -= nickels * 5
    if nickels == 1:
        print(f"{nickels:.0f} nickel")
    else:
        print(f"{nickels:.0f} nickels")
#  pennies
if change > 0:
    if change == 1:
        print(f"1 penny")
    else:
        print(f"{change:.0f} pennies")
