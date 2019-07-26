class Dog:
    def __init__(self, x):
        self.power = x

    def check_power(self):
        print(self.power)

amy = Dog(15)
lex = Dog(1)

lex.check_power()
amy.check_power()