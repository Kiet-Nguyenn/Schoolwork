# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Name:         Kiet Nguyen
# Section:      509
# Assignment:   Lab 11 - 1
# Date:         11/14/22
#

valid = open('valid_barcodes.txt', 'w')
contents = ''
count = 0

file_name = input('Enter the name of the file: ')


def validate(list_a, list_b, last_num):   # Takes first and second group and final digit of barcode
    list1_sum = sum(list_a)
    list2_sum = sum(list_b)
    list2_sum *= 3
    total = list1_sum + list2_sum
    final_digit = int(str(total)[-1])
    check = 10 - final_digit
    if check == int(last_num):
        return True
    return False


with open(file_name, 'r') as f:
    barcodes_string = f.read()
    barcodes = barcodes_string.split('\n')

for i in range(len(barcodes)):  # splits barcodes into lists
    list1 = []
    list2 = []
    for j in range(0, len(barcodes[i]) - 1, 2):
        list1.append(int(barcodes[i][j]))
    for j in range(1, len(barcodes[i]), 2):
        list2.append(int(barcodes[i][j]))
    if validate(list1, list2, barcodes[i][-1]):
        count += 1
        contents += barcodes[i] + '\n'

valid.write(contents)
print(f'There are {count} valid barcodes')
