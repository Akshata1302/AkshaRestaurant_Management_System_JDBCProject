package RestaurantJDBCPro;

import java.sql.Connection;
import java.sql.SQLException;

public interface RestaurantOp {

	/***
	 * this is interface
	 * and have abstract methods
	 * only declaration happen
	 * */

	void toAddRestaurant(Connection connection) throws NullPointerException, SQLException ;
	void toDisplayAll(Connection connection)throws NullPointerException, SQLException;
	void toDisplaybyId(Connection connection)throws NullPointerException, SQLException;
	void toUpdate(Connection connection)throws NullPointerException, SQLException;
	void toDelete(Connection connection)throws NullPointerException, SQLException;
	void deleteAll(Connection connection)throws NullPointerException, SQLException;
	void searchById(Connection connection)throws NullPointerException, SQLException;
	void displayHotelDetailsByOwnerName(Connection connection)throws NullPointerException, SQLException;
	void orderByRatings(Connection connection)throws NullPointerException, SQLException;
	default void rulesAndRegulation()
	{
		System.out.println("Maintain Social Distance and Sanitize your hand");
	}
	
}

