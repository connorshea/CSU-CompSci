#!/usr/bin/env python

import sys
from pygame.locals import *
import pygame, string
from threading import Thread
import rps_back 


# eztext taken from: http://www.pygame.org/project-EzText-920-.html 
class ConfigError(KeyError): pass

class Config:
    """ A utility for configuration """
    def __init__(self, options, *look_for):
        assertions = []
        for key in look_for:
            if key[0] in options.keys(): exec('self.'+key[0]+' = options[\''+key[0]+'\']')
            else: exec('self.'+key[0]+' = '+key[1])
            assertions.append(key[0])
        for key in options.keys():
            if key not in assertions: raise ConfigError(key+' not expected as option')

class Input:
    """ A text input for pygame apps """
    def __init__(self, **options):
        """ Options: x, y, font, color, restricted, maxlength, prompt """
        self.options = Config(options, ['x', '0'], ['y', '0'], ['font', 'pygame.font.Font(None, 32)'],
                              ['color', '(0,0,0)'], ['restricted', '\'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!"#$%&\\\'()*+,-./:;<=>?@[\]^_`{|}~\''],
                              ['maxlength', '-1'], ['prompt', '\'\''])
        self.x = self.options.x; self.y = self.options.y
        self.font = self.options.font
        self.color = self.options.color
        self.restricted = self.options.restricted
        self.maxlength = self.options.maxlength
        self.prompt = self.options.prompt; self.value = ''
        self.shifted = False

    def set_pos(self, x, y):
        """ Set the position to x, y """
        self.x = x
        self.y = y

    def set_font(self, font):
        """ Set the font for the input """
        self.font = font

    def draw(self, surface):
        """ Draw the text input to a surface """
        text = self.font.render(self.prompt+self.value, 1, self.color)
        surface.blit(text, (self.x, self.y))

    def update(self, events):
        """ Update the input based on passed events """
        for event in events:
            if event.type == KEYUP:
                if event.key == K_LSHIFT or event.key == K_RSHIFT: self.shifted = False
            if event.type == KEYDOWN:
                if event.key == K_BACKSPACE: self.value = self.value[:-1]
                elif event.key == K_LSHIFT or event.key == K_RSHIFT: self.shifted = True
                elif event.key == K_SPACE: self.value += ' '
                if not self.shifted:
                    if event.key == K_a and 'a' in self.restricted: self.value += 'a'
		    elif event.key == K_RETURN: return True
                    elif event.key == K_b and 'b' in self.restricted: self.value += 'b'
                    elif event.key == K_c and 'c' in self.restricted: self.value += 'c'
                    elif event.key == K_d and 'd' in self.restricted: self.value += 'd'
                    elif event.key == K_e and 'e' in self.restricted: self.value += 'e'
                    elif event.key == K_f and 'f' in self.restricted: self.value += 'f'
                    elif event.key == K_g and 'g' in self.restricted: self.value += 'g'
                    elif event.key == K_h and 'h' in self.restricted: self.value += 'h'
                    elif event.key == K_i and 'i' in self.restricted: self.value += 'i'
                    elif event.key == K_j and 'j' in self.restricted: self.value += 'j'
                    elif event.key == K_k and 'k' in self.restricted: self.value += 'k'
                    elif event.key == K_l and 'l' in self.restricted: self.value += 'l'
                    elif event.key == K_m and 'm' in self.restricted: self.value += 'm'
                    elif event.key == K_n and 'n' in self.restricted: self.value += 'n'
                    elif event.key == K_o and 'o' in self.restricted: self.value += 'o'
                    elif event.key == K_p and 'p' in self.restricted: self.value += 'p'
                    elif event.key == K_q and 'q' in self.restricted: self.value += 'q'
                    elif event.key == K_r and 'r' in self.restricted: self.value += 'r'
                    elif event.key == K_s and 's' in self.restricted: self.value += 's'
                    elif event.key == K_t and 't' in self.restricted: self.value += 't'
                    elif event.key == K_u and 'u' in self.restricted: self.value += 'u'
                    elif event.key == K_v and 'v' in self.restricted: self.value += 'v'
                    elif event.key == K_w and 'w' in self.restricted: self.value += 'w'
                    elif event.key == K_x and 'x' in self.restricted: self.value += 'x'
                    elif event.key == K_y and 'y' in self.restricted: self.value += 'y'
                    elif event.key == K_z and 'z' in self.restricted: self.value += 'z'
                    elif event.key == K_0 and '0' in self.restricted: self.value += '0'
                    elif event.key == K_1 and '1' in self.restricted: self.value += '1'
                    elif event.key == K_2 and '2' in self.restricted: self.value += '2'
                    elif event.key == K_3 and '3' in self.restricted: self.value += '3'
                    elif event.key == K_4 and '4' in self.restricted: self.value += '4'
                    elif event.key == K_5 and '5' in self.restricted: self.value += '5'
                    elif event.key == K_6 and '6' in self.restricted: self.value += '6'
                    elif event.key == K_7 and '7' in self.restricted: self.value += '7'
                    elif event.key == K_8 and '8' in self.restricted: self.value += '8'
                    elif event.key == K_9 and '9' in self.restricted: self.value += '9'
                    elif event.key == K_BACKQUOTE and '`' in self.restricted: self.value += '`'
                    elif event.key == K_MINUS and '-' in self.restricted: self.value += '-'
                    elif event.key == K_EQUALS and '=' in self.restricted: self.value += '='
                    elif event.key == K_LEFTBRACKET and '[' in self.restricted: self.value += '['
                    elif event.key == K_RIGHTBRACKET and ']' in self.restricted: self.value += ']'
                    elif event.key == K_BACKSLASH and '\\' in self.restricted: self.value += '\\'
                    elif event.key == K_SEMICOLON and ';' in self.restricted: self.value += ';'
                    elif event.key == K_QUOTE and '\'' in self.restricted: self.value += '\''
                    elif event.key == K_COMMA and ',' in self.restricted: self.value += ','
                    elif event.key == K_PERIOD and '.' in self.restricted: self.value += '.'
                    elif event.key == K_SLASH and '/' in self.restricted: self.value += '/'
                elif self.shifted:
                    if event.key == K_a and 'A' in self.restricted: self.value += 'A'
                    elif event.key == K_b and 'B' in self.restricted: self.value += 'B'
                    elif event.key == K_c and 'C' in self.restricted: self.value += 'C'
                    elif event.key == K_d and 'D' in self.restricted: self.value += 'D'
                    elif event.key == K_e and 'E' in self.restricted: self.value += 'E'
                    elif event.key == K_f and 'F' in self.restricted: self.value += 'F'
                    elif event.key == K_g and 'G' in self.restricted: self.value += 'G'
                    elif event.key == K_h and 'H' in self.restricted: self.value += 'H'
                    elif event.key == K_i and 'I' in self.restricted: self.value += 'I'
                    elif event.key == K_j and 'J' in self.restricted: self.value += 'J'
                    elif event.key == K_k and 'K' in self.restricted: self.value += 'K'
                    elif event.key == K_l and 'L' in self.restricted: self.value += 'L'
                    elif event.key == K_m and 'M' in self.restricted: self.value += 'M'
                    elif event.key == K_n and 'N' in self.restricted: self.value += 'N'
                    elif event.key == K_o and 'O' in self.restricted: self.value += 'O'
                    elif event.key == K_p and 'P' in self.restricted: self.value += 'P'
                    elif event.key == K_q and 'Q' in self.restricted: self.value += 'Q'
                    elif event.key == K_r and 'R' in self.restricted: self.value += 'R'
                    elif event.key == K_s and 'S' in self.restricted: self.value += 'S'
                    elif event.key == K_t and 'T' in self.restricted: self.value += 'T'
                    elif event.key == K_u and 'U' in self.restricted: self.value += 'U'
                    elif event.key == K_v and 'V' in self.restricted: self.value += 'V'
                    elif event.key == K_w and 'W' in self.restricted: self.value += 'W'
                    elif event.key == K_x and 'X' in self.restricted: self.value += 'X'
                    elif event.key == K_y and 'Y' in self.restricted: self.value += 'Y'
                    elif event.key == K_z and 'Z' in self.restricted: self.value += 'Z'
                    elif event.key == K_0 and ')' in self.restricted: self.value += ')'
                    elif event.key == K_1 and '!' in self.restricted: self.value += '!'
                    elif event.key == K_2 and '@' in self.restricted: self.value += '@'
                    elif event.key == K_3 and '#' in self.restricted: self.value += '#'
                    elif event.key == K_4 and '$' in self.restricted: self.value += '$'
                    elif event.key == K_5 and '%' in self.restricted: self.value += '%'
                    elif event.key == K_6 and '^' in self.restricted: self.value += '^'
                    elif event.key == K_7 and '&' in self.restricted: self.value += '&'
                    elif event.key == K_8 and '*' in self.restricted: self.value += '*'
                    elif event.key == K_9 and '(' in self.restricted: self.value += '('
                    elif event.key == K_BACKQUOTE and '~' in self.restricted: self.value += '~'
                    elif event.key == K_MINUS and '_' in self.restricted: self.value += '_'
                    elif event.key == K_EQUALS and '+' in self.restricted: self.value += '+'
                    elif event.key == K_LEFTBRACKET and '{' in self.restricted: self.value += '{'
                    elif event.key == K_RIGHTBRACKET and '}' in self.restricted: self.value += '}'
                    elif event.key == K_BACKSLASH and '|' in self.restricted: self.value += '|'
                    elif event.key == K_SEMICOLON and ':' in self.restricted: self.value += ':'
                    elif event.key == K_QUOTE and '"' in self.restricted: self.value += '"'
                    elif event.key == K_COMMA and '<' in self.restricted: self.value += '<'
                    elif event.key == K_PERIOD and '>' in self.restricted: self.value += '>'
                    elif event.key == K_SLASH and '?' in self.restricted: self.value += '?'

        if len(self.value) > self.maxlength and self.maxlength >= 0: self.value = self.value[:-1]
	return False




















