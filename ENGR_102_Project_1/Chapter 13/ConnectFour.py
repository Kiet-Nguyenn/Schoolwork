# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Name:         Michael Chrisanthus
# Section:      Section 509
# Assignment:   Lab 11
# Date:         21 November 2022


import random

begin = '\x1b[1m'  # color stuff
end = '\x1b[39m\x1b[22m'
colors = {'red': '\x1b[31m', 'yellow': '\x1b[33m'}


PlayerPiece = begin + colors['yellow'] + chr(9679) + end  # Define player and computer piece character values
ComputerPiece = begin + colors['red'] + chr(9670) + end
o = chr(9676)


board = [[o, o, o, o, o, o, o],  # grid
[o, o, o, o, o, o, o],
[o, o, o, o, o, o, o],
[o, o, o, o, o, o, o],
[o, o, o, o, o, o, o],
[o, o, o, o, o, o, o]]


def printBoard():
    print("", end=" ")
    for i in range(len(board[0])):
        print(i + 1, end=" ")
    print()
    for i in range(len(board)):  # nested loop to print the board
        print("", end=" ")
        for j in range(len(board[i])):
            print(board[i][j], end=" ")
        print()
    print()


def getInput():

    while True:  # while loop, so we don't leave till we have a valid input
        x = input("Which column do you want to drop you piece in?: ")

        try:  # try is specifically if the user enters something that is not an integer
            if int(x) > 0 and int(x) <= len(board[1]):  # Boundaries for input are 1 and the right most column
                x = int(x) - 1  # we make the x value one less because the code numbers the columns 0-6
                return x  # our column number

            else:
                print("invalid input, try again")  # out of range
        except ValueError:  # not an integer
            print("invalid input, try again")


def checkColumn(col):
    """
    The structure for checking columns goes from -1 downwards. The reason for this is that
    the last printed row (the row on the bottom) is row number len(board). So, we go from
    -1 downwards until we get an out of range error, and then we'll know that the column is full.
    """
    y = -1

    while True:
        try:
            if board[y][col] != o:  # if it is NOT empty
                y -= 1
                continue
            else:  # if it is empty, we can place a piece there
                return y  # and this becomes the row number
        except:
            return "no"  # this will be important to tell the main code to make the user choose a different x value


def checkForWinner(piece):
    """
    The way the return values work in this function is whether or not a player won, and which one won if one did
    All the loops have a return statement that are executed if a condition is met that means someone won
    The loops are all nested for loops that check if a certain player token was played enough times in a row
    to cause a victory or loss.
    If no win condition is met, we return a value that the main code will use as a go ahead to run another turn
    """

    # Check if player won horizontal
    for i in range(len(board)):
        inaRow = 0
        for j in range(len(board[i])):
            if board[i][j] == piece:
                inaRow = inaRow + 1
                if inaRow == 4:
                    return True
            else:
                inaRow = 0

    # Check if player won vertical
    for i in range(len(board[0])):
        inaRow = 0
        for j in range(len(board)):
            if board[j][i] == piece:
                inaRow = inaRow + 1

                if inaRow == 4:
                    return True
            else:
                inaRow = 0

    # Check if player won diagonal part 1a (down and right)
    for i in range(len(board[0])):
        inaRow = 0
        for j in range(len(board[0])):
            try:
                if board[j][i] == piece:
                    inaRow = inaRow + 1
                    if inaRow == 4:
                        return True
                else:
                    inaRow = 0
                i += 1
            except:
                inaRow = 0
                break

    # Check if player won diagonal part 1b
    for i in range(len(board[0])):
        inaRow = 0
        for j in range(len(board[0])):
            try:
                if board[i][j] == piece:
                    inaRow = inaRow + 1
                    if inaRow == 4:
                        return True
                else:
                    inaRow = 0
                i += 1
            except:
                inaRow = 0
                break

    # Check if player won diagonal 2a (down and left)
    for i in range(len(board[0])):
        inaRow = 0
        i = -i - 1
        for j in range(len(board[0])):
            try:
                if board[j][i] == piece:
                    inaRow = inaRow + 1

                    if inaRow == 4:
                        return True
                else:
                    inaRow = 0

                i -= 1
            except:
                inaRow = 0
                break

    # Check if player won diagonal part 2b
    for i in range(len(board[0])):
        inaRow = 0
        for j in range(len(board[0])):
            j = -j - 1
            try:
                if board[i][j] == piece:
                    inaRow = inaRow + 1
                    if inaRow == 4:
                        return True
                else:
                    inaRow = 0
                i += 1
            except:
                inaRow = 0
                break

    # if no condition is met:
    return False


def Tie():
    # if every piece is filled with a piece, it is considered a draw
    tie = True
    for i in range(len(board)):
        for j in range(len(board[i])):
            if board[i][j] == o:
                tie = False
    return tie



def playGame():   # main code

    printBoard()

    player1 = False  # flips every turn

    while True:

        draw = Tie()
        if draw == True:
            winner = "none"
            break
        if player1 == True:
            Done = checkForWinner(PlayerPiece)
            winner = "win"
        else:
            Done = checkForWinner(ComputerPiece)
            winner = "lose"

        if Done == True:  # the true false statement about if someone won or not
            break  # This breaks the foundation while Loop, as someone has won

        player1 = not player1  # the flip


        if player1 == False:  # it's the computer's turn, which is almost the same as the player's move code which is
                              # a bit further below

            while True:
                x = random.randint(0,6)
                y = checkColumn(x)
                if y == "no":
                    continue
                break

            board[y][x] = ComputerPiece
            printBoard()
            continue


        while True:  # so, while True because we need working values before we place the piece
            x = getInput()  # set column number to x
            y = checkColumn(x)  # set row number to y
            if y == "no":  # working with the checkColumn() function, we run the loop again if the column doesn't work
                print("That column is full, select another one.")  # out of range means no spot in that column is empty
                continue
            break  # x and y are good, so we can move on from the loop

        board[y][x] = PlayerPiece  # player piece in the empty spot
        printBoard()



    for i in range(len(board)):  # need to reset board to empty
        print("", end=" ")
        for j in range(len(board[i])):
            board[i][j] = o





    if winner == "lose":  # self-explanatory
        return("lose")
    elif winner == "win":
        return("win")
    else:
        return("draw")


