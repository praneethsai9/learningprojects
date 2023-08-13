import random

board=["-"]*9
winner=None
currentPlayer="X"
gameRunning=True
 
#printing the game board
def printBoard(board):
    print("\n")
    print(board[0]+" | "+board[1]+" | "+board[2])
    print("==========")
    print(board[3]+" | "+board[4]+" | "+board[5])
    print("==========")
    print(board[6]+" | "+board[7]+" | "+board[8])
    print("\n")
#take player input
def playerInput(board):
    global currentPlayer
    print("Npw the current player is ",currentPlayer)
    inp=int(input("Enter  the position: "))
    if board[inp-1]=="-" and inp>=1 and inp<=9:
        board[inp-1]=currentPlayer
    else:
        print("OOPS position either filled or invalid position")

#check for win/tie
def checkHorizontal(board):
    global currentPlayer
    global winner
    if board[0]==board[1]==board[2] and board[0]!="-":
        winner=board[0]
        return True
    if board[3]==board[4]==board[5] and board[3]!="-":
        winner=board[3]
        return True
    if board[6]==board[7]==board[8] and board[6]!="-":
        winner=board[6]
        return True   
     
def checkVertical(board):
    global currentPlayer
    global winner
    if board[0]==board[3]==board[6] and board[0]!="-":
        winner=board[0]
        return True
    if board[1]==board[4]==board[7] and board[1]!="-":
        winner=board[1]
        return True
    if board[2]==board[5]==board[8] and board[2]!="-":
        winner=board[2]
        return True  

def checkDiag(board):
    global winner
    if board[0]==board[4]==board[8] and board[0]!="-":
        winner=board[0]
        return True
    if board[2]==board[4]==board[6] and board[2]!="-":
        winner=board[2]

def checkWin(board):
    global gameRunning
    global winner
    if checkHorizontal(board) or checkVertical(board) or checkDiag(board):
        printBoard(board)
        print(f"The WINNER!!!! is {winner}")
        gameRunning=False

def checkTie(board):
    global gameRunning
    if "-" not in board:
        printBoard(board)
        print("!!!!GAME TIE!!!")
        gameRunning=False

#switch player
def switchPlayer(board):
    global currentPlayer
    if currentPlayer=="X":
        currentPlayer="O"
    else:
        currentPlayer="X"


"""computer
def computer(board):
    while currentPlayer=="O":
        position=random.randint(0,8)
        if board[position]=="-":
            board[position]="O"
            switchPlayer(board)"""


while gameRunning:
    printBoard(board)
    playerInput(board)
    checkWin(board)
    checkTie(board)
    switchPlayer(board)
    """computer(board)
    checkWin(board)
    checkTie(board)"""

