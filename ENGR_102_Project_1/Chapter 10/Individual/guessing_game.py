# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Name:         Kiet Nguyen
# Section:      509
# Assignment:   Lab 10
# Date:         11/05/22
#

num = 0
secret_num = 26
count = 0
invalid = False


def compare(num):  # Compares guess to number and evaluates
    if num > secret_num:
        print('Too high!')
    elif num < secret_num:
        print('Too low!')
    else:
        print(f'You guessed it! It took you {count} guesses.')


def prompt():  # Prompt for guess
    guess = int(input('What is your guess? '))
    return guess


def prompt2():
    guess = int(input('Bad input! Try again: '))
    return guess


print("Guess the secret number! Hint: it's an integer between 1 and 100...")
while num != secret_num:
    try:
        if not invalid:
            num = prompt()
        else:
            num = prompt2()
        invalid = False
        count += 1
        compare(num)
    except ValueError:
        invalid = True
        continue
