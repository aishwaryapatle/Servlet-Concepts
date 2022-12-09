package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Employee;
import Model.EmployeeDAO;


@WebServlet("/ViewServlet")
public class DisplayServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out =response.getWriter();
        
        out.print("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>");
        out.print("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js'></script>");
        out.print("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>");
        
        out.print("</br>");
        out.println("<a class='btn btn-primary' href='index.html'>Add New Employee</a></br></br>");
        
        
        //search
        
        out.print("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>");

//        out.print("<form action='search' method='post'>");
//        out.print("<select class='btn btn-primary dropdown-toggle' type='button' data-toggle='dropdown' class='dropdown' id='dropdownlist'>");
//        out.print("<option value='id'>Employee ID</option>");
//        out.print("<option value='fname'>Employee Name</option>");
////      out.print("<option value='address'>Employee Address</option>");
//        out.print("</select>");
//        out.print("   <input type='text' style='font-size: 11pt; height: 30px; width:280px;' placeholder='Search..' name='searchdata'>");
//        out.print("   <button type='submit' class='btn btn-primary'><i class='fa fa-search'></i></button>");
//        out.print("</form>");


        
        
        out.println("<h1 style='font-family:Serif;'><b>Employee Details</b></h1>");
         
        List<Employee> list = EmployeeDAO.getAllEmployee();
         
        out.print("<table class='table table-bordered'");
        out.print("<tr><th>Employee Id</th>"
        		+ "<th>FirstName</th>"
        		+ "<th>LastName</th>"
        		+ "<th>Gender</th>"
        		+ "<th>Email</th>"
        		+ "<th>Salary</th>"
        		+ "<th>Action</th></tr>");
        
        for(Employee e:list){
            // each row is identified by means of its id
            // hence on click of 'edit', it is sent as
            // <a href='EditServlet?id="+e.getId()+"'>edit</a>
            // on click of 'delete', it is sent as
            // <a href='DeleteServlet?id="+e.getId()+"'>delete</a>
        	out.print("<tr><td >"+e.getId()+
        			"</td><td>"+e.getFirstname()+
        			"</td><td>"+e.getLastname()+
        			"</td><td>"+e.getGender()+
        			"</td><td>"+e.getEmail()+
        			"</td><td>"+e.getSalary()+
        			"</td><td><a class='btn btn-warning' href='EditServlet?id="+e.getId()+"'>Edit</a>"
        					+ "   <a class='btn btn-danger' href='DeleteServlet?id="+e.getId()+"'>Delete</a></td></tr>");
        }
        out.print("</table>");
         
        out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
