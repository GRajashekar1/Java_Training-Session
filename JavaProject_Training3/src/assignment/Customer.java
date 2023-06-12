package assignment;

public class Customer {

	// properties
	private String CustomerID;
	private String firstName;
	private String lastName;
	
	public Customer(String firstname,String lastname, String customerid) {
		this.firstName=firstname;
		this.lastName=lastname;
		this.CustomerID=customerid;
		
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}


	public String getemailId() {
		return CustomerID;
	}

	public void setemailId(String customerid) {
		this.CustomerID = customerid;
	}

	public Customer() {
	}

	
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", emailid=" + CustomerID + "]";
	}

}
