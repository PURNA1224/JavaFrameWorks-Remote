package MysqlConnector;

import java.sql.*;

public class SimplifyCode {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StudentDAO s = new StudentDAO();
//		s.connectJDBC();
//		Student s1 = s.getStudent("sandeep");
//		System.out.println(s1.roll_no);
//		s.connectJDBC();
//		Student s2 = s.getStudent(11);
//		System.out.println(s2.name);
		s.connectJDBC();
		s.deleteStudent(24);
//		Student s3 = s.addStudent(25, "suraj", 30, "tadepalligudem");
//		System.out.println("1 row effected");
//		System.out.println("roll_no: " +s3.roll_no+ ", name: " +s3.name+ ", marks: " +s3.marks+ ", address: " +s3.address);
		
	}

}

class StudentDAO{
	Connection co = null;
	public void connectJDBC() throws Exception {
		co = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_schema", "root", "Purna3689");
	}
	public Student getStudent(int roll_no) throws Exception {
		Student stud = new Student();
		stud.roll_no = roll_no;
		Statement st = co.createStatement();
		ResultSet rs = st.executeQuery("Select * from Student_Marks where roll_no = "+roll_no);
		rs.next();
		stud.name = rs.getString(2);
		st.close();
		co.close();
		return stud;
	}
	public Student getStudent(String name) throws Exception {
		Student stud = new Student();
		stud.name = name;
		Statement st = co.createStatement();
		ResultSet rs = st.executeQuery("Select * from Student_Marks where name = '"+name+"'");
		rs.next();
		stud.roll_no = rs.getInt(1);
		st.close();
		co.close();
		return stud;
	}
	
	
	public Student addStudent(int roll_no, String name, int marks, String address) throws Exception {
		Student stud = new Student();
		stud.roll_no = roll_no;
		stud.name = name;
		stud.marks = marks;
		stud.address = address;
		String query = "insert into Student_Marks values(?,?,?,?);";
		PreparedStatement st = co.prepareStatement(query);
		st.setInt(1, roll_no);
		st.setString(2, name);
		st.setInt(3, marks);
		st.setString(4, address);
		st.executeUpdate();
		st.close();
		co.close();
		System.out.print("1 row added");
		return stud;
	}
	public Student deleteStudent(int roll_no) throws Exception {
		Student s = this.getStudent(roll_no);
		this.connectJDBC();
		String query = "delete from Student_Marks where roll_no="+roll_no;
		PreparedStatement st = co.prepareStatement(query);
		st.executeUpdate();
		System.out.print("1 row deleted");
//		st.close();
//		co.close();
		return s;
	}
}

class Student{
	int roll_no = 0;
	String name = null;
	int marks = 0;
	String address = null;
}