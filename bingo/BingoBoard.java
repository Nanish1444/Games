package SmallProject.game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import SmallProject.Board;

public class BingoBoard extends Board {
    protected Set<Integer> boardValues = new HashSet<>();
    protected HashMap<Integer,int[]> position = new HashMap<>();
    private int boardSize;
    BingoBoard(int size){
        super(size);
        boardSize=size;
        valueGenerator();
    }


    private void valueGenerator(){
        Random ran = new Random();

        for(int i=0;i<boardSize;i++){
            int count=0;
            while(count!=boardSize){
                int val = ran.nextInt(boardSize*boardSize)+1;
                if(!boardValues.contains(val)){
                    board[i][count]=val;
                    position.put(val,new int[]{i,count});
                    boardValues.add(val);
                    count++;
                }
            }
        }
    }

    @Override
    public void displayBoard(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]>9){
                    System.out.print(" "+board[i][j]+" ");
                }
                else{
                    System.out.print("  "+board[i][j]+"  ");
                }
                
            }
            System.out.println();
        }
    }
}
