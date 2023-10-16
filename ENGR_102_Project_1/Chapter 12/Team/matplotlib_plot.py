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
import matplotlib.pyplot as plt
from math import *
t = [0, 0.45, 1.1, 1.75, 2.25, 2.7]
y = [0, 0.23, 0.4, 0.18, 0.07, 0.01]
t_y = []
t_y2 = []
value = 0
times = []
while value < 3:
    t_y.append((value**2) * exp(-value**2))
    times.append(value)
    value += 0.06
value = 0
times2 = []
while value < 3:
    t_y2.append((value ** 4) * exp(-value ** 2))
    times2.append(value)
    value += 0.06

pt_2 = []
times3 = []
value2 = 1
while value2 < 2:
    pt_2.append((value2**2) * exp(-value2**2))
    times3.append(value2)
    value2 += 0.06

plt.subplot(2,1,1)
plt.plot(t, y, 'ko', label='data')
plt.plot(times, t_y, 'r', label='t^2*exp(-t^2)')
plt.plot(times2, t_y2, 'b', label='t^4*exp(-t^2)')
plt.title('Data and two curves vs. time')
plt.xlabel('time')
plt.ylabel('y')
plt.legend(loc='upper right', frameon=True)
plt.xticks([0.0, 0.5, 1.0, 1.5, 2.0, 2.5])
plt.yticks([0.0, 0.2, 0.4, 0.6, 0.8, 1.0])
plt.xlim([0,3])
plt.ylim([0,1])

plt.subplot(2,1,2)
plt.plot(times3, pt_2, 'b', label='t^2*exp(-t^2)')
t2 = times3[7]
y2 = pt_2[7]
plt.annotate("It's closest here" , xy= (t2, y2), xycoords='data', xytext=(-50, -40), textcoords='offset points', fontsize=10, arrowprops=dict(arrowstyle="->"))
plt.plot(t, y, 'y')
plt.plot(t[2], y[2], 'y^', label='data')
plt.plot(t[3], y[3], 'y^')
plt.title('Data interpolation and Curve 1')
plt.xlabel('time')
plt.ylabel('y')
plt.legend(loc='upper right', frameon=True)
plt.xticks([1.0, 1.2, 1.4, 1.6, 1.8, 2.0])
plt.yticks([0.0, 0.1, 0.2, 0.3, 0.4, 0.5])
plt.xlim([1, 2])
plt.ylim([0, 0.5])
plt.tight_layout()
plt.show()