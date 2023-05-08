package com.bus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class busBookingDetails {

		 public static void getBookingData() throws FileNotFoundException, IOException, ClassNotFoundException {

		        File file = new File("bookingDetails.txt");
		        List<passengerBooked> passengerData = new ArrayList<>();

		        if (file.exists()) {
		            FileInputStream fileIn = new FileInputStream(file);
		            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
		            passengerData = (List<passengerBooked>) objectIn.readObject();
		            objectIn.close();
		            fileIn.close();

		            for (passengerBooked passenger : passengerData) {
		                System.out.println(passenger);
		            }
		        } else {
		            System.out.println("No passenger data found.");
		        }
		    }
		
	}

