package cpsc2150.extendedTicTacToe;

/**
 * Created by kplis on 4/5/2018.
 */
public class GameSetupController {
    private GameSetupScreen view;
    private final int MEM_CUTOFF = 64;


    public GameSetupController(GameSetupScreen v)
    {
        view = v;
    }

    public void processButtonClick(int rows, int cols, int players, int numWin )
    {
        String errorMsg = "";

        if(rows < IGameBoard.MIN_ROWS || rows > IGameBoard.MAX_ROWS)
        {
            errorMsg += "Rows must be between " +  IGameBoard.MIN_ROWS + " and " + IGameBoard.MAX_ROWS ;
        }

        if(cols < IGameBoard.MIN_COLS || cols > IGameBoard.MAX_COLS)
        {
            errorMsg += "Columns must be between " +  IGameBoard.MIN_COLS + " and " + IGameBoard.MAX_COLS;
        }

        if(numWin < IGameBoard.MIN_WIN_REQ || numWin > IGameBoard.MAX_WIN_REQ)
        {
            errorMsg += "Number to win must be between " + IGameBoard.MIN_WIN_REQ + " and " + IGameBoard.MAX_WIN_REQ;
        }

        if (numWin > rows)
        {
            errorMsg += "Can't have more to win than the number of rows";
        }
        if (numWin > cols)
         {
            errorMsg += "Can't have more to win than the number of Columns";
         }


        if(!errorMsg.equals(""))
        {
            view.displayError(errorMsg);

        }
        else
        {
            view.closeScreen();
            IGameBoard model;
            if(rows * cols <= MEM_CUTOFF) {
                model = new GameBoard(rows, cols, numWin);
            }
            else
            {
                model = new GameBoardMem(rows, cols, numWin);
            }
            TicTacToeView tview = new TicTacToeView(rows, cols);
            TicTacToeController tcontroller = new TicTacToeController(model, tview, players);

            tview.registerObserver(tcontroller);
        }
    }
}