class Option:

    hovered = False
    
    def __init__(self, text, pos, image_name=None):
        self.text = text
        self.pos = pos
        self.image_name = image_name
        self.img = None
        if image_name is None:
            self.text_init()
        else:
            self.img_init()

    def text_init(self):
        self.set_rect()
        self.draw()

    def img_init(self):
        self.img = pygame.image.load(self.image_name)
        self.set_rect()
        self.draw()
            
    def draw(self):
        if self.img is None:
            self.set_rend()
            screen.blit(self.rend, self.rect)
        else:
            screen.blit(self.img, self.rect)
        
    def set_rend(self):
        self.rend = menu_font.render(self.text, True, self.get_color())
        
    def get_color(self):
        if self.hovered:
            return (0, 0, 0)
        else:
            return (100, 100, 100)
        
    def set_rect(self):
        if self.img is None:
            self.set_rend()
            self.rect = self.rend.get_rect()
        else:
            self.rect = self.img.get_rect()
        self.rect.topleft = self.pos


class OnScreen:
    def __init__(self):
	self.items = {}

# Input section
def get_name():
    return get_input("Enter name: ", 'name', rps_back.check_name)


def get_num_play():
    return get_input("How many games to play: ", 'num_games', rps_back.check_times_to_play)

def ask_instructions():
    return get_input("Would you like instructions (yes/no): ", 'instructions', rps_back.instructions) 

