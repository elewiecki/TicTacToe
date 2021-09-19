public class TicTacToe2Game{

int numRound;
String[] board;
String player1Symbol;
String player2Symbol;
boolean player1Win;
boolean player2Win;
boolean isTie;
boolean player1Turn;
boolean player2Turn;


    public TicTacToe2Game(){
       numRound = 1;
       player1Symbol = "x";
       player2Symbol = "o";
       board = new String[9];
       player1Win = false;
       player2Win = false;
       isTie = false;
       player1Turn = true;
       player2Turn = false;
    }
    
    public void createGameBoard(){                        
       // set game spaces 1-6 to underscores, 7-9 (bottom row) to spaces
       for(int i = 0; i < board.length; ++i){
            if (i < 6) board[i] = "_";
            else board[i] = " ";
       }
    }

     public void printGameBoard(){
         String verticalDivider = "|";
         // Print updated game board   
         System.out.print(board[0]);
         System.out.print(verticalDivider);
         System.out.print(board[1]);
         System.out.print(verticalDivider);
         System.out.println(board[2]);
         System.out.print(board[3]);
         System.out.print(verticalDivider);
         System.out.print(board[4]);
         System.out.print(verticalDivider);
         System.out.println(board[5]);
         System.out.print(board[6]);
         System.out.print(verticalDivider);
         System.out.print(board[7]);
         System.out.print(verticalDivider);
         System.out.println(board[8]);
     }
     
     
     public void playGame(String playerInput){            
         int playerChoice = Integer.parseInt(playerInput);       
         //if odd round, it's player 1's turn. If even, it's player 2's.
         if(numRound % 2 != 0){      
            board[playerChoice - 1] = player1Symbol;
            player1Turn = true;
            player2Turn = false;  
            }     
         else{
            board[playerChoice - 1] = player2Symbol;
            player1Turn = false;
            player2Turn = true;           
            }              
         
         numRound += 1;      
     }
     
     public boolean isTie(){
         // if all spaces have been used and no one won, its a tie
         if(numRound > 9) isTie = true;
         return isTie;
     }
     
     public boolean player1Win(){
         //check if player 1 wins   
         if(board[0].equals("x") && board[1].equals("x") && board[2].equals("x")){
            player1Win = true;
         }
         else if(board[3].equals("x") && board[4].equals("x") && board[5].equals("x")){
            player1Win = true;
         }
         else if(board[6].equals("x") && board[7].equals("x") && board[8].equals("x")){
            player1Win = true;
         }
         else if(board[0].equals("x") && board[3].equals("x") && board[6].equals("x")){
            player1Win = true;
         }
         else if(board[1].equals("x") && board[4].equals("x") && board[7].equals("x")){
            player1Win = true;
         }       
         else if(board[2].equals("x") && board[5].equals("x") && board[8].equals("x")){
            player1Win = true;
         }  
         else if(board[0].equals("x") && board[4].equals("x") && board[8].equals("x")){
            player1Win = true;
         }   
         else if(board[2].equals("x") && board[4].equals("x") && board[6].equals("x")){
            player1Win = true;
         }  
         else return false; 
         return player1Win;       
     }
     
     public boolean player2Win(){
          // Check if player 2 wins            
         if(board[0].equals("o") && board[1].equals("o") && board[2].equals("o")){
            player2Win = true;
         }
         else if(board[3].equals("o") && board[4].equals("o") && board[5].equals("o")){
            player2Win = true;
         }
         else if(board[6].equals("o") && board[7].equals("o") && board[8].equals("o")){
            player2Win = true;
         }
         else if(board[0].equals("o") && board[3].equals("o") && board[6].equals("o")){
            player2Win = true;
         }
         else if(board[1].equals("o") && board[4].equals("o") && board[7].equals("o")){
            player2Win = true;
         }       
         else if(board[2].equals("o") && board[5].equals("o") && board[8].equals("o")){
            player2Win = true;
         }  
         else if(board[0].equals("o") && board[4].equals("o") && board[8].equals("o")){
            player2Win = true;
         }   
         else if(board[2].equals("o") && board[4].equals("o") && board[6].equals("o")){
            player2Win = true;
         }
         else return false;
         return player2Win;
     }
     

     public int getNumRound(){
         return numRound;
     }
     
     public boolean isValidInput(String playerInput){        
         //make sure the player's input is a number
         try {  
            Integer.parseInt(playerInput);
           } 
            catch(NumberFormatException error){  
               return false;  
            }     
              
         int playerChoice = Integer.parseInt(playerInput);
         // Check if the spot has already been used or if number is outside the board's range
         if (playerChoice < 1 || playerChoice > 9 || board[playerChoice - 1].equals("x") || board[playerChoice - 1].equals("o"))
             return false;
         else return true;        
     }






}