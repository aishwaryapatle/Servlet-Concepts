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


@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
         
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        Double salary = Double.parseDouble(request.getParameter("salary"));

         
        Employee e=new Employee(id, firstname, lastname, gender, email, salary);
      
//        e.setId(id);
//		e.setFirstname(firstname);
//		e.setLastname(lastname);
//		e.setGender(gender);
//		e.setEmail(email);
//		e.setSalary(salary);
         
        // GeekUsersDao.update method is called
        // along with the modified values for geekUser
        int a = EmployeeDAO.update(e);
        if(a>0){
            response.sendRedirect("ViewServlet");
        }else{
            out.println("Sorry! unable to update record");
        }
         
        out.close();
    }	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
