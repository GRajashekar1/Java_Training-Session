package assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class ProductCatalog implements Serializable {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Product> products;

	/**
	 * Constructor for ProductCatalog creating initializing
	 */
	public ProductCatalog() {
		products = new HashMap<>();

	}

	/**
	 * adding the product name to the products catalog passing the product as @param
	 */
	public void addProduct(Product product) {
		products.put(product.getName(), product);
	}

	/**
	 * Remove the product based on its name from the catalog
	 * 
	 * @param product
	 */
	public void removeProduct(Product product) {
		products.remove(product.getName());
	}
	/**
	 * Use of @SuppressWarnings is the compiler will ignore warnings if any for that piece of code.
	 * FileInputStream class is useful to read data from a file in the form of sequence of bytes.
	 * The objectinputstream class is mainly used to deserialize the primitive data and objects which are written by using ObjectOutputStream.
	 * Now the products loads from a file using deserialization.
	 * 
	 * @param fileName
	 */
	@SuppressWarnings("unchecked")
	public void loadProducts(String fileName) {
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			products = (HashMap<String, Product>) objectIn.readObject();
			objectIn.close();
			fileIn.close();
			System.out.println("Product catalog loaded successfully.");
		} 
		catch (IOException | ClassNotFoundException e) {
			System.out.println("Error loading product catalog: " + e.getMessage());
		}
	}
	/**
	 * To write primitive values into a file, we use FileOutputStream class.
	 * For writing byte-oriented and character-oriented data, we can use FileOutputStream.
	 * ObjectOutputStream in Java can be used to convert an object to OutputStream. 
	 * The process of converting object to stream is called serialization in java. 
	 * Once an object is converted to Output Stream, it can be saved to file using serialization.
	 * In ObjectOutput stream class contains writeObject() method for serializing an object.
	 * 
	 * passing filename as @param
	 */
	public void saveProducts(String filename) {
		try {
			FileOutputStream fos=new FileOutputStream(filename);
			ObjectOutputStream objout=new ObjectOutputStream(fos);
			objout.writeObject(products);
			objout.close();
			fos.close();
			System.out.println("Product catalog saved successfully.");
		} 
		catch (IOException e) {
			System.out.println("Error saving product catalog: " + e.getMessage());
		}
		
	}
	/**
	 * Getting the product based on users input
	 * @param name
	 * @return
	 * returning the product based on its input
	 */
	public Product getProduct(String name) {
		return products.get(name);
	}

	/**
	 * Display the all the products which are available in the products catalog
	 */
	public void displayProducts() {
		for (Product product : products.values()) {
			System.out.println(product);
		}
	}
}
