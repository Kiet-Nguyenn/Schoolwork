# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Name:         Kiet Nguyen
# Section:      509
# Assignment:   Lab 11 - 2
# Date:         11/14/22
#

coins = open('coins.txt', 'w')
coin_count = 0
contents = ''
count = 0
move = 0

with open('game.txt', 'r') as f:
    game_big = f.read()
    game = game_big.split('\n')

while move < len(game):
    data = game[move].split()
    if data[0] == 'coin':
        contents += str(int(data[1])) + '\n'
        coin_count += int(data[1])
        move += 1
    elif data[0] == 'none':
        move += 1
    else:  # jump
        move += int(data[1])

coins.write(contents)
print(f'Total coins collected: {coin_count}')

