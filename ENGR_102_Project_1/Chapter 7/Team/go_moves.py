# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Names:        Michael Chrisanthus
#               Nathan Yandell
#               Brandon Le
#               Kiet Nguyen
# Section:      Section 509
# Assignment:   Lab - 2.8
# Date:         8 October 2022

begin = '\x1b[1m'  # Color code that I don't understand yet
end = '\x1b[39m\x1b[22m'
colors = {'red': '\x1b[31m', 'blue': '\x1b[34m'}

o = chr(9679)
board = [[o, o, o, o, o, o, o, o, o],
[o, o, o, o, o, o, o, o, o],
[o, o, o, o, o, o, o, o, o],
[o, o, o, o, o, o, o, o, o],
[o, o, o, o, o, o, o, o, o],
[o, o, o, o, o, o, o, o, o],
[o, o, o, o, o, o, o, o, o],
[o, o, o, o, o, o, o, o, o],
[o, o, o, o, o, o, o, o, o]]

print("", end=" ")
for i in range(len(board)):
    print(i+1, end= " ")
print()
for i in range(len(board)):  # Simple nested for loop to make 9x9 grid
    print("", end=" ")
    for j in range(len(board[i])):
        print(board[i][j], end= " ")
    print("", i + 1)

red_player = True  # Changes every turn to change the player and corresponding piece

while True:

    x = input("What is the x-value of the square you want to place\nyour piece (or type \"stop\" to end the game): ")
    if x == "stop":
        break

    x = int(x) - 1  # The -1 is because a list stores values from 0-8, but the players sees the grid from 1-9
    y = int(input("What is the y-value of the square you want to place\nyour piece: ")) - 1

    if x > 8 or y > 8 or x < 0 or y < 0 or board[y][x] != o:
        print("invalid move")
        continue
    if red_player == True:
        board[y][x] = begin + colors['red'] + o + end  # White stone
    else:
        board[y][x] = begin + colors['blue'] + o + end  # Black stone
    red_player = not red_player

    print("", end=" ")
    for i in range(len(board)):
        print(i + 1, end=" ")
    print()
    for i in range(len(board)):  # Simple nested for loop to make 9x9 grid
        print("", end=" ")
        for j in range(len(board[i])):
            print(board[i][j], end=" ")
        print("", i + 1)

print("Thank you for playing.")
