package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Employee;
import Model.EmployeeDAO;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<h1>Update Employee Details</h1>");
        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);
       
        Employee e = EmployeeDAO.getEmployeeById(id);
         
        out.print("<form action='EditServlet2' method='post'>");
        out.print("<table>");
        out.print("<tr><td>Employee ID</td><td><input type='text' readonly='readonly' name='id' value='"+e.getId()+"'/></td></tr>");
        out.print("<tr><td>FirstName:</td><td><input type='text' name='firstname' value='"+e.getFirstname()+"'/></td></tr>");
        out.print("<tr><td>LastName:</td><td><input type='text' name='lastname' value='"+e.getLastname()+"'/></td></tr>");
        out.print("<tr><td>Gender:</td><td><input type='text' name='gender' value='"+e.getGender()+"'/></td></tr>");
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");
        out.print("<tr><td>Salary:</td><td><input type='number' name='salary' value='"+e.getSalary()+"'/></td></tr>");
         
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
        out.print("</table>");
        out.print("</form>");
         
        out.close();
    }
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
