package MysqlConnector;
import java.sql.*;

public class SqlConnectorDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/Student_schema";
		String uname = "root";
		String pass = "Purna3689";
		
//		Class.forName("com.mysql.jdbc.Driver");
		Connection co = DriverManager.getConnection(url, uname, pass);
		Statement st = co.createStatement();
		ResultSet rs = st.executeQuery("select * from Student_Marks;");
		String name = "";
		rs.next();
		name = rs.getString(2);
		System.out.println(name);
		
		rs.next();
		name = rs.getString(2);
		System.out.println(name);
		st.close();
		co.close();
	}

}
