package com.bus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class GetPassengerData {

	 public static void getPassengerData() throws FileNotFoundException, IOException, ClassNotFoundException {

	        File file = new File("passengerData.txt");
	        List<Passenger> passengerData = new ArrayList<>();

	        if (file.exists()) {
	            FileInputStream fileIn = new FileInputStream(file);
	            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
	            passengerData = (List<Passenger>) objectIn.readObject();
	            objectIn.close();
	            fileIn.close();

	            for (Passenger passenger : passengerData) {
	                System.out.println(passenger);
	            }
	        } else {
	            System.out.println("No passenger data found.");
	        }
	    }
	
}
