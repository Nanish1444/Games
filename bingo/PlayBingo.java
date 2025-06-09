package SmallProject.game;

import java.util.Scanner;

public class PlayBingo {
    
    public static void main(String[] args) {
        int size=5;
        Bingo player = new Bingo(size);
        BingoBot computer = new BingoBot(size);
        
        player.displayBoard();
        Scanner scan = new Scanner(System.in);
        boolean start=true;
        while(start){
            System.out.print("INPUT :");
            int val = scan.nextInt();

            if(val==-1){// To stop the game in the mid use -1 as a User input
                break;
            }
            int count = player.strikeOut(val);
            player.bingoPrint(count);
            player.displayBoard();
            if(count==player.BOARD_SIZE){
                System.out.println("PLAYER WIN");
                break;
            }

            computer.strikeOut(val);

            val=computer.computerMove();

            int win = computer.strikeOut(val);

            System.out.println("Computer Turn ..."+val);
            if(win==computer.BOARD_SIZE){
                System.out.println("COMPUTER WIN");
                break;
            }
            count=player.strikeOut(val);
            player.displayBoard();
            player.bingoPrint(count);
            if(count==player.BOARD_SIZE){
                System.out.println("PLAYER WIN");
                break;
            }


        }
        
    }
}
