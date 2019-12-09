package cpsc2150.extendedTicTacToe;

/**
 * Jeffrey Black
 * jtblack@clemson.edu
 * 9/15/19
 */

/**
 * extended tic-tac-toe boundary class
 *
 * Game Details:
 * 8x8 tic-tac-toe game
 * 5 markers in a row to win
 * can play multiple rounds
 */

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
    public static void main(){}

    /**
     * @pre [a player made a play]
     * @post if #currentPlayer == 'X' : currentPlayer = 'Y'
     * @post if #currentPlayer == 'Y' : currentPlayer = 'X'
     */
    private void nextPlayer(){}

    /**
     * @return whether or not the play resulted in a win or a draw
     * @post if player wins or ties the game : returns true
     * @post if player did not win the game : returns false
     * @post [runs the player through the process of placing a marker on the tic-tac-toe board]
     */
    private void makePlay(){}
}
