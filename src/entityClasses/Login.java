package entityClasses;
import java.util.*;
import java.io.*;

class Passenger implements Serializable{
	
	String name;
	String email;
	String pass;
	
	public Passenger(String name, String email, String pass) {
		this.name = name;
		this.email = email;
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Passenger [name=" + name + ", email=" + email + ", pass=" + pass + "]";
	}
	
}

public class Login {

	public static void passengerLogin() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("New user? Press 1 to create new account");
		System.out.println();
		System.out.println("Already have an account? Press 0 to continue");
		
		int userPress = sc.nextInt();
		
		if(userPress==0) {
			
		   System.out.println("Please enter your UserName and Password");		
		   System.out.print("Username - ");
		   String email = sc.next();
		   sc.nextLine();	
		   System.out.print("Password - ");
		   String password = sc.next();
		 }
		else if(userPress == 1) {
		    
			System.out.println("Enter your details");
			System.out.println();
			System.out.println("Enter your Name");
			String name = sc.next();
			sc.nextLine();
			System.out.println("Enter your Email");
			String email = sc.next();
			sc.nextLine();
			System.out.println("Set Password");
			String pass = sc.next();
			sc.nextLine();
			
			Passenger p = new Passenger(name,email,pass);
			
			File file = new File("passengerData.txt");
			List<Passenger> passengerData = new ArrayList<>();
			
			if (file.exists()) {
		        FileInputStream fileIn = new FileInputStream(file);
		        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
		        passengerData = (List<Passenger>) objectIn.readObject();
		        objectIn.close();
		        fileIn.close();
		    }

		    passengerData.add(p);

		    ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(file));
		    objectOut.writeObject(passengerData);
		    objectOut.close();
			}
			
			
			//System.out.println(p);
			System.out.println("Account Created :)");
			System.out.println("---------------------------------");	
		
		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		System.out.println("-----------Welcome to Ticket to ride-----------");
		System.out.println();
		System.out.println("        Hello user, Please Login first-");
		System.out.println();
		System.out.println("        Press 1 to login as Passenger.");
		System.out.println("        Press 2 to login as Admin.");
		
	    Scanner sc = new Scanner(System.in);
	    
	    if(sc.nextInt()== 1) {
	        passengerLogin();	
	    }
		
	}
	
}
