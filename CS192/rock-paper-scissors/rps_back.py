import random
import matplotlib.pyplot as plt
import rps
import numpy as np
import matplotlib.pyplot as plt

# Lexi and Connor

def instructions(response):
    # Add to instruction_string so that it contains information on
    # how to play rock-paper-scissors
    instruction_string = "Scissors cuts Paper, Paper covers Rock, Rock crushes Lizard, "
    instruction_string += "Lizard poisons Spock, Spock smashes Scissors, Scissors decapitates Lizard, "
    instruction_string += "Lizard eats Paper, Paper disproves Spock, Spock vaporizes Rock, "
    instruction_string += "and as it always has Rock crushes Scissors."

    # Use a string method to make response all one case
    response = response.lower()
    # Use an if statement to check if the response is "yes"
    if response == "yes":
    	rps.print_instructions(instruction_string)



# Name requirements: must be at least two characters, must be no more than 10 characters, must only be 
# one name (i.e. no spaces), must start with an upper case letter.
# Return requirement: name
def check_name(name):

    if len(name) > 10:
        rps.quit_game("Name cannot be more than 10 characters long.")
    if len(name) < 2:
        rps.quit_game("Name must be at least 2 characters long.")
    if name.find(' ') != -1:
        rps.quit_game("Name cannot have spaces.")
    if name[0].isupper() == False:
        rps.quit_game("Name must start with a capital letter.")

    # Use if statements, as above, to check if 'name' meets the requirements listed above. If it fails
    # any condition call rps.quit_game with an appropriate error message.

    # return the variable name once have checked all name requirements
    return name





# Num requirements: must be more than two and less than 21.
# Return requirement: num
def check_times_to_play(num):
    error = "Number is not correct"

    # Check that 'num' meets the requirements above.

    if (3 > int(num)) or (int(num) > 20):
        rps.quit_game(error)

    # If 'num' does not meet requirements call rps.quit_game with an error 
    # message (the variable 'error.')
    # Note: use function int, to convert num to integer when using it to compare to another integer, i.e. int(num)

    # return the variable num once have checked requirements
    return int(num)





def play_game(name):
    # This gets the move from a player when they push a button.
    player_move = rps.get_player_move()

    # Use the random library to chose a random move for the player.
    random_moves = ['Rock', 'Paper', 'Scissors', 'Lizard', 'Spock']
    string_choice = random.choice(random_moves)

    who_won = "a"
    if (player_move == string_choice):
	who_won = 'Tie'
    elif ((player_move == 'Rock') and (string_choice == 'Paper')):
	who_won = 'Computer'
    elif ((player_move == 'Rock') and (string_choice == 'Scissors')):
	who_won = name
    elif ((player_move == 'Rock') and (string_choice == 'Lizard')):
	who_won = name
    elif ((player_move == 'Rock') and (string_choice == 'Spock')):
	who_won = 'Computer'
    elif ((player_move == 'Paper') and (string_choice == 'Scissors')):
	who_won = 'Computer'
    elif ((player_move == 'Paper') and (string_choice == 'Rock')):
	who_won = name
    elif ((player_move == 'Paper') and (string_choice == 'Lizard')):
	who_won = 'Computer'
    elif ((player_move == 'Paper') and (string_choice == 'Spock')):
	who_won = name
    elif ((player_move == 'Scissors') and (string_choice == 'Paper')):
	who_won = name
    elif ((player_move == 'Scissors') and (string_choice == 'Rock')):
	who_won = 'Computer'
    elif ((player_move == 'Scissors') and (string_choice == 'Lizard')):
	who_won = name
    elif ((player_move == 'Scissors') and (string_choice == 'Spock')):
	who_won = 'Computer'
    elif ((player_move == 'Lizard') and (string_choice == 'Rock')):
	who_won = 'Computer'
    elif ((player_move == 'Lizard') and (string_choice == 'Paper')):
	who_won = name
    elif ((player_move == 'Lizard') and (string_choice == 'Scissors')):
	who_won = 'Computer'
    elif ((player_move == 'Lizard') and (string_choice == 'Spock')):
	who_won = name
    elif ((player_move == 'Spock') and (string_choice == 'Rock')):
	who_won = name
    elif ((player_move == 'Spock') and (string_choice == 'Paper')):
	who_won = 'Computer'
    elif ((player_move == 'Spock') and (string_choice == 'Scissors')):
	who_won = name
    elif ((player_move == 'Spock') and (string_choice == 'Lizard')):
	who_won = 'Computer'

    # After determines who won, build a results string.
    # The next 3 lines partially builds this string. Complete for computer, add for tie, and add line for winner
    results = name + " played " + player_move
    results += "\n"
    results += "Computer played " + string_choice
    results += "\n"
    if (who_won is "Tie"):
	results += who_won
    else:
	results += who_won + " is the winner."

    # Use rps.display_results to display the results string for the game.
    rps.display_results(results)

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
        game_winner = play_game(player_name)
	
	if game_winner == "Computer":
		computer_wins = computer_wins + 1
	elif game_winner == player_name:
		player_wins = player_wins + 1
	elif game_winner == "Tie":
		ties = ties + 1

        # Now use an if statement to increment total for winner
        # i.e. will increment either ties, player_wins, or computer_winds
        count = count + 1

    # Call make_graph using the variables for win counts above.
    make_graph(player_name, player_wins, computer_wins, ties)




# Create a graph as we did in the previous lab
def make_graph(name, player_wins, comp_wins, ties):
    colors = ['red', 'blue', 'green', 'orange', 'purple']  

    people = (name, 'Computer', 'Ties')
    wins = (player_wins, comp_wins, ties)

    y_pos = np.arange(len(people))

# Creation of the bar graph
    plt.barh(y_pos, wins, align='center', alpha=0.4, color=colors)
    plt.yticks(y_pos, people)

# Label and title
    plt.xlabel('Wins per person')
    plt.title('Games Bargraph')

    plt.show()

