#!/usr/bin/env python3.4
# Python Lab 2


# Write the code to answer each question and print the answer
def place_of_birth():
	# Print the string containing your birth location
	birth_location = input("Enter your place of birth as city, state, country: ")
	
	birth_city = birth_location[0:birth_location.find(',')]

	return birth_city


def month_of_birth():
	# Return the month you were born by finding the appropriate substring in months
	# Hint use the variable index to find the start of your birth month in months
	months = "JanFebMarAprMayJunJulAugSepOctNovDec"
	bday_month = int(input("Enter the number of your birthday month: "))
	index = (bday_month - 1) * 3

	return months[index:index + 3]


def first_school():
	# Print the string containing the first school you went to
	school = input("Enter the name of the first school you went to: ")

	# Print on separate lines the first school you went to in all upper case letters, 
	# then all lower case letters, 
	# then with each word capitalized.
	# Finally return the the school with each word capitalized.

	print(school.upper())
	print(school.lower())
	print(school.title())

	return school.title()


def favorite_color():
	# Determine if your favorite color is in the color_list
	# If your favorite color is in the color_list, return the color
	# If your favorite color is not in the color_list, replace color with your favorite color
	# and return the whole color_list. Use an if, else statement.
	# Make sure that the input will work if it is entered in any case. i.e. ReD should 
	# be found in the color_list
	color_list = "red, blue, yellow, green, purple, color"
	favorite = input("Enter your favorite color: ")

	favorite = favorite.lower()

	if favorite in color_list:
		return favorite
	else:
		color_list = color_list.replace("color", favorite)
		return color_list


def print_summary(place, month, school, color):
	# Print out a summary message containing the information in the 
	# four variables.
	print(place + ", " + month + ", " + school + ", " + color)
	

def is_proper_noun():
	# Define your own function using strings and string operations making sure
	# to have some sort of return value
	input_string = input("Enter a string: ")

	if input_string.istitle():
		print("This is a proper noun.")
	else:
		print("This is not a proper noun.")


if __name__ == "__main__":
	# This is an example of testing your place_of_birth function.
	birth_city = place_of_birth()  
	print("Birth city result: ", birth_city)

	birth_month = month_of_birth()  
	print("Birth month result: ", birth_month)

	# Call first_school and store the result in a variable

	first_school = first_school()
	print("First school result: ", first_school)

	# Call favorite_color and store the result in a variable
	favorite_color = favorite_color()
	print("Favorite color result: ", favorite_color)

	# Call print_summary with the four variables you just created
	print_summary(birth_city, birth_month, first_school, favorite_color)

	# Create and test my_function()
	is_proper_noun()
