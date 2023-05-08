package com.bus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class CheckingLogin extends Main{

	private String email;
	private String password;
	private String name;

	CheckingLogin(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getName() { 
		return name;
	}
	public void getPassengerData() throws FileNotFoundException, IOException, ClassNotFoundException {

		File file = new File("passengerData.txt");
		List<Passenger> passengerData = new ArrayList<>();

		if (file.exists()) {
			FileInputStream fileIn = new FileInputStream(file);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			passengerData = (List<Passenger>) objectIn.readObject();
			objectIn.close();
			fileIn.close();

			boolean f = false;
			for (Passenger passenger : passengerData) {
				if (email.equals(passenger.getEmail()) && password.equals(passenger.getPassword())) {
					f = true;
					this.name = passenger.getName();
					break;
				}
			}
			if (f == true) {
				System.out.println("Logged in");
			} else {
				System.out.println("No passenger data found.");
				passengerLogin();
				
			}
		}

	}
}

