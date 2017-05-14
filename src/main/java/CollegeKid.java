import java.util.*;

public class CollegeKid {
	
	public static void main(String[] args){

		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("               CollegeKid                   ");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Enroll");
		System.out.println("How To Play");
		System.out.println("Command List");
		System.out.println("Dropout");
		System.out.println("");
		System.out.println("Made by H A M II™");
		System.out.println("");

		Scanner input = new Scanner(System.in);

		Processor p = new Processor();

		String command = " ";

		while (!(command.equals("dropout"))) {
			command = input.nextLine();

			String printout = p.processCommand(command);

			System.out.println(printout);
		}
	}
}