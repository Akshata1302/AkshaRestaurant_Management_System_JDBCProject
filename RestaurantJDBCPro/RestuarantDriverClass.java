package RestaurantJDBCPro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class RestuarantDriverClass{

	private static final Scanner scan = new Scanner(System.in);
	private static final RestaurantOp restaurantdb = new RestaurantDAO();
	private static Connection connection=null;
	


	static void showMenu1() {
		System.out.println("|===============================================|");
		System.out.println("|	Press 1 to add restaurant in system	|");
		System.out.println("|	Press 2 to display all restaurants	|");
		System.out.println("|	Press 3 to display restaurants by id	|");
		System.out.println("|	Press 4 to Update restaurant		|");
		System.out.println("|	Press 5 to Delete Restaurant By rest Id	|");
		System.out.println("|	Press 6 to Delete Restaurants		|");
		System.out.println("|	Press 7 to Search by Restid		|");
		System.out.println("|	Press 8 to display HotelDetails By OwnerName|");
		System.out.println("|	Press 9 to logout			|");
		System.out.println("|	Press 10 to exit			|");
		System.out.println("|===============================================|");

	}

	static Connection  toestablishConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Restaurants_Info", "root", "Akshu@123");
		return connection;
	}

	public static void main(String args[]) throws ClassNotFoundException, SQLException {

		System.out.println("Welcome to Restaurants===========");
		System.out.println("Login into Restaurant:");
		System.out.println("Enter username");
		String name = scan.next();
		System.out.println("Enter password");
		String password = scan.next();
		if(AbstRestaurant.loginDB(name, password) == true)
		{
			Connection conobj1=toestablishConnection();

			int restop;
			do {
				showMenu1();
				System.out.print("=========Enter your option=========");
				restop = scan.nextInt();
				switch(restop)
				{
				case 1:
					System.out.println("Insert All Data");
					restaurantdb.toAddRestaurant(conobj1);
					break;
	
				case 2:
					System.out.println("Display All Data");
					restaurantdb.toDisplayAll(conobj1);
					break;
	
				case 3:
					System.out.println("Display By id Data");
					restaurantdb.toDisplaybyId(conobj1);
					break;
	
				case 4:
					restaurantdb.toUpdate(conobj1);
					break;
	
				case 5:
					restaurantdb.toDelete(conobj1);
					break;
	
				case 6:
					restaurantdb.deleteAll(conobj1);	
					break;
					
				case 7:
					restaurantdb.searchById(conobj1);
					break;
					
				case 8:
					restaurantdb.displayHotelDetailsByOwnerName(conobj1);
					break;
	
				case 9:
					AbstRestaurant.logoutDB();
					break;
	
				case 10:
					System.exit(1);
					System.out.println("Thank you.....");
					break;
	
				default:
					if(restop != 9)
						System.out.println("Enter proper options...");
				}
	
			}while(restop != 9);
	
	
			connection.close();
		}
}
}

