package cpsc2150.extendedTicTacToe;

/**
 * IGameBoard represents a tic-tac-toe game board.
 * The game board is represented by a 2D grid.
 * Initialization ensures:
 *      board is a grid of size BOARD_SIZE_ROWS x BOARD_SIZE_COLS
 *      WIN_REQ markers in a row are required to win
*  Defines:
 *      board: data structure representing the tic-tac-toe board
 *      BOARD_SIZE_ROWS: number of rows the game board has
 *      BOARD_SIZE_COLS: number of columns the game board has
 *      MAX_ROWS: maximum number of allowable rows on the game board
 *      MIN_ROWS: minimum number of allowable rows on the game board
 *      MAX_COLS: maximum number of allowable columns on the game board
 *      MIN_COLS: minimum number of allowable columns on the game board
 *      WIN_REQ: number of markers in a row required to win
 *      MAX_WIN_REQ: maximum amount of markers in a row required to win
 *      MIN_WIN_REQ: minimum amount of markers in a row required to win
 *      totalMarkers: how many markers are currently on the board
 * Constraints:
 *      MIN_ROWS <= BOARD_SIZE_ROWS <= MAX_ROWS
 *      MIN_COLS <= BOARD_SIZE_COLS <= MAX_COLS
 *      MIN_WIN_REQ <= WIN_REQ <= MAX-WIN_REQ
 *      WIN_REQ <= BOARD_SIZE_ROWs and WIN_REQ <= BOARD_SIZE_COLS
 *      0 <= totalMarkers <= BOARD_SIZE_ROWS * BOARD_SIZE_COLS
 *      board != null
 */
public interface IGameBoard {

    //-------------------constants-------------------//
    int MAX_ROWS = 100;
    int MIN_ROWS = 3;

    int MAX_COLS = 100;
    int MIN_COLS = 3;

    int MAX_WIN_REQ = 25;
    int MIN_WIN_REQ = 3;




    //-------------------primary methods-------------------//

    /**

     * @param pos position on game board to place marker at
     * @param player the current player
     * @pre [pos is an empty space on the tic-tac-toe board]
     * @pre player == 'X' or player == 'O'
     * @post [the player's marker will appear at pos on the tic-tac-toe board]
     * @post totalMarkers = #totalMarkers + 1
     */
    void placeMarker(BoardPosition pos, char player);

    /**
     * @param pos position to check
     * @return character representing what's at pos on the game board
     * @post if pos is within game board : whatsAtPos = contents of cell at pos
     * @post if pos not within game board : whatsAtPos = '~'
     */
    char whatsAtPos(BoardPosition pos);

    /**
     * @return the number of rows on the game board
     * @post getNumRows = BOARD_SIZE_ROWS
     */
    int getNumRows();

    /**
     * @return the number of columns on the game board
     * @post getNumRows = BOARD_SIZE_COLS
     */
    int getNumColumns();

    /**
     * @return the number of markers in a row required to win
     * @post getNumToWin = WIN_REQ
     */
    int getNumToWin();

    //-------------------secondary methods-------------------//

    /**
     * @param pos position on game board being checked
     * @return whether or not pos is an empty space on the tic-tac-toe board
     * @pre [player entered a row and column to place a marker at]
     * @post if pos on game board && empty : checkSpace = true
     * @post if pos not on game board or not empty : checkSpace = false
     */
    default boolean checkSpace(BoardPosition pos){
        //check if space is on board
        if(pos.getRow() < this.getNumRows() && pos.getCol() < this.getNumColumns()) {
            //check if space is empty
            if(this.whatsAtPos(pos) == ' '){
                return true;
            }
        }
        return false;
    }

    /**
     * @return whether or not the conditions for a draw have been met
     * @pre [player placed a marker on the tic-tac-toe board]
     * @post if totalMarkers == BOARD_SIZE_ROWS * BOARD_SIZE_COLS : checkForDraw = true
     * @post if totalMarkers < BOARD_SIZE_ROWS * BOARD_SIZE_COLS : checkForDraw = false
     */
    default boolean checkForDraw(){
        //count number of X and O's on the board
        int totalMarkers = 0;
        for(int row = 0; row < this.getNumRows(); row++){
            for(int col = 0; col < this.getNumColumns(); col++){
                BoardPosition spotToCheck = new BoardPosition(row, col);
                if(this.whatsAtPos(spotToCheck) == 'X' || this.whatsAtPos(spotToCheck) == 'O'){
                    totalMarkers++;
                }
            }
        }

        //check if number of markers counted < number of spaces on the board
        if(totalMarkers < this.getNumRows() * this.getNumColumns()){
            return false;
        }
        return true;
    }

    /**
     * @param lastPos the location on the board where the last marker was placed
     * @return whether or not placing the last marker resulted in a win
     * @pre [the player placed a marker on the tic-tac-toe board at lastPos]
     * @post if there are WIN_REQ markers in a row : checkForWinner = true
     * @post if there are not WIN_REQ markers in a row : checkForWinner = false
     */
    default boolean checkForWinner(BoardPosition lastPos){
        if(this.checkHorizontalWin(lastPos, this.whatsAtPos(lastPos)) ||
                this.checkVerticalWin(lastPos, this.whatsAtPos(lastPos)) ||
                this.checkDiagonalWin(lastPos, this.whatsAtPos(lastPos))){
            return true;
        }
        return false;

    }

