class Parent():
    def print_lastName(self):
        print("KingKong")

class Child(Parent):
    def print_firstName(self):
        print("Amy")
    def print_lastName(self):
        print("Monkey")

amy = Child()
amy.print_firstName()
amy.print_lastName()