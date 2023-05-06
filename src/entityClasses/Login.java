package entityClasses;

import java.util.*;
import java.io.*;

class Passenger implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String email;
    private String password;

    public Passenger(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Passenger [name=" + name + ", email=" + email + "]";
    }

    // getters and setters
}

public class Login{

    private static final String PASSENGER_DATA_FILE = "passengerData.txt";

    public static void passengerLogin() throws IOException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("New user? Press 1 to create new account");
        System.out.println("Already have an account? Press 0 to continue");

        int userPress = scanner.nextInt();

        if (userPress == 0) {

            System.out.println("Please enter your email and password");
            System.out.print("Email: ");
            String email = scanner.next();
            scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.next();
            scanner.nextLine();

            // TODO: authenticate user
        } else if (userPress == 1) {

            System.out.println("Enter your details");
            System.out.println("Name: ");
            String name = scanner.next();
            scanner.nextLine();
            System.out.println("Email: ");
            String email = scanner.next();
            scanner.nextLine();
            System.out.println("Password: ");
            String password = scanner.next();
            scanner.nextLine();

            Passenger passenger = new Passenger(name, email, password);

            List<Passenger> passengerData = readPassengerData();

            passengerData.add(passenger);

            writePassengerData(passengerData);

            System.out.println("Account Created :)");
            System.out.println("---------------------------------");
            System.out.println("Book Bus Tickets in India");
            
           // BusDetails bd = new BusDetails();
            //bd.destination();
              AllPassengerData apd = new AllPassengerData();
            apd.getPassengerData();
        }

        scanner.close();
    }

    private static List<Passenger> readPassengerData() throws IOException, ClassNotFoundException {
        List<Passenger> passengerData = new ArrayList<>();

        File file = new File(PASSENGER_DATA_FILE);
        if (file.exists()) {
            try (FileInputStream fileIn = new FileInputStream(file);
                    ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
                passengerData = (List<Passenger>) objectIn.readObject();
            }
        }

        return passengerData;
    }

    private static void writePassengerData(List<Passenger> passengerData) throws IOException {
        try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(PASSENGER_DATA_FILE))) {
            objectOut.writeObject(passengerData);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

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
