package assignment;

import java.util.List;
import java.util.Scanner;

public class MainOnlineBiddingSystem {
	private static User currentuser;
	public static UserManagementService usermanagementservice;
	public static ItemManagementService itemmanagementservice;

	public static void main(String[] args) 
	{
		usermanagementservice = new UserManagementService();
		itemmanagementservice = new ItemManagementService();
		showInitialMenu();
	}

	private static void showInitialMenu() 
	{
		boolean exit = false;
		while (!exit)
		{
			System.out.println("Welcome to Online Bidding system");
			System.out.println(" 1. Create an Account \n 2. Login \n 3. Exit");
			System.out.println("Choose an option:");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();

			switch (option) 
			{
			case 1:
				createUserAccount();
				break;
			case 2:
				loginUser();
				break;
			case 3:
				System.out.println("GodBye....!");
				exit = true;
				break;
			default:
				System.out.println("You have entered invalid option!!!");
			}
		}
		
	}

	private static void createUserAccount() 
	{
		System.out.println("Create new user.");
		System.out.println("Enter the Username:");
		Scanner sc = new Scanner(System.in);
		String username = sc.next();
		System.out.println("Enter the Password:");
		String password = sc.next();
		usermanagementservice.createUser(username, password);

	}

	private static void loginUser() 
	{
		System.out.println("Login with username & password");
		System.out.println("Enter the Username:");
		Scanner sc = new Scanner(System.in);
		String username = sc.next();
		System.out.println("Enter the Password:");
		String password = sc.next();
		currentuser = usermanagementservice.authenticateUser(username, password);
		if (currentuser != null)
		{
			System.out.println("Welcome to Online Bidding System!");
			showMainMenu();
		}
		else 
		{
			System.out.println("Invalid username and password! Please try again.");
			showInitialMenu();
		}

	}

	private static void showMainMenu() 
	{
		Scanner sc = new Scanner(System.in);
		int option=0;
		while(option != 3)
		{
			System.out.println(" \n 1. Search item \n 2. View bidding \n 3. Logout");
			System.out.println("Choose an option:");
			option = sc.nextInt();
			switch (option) 
			{
			case 1:
				System.out.println("Enter a search keyword:");
				String itemname = sc.next();
				List<Item> searchresults = itemmanagementservice.searchItems(itemname);
				if (searchresults.isEmpty())
				{
					System.out.println("No items found");
				} 
				else
				{
					System.out.println("Search results:");
					for (Item item : searchresults) 
					{
						if (item.getName().contains(itemname))
						{
							System.out.println(item.getName() + " - " + item.getDescription()
									+ " - Current highest bid: Rs" + item.getCurrentHighestBid());
						}
					}
				}
				System.out.println("Enter an item name to place a bid, or '0' to go back:");
				String itemName;
				itemName = sc.next();
				itemName += sc.nextLine();
				if (!itemName.equals("0")) 
				{
					Item selected = itemmanagementservice.getItemByName(itemName);
					if (selected != null) 
					{
						System.out.println("Enter the bid amount:");
						double bidamount = sc.nextDouble();
						
						sc.nextLine();
						System.out.println(" \n 1. Incremental Bidding & \n 2. Automatic Bidding");
						System.out.println("Choose a bidding strategy:");
						int strategychoice = sc.nextInt();
						// The below code as Polymorphism
						BiddingStrategy biddingstrategy;
						if (strategychoice == 1) 
						{
							biddingstrategy = new IncrementalBiddingStrategy();
						} 
						else if (strategychoice == 2) 
						{
							biddingstrategy = new AutomaticBiddingStrategy();
						} 
						else 
						{
							System.out.println("Invalid strategy choice. Skip bidding");
							continue;
						}
						double placebid = biddingstrategy.bid(selected, currentuser, bidamount);
						if(placebid>0)
						System.out.println("Bid placed successfully. Your bid amount: Rs " + placebid);
					} 
					else 
					{
						System.out.println("Item not found.");
					}
				}
				break;

			case 2:
				List<Bid> biddinghistory1 = currentuser.getBiddingHistory();
				System.out.println("Your bidding history:");
				if (biddinghistory1.isEmpty()) {
					System.out.println("No bidding history found.");
				} else {
					for (Bid bid : biddinghistory1) {
						System.out.println(bid.getItemname().getName() + " - " + bid.getItemname().getDescription()
								+ " - " + "Bid Amount: Rs" + bid.getAmount() + " - " + "Winning bid: "
								+ bid.isWinbid());
					}
				}
				break;

			case 3:
				System.out.println("Logout successfully done....");
				break;
			default:
				System.out.println("You have entered invalid option!!!");
			}

		}

	}

}
