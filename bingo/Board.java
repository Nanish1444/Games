package SmallProject.game;
public abstract class Board{
    
    public final int BOARD_SIZE;
    protected int[][] board;

    protected Board(int n){
        BOARD_SIZE=n;
        board=new int[n][n];
    }

    public abstract void displayBoard();

}