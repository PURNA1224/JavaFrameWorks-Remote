package MysqlConnector;
import java.sql.*;

public class AccessingData {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/Student_schema";
		String userName = "root";
		String password = "Purna3689";
//		String location = "tadepalligudem";
		String query = "select * from Student_Marks where address='tadepalligudem'";
		Connection co = DriverManager.getConnection(url, userName, password);
		Statement st = co.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+ " " +rs.getString(2)+ " " +rs.getInt(3)+ " " +rs.getString(4));
		}
		
		st.close();
		co.close();
	}

}
