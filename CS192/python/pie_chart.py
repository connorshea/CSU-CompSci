#!/usr/bin/env python3.5

import matplotlib.pyplot as plt

# Find statistics on the languages here
# http://www.tiobe.com/index.php/content/paperinfo/tpci/index.html



# The slices will be ordered and plotted counter-clockwise.
# Keep the order of your items consistent. 

# TODO: Replace these languages with the actual top six, plus on other category
languages = ('Java', 'C', 'C++', 'C#', 'Python', 'PHP', 'Other') 

# TODO: Align the correct percentages here with their respective language above, making sure they all add up to 100
lang_pop_percent = [19.543, 16.190, 5.749, 4.825, 4.512, 2.561, 46.62]


# For information on matplotlib colors visit here
# http://matplotlib.org/api/colors_api.html

# For a tool to pick a color by hex string visit here
# http://www.color-hex.com/color-wheel/

# TODO: Make sure you have six colors here fore the above languages
pie_colors = ['#F44336', '#9C27B0', '#3F51B5', '#2196F3', '#009688', '#4CAF50', '#FF9800']

# TODO: "Explode" your favorite of the six languages using syntax you see below
pie_explode = (0, 0, 0, 0, 0, 0, 0.2)

# This statement is how we give all the data to matplotlib to create our pie chart.
plt.pie(lang_pop_percent, explode=pie_explode, labels=languages, colors=pie_colors,
		autopct='%1.1f%%', shadow=True) 

# Set aspect ratio to be equal so that pie is drawn as a circle. See
# what happens if this is removed.
plt.axis('equal')


# The title is overlapping the graph, change the statement below to  fix this.
# TODO: Fix the alignment of title by changing something in the below statement
plt.title('Programming Language Popularity (TIOBE Index)', y=.95)

plt.show()

