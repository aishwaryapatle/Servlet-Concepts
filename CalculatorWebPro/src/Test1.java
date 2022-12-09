

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/demo")
public class Test1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		double num1 = Double.parseDouble(request.getParameter("fnum"));
		double num2 = Double.parseDouble(request.getParameter("snum"));
		double result = 0;
		
		String operation = request.getParameter("operation");
		if(operation.equals("addition"))
		{
			result=num1+num2;
			out.print("Calculated Answer<br>Addition = "+result);
		}
			
		else if(operation.equals("subtraction"))
		{	
			result=num1-num2;
			out.print("Calculated Answer<br>Subtraction = "+result+"");
		}
	
		else if(operation.equals("multiply"))
		{
			result=num1*num2;
			out.print("Calculated Answer<br>Multiplication = "+result+"");
		}
		
		else if(operation.equals("division"))
		{
			result=num1/num2;
			out.print("Calculated Answer<br>Division = "+result+"");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
