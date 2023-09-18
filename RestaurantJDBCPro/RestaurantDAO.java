package RestaurantJDBCPro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


//REsDAO
public  class RestaurantDAO implements RestaurantOp {

	private static final Scanner scan = new Scanner(System.in);


	/* toAdd method is defined to insert data into a table in a database 
	 * corresponding to the query written inside preparedStatement.
	 * 
	 */

	/*
	 * To insert data into table using prepare statement**/
	public void toAddRestaurant(Connection connection) throws NullPointerException, SQLException{
		PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO Restaurant_Details values(?, ?, ?, ?, ?)");
		System.out.print("Enter the Restid:");
		insertStatement.setInt(1, scan.nextInt());
		System.out.print("Enter Restname: ");
		insertStatement.setString(2, scan.next());
		System.out.print("Enter Avg Cost: ");
		insertStatement.setInt(3, scan.nextInt());
		System.out.print("Enter rating:");
		insertStatement.setInt(4, scan.nextInt());
		System.out.print("Enter Owner Name: ");
		insertStatement.setString(5, scan.next());

		int insertRecord = insertStatement.executeUpdate();
		System.out.println(insertRecord +" records inserted");
	}

	public void toDisplayAll(Connection connection) throws NullPointerException, SQLException{
		java.sql.Statement stmt = connection.createStatement();

		//student_info table is created in mydata database
		ResultSet result = stmt.executeQuery("SELECT * FROM Restaurant_Details");
		while(result.next()) { 
			System.out.println(result.getInt(1)+" " +result.getString(2)+" " +result.getInt(3)
			+" " +result.getInt(4)+result.getString(5));
		}	
	}

	public void toDisplaybyId(Connection connection) throws NullPointerException, SQLException {
		PreparedStatement prepstmnt = connection.prepareStatement("SELECT * FROM Restaurant_Details WHERE restaurantId = ? ");  
		System.out.println("Enter RestId to display that particular record: ");
		int searchId = scan.nextInt();
		prepstmnt.setInt(1,searchId);
	
		ResultSet searchRecord = prepstmnt.executeQuery();
	
			while(searchRecord.next()) {
				System.out.println(searchRecord.getInt(1)+" "+searchRecord.getString(2)
				+" "+searchRecord.getInt(3)+" "+searchRecord.getInt(4)+" "+searchRecord.getString(5));
			}
		}

	public void toUpdate(Connection connection) throws NullPointerException, SQLException{
		System.out.println("Enter the Restid to be updated: ");
		int recordNum = scan.nextInt();
		System.out.println("Enter the Restname to be updated: ");
		String name = scan.next();
		PreparedStatement updateStmt = connection.prepareStatement("UPDATE Restaurant_Details SET restaurantName = ? WHERE restaurantId = ?");
		updateStmt.setString(1, name);
		updateStmt.setInt(2,recordNum);

		int updatedRecord = updateStmt.executeUpdate();
		System.out.println(updatedRecord +" record successfully updated!");
	}

	public void toDelete(Connection connection) throws NullPointerException, SQLException{
		PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Restaurant_Details WHERE restaurantId = ? ");
		System.out.println("Enter Restid to delete that record: ");
		int deleteId = scan.nextInt();
		pstmt.setInt(1, deleteId);

		int delRecord = pstmt.executeUpdate();
		System.out.println(delRecord +" record successfully deleted!");
	}


	public void deleteAll(Connection connection) throws NullPointerException, SQLException {
		PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Restaurant_Details");
		System.out.println("Are your sure want to delete all records? Press Yes if you want to continue");
		String input = scan.next();
		if(input.equalsIgnoreCase("YES")){

			int delRecord = pstmt.executeUpdate();
			System.out.println(delRecord +" record successfully deleted!");

		}


	}


	public void searchById(Connection connection) throws NullPointerException, SQLException{
		System.out.println("Enter the Restid to be updated: ");
		int recordNum = scan.nextInt();
		PreparedStatement prepstmnt = connection.prepareStatement("SELECT * FROM Restaurant_Details WHERE restaurantId = ? ");
		prepstmnt.setInt(1,recordNum);
		if(prepstmnt.execute())
			System.out.println("record found");
		else
			System.out.println("record not found");
	}

	public void displayHotelDetailsByOwnerName(Connection connection) throws NullPointerException, SQLException{
		PreparedStatement prepstmnt = connection.prepareStatement("SELECT ownerName,count(restaurantName) as restCount FROM Restaurant_Details GROUP BY ownerName order by restCount, ownerName;");
		ResultSet searchRecord = prepstmnt.executeQuery();
		while(searchRecord.next()) {
			System.out.println(searchRecord.getString(1)+" "+searchRecord.getInt(2));
		}

	}

	public void  orderByRatings(Connection connection) throws NullPointerException, SQLException{
		PreparedStatement prepstmnt = connection.prepareStatement("SELECT * FROMRestaurant_Details ORDER BY rating");
		ResultSet searchRecord = prepstmnt.executeQuery();
		while(searchRecord.next()) {
			System.out.println(searchRecord.getInt(1)+" "+searchRecord.getString(2)
			+" "+searchRecord.getInt(3)+" "+searchRecord.getInt(4)+" "+searchRecord.getString(5));
		}
		
	}

	
}


