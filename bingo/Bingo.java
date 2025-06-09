package SmallProject.game;

// import java.util.Arrays;

// Actual logic
public class Bingo extends BingoBoard{

    public Bingo(int size){
        super(size);
    }

    protected boolean[] bingoLines = new boolean[12];
    

    public int strikeOut(int val){

        if(!boardValues.contains(val)){
            System.out.println("This Value Already striked give a valid value");
            return -1;
        }
        int[] pos = position.get(val);
        board[pos[0]][pos[1]]=0;
        boardValues.remove(val);
        position.remove(val);
        checkAndUpdate(pos[0],pos[1]);

        return getCompletedLines();
    }


     private void checkAndUpdate(int row, int col) {
        
        boolean completeRow = true;
        for (int j = 0; j < 5; j++) {
            if (board[row][j] != 0) {
                completeRow = false;
                break;
            }
        }
        if (completeRow) bingoLines[row] = true;

        
        boolean completeCol = true;
        for (int i = 0; i < 5; i++) {
            if (board[i][col] != 0) {
                completeCol = false;
                break;
            }
        }
        if (completeCol) bingoLines[5 + col] = true;

        
        if (row == col) {
            boolean diag1 = true;
            for (int i = 0; i < 5; i++) {
                if (board[i][i] != 0) {
                    diag1 = false;
                    break;
                }
            }
            if (diag1) bingoLines[10] = true;
        }

        
        if (row + col == 4) {
            boolean diag2 = true;
            for (int i = 0; i < 5; i++) {
                if (board[i][4 - i] != 0) {
                    diag2 = false;
                    break;
                }
            }
            if (diag2) bingoLines[11] = true;
        }
    }

    private int getCompletedLines() {
        int count = 0;
        for (boolean b : bingoLines)
            if (b) count++;
        return count;
    }

    public void bingoPrint(int count){
            if(count>0){
                System.out.print("B-");
            }
            if(count>1){
                System.out.print("I-");
            }
            if(count>2){
                System.out.print("N-");
            }
            if(count>3){
                System.out.print("G-");
            }
            if(count>4){
                System.out.print("O");
            }
            System.out.println();
    }




}
