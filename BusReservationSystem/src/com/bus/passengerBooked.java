package com.bus;
import java.io.Serializable;

public class passengerBooked implements Serializable{

//	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private String busName;
	private int seatCount;
	
	public passengerBooked(String name, String email, String busName, int seatCount) {
		this.name = name;
		this.email = email;
		this.busName = busName;
		this.seatCount = seatCount;

	}

	@Override
	public String toString() {
		return "passengerBooked [name=" + name + ", email=" + email + ", busName=" + busName + ", seatCount="
				+ seatCount + "]";
	}
}


