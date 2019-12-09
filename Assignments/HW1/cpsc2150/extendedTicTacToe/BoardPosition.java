package cpsc2150.extendedTicTacToe;

/**
 * Jeffrey Black
 * jtblack@clemson.edu
 * 9/15/19
 */

/**
 * BoardPosition entity class
 *
 * BoardPosition represents an individual cell on a tic-tac-toe board
 * class is used to enable use of ordered pairs to represent locations on the tic-tac-toe board
 */


/**
 * @param row which row cell is in
 * @param col which column the cell is in
 * @inv 0 <= row
 * @inv 0 <= col
 */
public class BoardPosition {
    //fields
    private int row;
    private int col;

    //methods

    /**
     * @param r cell row
     * @param c cell column
     * @pre 0 <= r
     * @pre 0 <= c
     * @post row = r
     * @post col = c
     */
    public void BoardPosition(int r, int c){}

     /**
      * @return the row number of the cell
      */
    public int getRow(){}

    /**
     * @return the column number of the cell
     */
    public int getCol(){}

    /**
     * @param other cell to compare current cell to
     * @return whether or not the cells being compared are the same cell
     * @post if cells are the same : returns true
     * @post if cells are different : returns false
     */
    public boolean equals(BoardPosition other){}

    /**
     * @return string representing the position of the cell
     * @post string = "<row>,<column>"
     */
    public String toString(){}
}
