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
 * 8x8 tic-tac-toe game
 * 5 markers in a row to win
 * can play multiple rounds
 */

import java.util.Scanner;

/**
 * @param currentPlayer the player whose turn it is
 * @param board the tic-tac-toe board entity
 * @inv currentPlayer == 'X' or currentPlayer == 'Y'
 * @inv board != NULL
 */
public class GameScreen {
    //fields
    private char currentPlayer;
    private GameBoard board;

    //methods

    /**
     * @post [runs the extended tic-tac-toe program]
     */
    public static void main(String args[]){
        GameScreen game = new GameScreen();

        boolean playAgain = true;
        Scanner console = new Scanner(System.in);

        while(playAgain) {
            //reset game
            game.board = new GameBoard();
            game.currentPlayer = 'X';

            //make plays until win/draw condition is met
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

                } else if (choice.charAt(0) != 'Y' || choice.charAt(0) != 'y') {
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
     * @post if #currentPlayer == 'X' : currentPlayer = 'Y'
     * @post if #currentPlayer == 'Y' : currentPlayer = 'X'
     * @post [alternates the current player]
     */
    private void nextPlayer(){
        if(this.currentPlayer == 'X'){
            this.currentPlayer = 'O';
        }
        else{
            this.currentPlayer = 'X';
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
            System.out.println("Player " + currentPlayer + " please enter a row");
            int chosenRow = console.nextInt();
            System.out.println("Player " + currentPlayer + " please enter a column");
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
