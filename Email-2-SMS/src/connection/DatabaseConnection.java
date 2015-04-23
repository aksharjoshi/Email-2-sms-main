package connection;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DatabaseConnection {
	
	Connection con = null;
	static ResultSet rs;
    Statement stmt = null;
	
	public DatabaseConnection(){		
		try {			
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				con = DriverManager.getConnection("jdbc:mysql://10.189.74.87:3306/dhvani_test","root","");
				stmt = con.createStatement();
				if(!con.isClosed())
					System.out.println("Successfully Connected!!!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public String signUp(String firstname, String lastname, String emailid, String pwd){
		String result = "";
		int rowcount;
		try {
			String query = "Insert into Customer (firstname, lastname, emailid, password) values ('" + firstname + "', '" + lastname + "', '"+emailid+"', '"+pwd+"')";
			rowcount=stmt.executeUpdate(query);
			if(rowcount > 0){
				result="true";
				System.out.println("Insert Successful");
			}
			else{
				result="false: The data could not be inserted in the database.";
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public com.connect.Client signIn(String username, String password) {
		Client clientObj = null;
		String firstname, lastname, email;
		int userunkid;
		ResultSet rs;
		try {
			String query = "select * from client_master where username='"+ username + "' and password='"+password+"'";
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				firstname = rs.getString("first_name");
				lastname = rs.getString("last_name");
				email = rs.getString("email_id");
				userunkid = rs.getInt("user_id");
				
				clientObj = new Client(firstname, lastname, email, userunkid);
				System.out.println("Fetch Successfully for login");
			} else {
				System.out.println("Fetch not Successfull for login");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientObj;
	}
	/*public String sigIn_old(String userName, String pwd){
		String result = "";
		int rowcount;
		try {
			String query = "Select userunkid FROM client_master WHERE username = "+userName+" AND password = "+pwd;
			//rowcount=stmt.executeQuery(query);
			ResultSet rs = stmt.executeQuery(query);
			
			 // iterate through the java resultset
			 if(rs.next()) 
				 result = "true";
			 else
				 result = "false";
			 
			 return result;
		      
		      
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}*/
	
	

}
