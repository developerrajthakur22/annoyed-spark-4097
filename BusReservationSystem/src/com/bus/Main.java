package com.bus;

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

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}	
}

public class Main {
    

	private static final String PASSENGER_DATA_FILE = "passengerData.txt";

    public static void passengerLogin() throws IOException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------------");
        System.out.println();
        System.out.println("Press 1 -> New user? create new account");
        System.out.println("Press 2 -> Already have an account");
        System.out.println("Press 0 -> Exit");
        int userPress = scanner.nextInt();

        if (userPress == 2) {
        	  System.out.println("----------------------------------");
              System.out.println();
            System.out.println("Please enter your email and password");
            System.out.print("Email: ");
            String email = scanner.next();
            scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.next();
            scanner.nextLine();

            CheckingLogin cl = new CheckingLogin(email,password);
            cl.getPassengerData();
            BusDetails bd = new BusDetails(cl.getName(),email);
            bd.destination();
            // TODO: authenticate user
        } else if (userPress == 1) {
        	  System.out.println("----------------------------------");
              System.out.println();
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
           
            
            BusDetails bd = new BusDetails(name,email);
            bd.destination();
        }
        else if(userPress == 0) {
        	main(null);
        }
        else {
        	  System.out.println("----------------------------------");
              System.out.println();
        	System.out.println("Please select either 0 or 1");
        	passengerLogin();
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

    public static void adminLogin() throws FileNotFoundException, ClassNotFoundException, IOException {
    	
    	System.out.println("            Welcome admin:");
    	Scanner sc =new Scanner(System.in);
    	
    	System.out.println("Enter username");
    	String name = sc.next();
    	sc.nextLine();
        System.out.println("Enter Password");
    	String password = sc.next();
    	
    	if(name.equals("admin") && password.equals("admin")) {
    		  System.out.println("----------------------------------");
    	        System.out.println();
    		System.out.println("logged in");
    		System.out.println("Press 1 -> Passenger info");
    		System.out.println("Press 2 -> Bus booking info");
    		System.out.println("Press 0 -> Exit");
    		int info = sc.nextInt();
    		
    		if(info==1) {
    			GetPassengerData pd = new GetPassengerData();
    			pd.getPassengerData();    
    	   }else if(info==2) {
    			BusDetails bd = new BusDetails("a","b");
    			bd.viewAllBookings();    			
    	   }else if(info==0) {
    		   main(null);
    	   }
    	}else {
    		System.out.println("Please Enter correct credentails");
    		adminLogin();
    	}
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        System.out.println("-----------Welcome to Ticket to ride-----------");
        System.out.println();
        System.out.println("        Hello user, Please Login first-");
        System.out.println();
        System.out.println("        Press 1 -> login as Passenger.");
        System.out.println("        Press 2 -> login as Admin.");
		
	    Scanner sc = new Scanner(System.in);
	    int userPress = sc.nextInt();
	    
	    if(userPress== 1) {
	        passengerLogin();	
	    }
	    else if(userPress==2) {
	    	adminLogin();
	    }
	}
}
