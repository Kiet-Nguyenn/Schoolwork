# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Names:        Michael Chrisanthus
#               Nathan Yandell
#               Brandon Le
#               Kiet Nguyen
# Section:      Section 509
# Assignment:   Lab - 13
# Date:         29 November 2022

import math  # I don't think I used this, but whatever
import csv
import ConnectFour
import random
import Lab13_daRules
from PIL import Image


def gotta_catch_em_all():
    enemy = ((AllList[random.randint(1, 150)]).split(","))  # complex way of getting random pokemon and
                                                                #  setting its name to enemy
    enemyName = enemy[1]
    enemyNum = int(enemy[0])

    candies = [3, 5, 10]

    print(f"Oh no! it's a wild {enemyName}! Beat them in connect 4 to win them")

    win = ConnectFour.playGame()  # play a game of connect 4. Have to win to get candies and pokemon (no draw)

    if win == "win":
        print("YOU WON!")
        print(f"{enemyName} was added to your Pokemon collection!")
        candyCount = candies[random.randint(0, 2)]  # candies[0], candies[1], or candies[2], meaning either 3, 5, or 10
        print(f"And, you got {candyCount} candies!")
        return candyCount, enemyNum  # int, int
    else:
        print(f"You lost :( {enemyName} got away.")
        return(0, False)  # goes to do nothing part of foundation while loop because of boolean parameter


def open_menu(PikaPika=False):  # default parameter is false until user file has a Pikachu, see game() below

    # this is where the hub basically is, sort of a reset point

    print("Type only the number of the thing you want to do")
    print("1: Open rules")
    print("2: Open pokemon list")
    print("3: Go out and catch pokemon")
    print("4: Save and Quit (you'll lose any candies you're currently holding)")
    if PikaPika == True:
        print("0073735963: View surprised Pikachu face")  # Code for Mike Tyson in Mike Tyson's Punch Out

    go = int(input())

    # every option to go to relies on three return statements which will go to foundation while loop
    # check functions these areas go to for more details

    if go == 1:
        returning1, returning2, returning3 = open_rules()
        return returning1, returning2, returning3
    elif go == 2:
        eaten, index, candy = view_pokemon(candies)
        return eaten, index, candy
    elif go == 3:
        returning1, returning2 = gotta_catch_em_all()
        print()  # random debugging print statement that fixed stuff for some reason
        return returning1, returning2, 0
    elif go == 4:
        print("Thank you for playing. BYE!")
        leave()

    elif go == 73735963:
        surprise_pikachu_face()



def open_rules():

    # simply put, this prints the rules
    print("these are the rules")
    Lab13_daRules.daRules()
    x = input("Enter any key to continue: ")
    return "x", "y", "z"  # returns 3 strings to go to do nothing part of while loop



def view_pokemon(candy):
    minus = 0  # if candy is eaten, this number goes up
    index = 0
    putBack = 4.4  # a float to go to do nothing part of while loop, gets returned if user doesn't feed any Pokemon

    for i in range(len(currentList)):  # displays the names and numbers of each Pokemon the user has
        current = currentList[i].split(",")
        try:
            print(f"{i + 1}: {current[1]}")
        except:
            pass  # there will inevitably be empty lines in currentList

    print(f"0: Go Back")

    x = int(input())
    if x == 0:
        pass  # goes to the end and returns stuff
    else:
        index = x - 1
        current = currentList[x - 1].split(",")  # display stats  vvvvvv
        print(f"Name: {current[1]}")
        print(f"Min CP: {current[2]}")
        print(f"Max CP: {current[3]}")
        print(f"Level: {current[4]}")
        print(f"Candy Eaten: {current[5]}")
        print(f"Signature Move: {current[6]}")
        print(f"Move Damage: {current[7]}")
        print(f"Evolution #: {current[8]}")
        print(f"Type: {current[9]}")

        print("1: Give Candy")
        print("0: Go Back")
        print(f"Note: you have {candies-minus} candies")  # remember, minus is how many have been eaten

        y = int(input())
        if y == 0:
            pass  # go to end
        else:
            while y != 0:
                if candy > 0:  # only feeds if we have enough
                    candy -= 1
                    minus += 1
                    current[5] = str(int(current[5])+1)  # updating string of current pokemon's stats to fix candy eaten
                else:
                    print("You have no more candy")
                    break
                print("1: Give Candy")
                print("0: Go Back")
                print(f"Note: you have {candy} candies")
                y = int(input())

            putBack = ""
            for i in range(10):  # putBack is set to updated stats, which will eventually go back into currentList
                putBack += current[i] + ","
            putBack = putBack[:-1]  # getting rid of final comma

    return putBack, index, candy  # if a Pokemon was fed, str, int, int, otherwise float, int, int




