package SmallProject.game;

public class BingoBot extends Bingo {

    public BingoBot(int size){
        super(size);
    }

    public int computerMove(){
        int val = findWiningMove();
        if(val!=-1)return val;

        val = findMostUsefulMove();

        return val;
    }


    private int findWiningMove(){

        for(int i=0;i<board.length;i++){
            int count=0;
            int val=-1;
            for(int j=0;j<board[0].length;j++){
                
                if(board[i][j]==0){
                    count++;
                }
                else{
                    val=board[i][j];
                }
            }
            if(count==4 && val!=-1){
                return val;
            }
        }

        for(int i=0;i<board[0].length;i++){
            int count=0;
            int val=-1;
            for(int j=0;j<board.length;j++){
                
                if(board[j][i]==0){
                    count++;
                }
                else{
                    val=board[j][i];
                }
            }
            if(count==4 && val!=-1){
                return val;
            }
        }
        int dia1 = 0;
        int dia1Val = -1;
        int dia2 = 0;
        int dia2Val = -1;
        for(int i=0;i<board.length;i++){
            if(board[i][i]==0){
                dia1++;
            }
            else{
                dia1Val=board[i][i];
            }

            if(board[i][board.length-1-i]==0){
                dia2++;
            }
            else{
                dia2Val=board[i][board.length-1-i];
            }
        }

        if(dia1==4 && dia1Val!=-1)return dia1Val;


        if(dia2==4 && dia2Val!=-1)return dia2Val;

        return -1;
    }

    private int findMostUsefulMove(){
        int bestScore=-1;
        int bestNumber=-1;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){

                if(board[i][j]==0){
                    continue;
                }

                int score=0;

                for(int row=0;row<board.length;row++){
                    if(board[row][j]==0)score++;
                }

                for(int col=0;col<board[0].length;col++){
                    if(board[i][col]==0)score++;
                }

                if(i==j){
                    for(int dia=0;dia<board.length;dia++){
                        if(board[dia][dia]==0)score++;
                    }
                }

                if(i+j == board.length-1){
                    for(int dia=0;dia<board.length;dia++){
                        if(board[dia][board[0].length-1-dia]==0)score++;
                    }
                }

                if(score>bestScore){
                    bestScore=score;
                    bestNumber=board[i][j];
                }

            }
        }

        return bestNumber;
    }
    
}