package assignment;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	private String Name;
	private String Description;
	private double price;
	private int quantity;

	/**
	 * Constructor for Product class having parameters and for initialize name, description, price and quantity
	 */
	public Product(String name, String description, double price, int quantity) {
		this.Name = name;
		this.Description = description;
		this.price = price;
		this.quantity = quantity;
	}
	/**
	 * Get the name of the product
	 * @return
	 * return the name of the product
	 */
	public String getName() {
		return Name;
	}
	/**
	 * Get the description of the product
	 * @return
	 * return the description of the product
	 */
	public String getDescription() {
		return Description;
	}
	/**
	 * Get the price for the product
	 * @return
	 * return the price of the product 
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * Get the quantities 
	 * @return
	 * return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * Set how many quantities are required for the user. 
	 * @param passing parameter as quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
	/**
	 * Checks if the product objects are equal based on their names
	 * 
	 * @return
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Product otherproduct=(Product)obj;
		return Objects.equals(Name, otherproduct.Name);	
	}

	@Override
	public String toString() {
		return "Product [name =" + Name + ", description" + Description + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}

}
