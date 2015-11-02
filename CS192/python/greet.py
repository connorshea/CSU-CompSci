def greet():
  print("Hello, world!")
  name = input("Enter your name: ")
  if name == "Connor":
    print("Hello, Connor! I am glad you are in CS192")
  else:
    print("Hello ", name)

def ask_age():
  age = eval(input("What is your age? "))
  if age == 19:
    print("Your age is prime!")
  x = 0
  while age > 0:
    print(age)
    age -= 1

if __name__ == "__main__":
  greet()
  ask_age()
