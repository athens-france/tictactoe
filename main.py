game = ["[ ]","[ ]","[ ]",
        "[ ]","[ ]","[ ]",
        "[ ]","[ ]","[ ]"]

def printboard():
    print(game[0], game[1], game[2])
    print(game[3], game[4], game[5])
    print(game[6], game[7], game[8])

printboard()

help = 0
turn = 2
winner = None

def actionthing():
    userinput = input("place thing\n")
    userinput = int(userinput)
    global turn
    if (turn % 2) == 0:
        if userinput < 10 and userinput >= 1 and game[userinput - 1] == "[ ]":
            game[userinput - 1] = "[X]"
            printboard()
            turn += 1
        else:
            print("either theres somebody else there or your number is invalid")
    elif (turn % 2) != 0:
        if userinput < 10 and userinput >= 1 and game[userinput - 1] == "[ ]":
            game[userinput - 1] = "[O]"
            printboard()
            turn += 1
        else:
            print("buddy, either theres somebody else there or your number is invalid")

def checkwin():
    global winner
    global help
    if game[0] == game[1] == game[2] and game[1] != "[ ]": # horizontal 1
        winner = game[0]
        return True
    elif game[0] == game[3] == game[6] and game[3] != "[ ]": # vertical 2
        winner = game[3]
        return True
    elif game[0] == game[4] == game [8] and game[4] != "[ ]": # diagonal 1
        winner = game[4]
        return True
    elif game[6] == game[4] == game[2] and game[4] != "[ ]": # diagonal 2
        winner = game[4]
        return True
    elif game[1] == game[4] == game[7] and game[4] != "[ ]": # vertical 2
        winner = game[4]
        return True
    elif game[2] == game[5] == game[8] and game [5] != "[ ]": # vertical 3
        winner = game[5]
        return True
    elif game[3] == game[4] == game[5] and game[3] != "[ ]": # horizontal 2
        winner = game[4]
        return True
    elif game[6] == game[7] == game[8] and game[6] != "[ ]": # horizontal 3
        winner = game[6]
        return True

def checktie():
    global help
    if "[ ]" not in game:
        print("it's a tie")
        help = 1
    
def win():
    global help
    if checkwin():
        print("the winner is " + winner + "!!!!")
        help = 1


while help == 0:
    actionthing()
    checkwin()
    checktie()
    win()




