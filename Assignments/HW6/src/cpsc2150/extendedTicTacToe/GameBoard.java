package cpsc2150.extendedTicTacToe;

/**
 * Jeffrey Black
 * jtblack@clemson.edu
 * 9/29/19
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
 * @param BOARD_SIZE_ROWS number of rows on the game board
 * @param BOARD_SIZE_COLS number of columns on the game board
 * @param WIN_REQ number of markers in a row required to win the game
 * @param board data structure representing tic-tac-toe board
 * @param totalMarkers number of markers currently on the tic-tac-toe board
 * @inv MIN_ROWS <= BOARD_SIZE_ROWS <= MAX_ROWS
 * @inv MIN_COLS <= BOARD_SIZE_COLS <= MAX_COLS
 * @inv MIN_WIN_REQ <= WIN_REQ <= MAX_WIN_REQ
 * @inv WIN_REQ <= BOARD_SIZE_ROWS and WIN_REQ <= BOARD_SIZE_COLS
 * @inv 0 <= totalMarkers <= BOARD_SIZE_ROWS * BOARD_SIZE_COLS
 * @inv board != NULL
 * @correspondences
 *      BOARD_SIZE_ROWS = BOARD_SIZE_ROWS
 *      BOARD_SIZE_COLS = BOARD_SIZE_COLS
 *      WIN_REQ = WIN_REQ
 *      totalMarkers = totalMarkers
 *      board = board
 */
public class GameBoard extends AbsGameBoard{
    //fields
    private int BOARD_SIZE_ROWS;
    private int BOARD_SIZE_COLS;
    private int WIN_REQ;
    private int totalMarkers;
    private char[][] board;

    //methods

    /**
     * @param num_rows number of rows on the game board
     * @param num_cols number of columns on the game board
     * @param win_req number of markers in a row required to win
     * @post BOARD_SIZE_ROWS = num_rows
     * @post BOARD_SIZE_COLS = = num_cols
     * @post WIN_REQ = = win_req
     * @post [board is an empty tic-tac-toe board of size BOARD_SIZE_ROWS x BOARD_SIZE_COLS]
     * @post totalMarkers = 0
     */
    public GameBoard(int num_rows, int num_cols, int win_req){
        this.BOARD_SIZE_ROWS = num_rows;
        this.BOARD_SIZE_COLS = num_cols;
        this.WIN_REQ = win_req;
        this.totalMarkers = 0;

        //build new game board and fill it with empty spaces (' ')
        this.board = new char[this.BOARD_SIZE_ROWS][this.BOARD_SIZE_COLS];
        for(int i = 0; i < this.BOARD_SIZE_ROWS; i++){
            for(int j = 0; j < this.BOARD_SIZE_COLS; j++){
                this.board[i][j] = ' ';
            }
        }
    }


    /**
     * see IGameBoard.placeMarker()
     */
    public void placeMarker(BoardPosition pos, char player){
            if(this.checkSpace(pos) == true) {
                this.board[pos.getRow()][pos.getCol()] = player;
                this.totalMarkers++;
            }
    }

    /**
     * see IGameBoard.checkForDraw()
     * [uses dynamic programming to count the number of markers on the board as players place them instead of
     * counting them during the checkForDraw() call]
     */
    public boolean checkForDraw(){
        //same number of markers as there is board positions?
        if(this.totalMarkers == this.BOARD_SIZE_ROWS * this.BOARD_SIZE_COLS){
            return true;
        }
        return false;
    }

    /**
     * see IGameBoard.whatsAtPos()
     */
    public char whatsAtPos(BoardPosition pos){
        //check if pos is within board
        if( pos.getRow() < this.BOARD_SIZE_ROWS && pos.getCol() < this.BOARD_SIZE_COLS && pos.getRow() >= 0 && pos.getCol() >= 0){
            return this.board[pos.getRow()][pos.getCol()];
        }
        return '~';
    }



    /**
     * see IGameBoard.getNumRows()
     */
    public int getNumRows() { return this.BOARD_SIZE_ROWS; }

    /**
     * see IGameBoard.getNumColumns()
     */
    public int getNumColumns() { return this.BOARD_SIZE_COLS; }

    /**
     * see IGameBoard.getNumToWin()
     */
    public int getNumToWin() { return this.WIN_REQ; }

}

