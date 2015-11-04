#!/usr/bin/env python3.5

# 'import' statements allow us to use functions that are written in 
# another file, such as the libraries matplotlib and numpy.
import matplotlib.pyplot as plt
plt.rcdefaults()

# 'import ___ as ___' allows us to give a name to the group of functions
# we are importing. 
import numpy as np
import matplotlib.pyplot as plt


# Data taken from Google Trends at 
# https://www.google.com/trends/explore#q=%2Fm%2F09gbxjr%2C%20%2Fm%2F0dsbpg6%2C%20%2Fm%2F010sd4y3&date=now%207-d&cmpt=q&tz=Etc%2FGMT%2B7

# Here we define our data, making sure that each bar (Linux distribution) 
# is in the same position as it's data.
langs = ('Go', 'Rust', 'Swift')
google_trends_interest = (72, 2, 23)

y_pos = np.arange(len(langs))

# Creation of the bar graph
plt.barh(y_pos, google_trends_interest, align='center', alpha=0.4)
plt.yticks(y_pos, langs)

# Label and title
plt.xlabel('Interest over last 7 days')
plt.title('Interest in new programming languages over last 7 days (per Google Trends)')

plt.show()

