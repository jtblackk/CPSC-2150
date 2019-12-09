package cpsc2150.extendedTicTacToe;

/**
 * Jeffrey Black
 * jtblack@clemson.edu
 * 9/29/19
 */

/**
 * BoardPosition entity class
 *
 * BoardPosition represents the position of an individual cell on a tic-tac-toe board
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
    public BoardPosition(int r, int c){
        this.row = r;
        this.col = c;
    }

     /**
      * @return the row number of the cell
      * @post getRow = row position of cell
      */
    public int getRow(){
        return this.row;
    }

    /**
     * @return the column number of the cell
     * @post getRow = column position of cell
     */
    public int getCol(){
        return this.col;
    }

    /**
     * @param other cell to compare current cell to
     * @return whether or not the cells being compared are the same cell
     * @post if cells = same : equals = true
     * @post if cells != same : equals = false
     */
    public boolean equals(BoardPosition other){
        if(other.getRow() == this.row && other.getCol() == this.col){
            return true;
        }
        return false;
    }

    /**
     * @return string representing the position of the cell
     * @post toString = "<row>,<column>"
     */
    public String toString(){
        return this.row + "," + this.col;
    }
}
