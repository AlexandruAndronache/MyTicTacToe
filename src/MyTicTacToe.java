public class MyTicTacToe {

    public static final char SYMBOL_X = 'X';
    public static final char SYMBOL_0 = '0';

    public static final int GAME_SIZE = 3;

    char[][] game = new char [3][3];

    Player player1;
    Player player2;

    public MyTicTacToe(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public void ShowGame(){
        for(int i = 0; i < GAME_SIZE; i++){
            for( int j = 0; j < GAME_SIZE; j++){
                System.out.print(game[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void initBoard(){
        for (int i =0; i< GAME_SIZE; i++){
            for (int j = 0; j < GAME_SIZE; j++){
                game[i][j] = '.';
            }
        }
    }

    public boolean isWin(){
        //testesz linii
        //testez coloane
        //testez diag principala
        //testesz diag secundara
        return false;
    }

    public void playGame(){
        initBoard();
        System.out.println("Incepe jocul: ");
        ShowGame();

        Player currenctPlayer = player1;

        int nrMoves = 0;
        boolean isWin = false;

        while(isWin == false && nrMoves < 9){
            // citesc mutare
            // validez mutare
            // efectuez mutarea
            // numar mutarea
            // testez daca am stare de win

            // daca nu e win sau nu mai am mutari -- schimb jucatorul
        }

        // afisez mesaj corespunzator
    }

}
