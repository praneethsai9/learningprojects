import java.util.Scanner;
import java.util.Random;

public class toe_tic_toe {
    static char[] board = {'-', '-', '-', '-', '-', '-', '-', '-', '-'};
    static char winner = '-';
    static char currentPlayer = 'X';
    static boolean gameRunning = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (gameRunning) {
            printBoard();
            playerInput();
            checkWin();
            checkTie();
            switchPlayer();
            // computer(); Uncomment if you want to implement the computer's move
            // checkWin();
            // checkTie();
        }

        sc.close();
    }

    public static void printBoard() {
        System.out.println();
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("==========");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("==========");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    public static void playerInput() {
        System.out.println("Now the current player is " + currentPlayer);
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();

        if (inp >= 1 && inp <= 9 && board[inp - 1] == '-') {
            board[inp - 1] = currentPlayer;
        } else {
            System.out.println("OOPS position either filled or invalid position");
        }
    }

    public static boolean checkHorizontal() {
        if ((board[0] == board[1] && board[1] == board[2] && board[0] != '-')) {
            winner = board[0];
            return true;
        }
        if ((board[3] == board[4] && board[4] == board[5] && board[3] != '-')) {
            winner = board[3];
            return true;
        }
        if ((board[6] == board[7] && board[7] == board[8] && board[6] != '-')) {
            winner = board[6];
            return true;
        }
        return false;
    }

    public static boolean checkVertical() {
        if ((board[0] == board[3] && board[3] == board[6] && board[0] != '-')) {
            winner = board[0];
            return true;
        }
        if ((board[1] == board[4] && board[4] == board[7] && board[1] != '-')) {
            winner = board[1];
            return true;
        }
        if ((board[2] == board[5] && board[5] == board[8] && board[2] != '-')) {
            winner = board[2];
            return true;
        }
        return false;
    }

    public static boolean checkDiag() {
        if ((board[0] == board[4] && board[4] == board[8] && board[0] != '-')) {
            winner = board[0];
            return true;
        }
        if ((board[2] == board[4] && board[4] == board[6] && board[2] != '-')) {
            winner = board[2];
            return true;
        }
        return false;
    }

    public static void checkWin() {
        if (checkHorizontal() || checkVertical() || checkDiag()) {
            printBoard();
            System.out.println("The WINNER!!!! is " + winner);
            gameRunning = false;
        }
    }

    public static void checkTie() {
        if (!gameRunning)
            return;
        for (char cell : board) {
            if (cell == '-') {
                return;
            }
        }
        printBoard();
        System.out.println("!!!!GAME TIE!!!");
        gameRunning = false;
    }

    public static void switchPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    // Uncomment and complete this method if you want to implement the computer's move
    /*
    public static void computer() {
        while (currentPlayer == 'O') {
            Random rand = new Random();
            int position = rand.nextInt(9);
            if (board[position] == '-') {
                board[position] = 'O';
                switchPlayer();
            }
        }
    }
    */
}
