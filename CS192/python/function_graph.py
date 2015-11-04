#!/usr/bin/env python3.5

import numpy as np
import matplotlib.pyplot as plt
from matplotlib.patches import Polygon
from scipy import integrate


# TODO: Change function definition to match, first, the function given in the assignment document,
# then try some of your own.

def func(x):
  return (x - 3.5) * (x - 5) * (x - 7) + 85


a, b = 2, 9  # integral limits

# This creates a list on evenly spaced numbers that are then
# passed to the func, results are stored in y.
x = np.linspace(0, 10)
y = func(x)


fig, axis = plt.subplots()

# Graph x vs y 
plt.plot(x, y, 'r', linewidth=2)
plt.ylim(ymin=0)

# Make the shaded region
ix = np.linspace(a, b)
iy = func(ix)


verts = [(a, 0)] + list(zip(ix, iy)) + [(b, 0)]
poly = Polygon(verts, facecolor='0.9', edgecolor='0.5')
axis.add_patch(poly)


# Integration can be done using the following syntax. Notice the '[0]' at the end
# of the line, this is necessary to get the correct answer (two things are
# actually returned and we just want the first).

# result = integrate.quad( FUNCTION_TO_INTEGRATE, LOWER_LIMIT, UPPER_LIMIT )[0]

# TODO (optional): Using the function you created above, and the two limits, calculate the integral and store
# it in a variable named result.


# TODO (optional): Adjust the following line to include the answer to the integral.
plt.text(0.5 * (a + b), func((a + b) / 4) * 0.8, r"$\int_a^b f(x)\mathrm{d}x$" + " = " + "something...",
		horizontalalignment='center', fontsize=20)

# TODO: Adjust the following line to display the new equation at the top of the line.
plt.text(0.5 * (a + b), func(max(a,b)), "f(x) = (x - 3.5) * (x - 5) * (x - 7) + 85",
		horizontalalignment='center', fontsize=20)



plt.figtext(0.9, 0.05, '$x$')
plt.figtext(0.1, 0.9, '$y$')

# This turns of the bars that would go up the right and over the top.
axis.spines['right'].set_visible(False)
axis.spines['top'].set_visible(False)
axis.xaxis.set_ticks_position('bottom')


axis.set_xticks( [a, b] )
axis.set_xticklabels( ('$a=$' + str(a), '$b=$'+ str(b) ) )

# Get the approximate value of func at a and b
y_at_a = int(100. * func(a)) / 100. 
y_at_b =  int(100. * func(b)) / 100.

axis.set_yticks( [y_at_a, y_at_b] )

# TODO: Replace the two string with a string version of the variables y_at_a and y_at_b
axis.set_yticklabels( ( "y_at_a", "y_at_b" ) )


plt.show()
