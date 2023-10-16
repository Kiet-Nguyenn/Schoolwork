# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Names:        Kiet Nguyen
#               Brandon Le
#               Michael Chrisanthus
#               Nathan Yandell
# Section:      509
# Assignment:   Lab 5
# Date:         9/26/22
#

import math

# sex
sex_check = input('Enter your sex (M/F) : ')
if sex_check == 'F' or sex_check == 'f':
    sex = 0.879
else:  # male
    sex = 0

# age
age = int(input('Enter your age (years) : '))

# BMI
bmi_check = float(input('Enter your BMI: '))
if bmi_check < 25:
    bmi = 0
elif bmi_check < 27.5:
    bmi = 0.699
elif bmi_check < 30:
    bmi = 1.97
else:  # over 30
    bmi = 2.518

# Hypertension Medication
hypertension_check = input('Are you on medication for hypertension (Y/N)? ')
if hypertension_check == 'Y' or hypertension_check == 'y':
    hypertension = 1.222
else:
    hypertension = 0

# Steroids
steroids_check = input('Are you on steroids (Y/N)? ')
if steroids_check == 'Y' or steroids_check == 'y':
    steroids = 2.191
else:
    steroids = 0

# Smoker
smoker_check = input('Do you smoke cigarettes (Y/N)? ')
if smoker_check == 'Y' or smoker_check == 'y':
    smoker = 0.855
else:  # check for past smoker
    past_smoker_check = input('Did you used to smoke (Y/N)? ')
    if past_smoker_check == 'Y' or past_smoker_check == 'y':
        smoker = -0.218
    else:  #no smoking history
        smoker = 0

# Family History
family_check = input('Do you have a family history of diabetes (Y/N)? ')
if family_check == 'Y' or family_check == 'y':
    both_check = input('Both parent and sibling (Y/N)? ')
    if both_check == 'Y' or both_check == 'y':  #check for both
        history = 0.753
    else:  # only one
        history = 0.728
else:  # no history
    history = 0


# calculate
n = 6.322 + sex - (0.063 * age) - bmi - hypertension - steroids - smoker - history
risk = 100 / (1 + math.exp(n))
print(f'Your risk of developing type-2 diabetes is {risk:.1f}%')
