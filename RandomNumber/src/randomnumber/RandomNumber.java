/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package randomnumber;
import java.util.Random;
import java.util.Scanner;

public class RandomNumber {
    public static void startGame(){
      Scanner scan = new Scanner(System.in);
       Random ran = new Random(); //ran class object
       int score= 0; //score variable used to store user score
       int maxTries=5; //Max attempts
       
       System.out.println("Welome!! ");
        while (true) {
            int answer =ran.nextInt(100) + 1; //generating a random number > 0
            int Tries=0; //user attempts
            
            System.out.println("\nChoose the number between 1 and 100. You have 5 attempts to guess it.\n ");
            
            while(Tries < maxTries){
                System.out.println("Enter Your Guessed Number(Attempt" + (Tries + 1) + "/" + maxTries + "): ");
                int guess = scan.nextInt(); //user's guess
                
                if( guess == answer){
                 System.out.println("Congratulations!! you have guessed the Correct Number" + answer);
               score++;
               break;
            }else if(guess < answer){
                System.out.println("Oops the guessed number is too Low!! keep Trying");
            } else{
                 System.out.println("Oops the guessed number is too High!! keep Trying");
            }
                Tries++;
       }
    if(Tries == maxTries){
        System.out.println("Game Over! You have run out of attempts.");
        System.out.println("The Correct number was: "+answer);
    }
           System.out.println("Would you like to Play Again?(Yes/No): ");
           String playAgain = scan.next();
           
           if(!playAgain.equalsIgnoreCase("Yes")){
               break;
           }
       }
       System.out.println("Game Over. Your Score is:" +score);
       scan.close();
    }
    public static void main(String[] args){
        startGame();
    }
}