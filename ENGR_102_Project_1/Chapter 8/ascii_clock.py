# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Name:         Michael Chrisanthus
#               Nathan Yandell
#               Brandon Le
#               Kiet Nguyen
# Section:      Section 509
# Assignment:   Lab - 1.11
# Date:         7 November 2022

mylist = [["000", "0 0", "0 0", "0 0", "000"], [" 1 ", "11 ", " 1 ", " 1 ", "111"], ["222", "  2", "222", "2  ", "222"],
          ["333", "  3", "333", "  3", "333"], ["4 4", "4 4", "444", "  4", "  4"], ["555", "5  ", "555", "  5", "555"],
          ["666", "6  ", "666", "6 6", "666"], ["777", "  7", "  7", "  7", "  7"], ["888", "8 8", "888", "8 8", "888"],
          ["999", "9 9", "999", "  9", "999"], [" ", ":", " ", ":", " "]]

# above is a list of lists, with each sub list corresponding to a different number (or colon)
# the strings in the sub list are ordered in a top-down fashion

time = input("Enter the time: ")

for i in range(5):  # this first loop goes through each line of the eventual overall output
    print()
    for j in time:  # this loop goes through each character in the input
        try:  # if the character on the current iteration is a number,
            # we output the (i+1)'th line of what the number will look like
            num = int(j)
            print(mylist[num][i], end=" ")
        except ValueError:  # if the character does not convert to an integer, than we assume it is a colon
            print(mylist[10][i], end=" ")
print()
