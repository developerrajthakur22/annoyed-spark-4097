package entityClasses;
import java.util.*;

public class BusDetails {

	static Scanner sc = new Scanner(System.in);
	
	public static void destination() {
		
		System.out.println("From:");
		String from = sc.next();
		
		sc.nextLine();
		
		System.out.println("Where:");
		String where = sc.next();		
		
		System.out.println(" ---Here is the list of all the buses from " + from + " to "+ where + "--- ");
		System.out.println();
		buses();
	}
	
	public static void buses() {
		
		System.out.println("Select the Bus -");
		
		System.out.println("Press 1 - Intercity Travels ");
		System.out.println("Press 2 - Intercity Business Class");
		System.out.println("Press 3 - Citylink Travels ");
		System.out.println("Press 4 - Chartered Bus ");
		System.out.println("Press 5 - Hans Travels ");	
		
		int bus = sc.nextInt();
		
		if(bus==1) {
			System.out.println("1");
		}else if(bus==2){
			System.out.println("2");
		}else if(bus==3) {
			System.out.println("3");
		}else if(bus==4) {
			System.out.println("4");
		}else if(bus==5) {
			System.out.println("5");
		}else {
			System.out.println("Please select between 1 to 5:");
			buses();
		}
	}
	
}
