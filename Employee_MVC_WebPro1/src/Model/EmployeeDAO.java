package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/employeeDB";
    private static String username = "root";
    private static String password = "abc123";
 
    private static Connection getConnection() throws ClassNotFoundException, SQLException{
        
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, username, password);
        return con;
    }
 
    public static int insert(Employee e) throws SQLException, ClassNotFoundException
    {
    	String query = "Insert into employee values (?,?,?,?,?,?)";
    	Connection con = getConnection();
    	PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, e.getId());
		ps.setString(2, e.getFirstname());
		ps.setString(3, e.getLastname());
		ps.setString(4, e.getGender());
		ps.setString(5, e.getEmail());
		ps.setDouble(6, e.getSalary());

		int a = ps.executeUpdate();
		con.close();
    	return a;
    }
    
    
    public static List<Employee> getAllEmployee()
    {
    	List<Employee> list = new ArrayList<Employee>();

    	try {
    		Connection con = getConnection();
    		PreparedStatement ps = con.prepareStatement("select * from employee");
    		ResultSet rs = ps.executeQuery();
    		while (rs.next()) {
    			Employee e = new Employee();
    			e.setId(rs.getInt(1));
    			e.setFirstname(rs.getString(2));
    			e.setLastname(rs.getString(3));
    			e.setGender(rs.getString(4));
    			e.setEmail(rs.getString(5));
    			e.setSalary(rs.getDouble(6));
    			
    			list.add(e);
    		}
    		con.close();
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}

    	return list;
    }

    
    public static int delete(int id)
    {
    	int a=0;
    	try {
    		Connection con = EmployeeDAO.getConnection();
    		// delete query is given to delete the record for
    		// the given UserId
    		PreparedStatement ps = con.prepareStatement(
    			"delete from employee where id=?");
    		ps.setInt(1, id);
    		a = ps.executeUpdate();
    		con.close();
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}

		return a;
    }

    
    public static Employee getEmployeeById(int id)
    {
    	Employee e = new Employee();
    	try {
    		Connection con = getConnection();
    		// We are getting the details for a specific user
    		// and hence the query has to be sent in the below
    		// way
    		PreparedStatement ps = con.prepareStatement("select * from employee where id=?");
    		ps.setInt(1, id);
    		ResultSet rs = ps.executeQuery();
    		if (rs.next()) {
    			e.setId(rs.getInt(1));
    			e.setFirstname(rs.getString(2));
    			e.setLastname(rs.getString(3));
    			e.setGender(rs.getString(4));
    			e.setEmail(rs.getString(5));
    			e.setSalary(rs.getDouble(6));
    		}
    		con.close();
    	}
    	catch (Exception ex) {
    		ex.printStackTrace();
    	}

    	return e;
    }
    
    
    public static int update(Employee e)
    {
    	int a = 0;
    	try {
    		Connection con = getConnection();
    		// AS we are not sure about what fields need to be
    		// updated, we are setting for all the firlds by
    		// means of update query This will update the record
    		// for the corresponding geekUserId
    		PreparedStatement ps = con.prepareStatement(
    			"update employee set firstname=?, lastname=?, gender=?, email=?, salary=? where id=?");
    		
    		ps.setString(1, e.getFirstname());
    		ps.setString(2, e.getLastname());
    		ps.setString(3, e.getGender());
    		ps.setString(4, e.getEmail());
    		ps.setDouble(5, e.getSalary());
    		ps.setInt(6, e.getId());

    		a = ps.executeUpdate();
    		con.close();
    	}
    	catch (Exception ex) {
    		ex.printStackTrace();
    	}

    	return a;
    }


}
