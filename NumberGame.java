package Game;
import java.util.Random;
import java.util.Scanner;
public class NumberGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		System.out.println("Welcome to the Number Game!");

		    while (true) {
		    	int targetNumber = random.nextInt(100) + 1;
		        int attempts = 0;
		        int maxAttempts = 10;
		        	while (attempts < maxAttempts) {
		                
		                System.out.print("Enter your guess (1-100): ");
		                int userGuess = scanner.nextInt();
		                
		                if (userGuess == targetNumber) {
		                    System.out.println("Congratulations! You guessed the correct number " + targetNumber +
		                            " in " + (attempts + 1) + " attempts.");
		                    break;
		                } else if (userGuess < targetNumber) {
		                    System.out.println("Too low! Try again.");
		                } else {
		                    System.out.println("Too high! Try again.");
		                }

		                attempts++;
		            }
		        	if (attempts == maxAttempts) {
		            System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " +
		                    targetNumber + ".");
		            }
		        System.out.print("Do you want to play again? (yes/no): ");
		        String playAgain = scanner.next().toLowerCase();
		        if (!playAgain.equals("yes")) {
		            break;
		        }
		    }

		    System.out.println("Thanks for playing the Number Game!");
		    scanner.close();
	}

}
