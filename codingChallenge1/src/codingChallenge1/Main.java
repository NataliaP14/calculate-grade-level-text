package codingChallenge1;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		//scanner
		Scanner input = new Scanner(System.in);
		//variables
		int indexCalculation;
		String text;
		
		do {
		System.out.println("Please enter a text to determine the reading level or type S to end the program ");
		 text = input.nextLine();
		
		 //type S to exit program
		if (text.equalsIgnoreCase("S")) {
			break;
		}
		
		//variables
		double numLetters = 0;
		double numWords = 0;
		double numSentences = 0;

		List<String> symbols = List.of(" ", "!", ".", "'","?",";", "(", ")", ",", ":", "#", "[", "]", "{", "}", 
				"&", "-","''", "...", "$,","%", "*", "^", "@");
		List<String> honorifics = List.of("Mr.", "Mrs.", "Ms.", "Dr.","Prof.","Rev.", "Hon.", "Capt.", "Sgt.", "Col.",
				"Gen.", "Gov.", "Pres.", "Rep.","Sen.");
		List<String> endSentences = List.of(".", "?","!", ";", "...");
		
		for (int i = 0; i < text.length(); i++) {
			//count the number of letters
			if(!symbols.contains(String.valueOf(text.charAt(i)))) {
				numLetters++;
			}
			//counts the number of words
			if (text.trim().isEmpty()) {
				numWords = 0;
			} else {
				numWords = text.trim().split("\\s+").length;
			}
			//counts the number of sentences
			if (!honorifics.contains(String.valueOf(text.charAt(i))) && endSentences.contains(String.valueOf(text.charAt(i)))) {
				numSentences++;
			}
		}
			//calculations
			double L = numLetters / numWords * 100;
			double S = numSentences / numWords * 100;
			indexCalculation = (int) (0.0588 * L - 0.296 * S - 15.8);
			
			//determining grade levels
			if (indexCalculation <= 0) {
				System.out.println("The grade level of this text is less than or equal to 0, please try again \n");
			}
			else if (indexCalculation > 12) {
				System.out.println("This text is Grade: 12");
			} else {
			System.out.println("This text is Grade: " + indexCalculation);
			}
		} while (true);
			
			input.close();
	}
	
}

/** OUTPUT
Please enter a text to determine the reading level or type S to end the program 
1.
The grade level of this text is less than or equal to 0, please try again 

Please enter a text to determine the reading level or type S to end the program 
The Industrial Revolution, which began in Britain in the late 18th century, was a significant turning point in history. 
It marked the transition from agrarian and handicraft economies to industrialized ones, characterized by the rise of factories,
 machines, and mass production.
This text is Grade: 12
Please enter a text to determine the reading level or type S to end the program 
Congratulations! Today is your day. You're off to Great Places! You're off and away!
This text is Grade: 3
Please enter a text to determine the reading level or type S to end the program 
s

 */

