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
		
		pusher.assignRepo();
		pusher.commitAndPush();
	}
}
