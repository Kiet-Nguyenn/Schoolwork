import math
import csv

def gotta_catch_em_all():

    pass
    """
    
    The user plays a game of Connect 4 against a pokemon AI, and wins
    the pokemon and some candies if they win the game.
    There is no option to run, but the game closes and
    goes back to the menu if you lose or win.
    
    
    """

def open_menu():
    pass

    """

    Function to open menu and display options to,
    (1), open rules
    (2), open pokemon list
    (3), go out and catch pokemon
    (4), exit game
    
    (5) (unlockable), view surprised Pikachu face
    
    player types number to do action
    
    """

def open_rules():
    pass
    """
    
    print rules
    player exits by typing "b"
        
    """


def view_pokemon():
    pass
    """
    
    display pokemon collected so far
    player types index of pokemon to select and view that specific pokemon
    again, "b" to exit
    
    """


def surprise_pikachu_face():
    pass
    """
    
    Think of the meme.
    You can't exit once you open
        
    """

# initialize full list of pokemon from the csv
# menu is opened at first automatically (open_rules() is called)
# if the player selects rules view rules (call open_rules())
# if the player selects pokemon collection, open their collection (call view_pokemon())
#     a random pokemon is assigned to each player to begin (Your_poke_collection has one pokemon already in it)
#     more will be in their collection after they collect more
# if the player selects to go out and catch, send them out (call gotta_catch_em_all())
#     a connect four mini game starts with an AI and the player, AI makes random moves
#     if the player wins, they win a random number of pieces of candy (3, 5, or 10), which is added to total_candies
#         they also get the pokemon that they beat added to their collection
#         if the pokemon they catch happens to be Pikachu, the variable Pika is set to True,
#             and a new option in the menu will be available
