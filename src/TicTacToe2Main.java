import java.util.*;

public class TicTacToe2Main{

   public static void main(String[] args){
    
    //instructions
    System.out.println("Welcome to TicTacToe!");
    System.out.println("Decide who will be player 1 and player 2.");
    System.out.println("Player 1 will be x's and go first. Player 2 will be o's and go second.");
    System.out.println("Each spot on the board corresponds to a number:");
    System.out.println("\t The spot numbers increase left to right, such that");
    System.out.println("\t the top left is spot 1, and the bottom right is spot 9.");
    System.out.println("When prompted, enter the number of the spot where you would like to go,");
    System.out.println("and an x or o will be placed there.");
    System.out.println("First player to 3 in a row (including diagonals) wins.");
    System.out.println("");
    
    Scanner scan = new Scanner(System.in);
    TicTacToe2Game game = new TicTacToe2Game(); 
    
    //Initializes blank board
    game.createGameBoard();

    String player1Choice;
    String player2Choice;
    
    boolean keepGoing = true;
             
      //begin game loop          
      while (keepGoing){
            
         //prints updated version of the board
         game.printGameBoard();
         System.out.println("");
         
         //prompt user and get input, alternating player 1 and player 2         
         if(game.getNumRound() % 2 != 0){         
            System.out.println("Where would player 1 like to go? Enter a number 1 to 9, and an x will be placed there");
            player1Choice = scan.nextLine();
            //keep prompting until user input is valid   
            while(!game.isValidInput(player1Choice)){
                  System.out.println("Not a valid input or the space has been used. Try again");
                  player1Choice = scan.nextLine();           
            }                   
            game.playGame(player1Choice);
         }
         else{
            System.out.println("Where would player 2 like to go? Enter a number 1 to 9, and an o will be placed there");
            player2Choice = scan.nextLine(); 
            while(!game.isValidInput(player2Choice)){
                  System.out.println("Not a valid input or the space has been used. Try again");
                  player2Choice = scan.nextLine();           
            }         
            game.playGame(player2Choice);
         }//end of round
         
         System.out.println("");
                
         //check for wins or tie
         if(game.player1Win()){
            game.printGameBoard();
            System.out.println("\nPlayer 1 wins! Congrats!");
            keepGoing = false;
         }
         else if(game.player2Win()){
            game.printGameBoard();
            System.out.println("\nPlayer 2 wins! Congrats!");
            keepGoing = false;
         }
         else if(game.isTie()){
            game.printGameBoard();
            System.out.println("\nIt's a Tie!");
            keepGoing = false;
         }
         else{
            keepGoing = true;
         }//end of win conditions        
       }//end of loop
    }//end of main
}//end of class