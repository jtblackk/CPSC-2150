package cpsc2150.extendedTicTacToe;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestGameBoard {

    /**
     * constructor tests
     */
    @Test
    public void test_GameBoard_min_size(){
        //expected
        char[][] expected = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
        };

        //input

        //operation
        IGameBoard gb = callConstructor(IGameBoard.MIN_ROWS, IGameBoard.MIN_COLS, IGameBoard.MIN_WIN_REQ);

        //output
        assertTrue(gb.toString().equals(expectedToString(expected)));

    }

    @Test
    public void test_GameBoard_max_size(){
        //expected
        char[][] expected = new char[IGameBoard.MAX_ROWS][IGameBoard.MAX_COLS];

        for(int i = 0; i < IGameBoard.MAX_ROWS; i++){
            for(int j = 0; j < IGameBoard.MAX_COLS; j++){
                expected[i][j] = ' ';
            }
        }

        //input

        //operation
        IGameBoard gb = callConstructor(IGameBoard.MAX_ROWS, IGameBoard.MAX_COLS, IGameBoard.MAX_WIN_REQ);

        //output
        assertTrue(gb.toString().equals(expectedToString(expected)));

    }

    @Test
    public void test_GameBoard_different_rows_cols(){
        //expected
        char[][] expected = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        };

        //input

        //operation
        IGameBoard gb = callConstructor(5, 7, IGameBoard.MIN_WIN_REQ);

        //output
        assertTrue(gb.toString().equals(expectedToString(expected)));

    }

    /**
     * checkSpace tests
     */
    @Test
    public void test_checkSpace_occupied(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, IGameBoard.MIN_WIN_REQ);
        BoardPosition pBoard = new BoardPosition(1, 1);
        gb.placeMarker(pBoard,'X');

        //operation
        BoardPosition pCheck = pBoard;
        boolean result = gb.checkSpace(pCheck);

        //output
        assertTrue(result == false);

    }

    @Test
    public void test_checkSpace_unoccupied(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, IGameBoard.MIN_WIN_REQ);

        //operation
        BoardPosition pCheck = new BoardPosition(1, 1);
        boolean result = gb.checkSpace(pCheck);

        //output
        assertTrue(result == true);

    }

    @Test
    public void test_checkSpace_out_of_bounds(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, IGameBoard.MIN_WIN_REQ);

        //operation
        BoardPosition pCheck = new BoardPosition(5, 1);
        boolean result = gb.checkSpace(pCheck);

        //output
        assertTrue(result == false);

    }

    /**
     * checkHorizontalWin tests
     */
    @Test
    public void test_checkHorizontalWin_win_start_left(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);
        for(int i = 0; i < 3; i++){
            BoardPosition pBoard = new BoardPosition(2, 1 + i);
            gb.placeMarker(pBoard, 'X');
        }

        //operation
        BoardPosition pCheck = new BoardPosition(2, 1);
        boolean result = gb.checkHorizontalWin(pCheck, 'X');

        //output
        assertTrue(result == true);
    }

    @Test
    public void test_checkHorizontalWin_win_start_right(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);
        for(int i = 0; i < 3; i++){
            BoardPosition pBoard = new BoardPosition(2, 1 + i);
            gb.placeMarker(pBoard, 'X');
        }

        //operation
        BoardPosition pCheck = new BoardPosition(2, 3);
        boolean result = gb.checkHorizontalWin(pCheck, 'X');

        //output
        assertTrue(result == true);
    }

    @Test
    public void test_checkHorizontalWin_win_start_middle(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);
        for(int i = 0; i < 3; i++){
            BoardPosition pBoard = new BoardPosition(2, 1 + i);
            gb.placeMarker(pBoard, 'X');
        }

        //operation
        BoardPosition pCheck = new BoardPosition(2, 2);
        boolean result = gb.checkHorizontalWin(pCheck, 'X');

        //output
        assertTrue(result == true);
    }

    @Test
    public void test_checkHorizontalWin_no_win_interrupt() {
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);
        for (int i = 0; i < 3; i++) {
            BoardPosition pBoard = new BoardPosition(2, 1 + i);
            if (i == 0 || i == 2) {
                gb.placeMarker(pBoard, 'X');
            } else {
                gb.placeMarker(pBoard, 'Y');
            }
        }
    }


    /**
     * checkVerticalWin tests
     */
    @Test
    public void test_checkVerticalWin_win_start_top(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);
        for(int i = 0; i < 3; i++){
            BoardPosition pBoard = new BoardPosition(1 + i, 2 );
            gb.placeMarker(pBoard, 'X');
        }

        //operation
        BoardPosition pCheck = new BoardPosition(1, 2);
        boolean result = gb.checkVerticalWin(pCheck, 'X');

        //output
        assertTrue(result == true);
    }

    @Test
    public void test_checkVerticalWin_win_start_bottom(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);
        for(int i = 0; i < 3; i++){
            BoardPosition pBoard = new BoardPosition(1 + i, 2 );
            gb.placeMarker(pBoard, 'X');
        }

        //operation
        BoardPosition pCheck = new BoardPosition(3, 2);
        boolean result = gb.checkVerticalWin(pCheck, 'X');

        //output
        assertTrue(result == true);
    }

    @Test
    public void test_checkVerticalWin_win_start_middle(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);
        for(int i = 0; i < 3; i++){
            BoardPosition pBoard = new BoardPosition(1 + i, 2 );
            gb.placeMarker(pBoard, 'X');
        }

        //operation
        BoardPosition pCheck = new BoardPosition(2, 2);
        boolean result = gb.checkVerticalWin(pCheck, 'X');

        //output
        assertTrue(result == true);
    }

    @Test
    public void test_checkVerticalWin_no_win_interrupt(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);
        for(int i = 0; i < 3; i++){
            BoardPosition pBoard = new BoardPosition(1 + i, 2 );
            if(i == 0 || i == 2) {
                gb.placeMarker(pBoard, 'X');
            } else{
                gb.placeMarker(pBoard, 'Y');
            }
        }

        //operation
        BoardPosition pCheck = new BoardPosition(1, 2);
        boolean result = gb.checkVerticalWin(pCheck, 'X');

        //output
        assertTrue(result == false);
    }

    /**
     * checkDiagonalWin tests
     */
    @Test
    public void test_checkDiagonalWin_win_start_lower_left(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);
        for(int i = 0; i < 3; i++){
            BoardPosition pBoard = new BoardPosition(3 - i, 1 + i );
            gb.placeMarker(pBoard, 'X');
        }

        //operation
        BoardPosition pCheck = new BoardPosition(3, 1);
        boolean result = gb.checkDiagonalWin(pCheck, 'X');

        //output
        assertTrue(result == true);
    }

    @Test
    public void test_checkDiagonalWin_win_start_upper_right(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);
        for(int i = 0; i < 3; i++){
            BoardPosition pBoard = new BoardPosition(3 - i, 1 + i );
            gb.placeMarker(pBoard, 'X');
        }

        //operation
        BoardPosition pCheck = new BoardPosition(1, 3);
        boolean result = gb.checkDiagonalWin(pCheck, 'X');

        //output
        assertTrue(result == true);
    }

    @Test
    public void test_checkDiagonalWin_win_diag1_start_middle(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);
        for(int i = 0; i < 3; i++){
            BoardPosition pBoard = new BoardPosition(3 - i, 1 + i );
            gb.placeMarker(pBoard, 'X');
        }

        //operation
        BoardPosition pCheck = new BoardPosition(2, 2);
        boolean result = gb.checkDiagonalWin(pCheck, 'X');

        //output
        assertTrue(result == true);
    }

    @Test
    public void test_checkDiagonalWin_win_start_upper_left(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);
        for(int i = 0; i < 3; i++){
            BoardPosition pBoard = new BoardPosition(1 + i, 1 + i );
            gb.placeMarker(pBoard, 'X');
        }

        //operation
        BoardPosition pCheck = new BoardPosition(1, 1);
        boolean result = gb.checkDiagonalWin(pCheck, 'X');

        //output
        assertTrue(result == true);
    }

    @Test
    public void test_checkDiagonalWin_win_start_lower_right(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);
        for(int i = 0; i < 3; i++){
            BoardPosition pBoard = new BoardPosition(1 + i, 1 + i );
            gb.placeMarker(pBoard, 'X');
        }

        //operation
        BoardPosition pCheck = new BoardPosition(3, 3);
        boolean result = gb.checkDiagonalWin(pCheck, 'X');

        //output
        assertTrue(result == true);
    }

    @Test
    public void test_checkDiagonalWin_win_diag2_start_middle(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);
        for(int i = 0; i < 3; i++){
            BoardPosition pBoard = new BoardPosition(1 + i, 1 + i );
            gb.placeMarker(pBoard, 'X');
        }

        //operation
        BoardPosition pCheck = new BoardPosition(2, 2);
        boolean result = gb.checkDiagonalWin(pCheck, 'X');

        //output
        assertTrue(result == true);
    }

    @Test
    public void test_checkDiagonalWin_no_win_interrupt(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);
        for(int i = 0; i < 3; i++){
            BoardPosition pBoard = new BoardPosition(1 + i, 1 + i );
            if(i == 0 || i == 2) {
                gb.placeMarker(pBoard, 'X');
            } else{
                gb.placeMarker(pBoard, 'Y');
            }
        }

        //operation
        BoardPosition pCheck = new BoardPosition(1, 1);
        boolean result = gb.checkDiagonalWin(pCheck, 'X');

        //output
        assertTrue(result == false);
    }


    /**
     * checkForDraw Tests
     */
    @Test
    public void test_checkForDraw_no_draw_NxN() {
        //expected
            //N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                BoardPosition pBoard = new BoardPosition(i, j);
                if(!(i == 4 && j == 4)) {
                    gb.placeMarker(pBoard, 'X');
                }
            }
        }

        //operation
        boolean result = gb.checkForDraw();

        //output
        assertTrue(result == false);
    }

    @Test
    public void test_checkForDraw_draw_NxN() {
        //expected
             //N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                BoardPosition pBoard = new BoardPosition(i, j);
                gb.placeMarker(pBoard, 'X');
            }
        }

        //operation
        boolean result = gb.checkForDraw();

        //output
        assertTrue(result == true);
    }

    @Test
    public void test_checkForDraw_no_draw_NxM() {
        //expected
            //N/A

        //input
        IGameBoard gb = callConstructor(5, 6, 3);
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 6; j++){
                BoardPosition pBoard = new BoardPosition(i, j);
                if(!(i == 4 && j == 5)) {
                    gb.placeMarker(pBoard, 'X');
                }
            }
        }

        //operation
        boolean result = gb.checkForDraw();

        //output
        assertTrue(result == false);
    }

    @Test
    public void test_checkForDraw_draw_NxM() {
        //expected
            //N/A

        //input
        IGameBoard gb = callConstructor(5, 6, 3);
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 6; j++){
                BoardPosition pBoard = new BoardPosition(i, j);
                gb.placeMarker(pBoard, 'X');
            }
        }

        //operation
        boolean result = gb.checkForDraw();

        //output
        assertTrue(result == true);
    }


    /**
     * whatsAtPos tests
     */
    @Test
    public void test_whatsAtPos_x_on_board(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);
        BoardPosition pBoard = new BoardPosition(2, 2);
        gb.placeMarker(pBoard, 'X');

        //operation
        BoardPosition pCheck = new BoardPosition(2, 2);
        char result = gb.whatsAtPos(pCheck);

        //output
        assertTrue(result == 'X');

    }

    @Test
    public void test_whatsAtPos_tilde_off_board_right(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);

        //operation
        BoardPosition pCheck = new BoardPosition(0, 5);
        char result = gb.whatsAtPos(pCheck);

        //output
        assertTrue(result == '~');

    }

    @Test
    public void test_whatsAtPos_tilde_off_board_left(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);

        //operation
        BoardPosition pCheck = new BoardPosition(0, -1);
        char result = gb.whatsAtPos(pCheck);

        //output
        assertTrue(result == '~');

    }

    @Test
    public void test_whatsAtPos_tilde_off_board_bottom(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);

        //operation
        BoardPosition pCheck = new BoardPosition(5, 0);
        char result = gb.whatsAtPos(pCheck);

        //output
        assertTrue(result == '~');

    }

    @Test
    public void test_whatsAtPos_tilde_off_board_top(){
        //expected
             // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);

        //operation
        BoardPosition pCheck = new BoardPosition(-1, 0);
        char result = gb.whatsAtPos(pCheck);

        //output
        assertTrue(result == '~');

    }


    /**
     * isPlayerAtPos tests
     */
    @Test
    public void test_isPlayerAtPos_yes(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);
        BoardPosition pBoard = new BoardPosition(2, 2);
        gb.placeMarker(pBoard, 'X');

        //operation
        BoardPosition pCheck = new BoardPosition(2, 2);
        boolean result = gb.isPlayerAtPos(pCheck, 'X');

        //output
        assertTrue(result == true);
    }

    @Test
    public void test_isPlayerAtPos_no_different_player(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);
        BoardPosition pBoard = new BoardPosition(2, 2);
        gb.placeMarker(pBoard, 'Y');

        //operation
        BoardPosition pCheck = new BoardPosition(2, 2);
        boolean result = gb.isPlayerAtPos(pCheck, 'X');

        //output
        assertTrue(result == false);
    }

    @Test
    public void test_isPlayerAtPos_no_empty(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);

        //operation
        BoardPosition pCheck = new BoardPosition(2, 2);
        boolean result = gb.isPlayerAtPos(pCheck, 'X');

        //output
        assertTrue(result == false);
    }

    @Test
    public void test_isPlayerAtPos_no_invalid_column(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);

        //operation
        BoardPosition pCheck = new BoardPosition(2, 5);
        boolean result = gb.isPlayerAtPos(pCheck, 'X');

        //output
        assertTrue(result == false);
    }

    @Test
    public void test_isPlayerAtPos_no_invalid_row(){
        //expected
            // N/A

        //input
        IGameBoard gb = callConstructor(5, 5, 3);

        //operation
        BoardPosition pCheck = new BoardPosition(5, 2);
        boolean result = gb.isPlayerAtPos(pCheck, 'X');

        //output
        assertTrue(result == false);
    }

    @Test
    public void test_placeMarker_x_valid_position(){
        //expected
        char[][] expected = {
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '}
        };

        //input
        IGameBoard gb = callConstructor(5, 5, 3);

        //operation
        BoardPosition pPlace = new BoardPosition(2, 2);
        gb.placeMarker(pPlace, 'X');

        //output
        assertTrue(gb.toString().equals(expectedToString(expected)));
    }

    @Test
    public void test_placeMarker_x_occupied_different(){
        //expected
        char[][] expected = {
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', 'Y', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '}
        };

        //input
        IGameBoard gb = callConstructor(5, 5, 3);
        BoardPosition pBoard = new BoardPosition(2, 2);
        gb.placeMarker(pBoard, 'Y');

        //operation
        BoardPosition pPlace = new BoardPosition(2, 2);
        gb.placeMarker(pPlace, 'X');

        //output
        assertTrue(gb.toString().equals(expectedToString(expected)));
    }

    @Test
    public void test_placeMarker_x_occupied_same(){
        //expected
        char[][] expected = {
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '}
        };

        //input
        IGameBoard gb = callConstructor(5, 5, 3);
        BoardPosition pBoard = new BoardPosition(2, 2);
        gb.placeMarker(pBoard, 'X');

        //operation
        BoardPosition pPlace = new BoardPosition(2, 2);
        gb.placeMarker(pPlace, 'X');

        //output
        assertTrue(gb.toString().equals(expectedToString(expected)));
    }

    @Test
    public void test_placeMarker_x_out_of_bounds_col(){
        //expected
        char[][] expected = {
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '}
        };

        //input
        IGameBoard gb = callConstructor(5, 5, 3);

        //operation
        BoardPosition pPlace = new BoardPosition(0, 5);
        gb.placeMarker(pPlace, 'X');

        //output
        assertTrue(gb.toString().equals(expectedToString(expected)));
    }

    @Test
    public void test_placeMarker_x_out_of_bounds_row(){
        //expected
        char[][] expected = {
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '}
        };

        //input
        IGameBoard gb = callConstructor(5, 5, 3);

        //operation
        BoardPosition pPlace = new BoardPosition(5, 0);
        gb.placeMarker(pPlace, 'X');

        //output
        assertTrue(gb.toString().equals(expectedToString(expected)));
    }






    //-------------------Helper Methods-------------------//
    //calls the constructor for the game board
    private IGameBoard callConstructor(int r, int c, int w){
        IGameBoard gameBoard = new GameBoard(r, c, w);
        return gameBoard;
    }

    //takes in an array of characters and returns the GameBoard.toString version of it
    private String expectedToString(char[][] exp){
        String bString = "   ";

        //append column numbers
        for(int col = 0; col < exp[0].length; col++){
            if(col < 10){
                bString += " ";
            }
            bString += col + "|";
        }

        bString += "\n";

        //append rows
        for(int row = 0; row < exp.length; row++){
            //append row number
            if(row < 10){
                bString += " ";
            }
            bString += row + "|";

            //append each cell in row
            for(int col = 0; col < exp[0].length; col++){
                BoardPosition pos = new BoardPosition(row,col);
                bString += exp[row][col] + " |";
            }

            bString += "\n";
        }

        return bString;
    }
}
