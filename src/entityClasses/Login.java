package entityClasses;
import java.util.*;

public class Login {

	public static void passenger() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter your UserName and Password");
		
		System.out.print("Username - ");
		String email = sc.next();
		sc.nextLine();	
		System.out.print("Password - ");
		String password = sc.next();
		
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("-----------Welcome to Ticket to ride-----------");
		System.out.println();
		System.out.println("        Hello user, Please Login first-");
		System.out.println();
		System.out.println("        Press 1 to login as Passenger.");
		System.out.println("        Press 2 to login as Admin.");
		
	    Scanner sc = new Scanner(System.in);
	    
	    if(sc.nextInt()== 1) {
	        passenger();	
	    }
		
	}
	
}