def get_input(prompt_text, item_key, call_back=None):
    txtbx = Input(maxlength=45, color=(0,0,0), prompt=prompt_text)

    while 1:
        # make sure the program is running at 30 fps
        clock.tick(30)

        # events for txtbx
        events = pygame.event.get()
        # process other events
        for event in events:
            # close it x button si pressed
            if event.type == QUIT: return

        # clear the screen
        screen.fill((242, 209, 133))
        # update txtbx
        done = txtbx.update(events)

        # blit txtbx on the sceen
        txtbx.draw(screen)

        # refresh the display
        pygame.display.flip()
        if done:
            break

    onscreen.items[item_key] = txtbx.value
    return call_back(txtbx.value) if call_back is not None else txtbx.value



def print_instructions(instructions):
    options = [Option("OK",(280,280)), Option("Quit", (15,280))]
    while True:
        pygame.event.pump()
        screen.fill((242, 209, 133))
	
	myfont = pygame.font.SysFont("Comic Sans MS", 22)
	words = instructions.split(' ')
	y = 15
        line = ''
        for word in words:
            if len(line) < 55:
                line += word + " "
            else:
	        label = myfont.render(line,True,(0,0,0))
	        screen.blit(label, (15,y))
	        y += 25
                line = word + " "

	label = myfont.render(line,True,(0,0,0))
	screen.blit(label, (15,y))

        for option in options:
            if option.rect.collidepoint(pygame.mouse.get_pos()):
                option.hovered = True
            else:
                option.hovered = False


	ev = pygame.event.get()
	clicked_option = []
	for event in ev:
	    if  event.type == pygame.MOUSEBUTTONUP:
		pos = pygame.mouse.get_pos()
		clicked_option = [o for o in options if o.rect.collidepoint(pos) ]
	if len(clicked_option) > 0:
            if clicked_option[0].text == "Quit":
                sys.exit(0)
            elif clicked_option[0].text == "OK":
                return

	for option in options:
	    option.draw()
        pygame.display.update()



