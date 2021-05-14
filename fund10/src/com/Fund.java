package com;

import java.sql.*;

public class Fund {
	
	private Connection connect() 
	{ 
		
		Connection con = null; 
		try
		{ 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
	 
			//Provide the correct details: DBServer/DBName, username, password 
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:8111/fundcl", "root", ""); 
			 //For testing
			 System.out.print("Successfully connected");
		} 
		catch (Exception e) 
		{e.printStackTrace();} 
		return con; 
	}
	
	
	public String readFunds() 
	{ 
			String output = ""; 
			try
			{ 
				Connection con = connect(); 
		 		
				if (con == null) 
				{ 
					return "Error while connecting  to the database for reading."; 
				} 
	 
				// Prepare the html table to be displayed
				output = "<table border='1'><tr><th>Funder Code</th><th>Company Name</th><th>Contact Number</th><th>Company Description</th><th>Update</th><th>Remove</th></tr>"; 
				String query = "select * from fundcl"; 
				Statement stmt = con.createStatement(); 
				ResultSet rs = stmt.executeQuery(query); 
	 
				// iterate through the rows in the result set
				while (rs.next()) 
				{ 
					String FID = Integer.toString(rs.getInt("FID")); 
					String FunderCode = rs.getString("FunderCode");
					String CompanyName = rs.getString("CompanyName");
					String ContactNo = Integer.toString( rs.getInt("ContactNo")); 
					String CompanyDesc = rs.getString("CompanyDesc"); 
		 
					// Add into the html table
					output += "<tr><td><input id='hidfIDUpdate'  name='hidfIDUpdate'  type='hidden' value='" + FID + "'>" + FunderCode + "</td>"; 
					output += "<td>" + CompanyName + "</td>"; 
					output += "<td>" + ContactNo + "</td>"; 
					output += "<td>" + CompanyDesc + "</td>"; 
	 
	 
					// buttons
					output += "<td><input name='btnUpdate'  type='button' value='Update'  class='btnUpdate btn btn-secondary'></td>" + "<td><input name='btnRemove'  type='button' value='Remove'  class='btnRemove btn btn-danger'  data-fid='" + FID + "'>" + "</td></tr>"; 
				} 
				con.close(); 
				// Complete the html table
				output += "</table>"; 
			} 
			catch (Exception e) 
			{ 
				output = "Error while reading the items."; 
				System.err.println(e.getMessage()); 
			} 
			return output;
	 }
	
	
	public String insertFund(String FunderCode, String CompanyName, String ContactNo, String CompanyDesc) 
	{ 
		String output = ""; 
		try
		{ 
			Connection con = connect(); 
			if (con == null) 
			{ 
					return "Error while connecting  to the database for inserting."; 
			} 
			// create a prepared statement
			String query = " insert into fundcl (`FID`,`FunderCode`,`CompanyName`,`ContactNo`,`CompanyDesc`)" + " values(?, ?, ?, ?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(query); 
			 
			// binding values
			preparedStmt.setInt(1, 0); 
			preparedStmt.setString(2, FunderCode); 
			preparedStmt.setString(3, CompanyName); 
			preparedStmt.setInt(4, Integer.parseInt(ContactNo));
			preparedStmt.setString(5, CompanyDesc); 
			 
			 
			 // execute the statement
			 preparedStmt.execute(); 
			 con.close(); 
			 String newFunds = readFunds(); 
			 output = "{\"status\":\"success\", \"data\": \"" + 
			 newFunds + "\"}"; 
			 } 
			 catch (Exception e) 
			 { 
			 output = "{\"status\":\"error\", \"data\":  \"Error while inserting the item.\"}"; 
			 System.err.println(e.getMessage()); 
			 } 
			 return output; 
			 }
	
	
	
	public String updateFund(String FunderCode, String CompanyName, String ContactNo, String CompanyDesc) 
    { 
		String output = ""; 
		try
		{ 
			Connection con = connect(); 
			if (con == null) 
			{ 
				 return "Error while connecting  to the database for updating."; 
			} 
		
			String query = "UPDATE fundcl SET FunderCode=?,CompanyName=?,ContactNo=?,CompanyDesc=? WHERE FID=?"; 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
		 
			
			preparedStmt.setString(1, FunderCode); 
			preparedStmt.setString(2, CompanyName);
			preparedStmt.setInt(3, Integer.parseInt(ContactNo));
			preparedStmt.setString(4, CompanyDesc); 
			preparedStmt.setInt(5, Integer.parseInt(FID)); 
			 
		 	
			// execute the statement
			 preparedStmt.execute(); 
			 con.close(); 
			 String newFunds = readFunds(); 
			 output = "{\"status\":\"success\", \"data\": \"" + 
			 newFunds + "\"}"; 
		} 
		catch (Exception e) 
		{ 
			output = "{\"status\":\"error\", \"data\":  \"Error while updating the item.\"}"; 
			System.err.println(e.getMessage()); 
		} 
		return output;
	 		 
		 
	}
	
	public String deleteFund(String FID) 
	{ 
		String output = ""; 
		try
		{ 
			Connection con = connect(); 
		 
			if (con == null) 
			{ 
				return "Error while connecting to the database for deleting."; 
			} 
		
			// create a prepared statement
			 String query = "delete from fundcl where FID=?"; 
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			 preparedStmt.setInt(1, Integer.parseInt(FID));
			 
			// execute the statement
			 preparedStmt.execute(); 
			 con.close(); 
			 String newFund = readFunds(); 
			 output = "{\"status\":\"success\", \"data\": \"" + newFund + "\"}"; 
			 
		}
		catch (Exception e)
		{
			output = "{\"status\":\"error\", \"data\":  \"Error while deleting the item.\"}"; 
			 System.err.println(e.getMessage()); 
		}
		 
		return output;
	
	 }

}
