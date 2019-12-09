package cpsc2150.extendedTicTacToe;

public abstract class AbsGameBoard implements IGameBoard {
    /**
     * @return string representing the tic-tac-toe board and the markers on it
     * @post toString = string representing tic-tac-toe board
     */
    public String toString(){
        String bString = "   ";

        //append column numbers
        for(int col = 0; col < this.getNumColumns(); col++){
            if(col < 10){
                bString += " ";
            }
            bString += col + "|";
        }

        bString += "\n";

        //append rows
        for(int row = 0; row < this.getNumRows(); row++){
            //append row number
            if(row < 10){
                bString += " ";
            }
            bString += row + "|";

            //append each cell in row
            for(int col = 0; col < this.getNumColumns(); col++){
                BoardPosition pos = new BoardPosition(row,col);
                bString += this.whatsAtPos(pos) + " |";
            }

            bString += "\n";
        }

        return bString;
    }
}
