package assignment;

import java.time.LocalDateTime;

public class Rental {
	
	private String id;
	private Vehicle rentedVehicle;
	private Customer customer;
	private LocalDateTime startDate;
	private LocalDateTime endDate;

	// Getters, setters, and other methods
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Vehicle getRentedVehicle() {
		return rentedVehicle;
	}
	
	public void setRentedVehicle(Vehicle rentedVehicle) {
		this.rentedVehicle = rentedVehicle;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartTime(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Rental(Vehicle rentedVehicle,Customer customer,LocalDateTime startDate,LocalDateTime endDate) {
		super();
		
	}
}