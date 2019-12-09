package cpsc2150.extendedTicTacToe;


import java.util.*;

public class GameBoardMem extends AbsGameBoard{
    //fields
    private int BOARD_SIZE_ROWS;
    private int BOARD_SIZE_COLS;
    private int WIN_REQ;
    private int totalMarkers;
    private Map<Character, List<BoardPosition>> board;

    //methods

    /**
     * @param num_rows number of rows on the game board
     * @param num_cols number of columns on the game board
     * @param win_req number of markers in a row required to win
     * @post BOARD_SIZE_ROWS = num_rows
     * @post BOARD_SIZE_COLS = num_cols
     * @post WIN_REQ = win_req
     * @post [board is a map with keys being the players playing and
     *      the values being the positions that the player has markers at]
     * @post totalMarkers = 0
     */
    public GameBoardMem(int num_rows, int num_cols, int win_req){
        this.BOARD_SIZE_ROWS = num_rows;
        this.BOARD_SIZE_COLS = num_cols;
        this.WIN_REQ = win_req;
        this.totalMarkers = 0;

        //build new game board
        board = new HashMap<>();
    }


    /**
     * see IGameBoard.placeMarker()
     */
    public void placeMarker(BoardPosition pos, char player){
        //if this is player's first marker, create new key-value pair for the player
        this.board.putIfAbsent(player, new ArrayList<>());

        //add position to player's list of marker positions
        List<BoardPosition> updatedList = this.board.get(player);
        updatedList.add(pos);
        this.board.replace(player, updatedList);

        this.totalMarkers++;
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
            //look through every key in the map
            for(Map.Entry<Character, List<BoardPosition>> pair: board.entrySet()){
                //look through the value of each key (iterating through position list)
                //.contains didn't work so i had to go with an inefficient implementation
                for(int i = 0; i < pair.getValue().size(); i++) {
                    if (pair.getValue().get(i).equals(pos)) {
                        return pair.getKey();
                    }
                }
            }

            //position is empty
            return ' ';
        }
        //position is outside of playable board
        else {
            return '~';
        }
    }

    /**
     * see IGameBoard.isPlayerAtPos()
     * [uses the fact that this implementation uses a map to restrict the positions being checked to only those which the player is at]
     */
    public boolean isPlayerAtPos(BoardPosition pos, char player){
        //check if pos is a position on the board
        if(pos.getRow() < this.BOARD_SIZE_ROWS && pos.getCol() < this.BOARD_SIZE_COLS){
            //check if player is at position (i.e. check if the position exists in the player's position list)
            //.contains didn't work so i had to go with an inefficient implementation
            for(int i = 0; i < this.board.get(player).size(); i++){
                if(this.board.get(player).get(i).equals(pos)){
                    return true;
                }
            }
        }
        return false;
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