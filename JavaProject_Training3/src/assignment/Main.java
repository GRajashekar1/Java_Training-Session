package assignment;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		RentalService rentalService = new RentalService();
		Scanner scanner = new Scanner(System.in);

		int choice;
		do {
			System.out.println("Vehicle rental system - menu");
			System.out.println(" 1. Add Vehicle \n 2. List available vehicles \n 3. Rent a vehicle \n 4. Calculate a rental cost \n 5. Return a vehicle \n 6. Quit");
			
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println(" 1. car \n 2. motorcycle \n 3. bicycle");
				
				String vehicleType = scanner.next();

				Vehicle vehicles;
				if (vehicleType.equalsIgnoreCase("car")) {
					vehicles = new Car();
				} else if (vehicleType.equalsIgnoreCase("motorcycle")) {
					vehicles = new Motorcycle();
				} else if (vehicleType.equalsIgnoreCase("bicycle")) {
					vehicles = new Bicycle();
				} else {
					System.out.println("Invalid vehicle type.");
					break;
				}

				System.out.println("Enter vehicle details");
				System.out.print("License Plate of the vehicle : ");
				String licensePlate = scanner.next();
				System.out.print("Make of the vehicle : ");
				String make = scanner.next();
				System.out.print("Model of the vehicle : ");
				String model = scanner.next();
				vehicles.setLicensePlate(licensePlate);
				vehicles.setMake(make);
				vehicles.setModel(model);
				vehicles.setAvailable(true);

				rentalService.addVehicle(vehicles);
				System.out.println("Vehicle added successfully.");
				break;
			case 2:
				List<Vehicle> availableVehicles = rentalService.getAvailableVehicles();
				System.out.println("Available Vehicles:");
				for (Vehicle vehicless : availableVehicles) {
					System.out.println(vehicless);
				}
				break;
			case 3:
				System.out.print("Enter customer's first name: ");
				String firstName = scanner.next();
				System.out.print("Enter customer's last name: ");
				String lastName = scanner.next();
				System.out.print("Enter customer's ID: ");
				String id = scanner.next();

				Customer customer = new Customer();
				customer.getFirstName();
				customer.getLastName();
				customer.getemailId();

				// Get vehicle information
			
				System.out.print("Enter vehicle type : ");
				String vehicleType1 = scanner.next();

				Vehicle vehicle;
				if (vehicleType1.equalsIgnoreCase("car")) {
					vehicle = new Car();
				} else if (vehicleType1.equalsIgnoreCase("motorcycle")) {
					vehicle = new Motorcycle();
				} else if (vehicleType1.equalsIgnoreCase("bicycle")) {
					vehicle = new Bicycle();
				} else {
					System.out.println("Invalid vehicle type.");
					break;
				}
				System.out.print("Enter rental start time (yyyy-MM-dd'T'HH:mm:ss.SSSX): ");
                String startDate = scanner.next();
                LocalDateTime startdate = LocalDateTime.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX"));
                System.out.print("Enter rental end time (yyyy-MM-dd'T'HH:mm:ss.SSSX): ");
                String endDate = scanner.next();
                LocalDateTime enddate = LocalDateTime.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX"));



                Rental rental = rentalService.rentVehicle(customer, vehicle, startdate, enddate);
                if (rental != null) {
                    System.out.println("Rental successful. Rental ID: " + rental.getId());
                } else {
                    System.out.println("Vehicle is not available for rent.");
                }
				break;
			case 4:
				// Calculate rental cost
				System.out.print("Enter rental ID: ");
				int rentalId = scanner.nextInt();

				Rental rentalToCalculate = null;
				for (Rental rentals : rentalService.getRentals()) {
					if (rentals != null) {
						rentalToCalculate = rentals;
						break;
					}
				}

				if (rentalToCalculate != null) {
					BigDecimal rentalCost = rentalService.calculateRentalCost(rentalToCalculate);
					System.out.println("Rental cost: " + rentalCost);
				} else {
					System.out.println("Rental not found.");
				}
				break;
			case 5:
				System.out.print("Enter rental ID: ");
				int rentalId1 = scanner.nextInt();

				Rental rentalToReturn = null;
				for (Rental rental1 : rentalService.getRentals()) {
					if (rental1 != null) {
						rentalToReturn = rental1;
						break;
					}
				}

				if (rentalToReturn != null) {
					boolean success = rentalService.returnVehicle(rentalToReturn);
					if (success) {
						System.out.println("Vehicle returned successfully.");
					} else {
						System.out.println("Failed to return vehicle.");
					}
				} else {
					System.out.println("Rental not found.");
				}
				break;
			case 6:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice.");
				break;
			}
		} while (choice != 6);
		scanner.close();
	}
}
