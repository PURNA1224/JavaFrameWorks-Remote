package MysqlConnector;
import java.sql.*;
public class InsertingData {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/Student_schema";
		String uname = "root";
		String pw = "Purna3689";
		int roll_no = 22;
		String name = "purnaaaa";
		int marks = 78;
		String address = "pkl";
		String query = "insert into Student_Marks values(" + roll_no + ",'" + name + "'," + marks + ",'" + address + "')" ;
//		Class.forName("com.mysql.jdbc.Driver");
		Connection co = DriverManager.getConnection(url, uname, pw);
		Statement st = co.createStatement();
//		st.setInt(1, 21);
//		st.setString(2, "sekhar");
//		st.setInt(3, 98);
//		st.setString(4, "Tillapudi");
		int count = st.executeUpdate(query);
		System.out.print(count);
		st.close();
		co.close();
		
	}

}
