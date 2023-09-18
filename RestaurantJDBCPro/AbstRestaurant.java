package RestaurantJDBCPro;

public abstract class AbstRestaurant {

	
	 
	
	
		public static boolean loginDB(String user, String pass) {
					if(user.equals("Akshata") && pass.equals("123"))
					{
						System.out.println("=====Logged in successfully======");
						return true;
					}
					else
					{
						System.out.println("-------------Loggin Failed--------------");
						//System.out.println("Please Enter correct username and password");
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
						System.exit(1);
					}
					return false;
			
		}
		public static void logoutDB() {
			System.out.println("|-----------------------------|");
			System.out.println("|Thank you...visit us again.. |");
			System.out.println("|-----------------------------|");
		}		
}
