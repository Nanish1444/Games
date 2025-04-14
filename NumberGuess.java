import java.util.*;

public class NumberGuess{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random ran = new Random();
        int guessNumber=ran.nextInt(1, 100);
        
        System.out.println(
        "Welcome to the Number Guessing Game!"+
        "\nI'm thinking of a number between 1 and 100."+
        "\nYou have 5 chances to guess the correct number.");

        
        boolean quit=false;
        while(!quit){ 

            intro();

            System.out.println("Enter your choice: ");
            int level=scan.nextInt();
            int chance=level==1?10:level==2?5:level==3?3:0;
            String levelInString = level==1?"Easy":level==2?"Medium":level==3?"Hard":"";
            
            levelSelect(levelInString);

            int run=1;
            while(run<=chance){
                System.out.println("\nEnter your guess: ");
                
                int userGuess=scan.nextInt();
                if(userGuess<guessNumber){
                    System.out.printf("Incorrect! The number is Greater than %d .",userGuess);
                }
                else if(userGuess>guessNumber){
                    System.out.printf("Incorrect! The number is Less than %d .",userGuess);
                }
                else{
                    System.out.printf("Congratulations! You guessed the correct number in %d attempts.\n",run);
                    break;
                }
                run++;
            }
            if(run==chance+1){
                System.out.println("\nYou not guess the correct number you finished your chance try Again.....");
            }
            
            System.out.println("If you want to play again this game \n if yes press 1 or if no press 2");
            int in=scan.nextInt();
            if(in==2){
                quit=true;
            }

        }
        
        
    }
    public static void intro(){
        System.out.println(
        "\nPlease select the difficulty level:"+
        "\n1. Easy (10 chances)"+
        "\n2. Medium (5 chances)"+
        "\n3. Hard (3 chances)");
    }

    public static void levelSelect(String levelInString){
        System.out.println("Great! You have selected the "+levelInString+
        " difficulty level."+
        "\nLet's start the game!");
    }
}
