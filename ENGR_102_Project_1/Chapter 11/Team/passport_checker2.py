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

valid = open('valid_passports2.txt', 'w')
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


def confirm(string):
    if string[:3] == 'byr':
        try:
            if int(string[4:8]) >= 1920:
                if int(string[4:8]) <= 2005:
                    return True
        except ValueError:
            return False
    if string[:3] == 'iyr':
        try:
            if int(string[4:8]) >= 2012:
                if int(string[4:8]) <= 2022:
                    return True
        except ValueError:
            return False
    if string[:3] == 'eyr':
        try:
            if int(string[4:8]) >= 2022:
                if int(string[4:8]) <= 2032:
                    return True
        except ValueError:
            return False
    if string[:3] == 'hgt':
        if string[-2:] == 'cm':
            try:
                num = int(string[string.index(':') + 1:string.index('c')])
                if 150 <= num & num <= 193:
                    return True
            except ValueError:
                return False
        if string[-2:] == 'in':
            try:
                num = int(string[string.index(':') + 1:string.index('i')])
                if 59 <= num & num <= 76:
                    return True
            except ValueError:
                return False
    if string[:3] == 'ecl':
        colors = ['amb', 'blu', 'brn', 'gry', 'grn', 'hzl', 'oth']
        if string[string.index(':') + 1: string.index(':') + 4] in colors:
            return True
    if string[:3] == 'pid':
        num = string[string.index(':') + 1:]
        if len(num) == 9:
            try:
                num = int(num)
                return True
            except ValueError:
                return False
    if string[:3] == 'cid':
        try:
            num = int(string[string.index(':') + 1:])
            if 100 <= num & num <= 999:
                return True
        except ValueError:
            return False
    return False


with open(file_name, 'r') as f:
    all_passports = f.read()
    passports = all_passports.split('\n\n')
    for i in range(len(passports)):  # iterates through all passports to validate
        if validate(passports[i]):
            ppcheck1 = passports[i].split('\n')
            ppcheck2 = []
            for j in range(len(ppcheck1)):
                ppcheck2 += ppcheck1[j].split(' ')
            check_count = 0
            for j in range(len(ppcheck2)):
                if confirm(ppcheck2[j]):
                    check_count += 1
            if check_count == 7:
                count += 1
                contents += passports[i] + '\n\n'
    valid.write(contents)

print(f'There are {count} valid passports')