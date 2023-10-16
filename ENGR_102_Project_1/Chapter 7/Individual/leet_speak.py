# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Name:         Kiet Nguyen
# Section:      509
# Assignment:   Lab 7 - 2
# Date:         10/18/22
#

# Create dictionary and checklist
leet_dict = {'a': '4', 'e': '3', 'o': '0', 's': '5', 't': '7'}
checklist = ['a', 'e', 'o', 's', 't']

# Prompt
sentence = input('Enter some text: ')
output = ''

for i in range(len(sentence)):
    if sentence[i] in checklist:
        for j in range(len(checklist)):
            if sentence[i] == checklist[j]:
                output += leet_dict[checklist[j]]
    else:
        output += sentence[i]
print(f'In leet speak, "{sentence}" is: ')
print(output)

