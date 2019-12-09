package cpsc2150.extendedTicTacToe;

/**
 * Jeffrey Black
 * jtblack@clemson.edu
 * 9/15/19
 */

/**
 * GameBoard entity class
 *
 * GameBoard represents an extended tic-tac-toe board
 * class contains the tic-tac-toe board, functions
 * specific to playing tic-tac-toe, and the win conditions
 * for the game
 */

/**
 * @param BOARD_SIZE side length of BOARD_SIZE x BOARD_SIZE tic-tac-toe board
 * @param WIN_REQ number of markers in a row required to win the game
 * @param board data structure representing tic-tac-toe board
 * @param totalMarkers number of markers currently on the tic-tac-toe board
 * @inv BOARD_SIZE > 0
 * @inv 0 < WIN_REQ and WIN_REQ <= BOARD_SIZE
 * @inv board != NULL
 * @inv 0 <= totalMarkers and totalMarkers <= BOARD_SIZE * BOARD_SIZE
 */
public class GameBoard {
    //fields
    private int BOARD_SIZE;
    private int WIN_REQ;
    private char[][] board;
    private int totalMarkers;

    //methods

    /**
     * @post BOARD_SIZE = 8
     * @post WIN_REQ = 5
     * @post [board is an empty tic-tac-toe board of size BOARD_SIZE x BOARD_SIZE]
     * @post totalMarkers = 0
     */
    public void GameBoard(){}

    /**
     * @param pos position on game board being checked
     * @return whether or not pos is an empty space on the tic-tac-toe board
     * @pre [player entered a row and column to place a marker at]
     * @post if pos is available : returns true
     * @post if pos is not available : returns false
     */
    public boolean checkSpace(BoardPosition pos){}

    /**
     *
     * @param pos position on game board to place marker at
     * @param player the current player
     * @pre [pos is an empty space on the tic-tac-toe board]
     * @pre player == 'X' or player == 'Y'
     * @post [the player's marker will appear at pos on the tic-tac-toe board]
     * @post totalMarkers = #totalMarkers + 1
     */
    public void placeMarker(BoardPosition pos, char player){}

    /**
     * @param lastPos the location on the board where the last marker was placed
     * @return whether or not placing the last marker resulted in a win
     * @pre [the player placed a marker on the tic-tac-toe board at lastPos]
     * @post if win conditions are met : returns true
     * @post if win conditions are not met : returns false
     */
    public boolean checkForWinner(BoardPosition lastPos){}

    /**
     * @return whether or not the conditions for a draw have been met
     * @pre [player placed a marker on the tic-tac-toe board]
     * @post if draw conditions are met : returns true
     * @post if draw conditions are not met : returns false
     */
    public boolean checkForDraw(){}

    /**
     *
     * @param pos position to check
     * @return character representing what's at pos on the game board
     * @post if pos is within game board : returns content of cell at pos
     * @post if pos not within game board : returns '~'
     */
    public char whatsAtPos(BoardPosition pos){}

    /**
     *
     * @param lastPos the location on the board where the last marker was placed
     * @param player player being checked for win
     * @return whether or not last marker placed resulted in a win horizontally
     * @pre [player placed a marker on the tic-tac-toe board at lastPos]
     * @pre player == 'X' or player == 'Y'
     * @post if there is a horizontal win at lastPos: returns true
     * @post if there is no horizontal win at lastPos: returns false
     */
    public boolean checkHorizontalWin(BoardPosition lastPos, char player){}

    /**
     *
     * @param lastPos the location on the board where the last marker was placed
     * @param player player being checked for win
     * @return whether or not last marker placed resulted in a win vertically
     * @pre [player placed a marker on the tic-tac-toe board at lastPos]
     * @pre player == 'X' or player == 'Y'
     * @post if there is a vertical win at lastPos: returns true
     * @post if there is no vertical win at lastPos: returns false
     */
    public boolean checkVerticalWin(BoardPosition lastPos, char player){}

    /**
     *
     * @param lastPos the location on the board where the last marker was placed
     * @param player player being checked for win
     * @return whether or not last marker placed resulted in a win diagonally
     * @pre [player placed a marker on the tic-tac-toe board at lastPos]
     * @pre player == 'X' or player == 'Y'
     * @post if there is a diagonal win at lastPos: returns true
     * @post if there is no diagonal win at lastPos: returns false
     */
    public boolean checkDiagonalWin(BoardPosition lastPos, char player){}

    /**
     *
     * @param pos position to check
     * @param player player to check for
     * @pre player == 'X' or player == 'Y'
     * @return whether or not player has a marker at pos
     * @post if player has marker at pos : return true
     * @post if player does not have marker at pos or pos is not on board : return false
     */
    public boolean isPlayerAtPos(BoardPosition pos, char player){}

    /**
     * @return string representing the tic-tac-toe board and the markers on it
     */
    public String toString(){}

    /**
     * @param lastPos the location on the board where the last marker was placed
     * @param player player being checked for win
     * @return whether or not last marker placed resulted in a win along the lower-left/upper-right diagonal
     * @pre [player placed a marker on the tic-tac-toe board at lastPos]
     * @pre player == 'X' or player == 'Y'
     * @post if there is a  lower-left/upper-right diagonal win at lastPos: returns true
     * @post if there is no lower-left/upper-right diagonal win at lastPos: returns false
     */
    private boolean checkDiagonal1Win(BoardPosition lastPos, char player){}

    /**
     * @param lastPos the location on the board where the last marker was placed
     * @param player player being checked for win
     * @return whether or not last marker placed resulted in a win along the upper-left/lower-right diagonal
     * @pre [player placed a marker on the tic-tac-toe board at lastPos]
     * @pre player == 'X' or player == 'Y'
     * @post if there is a  upper-left/lower-right diagonal win at lastPos: returns true
     * @post if there is no upper-left/lower-right diagonal win at lastPos: returns false
     */
    private boolean checkDiagonal2Win(BoardPosition lastPos, char player){}
}

