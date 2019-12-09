package cpsc2150.extendedTicTacToe;

/**
 * Jeffrey Black
 * jtblack@clemson.edu
 * 9/29/19
 */

/**
 * extended tic-tac-toe boundary class
 *
 * Game Details:
 * resizeable tic-tac-toe game
 * win conditions can be changed
 * can play multiple rounds
 * can have more than 2 players
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @param players a list of players playing the current game of tic-tac-toe
 * @param currentPlayer the player whose turn it is
 * @param board the tic-tac-toe board entity
 * @param MAX_PLAYERS the maximum amount of players allowed to play
 * @param MIN_PLAYERS the minimum amount of players required to play
 * @inv [currentPlayer is a character in the players list]
 * @inv MIN_PLAYERS <= players.size() [number of players] <= MAX_PLAYERS
 * @inv [players is a list of capitalized characters]
 * @inv board != NULL
 *
 */
public class GameScreen {
    //constants
    static final int MAX_PLAYERS = 10;
    static final int MIN_PLAYERS = 2;


    //fields
    private List<Character> players = new ArrayList<>();
    private Character currentPlayer;
    private IGameBoard board;

    //methods

    /**
     * @post [runs the extended tic-tac-toe program]
     */
    public static void main(String args[]){
        GameScreen game = new GameScreen();
        boolean playAgain = true;
        Scanner console = new Scanner(System.in);

        while(playAgain){
            //clear players
            game.players.clear();

            //ask for game specs
            int numPlayers;
            do {
                System.out.println("How many players? (must be between " + GameScreen.MIN_PLAYERS + " and " + GameScreen.MAX_PLAYERS + ")");
                numPlayers = console.nextInt();
            }
            while(numPlayers > GameScreen.MAX_PLAYERS || numPlayers < GameScreen.MIN_PLAYERS);

            //choose marker representations
            for(int i = 0; i < numPlayers; i++){
                Character choice;
                do {
                    System.out.println("Choose character representation for player " + (i+1) + " (must not already be taken)");
                    choice = Character.toUpperCase(console.next().charAt(0));
                }
                while(game.players.contains(choice));

                game.players.add(choice);
            }

            int numRows;
            do {
                System.out.println("How many rows? (must be between " + IGameBoard.MIN_ROWS +" and " + IGameBoard.MAX_ROWS + ")");
                numRows = console.nextInt();
            }
            while(numRows > IGameBoard.MAX_ROWS || numRows < IGameBoard.MIN_ROWS);

            int numCols;
            do {
                System.out.println("How many columns? (must be between " + IGameBoard.MIN_COLS +" and " + IGameBoard.MAX_COLS + ")");
                numCols = console.nextInt();
            }
            while(numCols > IGameBoard.MAX_COLS || numCols < IGameBoard.MIN_COLS);

            int winReq;
            do{
                System.out.println("How many in a row to win? (must be between " + IGameBoard.MIN_WIN_REQ +" and " + IGameBoard.MAX_WIN_REQ + ", and must be valid for the board size)");
                winReq = console.nextInt();
            }
            while(winReq > IGameBoard.MAX_WIN_REQ || winReq < IGameBoard.MIN_WIN_REQ || winReq > numRows || winReq > numCols);

            char implementation;
            do {
                System.out.println("Would you like a Fast Game (F/f) or a Memory Efficient Game (M/m)?");
                implementation = console.next().charAt(0);
            }
            while(!(implementation == 'F' || implementation == 'f' || implementation == 'M' || implementation == 'm'));

            //construct game board
            if(implementation == 'F' || implementation == 'f'){
                game.board = new GameBoard(numRows, numCols, winReq);
            }
            else if(implementation == 'M' || implementation == 'm'){
                game.board = new GameBoardMem(numRows, numCols, winReq);
            }

            //make plays until win/draw condition is met
            game.currentPlayer = game.players.get(0);
            while (game.makePlay() == false) {
                game.nextPlayer();
            }

            //ask to play again
            System.out.println("Play again? (Y/N)");
            boolean madeAChoice = false;

            while(madeAChoice == false) {
                String choice = console.next();
                if (choice.charAt(0) == 'N' || choice.charAt(0) == 'n') {
                    playAgain = false;
                    madeAChoice = true;

                } else if (choice.charAt(0) != 'Y' && choice.charAt(0) != 'y') {
                    System.out.println("invalid option. try again.");
                }
                else{
                    playAgain = true;
                    madeAChoice = true;
                }
            }

        }

    }

    /**
     * @pre [a player made a play]
     * @post if #currentPlayer != end of list : currentPlayer = players.get(players.indexOf(currentPlayer) + 1)
     * @post if #currentPlayer == end of list : currentPlayer = players.get(0);
     * @post [alternates the current player]
     */
    private void nextPlayer(){
        if(this.currentPlayer == this.players.get(this.players.size() - 1)){
            this.currentPlayer = this.players.get(0);
        }
        else{
            this.currentPlayer = this.players.get(this.players.indexOf(currentPlayer) + 1);
        }
    }

    /**
     * @return whether or not the play resulted in a win or a draw
     * @post if player wins or ties the game : returns true
     * @post if player did not win the game : returns false
     * @post [runs the player through the process of placing a marker on the tic-tac-toe board]
     */
    private boolean makePlay() {
        Scanner console = new Scanner(System.in);
        boolean foundASpace = false;
        BoardPosition finalLocation = null;

        //player chooses a space
        while (foundASpace == false) {
            //print gameboard
            System.out.print(this.board.toString());

            //get row and col from player
            System.out.println("Player " + this.currentPlayer + " please enter a row");
            int chosenRow = console.nextInt();
            System.out.println("Player " + this.currentPlayer + " please enter a column");
            int chosenCol = console.nextInt();
            BoardPosition chosenPos = new BoardPosition(chosenRow, chosenCol);

            //check that chosen position is an available space
            if (this.board.checkSpace(chosenPos) == false) {
                System.out.println("Space is unavailable. Pick a new position.");
            } else {
                foundASpace = true;
                finalLocation = new BoardPosition(chosenRow, chosenCol);
            }
        }

        //place marker and check for wins or draws
        this.board.placeMarker(finalLocation, this.currentPlayer);
        if(this.board.checkForWinner(finalLocation)){
            System.out.println("Player " + this.currentPlayer + " wins!");
        }
        else if(this.board.checkForDraw()){
            System.out.println("Draw!");
        }
        else{
            return false;
        }

        return true;
    }
}
