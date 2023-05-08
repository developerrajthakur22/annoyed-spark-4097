package com.bus;
import java.util.*;
import java.io.*;


public class BusDetails implements Serializable{

	private static final long serialVersionUID = 1L;
	static Scanner sc = new Scanner(System.in);
	private static String passengerName;
	private static String passengerEmail;
	
	public BusDetails(String passengerName, String passengerEmail) {
		this.passengerName = passengerName;
		this.passengerEmail = passengerEmail;
	}

	
	public static void destination() throws IOException, ClassNotFoundException {
		  System.out.println("----------------------------------");
	        System.out.println();
		System.out.println("Book Bus Tickets in India");
		System.out.println("From:");
		String from = sc.next();
		
		sc.nextLine();
		
		System.out.println("Where:");
		String where = sc.next();		
		 System.out.println("----------------------------------");
	        System.out.println();
		System.out.println(" ---Here is the list of all the buses from " + from + " to "+ where + "--- ");
		System.out.println();
		buses();
	}
	
	public static void buses() throws IOException, ClassNotFoundException {
		 
		System.out.println("Mr." +passengerName.toUpperCase() +" Select the Bus -");
		
		System.out.println("Press 1 - Intercity Travels ");
		System.out.println("Press 2 - Intercity Business Class");
		System.out.println("Press 3 - Citylink Travels ");
		System.out.println("Press 4 - Chartered Bus ");
		System.out.println("Press 5 - Hans Travels ");	
		System.out.println();
		System.out.println("Press 0 - Back");
		//System.out.println("Press 9 - Main menu");
		
		int bus = sc.nextInt();
		passengerBooked pb = null;
		if(bus==1) {
			 System.out.println("Intercity Travels - Timings and Seat Availability");
			 int seat = intercityt();
			 pb= new passengerBooked(passengerName,passengerEmail,"Intercity Travels",seat);
			 System.out.println("Thanks for booking!");
		}else if(bus==2){
			System.out.println("Intercity Business Class - Timings and Seat Availability");
			int seat = intercityt();
	    	pb = new passengerBooked(passengerName,passengerEmail,"Intercity Business Class",seat);
			System.out.println("Thanks for booking!");
		}else if(bus==3) {
			System.out.println("Citylink Travels - Timings and Seat Availability");
			int seat = intercityt();
			pb = new passengerBooked(passengerName,passengerEmail,"Citylink Travels",seat);
			System.out.println("Thanks for booking!");
		}else if(bus==4) {
			System.out.println("Chartered Bus - Timings and Seat Availability");
			int seat = intercityt();
			pb = new passengerBooked(passengerName,passengerEmail,"Chartered Bus",seat);
			System.out.println("Thanks for booking!");
		}else if(bus==5) {
			System.out.println("Hans Travels - Timings and Seat Availability");
			int seat = intercityt();
			pb = new passengerBooked(passengerName,passengerEmail,"Hans Travels",seat);
			System.out.println("Thanks for booking!");
		}else if(bus==0) {
			destination();
		}
		else {
			System.out.println("Please select between 1 to 5:");
			buses();
		}
		System.out.println(pb);
		saveBooking(pb);
		//viewAllBookings();
		System.out.println("Press 0 --> EXIT");
		
		int exit = sc.nextInt();
		while(exit!=0) {
			System.out.println("Please Press 0");
			exit = sc.nextInt();
		}
		if(exit==0) {
			destination();
		}
		sc.close();
	}
	
	//all bus timings and seat availablity
	static int intercityt() throws FileNotFoundException, ClassNotFoundException, IOException {
        System.out.println();
	    System.out.println("Date - " + new Date());
	    int number = 20;
	    String fileName = "number.txt";
	    boolean f = false;
	    int seat = 0;

	    File file = new File(fileName);
	    if (file.exists()) {
	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	            String line = reader.readLine();
	            number = Integer.parseInt(line);
	            System.out.println("Number of seats available: " + number);
	            System.out.print("Enter the number of seats you want to book: ");
	            seat = sc.nextInt();
	            if (seat > number) {
	                System.out.println("Sorry, only " + number + " seats are available.");
	                System.out.println(" ");
	                intercityt();
	            } else {
	                f = true;
	                number = number - seat;   
	            }
	        } catch (IOException e) {
	            System.err.println("Error reading from file: " + e.getMessage());
	        }
	    }else {
	        System.out.println("Number of seats available: " + number);
	        System.out.print("Enter the number of seats you want to book: ");
	        seat = sc.nextInt();
	        if (seat > number) {
	            System.out.println("Sorry, only " + number + " seats are available.");
	            intercityt();
	        } else {
	            f = true;
	            number = number - seat;
	        }
	    }  

	    if (f==true) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
	            writer.write(String.valueOf(number));
	            System.out.println();
	            System.out.println("Number of seats booked: " + seat);
	            System.out.println("Number of seats available now: " + number);
	        } catch (IOException e) {
	            System.err.println("Error writing to file: " + e.getMessage());
	        }
	    }
	  
	    return seat;
	}
	
	public static void saveBooking(passengerBooked pb) {
	    try {
	        ArrayList<passengerBooked> pList = new ArrayList<passengerBooked>();
	        File file = new File("passengers.txt");
	        if (file.exists() && file.length() > 0) {
	            FileInputStream fin = new FileInputStream(file);
	            ObjectInputStream oin = new ObjectInputStream(fin);
	            pList = (ArrayList<passengerBooked>) oin.readObject();
	            oin.close();
	            fin.close();
	        }
	        if (pList != null) {
	            pList.add(pb);
	        } else {
	            pList = new ArrayList<>();
	            pList.add(pb);
	        }
	        FileOutputStream fout = new FileOutputStream(file);
	        ObjectOutputStream oout = new ObjectOutputStream(fout);
	        oout.writeObject(pList);
	        oout.close();
	        fout.close();
	    } catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	}

	// View all passenger booking details
	public static void viewAllBookings() {
	    try {
	        ArrayList<passengerBooked> pList = new ArrayList<passengerBooked>();
	        File file = new File("passengers.txt");
	        if (!file.exists()) {
	            file.createNewFile();
	        }
	        FileInputStream fin = new FileInputStream(file);
	        ObjectInputStream oin = new ObjectInputStream(fin);
	        pList = (ArrayList<passengerBooked>) oin.readObject();
	        oin.close();
	        fin.close();
	        if (pList.size() == 0) {
	            System.out.println("No bookings made yet!");
	        } else {
	            System.out.println("All passenger bookings:");
	            for (passengerBooked pb : pList) {
	            	if (pb != null) {
	                    System.out.println(pb.toString());
	                }
	                //System.out.println(pb.toString());
	            }
	        }
	    } catch (Exception e) {
	    	e.printStackTrace();
	        System.out.println("Error occurred. Please try again later.");
	        System.exit(0);
	    }
	}
	//viewAllBookings();
}
