package assignment;

import java.util.Scanner;

public class OnlineShopping {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductCatalog productcatalog = new ProductCatalog();
		ShoppingCart shoppingcart = new ShoppingCart();
		OrderHistory orderhistory = new OrderHistory();

		System.out.println("Welcome to online shopping system");

		boolean exit = false;
		while (!exit) {

			System.out.println(
					" 1. Create a new product file \n 2. Load an existing product file \n 3. Show products \n 4. Add product \n 5. Save product to the shopping cart \n 6. Remove a product from the shopping cart \n 7. View shopping cart \n 8. Place an order \n 9. Exit");
			System.out.println("Enter your choice :");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the file name to save the product file: ");
				String productfilename = sc.nextLine();
				productcatalog.saveProducts(productfilename);

				System.out.println("Enter the file name to save the order history: ");
				String orderfilename = sc.nextLine();
				orderhistory.saveorderhistory(orderfilename);

				System.out.println("Product file and order history saved successfully.");
				break;
			case 2:
				System.out.println("Enter the filename to load the product: ");
				String productfilename1 = sc.nextLine();
				productcatalog.loadProducts(productfilename1);

				System.out.println("Enter the fliename to load orrder history: ");
				String orderfilename1 = sc.nextLine();
				orderhistory.loadorderhistory(orderfilename1);

				System.out.println("Product file and order history loaded successfully.");
				break;

			case 3:
				System.out.println("Available products: ");
				productcatalog.displayProducts();
				break;
			case 4:
				System.out.println("Add product:");
				System.out.println("Enter the name of the product: ");
				String name = sc.nextLine();
				System.out.println("Enter the description of the product: ");
				String description = sc.nextLine();
				System.out.println("Enter the description of the product: ");
				double price = sc.nextDouble();
				System.out.println("Enter the description of the product: ");
				int quantity = sc.nextInt();

				Product product = new Product(name, description, price, quantity);
				productcatalog.addProduct(product);
				System.out.println("Product added successfully.");
				break;
			case 5:
				System.out.println("Enter the name of the product to save the product to shopping cart: ");
				String productname = sc.nextLine();
				Product product1 = productcatalog.getProduct(productname);
				if (product1 != null) {
					System.out.println("Enter the quantity :");
					int quantity1=sc.nextInt();
					if(product1.getQuantity()>=quantity1) {
						shoppingcart.addItem(product1, quantity1);
						System.out.println("Product added to shopping cart successfully.");
					}
					else
					{
						System.out.println("you entered quantity is greater than availabile quantities......");
					}
					
				}
			case 6:
				System.out.println("Enter the product name you want to remove: ");
				String removeproduct=sc.nextLine();
				Product products=shoppingcart.getItems(removeproduct);
				if(products!=null) {
					shoppingcart.removeProduct(products);
					System.out.println("Product removed successfully from shopping cart.");
				
				}else {
					System.out.println("Product not found.");
				}
				
				break;
			case 7:
				System.out.println("Viewing shopping cart items");
				shoppingcart.displayCart();
				System.out.println("Total price $:"+shoppingcart.getTotalPrice());
				System.out.println("Displaying the cart items successfully.");
				break;
				
			case 8:
				System.out.println("Place an order......");
				if(shoppingcart.isempty()) {
					System.out.println("Shopping cart is empty.");
				}
				else
				{				
					Order order=new Order(shoppingcart.getItems(),shoppingcart.getTotalPrice());
					orderhistory.addorder(order);
					System.out.println("Order placed successfully.");
					System.out.println("Order confirmation number :"+order.getConfirmationNumber());
					System.out.println("Total price: $"+order.getTotalPrice());
					//After placing the order the shopping cart has to get clear
					shoppingcart.clearCart();
				}
				break;
				
			case 9:
				System.out.println("Enter the filename you want to save the product file.");
				String productfilenames=sc.nextLine();
				productcatalog.saveProducts(productfilenames);
				
				System.out.println("Enter the filename you want to save the order history.");
				String orderfilenames=sc.nextLine();
				orderhistory.saveorderhistory(orderfilenames);
				
				System.out.println("Exiting the program. Thank you for using the Online Shopping!.");
				break;
			default:
					System.out.println("Invalid option. Please try again.");
			}

		}

	}

}
