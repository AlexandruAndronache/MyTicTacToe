import java.util.Scanner;

public class MyTicTacToe {

    public static final char SYMBOL_X = 'X';
    public static final char SYMBOL_0 = '0';

    public static final int GAME_SIZE = 3;

    char[][] game = new char[3][3];

    Player player1;
    Player player2;

    public MyTicTacToe(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void ShowGame() {
        for (int i = 0; i < GAME_SIZE; i++) {
            for (int j = 0; j < GAME_SIZE; j++) {
                System.out.print(game[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void initBoard() {
        for (int i = 0; i < GAME_SIZE; i++) {
            for (int j = 0; j < GAME_SIZE; j++) {
                game[i][j] = '.';
            }
        }
    }

    public Move readMove() {
        Scanner s = new Scanner(System.in);
        System.out.println("Citim miscarea: ");
        String myMove = s.nextLine();
        String[] split = myMove.split("-");

        int line = Integer.valueOf(split[0]);
        int column = Integer.valueOf(split[1]);

        Move m = new Move(line, column);
        return m;
    }

    public void makeMove(Move move, char Symbol) {
        game[move.line][move.col] = Symbol;
    }

    public boolean isWinLine(int line, char symbol) {
        boolean isWin = true;
        int i = 0;

        while (i < GAME_SIZE && isWin == true) {
            if (game[line][i] != symbol) {
                isWin = false;
            }
            i++;
        }
        return isWin;
    }

    public boolean isWinColumn(int column, char symbol) {
        boolean isWin = true;
        int i = 0;

        while (i < GAME_SIZE && isWin == true) {
            if (game[i][column] != symbol) {
                isWin = false;
            }
            i++;
        }
        return isWin;
    }

    public boolean isWinDiag1(char symbol) {
        boolean isWin = true;
        int i = 0;
        while (i < GAME_SIZE && isWin == true) {
            if (game[i][i] != symbol) {
                isWin = false;
            }
            i++;
        }
        return isWin;
    }

    public boolean isWinDiag2(char symbol) {
        boolean isWin = true;
        int i = 0;
        while (i < GAME_SIZE && isWin == true) {
            if (game[i][GAME_SIZE - i - 1] != symbol) {
                isWin = false;
            }
            i++;
        }
        return isWin;
    }

    public boolean isWin(Move move, char symbol) {
        boolean isWin = false;
        //testesz linii
        isWin = isWinLine(move.line, symbol);

        if (isWin == false) {
            //testez coloane
            isWin = isWinColumn(move.col, symbol);
        }

        //testez diag principala
        if (isWin == false && move.line == move.col) {
            isWin = isWinDiag1(symbol);
        }

        //testesz diag secundara
        if (isWin == false && move.line == GAME_SIZE - move.col - 1) {
            isWin = isWinDiag2(symbol);
        }
        return isWin;
    }


    public void playGame() {
        initBoard();
        System.out.println("Incepe jocul: ");
        ShowGame();
        Player currentPlayer = player1;
        char currentSymbol = SYMBOL_X;
        int nrMoves = 0;
        boolean isWin = false;


        while (isWin == false && nrMoves < (GAME_SIZE * GAME_SIZE)) {

            // citesc mutare
            Move move = readMove();

            // validez mutare



            // efectuez mutarea
            makeMove(move, currentSymbol);
            ShowGame();

            // numar mutarea
            nrMoves++;

            if (nrMoves >= (2 * GAME_SIZE - 1)) {

                // testez daca am stare de win
                isWin = isWin(move, currentSymbol);
            }
            // daca nu e win sau nu mai am mutari -- schimb jucatorul
            if (!isWin) {
                if (currentPlayer == player1) {
                    currentPlayer = player2;
                    currentSymbol = SYMBOL_0;
                } else {
                    currentPlayer = player1;
                    currentSymbol = SYMBOL_X;
                }
            }
        }

        // afisez mesaj corespunzator
        if (isWin == true) {
            System.out.println("This is a win for" + " " + currentPlayer.name);
        } else {
            System.out.println("There is no winner!");
        }
    }


}
