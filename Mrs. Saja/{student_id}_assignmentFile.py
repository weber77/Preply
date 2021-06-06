{
 "cells": [
  {
   "cell_type": "markdown",
   "metadata": {},
   "source": [
    "# CSE5AIF - Artificial Intelligence Fundamentals\n",
    "# 2020 Assignment \n",
    "\n",
    "\n",
    "## Student Name:\n",
    "\n",
    "## Student ID: "
   ]
  },
  {
   "cell_type": "markdown",
   "metadata": {},
   "source": [
    "## Solving the Towers of Hanoi Problem using State Space Search\n",
    "\n",
    "Among many classic AI problems is the Towers of Hanoi problem; one of many versions of this, forms the basis of this assignment and is told as follows:\n",
    "\n",
    "In a monastery in the deepest parts of Tibet there are three crystal columns and 64 golden rings. The rings are different sizes and rest over the columns. At the beginning of time, all of the rings rested on the leftmost column, and since then the monks have toiled ceaselessly trying to perfectly transfer the rings to their resting place on the final column.\n",
    "\n",
    "The objective of this problem is to move the entire stack of rings from the first, to the last column, while obeying 3 simple rules:\n",
    "\n",
    "1.\tOnly one ring can be moved at time.\n",
    "\n",
    "2.\tEach move consists of taking the upper ring from one of the stacks and placing it on the top of another stack or an empty pole.\n",
    "\n",
    "3.\tA larger ring must not be placed on top of a smaller ring.\n"
   ]
  },
  {
   "cell_type": "markdown",
   "metadata": {},
   "source": [
    "## This file must contain:\n",
    "    •\tA function containing your Breadth-First Search implementation;\n",
    "\n",
    "    •\tA function containing your A* Search implementation;\n",
    "\n",
    "    •\tA correct representation of the problem state, indicating all variables required to solve the problem;\n",
    "\n",
    "    •\tThe ability to switch between both search algorithms without major modification to any part of the code.\n",
    "\n",
    "As well as correctly solving the problem, your code must display good programming style:\n",
    "\n",
    "    •\tappropriate function and parameter naming;\n",
    "\n",
    "    •\tappropriate and consistent documentation;\n",
    "\n",
    "    •\tappropriate use of Classes;\n",
    "\n",
    "    •\tappropriate and consistent indentation that reflects logical structure of the code.\n",
    "    \n",
    "\n",
    "## Expected Output\n",
    "The output of your program must be a count of the total number of steps taken to reach the solution; and a path list, showing the rings positions at each level of the search. E.g.:\n",
    "\n",
    "\n",
    "Path Output:\n",
    "\n",
    "    [5, 4, 3, 2, 1], [0], [0]\n",
    "    \n",
    "    [5, 4, 3, 2], [1], [0]\n",
    "    \n",
    "    [5, 4, 3], [1], [2]\n",
    "    \n",
    "    …\n",
    "    \n",
    "    [0], [0], [5, 4, 3, 2, 1, 0]\n",
    "\n",
    "Steps Taken: 100\n"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": null,
   "metadata": {},
   "outputs": [],
   "source": [
    "# Implementation of code below.\n",
    "\n"
   ]
  }
 ],
 "metadata": {
  "kernelspec": {
   "display_name": "Python 3",
   "language": "python",
   "name": "python3"
  },
  "language_info": {
   "codemirror_mode": {
    "name": "ipython",
    "version": 3
   },
   "file_extension": ".py",
   "mimetype": "text/x-python",
   "name": "python",
   "nbconvert_exporter": "python",
   "pygments_lexer": "ipython3",
   "version": "3.7.6"
  }
 },
 "nbformat": 4,
 "nbformat_minor": 2
}
