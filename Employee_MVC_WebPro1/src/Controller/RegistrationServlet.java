package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Employee;
import Model.EmployeeDAO;


@WebServlet("/SaveServlet")
public class RegistrationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		double salary = Double.parseDouble(request.getParameter("salary"));
		
		out.print("Employee ID = "+ id + "\nFirstName = " + firstname + "\nLastName = " + lastname + "\nGender = " + gender + "\nEmail =  " + email + "\nSalary = " + salary);
		
		Employee e = new Employee(id, firstname, lastname, gender, email, salary);

		try {
			int a = new EmployeeDAO().insert(e);
			if(a>0)
			{
				out.print("Data Inserted successfully!");
				request.getRequestDispatcher("index.html").include(request, response);
			}
			else
				out.print("Data Not Inserted!");
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



