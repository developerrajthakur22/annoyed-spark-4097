package entityClasses;
import java.io.*;
import java.util.*;

public class AllPassengerData {
  
	public static void main(String[] args) {
	    try {
	        FileInputStream fileIn = new FileInputStream("passengerData.txt");
	        ObjectInputStream objectIn = new ObjectInputStream(fileIn);

	        List<Passenger> passengerData = (List<Passenger>) objectIn.readObject();
	        objectIn.close();
	        fileIn.close();

	        // Process the passenger data as needed
	        for (Passenger passenger : passengerData) {
	            System.out.println(passenger);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e1) {
	        e1.printStackTrace();
	    }
	}

}

	


