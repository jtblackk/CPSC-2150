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
    public GameBoard(){
        this.BOARD_SIZE = 8;
        this.WIN_REQ = 5;
        this.totalMarkers = 0;

        //build new game board and fill it with empty spaces (' ')
        this.board = new char[this.BOARD_SIZE][this.BOARD_SIZE];
        for(int i = 0; i < this.BOARD_SIZE; i++){
            for(int j = 0; j < this.BOARD_SIZE; j++){
                this.board[i][j] = ' ';
            }
        }
    }


    /**
     * @param pos position on game board being checked
     * @return whether or not pos is an empty space on the tic-tac-toe board
     * @pre [player entered a row and column to place a marker at]
     * @post if pos = available : checkSpace = true
     * @post if pos != available : checkSpace = false
     */
    public boolean checkSpace(BoardPosition pos){
        //check if space is on board
        if(pos.getRow() < this.BOARD_SIZE && pos.getCol() < this.BOARD_SIZE) {
            //check if space is empty
            if(this.board[pos.getRow()][pos.getCol()] == ' '){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param pos position on game board to place marker at
     * @param player the current player
     * @pre [pos is an empty space on the tic-tac-toe board]
     * @pre player == 'X' or player == 'Y'
     * @post [the player's marker will appear at pos on the tic-tac-toe board]
     * @post totalMarkers = #totalMarkers + 1
     */
    public void placeMarker(BoardPosition pos, char player){
        this.board[pos.getRow()][pos.getCol()] = player;
        this.totalMarkers++;
    }

    /**
     * @param lastPos the location on the board where the last marker was placed
     * @return whether or not placing the last marker resulted in a win
     * @pre [the player placed a marker on the tic-tac-toe board at lastPos]
     * @post if win conditions are met : checkForWinner = true
     * @post if win conditions are not met : checkForWinner = false
     */
    public boolean checkForWinner(BoardPosition lastPos){
       if(this.checkHorizontalWin(lastPos, this.whatsAtPos(lastPos)) ||
            this.checkVerticalWin(lastPos, this.whatsAtPos(lastPos)) ||
            this.checkDiagonalWin(lastPos, this.whatsAtPos(lastPos))){
            return true;
       }
       return false;

    }

    /**
     * @return whether or not the conditions for a draw have been met
     * @pre [player placed a marker on the tic-tac-toe board]
     * @post if draw conditions are met : checkForDraw = true
     * @post if draw conditions are not met : checkForDraw = false
     */
    public boolean checkForDraw(){
        //same number of markers as there is board positions?
        if(this.totalMarkers == this.BOARD_SIZE * this.BOARD_SIZE){
            return true;
        }
        return false;
    }

    /**
     *
     * @param pos position to check
     * @return character representing what's at pos on the game board
     * @post if pos is within game board : whatsAtPos = contents of cell at pos
     * @post if pos not within game board : whatsAtPos = '~'
     */
    public char whatsAtPos(BoardPosition pos){
        //check if pos is within board
        if( pos.getRow() < this.BOARD_SIZE && pos.getCol() < this.BOARD_SIZE && pos.getRow() >= 0 && pos.getCol() >= 0){
            return this.board[pos.getRow()][pos.getCol()];
        }
        return '~';
    }

    /**
     *
     * @param lastPos the location on the board where the last marker was placed
     * @param player player being checked for win
     * @return whether or not last marker placed resulted in a win horizontally
     * @pre [player placed a marker on the tic-tac-toe board at lastPos]
     * @pre player == 'X' or player == 'Y'
     * @post if there is a horizontal win at lastPos: checkHorizontalWin = true
     * @post if there is no horizontal win at lastPos: checkHorizontalWin = false
     */
    public boolean checkHorizontalWin(BoardPosition lastPos, char player){
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
        while(this.whatsAtPos(spotToCheck) == player);

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
        if(score >= this.WIN_REQ){
            return true;
        }
        return false;
    }

    /**
     *
     * @param lastPos the location on the board where the last marker was placed
     * @param player player being checked for win
     * @return whether or not last marker placed resulted in a win vertically
     * @pre [player placed a marker on the tic-tac-toe board at lastPos]
     * @pre player == 'X' or player == 'Y'
     * @post if there is a vertical win at lastPos: checkVerticalWin = true
     * @post if there is no vertical win at lastPos: checkVerticalWin = false
     */
    public boolean checkVerticalWin(BoardPosition lastPos, char player){
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
        while(this.whatsAtPos(spotToCheck) == player);


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
        while(this.whatsAtPos(spotToCheck) == player);

        //check if a win was made
        if(score >= this.WIN_REQ){
            return true;
        }
        return false;
    }

    /**
     *
     * @param lastPos the location on the board where the last marker was placed
     * @param player player being checked for win
     * @return whether or not last marker placed resulted in a win diagonally
     * @pre [player placed a marker on the tic-tac-toe board at lastPos]
     * @pre player == 'X' or player == 'Y'
     * @post if there is a diagonal win at lastPos: checkDiagonalWin = true
     * @post if there is no diagonal win at lastPos: checkDiagonalWin = false
     */
    public boolean checkDiagonalWin(BoardPosition lastPos, char player){
        if(this.checkDiagonal1Win(lastPos, player) || this.checkDiagonal2Win(lastPos, player)){
            return true;
        }
        return false;
    }

    /**
     *
     * @param pos position to check
     * @param player player to check for
     * @pre player == 'X' or player == 'Y'
     * @return whether or not player has a marker at pos
     * @post if player has marker at pos : isPlayerAtPos = true
     * @post if player does not have marker at pos or pos is not on board : isPlayerAtPos = false
     */
    public boolean isPlayerAtPos(BoardPosition pos, char player){
        //check if pos is a position on the board
        if(pos.getRow() < this.BOARD_SIZE && pos.getCol() < this.BOARD_SIZE){
            //check if player is at position
            if(this.board[pos.getRow()][pos.getCol()] == player){
                return true;
            }
        }
        return false;
    }

    /**
     * @return string representing the tic-tac-toe board and the markers on it
     * @post string representing the tic-tac-toe board was returned
     */
    public String toString(){
        String bString = "  ";

        //append column numbers
        for(int i = 0; i < this.BOARD_SIZE; i++){
            bString += i + " ";
        }

        bString += "\n";

        //append rows
        for(int i = 0; i < this.BOARD_SIZE; i++){
            //append row number
            bString += i + "|";

            //append each cell in row
            for(int j = 0; j < this.BOARD_SIZE; j++){
                bString += this.board[i][j] + "|";
            }

            bString += "\n";
        }

        return bString;
    }

    //lower-left/upper-right diagonal check
    private boolean checkDiagonal1Win(BoardPosition lastPos, char player){
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
        while(this.whatsAtPos(spotToCheck) == player);


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
        while(this.whatsAtPos(spotToCheck) == player);

        //check if a win was made
        if(score >= this.WIN_REQ){
            return true;
        }
        return false;
    }

    //upper-left/lower-right diagonal check
    private boolean checkDiagonal2Win(BoardPosition lastPos, char player){
        int score = 0;
        int offset;
        BoardPosition spotToCheck;

        //check spaces on the upper left
        offset = 0;
        do {
            offset++;
            score++;
            spotToCheck = new BoardPosition(lastPos.getRow() - offset, lastPos.getCol() - offset);
        }
        while(this.whatsAtPos(spotToCheck) == player);


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
        while(this.whatsAtPos(spotToCheck) == player);

        //check if a win was made
        if(score >= this.WIN_REQ){
            return true;
        }
        return false;
    }
}

