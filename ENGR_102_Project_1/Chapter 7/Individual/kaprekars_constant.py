# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Name:         Kiet Nguyen
# Section:      509
# Assignment:   Lab 7 - 4
# Date:         10/18/22
#

num =int(input('Enter a four-digit integer: '))
initial_num = num
count = 0

while num != 6174 and num != 0:
    # Break num into list
    num_str = str(num)
    while len(num_str) != 4:
        num_str += '0'
    num_list = []
    for i in range(len(num_str)):
        num_list.append(num_str[i])
    descending_list = sorted(num_list, reverse=True)
    ascending_list = sorted(num_list)

    # Create descending value
    descending = ''
    for i in range(len(descending_list)):
        descending += descending_list[i]
    descending = int(descending)

    # Create ascending value
    ascending = ''
    for i in range(len(ascending_list)):
        ascending += ascending_list[i]
    ascending = int(ascending)

    # Change num
    if descending > ascending:
        print(num, end='')
        num = descending - ascending
    else:
        print(num, end='')
        num = ascending - descending
    if num != 6174 and num != 0:
        print(' > ', end='')
    else:
        print(' >', num)
    count += 1

print(f'{initial_num} reaches {num} via Kaprekar\'s routine in {count} iterations')
