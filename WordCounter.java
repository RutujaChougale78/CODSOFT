package Game;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class WordCounter {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		    System.out.println("Word Counter Project");
		    System.out.println("1. Enter text manually");
		    System.out.println("2. Provide a file path");
		    System.out.print("Choose an option (1 or 2): ");

		    String userInput = scanner.nextLine();
		    String text = "";

		        if (userInput.equals("1")) {
		            System.out.print("Enter the text: ");
		            text = scanner.nextLine();
		        } else if (userInput.equals("2")) {
		            System.out.print("Enter the file path: ");
		            String filePath = scanner.nextLine();
		            try {
		                text = new String(Files.readAllBytes(Paths.get(filePath)));
		            } catch (IOException e) {
		                System.err.println("Error reading file. Please check the file path and try again.");
		                System.exit(1);
		            }
		        } else {
		            System.err.println("Invalid option. Exiting the program.");
		            System.exit(1);
		        }
		        String[] words = text.split("[\\s.,;!?]+");
		        int wordCount = 0;
		        List<String> stopWords = Arrays.asList("the", "and", "is", "in", "of", "to", "a", "for");
		        Map<String, Integer> wordFrequency = new HashMap<String, Integer>();
		        for (String word : words) {
		            if (!stopWords.contains(word.toLowerCase())) {
		                wordCount++;
		                wordFrequency.put(word.toLowerCase(), wordFrequency.getOrDefault(word.toLowerCase(), 0) + 1);
		            }
		        }
		        
		        System.out.println("Total words: " + wordCount);
		        
		        System.out.println("Word frequency:");
		        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
		            System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
		        }

		        scanner.close();
	}
}