    /**
     * @param lastPos the location on the board where the last marker was placed
     * @param player player being checked for win
     * @return whether or not last marker placed resulted in a win horizontally
     * @pre [player placed a marker on the tic-tac-toe board at lastPos]
     * @pre player == 'X' or player == 'O'
     * @post if there is WIN_REQ in a row horizontally : checkHorizontalWin = true
     * @post if there is not WIN_REQ in a row horizontally : checkHorizontalWin = false
     */
    default boolean checkHorizontalWin(BoardPosition lastPos, char player){
        int score = 0;
        int offset;
        BoardPosition spotToCheck;

        //check spaces on the left
        offset = 0;
        do {
            offset++;
            score++;
            spotToCheck = new BoardPosition(lastPos.getRow(), lastPos.getCol() - offset);
        }
        while(this.isPlayerAtPos(spotToCheck, player));

        //check spaces on the right
        offset = 0;
        do {
            //subtract one from score to account for last marker placed
            if(offset == 0){
                score--;
            }
            offset++;
            score++;
            spotToCheck = new BoardPosition(lastPos.getRow(), lastPos.getCol() + offset);
        }
        while(this.whatsAtPos(spotToCheck) == player);

        //check if a win was made
        if(score >= this.getNumToWin()){
            return true;
        }
        return false;
    }

    /**
     * @param lastPos the location on the board where the last marker was placed
     * @param player player being checked for win
     * @return whether or not last marker placed resulted in a win vertically
     * @pre [player placed a marker on the tic-tac-toe board at lastPos]
     * @pre player == 'X' or player == 'O'
     * @post if there is WIN_REQ in a row vertically : checkVerticalWin = true
     * @post if there is not WIN_REQ in a row vertically : checkVerticalWin = false
     */
    default boolean checkVerticalWin(BoardPosition lastPos, char player){
        int score = 0;
        int offset;
        BoardPosition spotToCheck;

        //check spaces above
        offset = 0;
        do {
            offset++;
            score++;
            spotToCheck = new BoardPosition(lastPos.getRow() - offset, lastPos.getCol());
        }
        while(this.isPlayerAtPos(spotToCheck, player));


        //check spaces below
        offset = 0;
        do {
            //subtract one from score to account for last marker placed
            if(offset == 0){
                score--;
            }
            offset++;
            score++;
            spotToCheck = new BoardPosition(lastPos.getRow() + 1, lastPos.getCol());
        }
        while(this.isPlayerAtPos(spotToCheck, player));

        //check if a win was made
        if(score >= this.getNumToWin()){
            return true;
        }
        return false;
    }

    /**
     * @param lastPos the location on the board where the last marker was placed
     * @param player player being checked for win
     * @return whether or not last marker placed resulted in a win diagonally
     * @pre [player placed a marker on the tic-tac-toe board at lastPos]
     * @pre player == 'X' or player == 'O'
     * @post if there is WIN_REQ in a row diagonally : checkDiagonalWin = true
     * @post if there is not WIN_REQ in a row diagonally : checkDiagonalWin = false
     */
    default boolean checkDiagonalWin(BoardPosition lastPos, char player){
        //-----------lower-left/upper-right diagonal check-----------//
        int score = 0;
        int offset;
        BoardPosition spotToCheck;

        //check spaces on the lower left
        offset = 0;
        do {
            offset++;
            score++;
            spotToCheck = new BoardPosition(lastPos.getRow() + offset, lastPos.getCol() - offset);
        }
        while(this.isPlayerAtPos(spotToCheck, player));


        //check spaces on the upper right
        offset = 0;
        do {
            //subtract one from score to account for last marker placed
            if(offset == 0){
                score--;
            }
            offset++;
            score++;
            spotToCheck = new BoardPosition(lastPos.getRow() - offset, lastPos.getCol() + offset);
        }
        while(this.isPlayerAtPos(spotToCheck, player));

        //check if a win was made
        if(score >= this.getNumToWin()){
            return true;
        }

        //reset score
        score = 0;

        //-----------upper-left/lower-right diagonal check------------//
        //check spaces on the upper left
        offset = 0;
        do {
            offset++;
            score++;
            spotToCheck = new BoardPosition(lastPos.getRow() - offset, lastPos.getCol() - offset);
        }
        while(this.isPlayerAtPos(spotToCheck, player));


        //check spaces on the lower right
        offset = 0;
        do {
            //subtract one from score to account for last marker placed
            if(offset == 0){
                score--;
            }
            offset++;
            score++;
            spotToCheck = new BoardPosition(lastPos.getRow() + offset, lastPos.getCol() + offset);
        }
        while(this.isPlayerAtPos(spotToCheck, player));

        //check if a win was made
        if(score >= this.getNumToWin()){
            return true;
        }
        return false;

    }

    /**
     *
     * @param pos position to check
     * @param player player to check for
     * @return whether or not player has a marker at pos
     * @pre player == 'X' or player == 'O'
     * @post if player has marker at pos : isPlayerAtPos = true
     * @post if player does not have marker at pos or pos is not on board : isPlayerAtPos = false
     */
    default boolean isPlayerAtPos(BoardPosition pos, char player){
        //check if pos is a position on the board
        if(pos.getRow() < this.getNumRows() && pos.getCol() < this.getNumColumns()){
            //check if player is at position
            if(this.whatsAtPos(pos) == player){
                return true;
            }
        }
        return false;
    }
}
