import random
import matplotlib.pyplot as plt
import rps


def instructions(response):
    # Add to instruction_string so that it contains information on
    # how to play rock-paper-scissors
    instruction_string = "Choose rock, paper, or scissors from the buttons. "
    instruction_string += "The computer will then choose a move. "
    instruction_string += "Rock beats scissors, scissors beats paper, and paper beats rock."

    # Use a string method to make response all one case
    response = response.lower()
    # Use an if statement to check if the response is "yes"
    if response == "yes":
    	rps.print_instructions(instruction_string)



# Name requirements: must be at least two characters, must be no more than 10 characters, must only be 
# one name (i.e. no spaces), must start with an upper case letter.
# Return requirement: name
def check_name(name):

    error = "Something's wrong"

    # Use if statements, as above, to check if 'name' meets the requirements listed above. If it fails
    # any condition call rps.quit_game with an appropriate error message.
    if len(name) > 10:
        rps.quit_game(error)
    if len(name) < 2:
        rps.quit_game(error)
    if name.find(' ') == True:
        rps.quit_game(error)
    if name.istitle() == False:
        rps.quit_game(error)


    # return the variable name once you have checked all name requirements
    return name





# Num requirements: must be more than two and less than 21.
# Return requirement: num
def check_times_to_play(num):
    error = "Number is not correct"

    # Check that 'num' meets the requirements above.

    if (2 < int(num)) and (int(num) < 21):
        return num
    else:
        rps.quit_game(error)

    # If 'num' does not meet requirements call rps.quit_game with an error 
    # message (the variable 'error.')
    # Note: use function int, to convert num to integer when using it to compare to another integer, i.e. int(num)

    # return the variable num once have checked requirements




def play_game(name):
    # This gets the move from a player when they push a button.
    player_move = rps.get_player_move()

    # Use the random library to chose a random move for the player.
    random_moves = ['rock', 'paper', 'scissors']
    string_choice = random.choice(random_moves)

    if (player_move == string_choice):
        who_won = "Tie"
    elif ((player_move == 'rock') and (string_choice == 'paper')):
        who_won = "Computer"
    elif ((player_move == 'rock') and (string_choice == 'scissors')):
        who_won = "Player"
    elif ((player_move == 'paper') and (string_choice == 'scissors')):
        who_won = "Computer"
    elif ((player_move == 'paper') and (string_choice == 'rock')):
        who_won = "Player"
    elif ((player_move == 'scissors') and (string_choice == 'paper')):
        who_won = "Player"
    elif ((player_move == 'scissors') and (string_choice == 'rock')):
        who_won = "Computer"

    # After determines who won, build a results string.
    # The next 3 lines partially builds this string. Complete for computer, add for tie, and add line for winner
    results = "Player played " + player_move
    results += "\n"
    results += "Computer played "

    # Use rps.display_results to display the results string for the game.
    rps.display_results

    # return the variable who_won
    return who_won
  


def play_match():

    # Call rps.ask_instructions() to see if player wants instructions
    rps.ask_instructions()

    # Call rps.get_name() to get a string of the players name
    # Be sure to save return value, i.e. player_name = rps.get_name()
    player_name = rps.get_name()


    # Call rps.get_num_play to get the number of games to play
    # Be sure to save return value, i.e. num_times = rps.get_num_play()
    num_times = rps.get_num_play()

    
    # Use these variables to keep track of who won
    ties = 0
    player_wins = 0
    computer_wins = 0


    # Use a while or for loop to call play_game the correct amount of times
    count = 0
    while count < num_times:
        game_winner = play_game(name)
        # Now use an if statement to increment total for winner
        # i.e. will increment either ties, player_wins, or computer_winds
        count = count + 1

    # Call make_graph using the variables for win counts above.
    make_graph(player_name, player_wins, computer_wins, ties)




# Create a graph as we did in the previous lab
def make_graph(name, player_wins, comp_wins, ties):
    print "Not implemented yet"


