package assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class OrderHistory implements Serializable {

	private static final long serialversionUID = 1L;
	private ArrayList<Order> orders;

	/**
	 * Constructor for the Order history class using ArrayList for Order class
	 */
	public OrderHistory() {
		orders = new ArrayList<>();
	}

	/**
	 * Using order class adds an order to order history
	 * 
	 * @param order
	 */
	public void addorder(Order order) {
		orders.add(order);
	}

	public void displayOrderHistory() {
		for (Order order : orders) {
			System.out.println(order);
		}
	}
	
	/**
	 * Read / load the data from a file using FileinputStream of order history class.
	 * ObjectInputStream contains readObject() mtehod 
	 * @param filename
	 */
	public void loadorderhistory(String filename) {
		try {
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream objis=new ObjectInputStream(fis);
			orders=(ArrayList<Order>) objis.readObject();
			objis.close();
			fis.close();
			System.out.println("Order history loadded the successfully.");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Saves the data in to a file to a file using serialization of order history class.
	 * using FileoutputStream and ObjectOutputStream class contains writeObject() method.
	 * 
	 * @param filename
	 */
	public void saveorderhistory(String filename) {
		
		try {
			FileOutputStream fos=new FileOutputStream(filename);
			ObjectOutputStream objos=new ObjectOutputStream(fos);
			objos.writeObject(orders);
			objos.close();
			fos.close();
			System.out.println("Order history saved successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