def get_player_move():
    options = [Option("Rock", (20, 45), "rock.png"), Option("Paper", (95, 45), "paper.png"), Option("Scissors", (20, 120), "scissors.png"), Option("Lizard", (95, 120), "lizard.png"), Option("Spock", (20, 200), "spock.png"), Option("Quit", (15,280))]
    return_move = ""
    while True:
        pygame.event.pump()
        screen.fill((242, 209, 133))



	myfont = pygame.font.SysFont("Comic Sans MS", 22)

        text = "Click on one of the five pictures for your move"
	label = myfont.render(text,True,(0,0,0))
	screen.blit(label, (15,5))

	
	if not onscreen.items['display_text'] == "temp":
	    myfont = pygame.font.SysFont("Comic Sans MS", 22)
	    text_line = onscreen.items['display_text'].split('\n')
	    y = 110
	    for line in text_line:
		label = myfont.render(line,True,(0,0,0))
		screen.blit(label, (250,y))
		y += 50

        for option in options:
            if option.rect.collidepoint(pygame.mouse.get_pos()):
                option.hovered = True
            else:
                option.hovered = False

	ev = pygame.event.get()
	clicked_option = []
	for event in ev:
	    if  event.type == pygame.MOUSEBUTTONUP:
		pos = pygame.mouse.get_pos()
		clicked_option = [o for o in options if o.rect.collidepoint(pos) ]
	if len(clicked_option) > 0:
            if clicked_option[0].text == "Quit":
                sys.exit(0)
	    return clicked_option[0].text


	for option in options:
	    option.draw()
        pygame.display.update()

# Various game modes could be added here, else it is just a start menu.
def get_player_mode():
    options = [Option("Start Game", (165, 125)), Option("Quit", (15,280))]
    while True:
        clock.tick(30)
        pygame.event.pump()
        screen.fill((242, 209, 133))
        for option in options:
            if option.rect.collidepoint(pygame.mouse.get_pos()):
                option.hovered = True
                if pygame.mouse.get_pressed()[0]:
                    if option.text == "Quit":
                        sys.exit(0)
                    return option.text
            else:
                option.hovered = False
            option.draw()
        pygame.display.update()




# Exiting on errors.
def quit_game(error_message):
    print "Program aborted.."
    print error_message
    sys.exit(1)


# Transfer control to rps_back
def play_comp_game():
    output = rps_back.play_match()


# Set the result string so it may be displayed during get_move
def display_results(result_string):
    onscreen.items['display_text'] = result_string
    

# This shows the start menu then kicks of the game. game_mode was originally used for
# the possible inclusion of a human v. human game mode.
def main():
    game_mode = get_player_mode()
    play_comp_game()


# These are global variables / statements. They are necessary because there is no way to keep 
# these variable is scope when communicating with rps_back.py
pygame.init()
screen = pygame.display.set_mode((480, 320))
menu_font = pygame.font.Font(None, 40)
clock = pygame.time.Clock()   
onscreen = OnScreen()
onscreen.items["display_text"] = "temp"
    
# The canonical starting of main
if __name__ == "__main__":
    main()

