# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Names:        Michael Chrisanthus
#               Nathan Yandell
#               Brandon Le
#               Kiet Nguyen
# Section:      Section 509
# Assignment:   Lab 11
# Date:         13 November 2022

valid = open('valid_passports.txt', 'w')
contents = ''
file_name = input('Enter the name of the file: ')
count = 0


def validate(string):  # Checks for all fields
    is_valid = 0
    if 'byr' in string:
        is_valid += 1
    if 'iyr' in string:
        is_valid += 1
    if 'eyr' in string:
        is_valid += 1
    if 'hgt' in string:
        is_valid += 1
    if 'ecl' in string:
        is_valid += 1
    if 'pid' in string:
        is_valid += 1
    if 'cid' in string:
        is_valid += 1
    if is_valid == 7:
        return True
    return False


with open(file_name, 'r') as f:
    all_passports = f.read()
    passports = all_passports.split('\n\n')
    for i in range(len(passports)):  # iterates through all passports to validate
        if validate(passports[i]):
            count += 1
            contents += passports[i] + '\n\n'
    valid.write(contents)

print(f'There are {count} valid passports')



