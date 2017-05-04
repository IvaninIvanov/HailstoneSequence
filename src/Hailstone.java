import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Hailstone {

	public static void main(String[] args) {
		// initiate
		System.out.println("*** Hailstone Sequence Calculator ***");
		promptUser();
	}
	
	
	public static void promptUser() { 
		// get initial n from user
		Scanner scan = new Scanner(System.in);
		System.out.printf("Enter a positive natural number to initiate the Hailstone sequence: ");
		
		// store n
		int n = scan.nextInt();
		
		// request validation
		validateInput(n);
	}
	
	
	public static void validateInput(int seqStart) {
		// check if 1 : can't start with the end 
		if (seqStart == 1) {
			System.out.println("Error: 1 cannot be the start of the sequence!");
			anotherGo();
			
		}
		
		// check if non-positive : can't calculate sequence
		else if (seqStart <= 0) {
			System.out.println("Error: " + seqStart + " is not a positive natural number!");
			anotherGo();
		}
		
		// tests pass : proceed with generating the sequence
		else {
			sequenceGenerator(seqStart);
		}
	}


	public static void sequenceGenerator(int n) {
		// declare sequence output variable
		List<String> sequence = new ArrayList<String>();
				
		// step counter - additional functionality
		int steps = 0;
		
		// record start - additional functionality
		int start = n;
				
		// ** ALGORHITM **
		// check if reached the end (1)
		while (n != 1) {
			// even? : next n = n/2
			if (n % 2 == 0) {
				n = n/2;
				// add to final output
				sequence.add(Integer.toString(n));
				// count steps to 1
				steps++;
			}
			
			// odd? : next n = 3n+1
			else {
				n = (n * 3) + 1;
				// add to final output
				sequence.add(Integer.toString(n));
				// count steps to 1
				steps++;
			}
		}
		
		// ** OUTPUT **
		// show start
		System.out.println("Sequence initiated with: " + start);
		// show sequence
		System.out.println("Sequence: " + sequence);
		// reverse sequence - as requested in task specification
		Collections.reverse(sequence);
		System.out.println("Sequence (reversed): " + sequence); 
		// show steps
		System.out.println("Sequence complete in " + steps + " steps.");
		// loop over?
		anotherGo();
	}
	
	
	// simple loop mechanism with validation
	public static void anotherGo() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Try again?  1-YES   2-EXIT");
		int response = scan.nextInt();
		if (response == 1) {
			promptUser();
		}
		else if (response == 2) {
			System.exit(0);
		}
		else {
			System.out.println("Invalid input!");
			anotherGo();
		}

	}
}
