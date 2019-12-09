package cpsc2150.extendedTicTacToe;

import java.util.ArrayList;
import java.util.List;

/**
 * The TicTacToe controller class will handle communication between our TicTacToeView and our Model (IGameBoard and BoardPosition)
 *
 * This is where you will write code
 *
 * You will need to include your BoardPosition class, the IGameBoard interface
 * and the implementations from previous homeworks
 * If your code was correct you will not need to make any changes to your IGameBoard classes
 */
public class TicTacToeController{
    //constants
    private static final int MAX_PLAYERS = 10;
    private static final int MIN_PLAYERS = 2;

    //view
    private TicTacToeView screen;

    //models
    private List<Character> players = new ArrayList<>();
    private Character currentPlayer;
    private IGameBoard curGame;

    //etc
    private boolean gameOver; //keeps track of whether or not a win/draw condition has been met.


    /**
     *
     * @param model the board implementation
     * @param view the screen that is shown
     * @param np The number of players for the game
     * @post the controller will respond to actions on the view using the model.
     */
    TicTacToeController(IGameBoard model, TicTacToeView view, int np){
        this.curGame = model;
        this.screen = view;

        //player character representations
        Character[] playerReps = {'X', 'O', 'Z', 'E','V', 'L', 'H', 'U', 'P', 'T'};

        //set up players list
        for(int i = 0; i < np; i++){
            //build player list
            this.players.add(playerReps[i]);
        }

        //set current player
        this.currentPlayer = this.players.get(0);
        gameOver = false;
    }

    /**
     *
     * @param row the row of the activated button
     * @param col the column of the activated button
     * @pre row and col are in the bounds of the game represented by the view
     * @post The button pressed will show the right token and check if a player has won.
     */
    public void processButtonClick(int row, int col) {
        BoardPosition chosenPos = new BoardPosition(row, col);

        if(!gameOver) {
            if (this.curGame.checkSpace(chosenPos) == false) { //validate space availability
                screen.setMessage("Space is unavailable. Pick a new position.");
            } else { //space is available
                //place marker on board
                this.curGame.placeMarker(chosenPos, this.currentPlayer);
                screen.setMarker(row, col, this.currentPlayer);

                //check for win
                if (this.curGame.checkForWinner(chosenPos)) {
                    this.screen.setMessage("Player " + this.currentPlayer + " wins! Click on any button to start a new game.");
                    this.gameOver = true;
                } //check for draw
                else if (this.curGame.checkForDraw()) {
                    this.screen.setMessage("Draw! Click on any button to start a new game.");
                    this.gameOver = true;
                } else { //alternate player
                    if (this.currentPlayer == this.players.get(this.players.size() - 1)) {
                        this.currentPlayer = this.players.get(0);
                    } else {
                        this.currentPlayer = this.players.get(this.players.indexOf(currentPlayer) + 1);
                    }

                    //update message
                    screen.setMessage("It is "+ this.currentPlayer + "\'s turn. ");
                }

            }
        }
        else{
            this.gameOver = false; //reset gameOver condition
            this.newGame(); //reset game
        }

    }

    private void newGame()
    {
        screen.dispose();
        GameSetupScreen screen = new GameSetupScreen();
        GameSetupController controller = new GameSetupController(screen);
        screen.registerObserver(controller);
    }
}