def surprise_pikachu_face():

    while True:
        img = Image.open("Surprised Pikachu Face.png")
        img.show()
        x = input("enter any key to see this masterpiece again: ")
        # You can't close this. How unfortunate. Hope you saved. :I    ._.

        # by the way, this is where we learned something new, opening pngs with python


def checkPika(user):
    with open(user, "r") as check:  # basically just checking user file to see if they have a Pikachu
        for i in check:
            if i[0:2] == "25":  # Pikachu's number
                return True
    return False

def leave():
        with open(user, "w") as newGame:  # "w" rewrites the whole user file
            for i in range(len(currentList)):
                if len(currentList[i]) > 5:
                    newGame.write(currentList[i] + "\n")
        if existingUser == False:   # if the user is new, we add it to Users.txt
            with open("Users.txt", "a") as newUser:  # "a" adds to it
                newUser.write(f"{user}\n")
        exit()  # we're done

def play():
    # the moment before going to the hub STRICTLY for checking if the code
    # for seeing Surprised Pikachu Face should be made available yet.
    PikaPika = checkPika(user)
    if PikaPika == True:  # make available
        returning1, returning2, returning3 = open_menu(True)  # and again, our three return statements
    else:  # don't make available
        returning1, returning2, returning3 = open_menu()  # and here again
    return returning1, returning2, returning3


##############################################
##############################################
####### CODE OFFICIALLY BEGINS HERE ##########
##############################################
##############################################


name = input("Who is playing (Case sensitive, and no spaces)? ")
existingUser = False
with open("Users.txt", "r") as users:  # check file of user names to see if who is playing already has an account
    for i in users:
        if f"{name}.txt" == i[:-1]:  # i[:-1] will go through every existing user and chop off the ending new line
            existingUser = True
            user = i[:-1]


if existingUser == True:
    currentList = []  # pokemon that the user will have
    AllList = []  # every pokemon and their stats go to this list
    with open(user, "r") as game:
        for i in game:
            currentList.append(i)  # going through each pokemon that the user has
    with open("PokeList_v2.csv", "r") as PokemonList:
        for i in PokemonList:
            current = i.split(",")  # the first row isn't pokemon
            current = current[0]    # so these three lines
            if current == "Index":  # are to skip it
                continue
            AllList.append(i)


    print("Welcome Back!")  # if it's a returning user, be friendly

else:  # it's not a returning user
    user = f"{name}.txt"  # the name of the file we will create later
    with open("PokeList_v2.csv", "r") as PokemonList:
        currentList = []
        AllList = []
        num = random.randint(1, 148)
        for i in PokemonList:
            current = i.split(",")
            current = current[0]
            if current == "Index":  # the first row isn't pokemon
                continue

            current = int(current)
            if current == num:  # random starter
                currentList.append(i)

            AllList.append(i)

    with open(user, "w") as create:
        justCreating = "justCreating and I don't really know what else to do cause there are problems with checkPika()"
        # you read that right


candies = 0  # oh yeah, you lose all of your candies that you don't feed to your Pokemon before you quit.


while True:  # FOUNDATION WHILE LOOP (This is where the magic happens)

    addCandies, newPokemon, eatenCandies = play()  # three returning parameters: variable types will
                                                   # help determine what needs to be done
                                                   #(chosen based on what action was just done)

    try:  # this part is for adding candies and a new Pokemon that were won from a battle (needs int, int for first 2)
        if addCandies == int(addCandies): # int checker
            candies += int(addCandies)  # add candies that were won
            currentList.append(AllList[newPokemon-1])  # add stats of pokemon that was won (newPokemon is the index)
            print("\n")  # readability whitespace
    except:
        try:  # this part needs str, int, int, and it is for feeding Pokemon
              # weird names, but this edits the candies eaten of the pokemon fed
            currentList[newPokemon] = addCandies  # addCandies is the Pokemon's new stats
            candies = eatenCandies  # updating global variable candies to the new value of eaten candies
            print("\n")  # readability whitespace
        except:
            # do nothing section for after reading rules or losing connect 4
            print("\n")  # you get it
