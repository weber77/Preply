from time import time

class Node:

    def __init__(self, puzzle):
        
        self.children = []
        self.parent = None
        self.puzzle = puzzle
        self.zero = 0

    def create_child(self, puzzle):
        child = Node(puzzle)

        self.children.append(child)

        child.parent = self

    def move_right(self):
        if(self.zero + 1) % 3 != 0:
            puzzle_copy = self.puzzle[:]
            puzzle_copy[self.zero], puzzle_copy[self.zero +1] = puzzle_copy[self.zero +1], puzzle_copy[self.zero]

            self.create_child(puzzle_copy)

    def move_left(self):
        if self.zero % 3 != 0:
            puzzle_copy = self.puzzle[:]

            puzzle_copy[self.zero], puzzle_copy[self.zero -1] = puzzle_copy[self.zero -1], puzzle_copy[self.zero]

            self.create_child(puzzle_copy)

    def move_up(self):
        if self.zero > 2:
            puzzle_copy = self.puzzle[:]
            puzzle_copy[self.zero], puzzle_copy[self.zero - 3] = puzzle_copy[self.zero - 3], puzzle_copy[self.zero]

            self.create_child(puzzle_copy)

    def move_down(self):
        if self.zero < 6:
            puzzle_copy = self.puzzle[:]
            puzzle_copy[self.zero], puzzle_copy[self.zero + 3] = puzzle_copy[self.zero + 3], puzzle_copy[self.zero]

            self.create_child(puzzle_copy)

    def goal_test(self):
        for i in range(len(self.puzzle)):
            if i != self.puzzle[i]:
                return False
        return True
    def expand_node(self):

        for i in range(len(self.puzzle)):
            if self.puzzle[i] == 0:
                self.zero = i
        self.move_right()
        self.move_left()
        self.move_up()
        self.move_down()

    def print_puzzle(self):
        print()
        m = 0

        for i in range(3):
            for j in range(3):
                print( self.puzzle[m], end= " ")
                m += 1
            print()

    def is_unsolvable(self):
        print(self.puzzle)
        count = 0
        for i in range(8):
            for j in range(i, 9):
                if self.puzzle[i] > self.puzzle[j] and self.puzzle[j] != 0:
                    count +=1
        if count % 2 == 1:
            return True
        else:
            return False

class Search:
    def breadth_first_search(self, root):
        open_list = []
        visited = set()
        open_list.append(root)
        visited.add(tuple(root.puzzle))

        while(True):
            current_Node = open_list.pop(0)
            if current_Node.goal_test():
                path_to_solution = self.path_trace(current_Node)
                print(len(visited))
                return path_to_solution

            current_Node.expand_node()

            for current_child in current_Node.children:
                if(not (tuple(current_child.puzzle) in visited)):
                    open_list.append(current_child)
                    visited.add(tuple(current_child.puzzle))

    def path_trace(self, node):
        current  = node
        path = []

        path.append(current)

        while current.parent != None:
            current = current.parent
            path.append(current)
        return path

if __name__ == "__main__":
    puzzle = [6,7,5,4,3,0,2,1,8]
    root_puzzle = Node(puzzle)
    if root_puzzle.is_unsolvable():
        print("Puzzle has no solution")

    else:
        search = Search()
        print("Finding solution...")

        start = time()

        solution_path = search.breadth_first_search(root_puzzle)

        end = time()

        solution_path.reverse()

        for i in range(len(solution_path)):
            solution_path[i].print_puzzle()
        
        print("Number of steps taken:", len(solution_path))
        print("Elapsed time:", end - start)