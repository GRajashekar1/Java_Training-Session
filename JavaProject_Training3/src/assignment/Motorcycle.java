package assignment;

public class Motorcycle extends Vehicle{
	
	public void startEngine() {
		System.out.println("Starting the motorcycle engine.");
	}

	@Override
	public String toString() {
		return "MotorCycle [licensePlate=" + licensePlate + ", make=" + make + ", model=" + model + "]";
	}
	
	
}
