package Exercises;
import java.sql.*;
public class StudentDetails {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/Student_schema";
		String un = "root";
		String pw = "Purna3689";
		String query = "Select * from StudentMails";
		try(Connection co = DriverManager.getConnection(url, un, pw)){
			Statement st = co.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				System.out.println("Id: "+rs.getInt(1)+" || Name: "+rs.getString(2)+" || Mail address: "+rs.getString(3));
			}
			rs.close();
			st.close();
		}
		
	}

}
