#!/usr/bin/env python3.5

# 'import' statements allow us to use functions that are written in 
# another file, such as the libraries matplotlib and numpy.
import matplotlib.pyplot as plt
plt.rcdefaults()

# 'import ___ as ___' allows us to give a name to the group of functions
# we are importing. 
import numpy as np
import matplotlib.pyplot as plt


# Data taken from Distrowatch at 
# http://distrowatch.com/

# Here we define our data, making sure that each bar (Linux distribution) 
# is in the same position as it's data.
distros = ('Mint', 'Debian', 'Ubuntu', 'openSUSE', 'Fedora', 'Mageja', 'Manjaro', 'CentOS')
hits_per_day = (3011, 1846, 1554, 1281, 1148, 1034, 987, 872)

y_pos = np.arange(len(distros))

# Creation of the bar graph
plt.barh(y_pos, hits_per_day, align='center', alpha=0.4)
plt.yticks(y_pos, distros)

# Label and title
plt.xlabel('Hits Per Day')
plt.title('Popularity of Linux Distributions Based on Hits Per Day on Distrowatch')

plt.show()

