# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Name:         Kiet Nguyen
# Section:      509
# Assignment:   Lab 7 - 1
# Date:         10/14/22
#

word = input('Enter word(s) to convert to Pig Latin: ')
word_list = word.split()
length = len(word_list)
vowels = ['a', 'e', 'i', 'o', 'u', 'y']
i = 0

while i < length:
    # Check if word starts with vowel
    if word_list[i][0] in vowels:
            v_start = True
    else:
            v_start = False
    if v_start:  # word starts with vowel
        word_list[i] += 'yay'
    else:  # word starts with consonant
        consonants = len(word_list[i]) - 1
        for j in range(len(word_list[i])):  # check when first vowel is
            if word_list[i][j] in vowels:
                consonants = j
                break
        word_list[i] = word_list[i][consonants:] + word_list[i][:consonants] + 'ay'
    i += 1

print(f'In Pig Latin, "{word}" is: ', end='')
for i in range(length):
    print(word_list[i] + ' ', end='')
