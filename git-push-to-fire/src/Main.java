/**
 * 
 * @author poisonphang
 * 
 * Driver class
 */
import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		Pusher pusher = new Pusher();
		AddToList addToList = new AddToList();
		Scanner input = new Scanner(System.in);
		
		boolean isRunning = true;
		String userInput = "";
		
		System.out.println("'add' to add git repo to managed list");
		System.out.println("	add (next line) C:\\%path-to-project%");
		System.out.println("'view' to look at currnetly managed directories");
		System.out.println("'trigger' to trigger example run of the program");
		System.out.println("'help' show commands");
		System.out.println("'exit' to exit program");
		
		while (isRunning) {
			
			userInput = input.nextLine();
			
			if (userInput.equalsIgnoreCase("exit")) {
				isRunning = false;
				
			} else if (userInput.equalsIgnoreCase("add")) {
				userInput = input.nextLine();
				addToList.addItem(userInput);
				addToList.saveToFile();
			} else if (userInput.equalsIgnoreCase("view")) {
				System.out.println(addToList.getList());
			} else if (userInput.equalsIgnoreCase("trigger")) {
				pusher.assignRepo();
				pusher.commitAndPush();
			} else if(userInput.equalsIgnoreCase("help")) {
				System.out.println("'add' to add git repo to managed list");
				System.out.println("	add (next line) C:\\%path-to-project%");
				System.out.println("'view' to look at currently managed directories");
				System.out.println("'trigger' to trigger example run of the program");
				System.out.println("'help' show commands");
				System.out.println("'exit' to exit program");
			} else {
				System.out.println("Enter a valid command.");
			}
		}
		
	}
}
