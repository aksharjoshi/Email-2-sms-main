package servlets;

import java.io.IOException;
import connection.Client;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.ServiceProxy;

/**
 * Servlet implementation class SignIn
 */
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Client clientObj = null;		 
		 try{			
			 	String username = request.getParameter("user");
			 	String password = request.getParameter("pass");
			 	proxy.setEndpoint("http://localhost:8080/Email-2-SMS/services/Service");
			 	clientObj = (Client) proxy.signIn(username,password);
				System.out.println(clientObj);
				
				HttpSession session = request.getSession();
				System.out.println("summary:"+clientObj.getEmailid());
				if(clientObj.getEmailid() == null)
				{
					out.println("Success login");
					session.setAttribute("userSession", session);
					session.setAttribute("userid", clientObj.getEmailid());
					//request.getRequestDispatcher("CreateProfile.jsp").forward(request,response);
				}
				else{
					out.println("Error login");
					//response.sendRedirect("Loginerror.jsp");
				}
				
				//HttpSession session = request.getSession();
				/*if(qdone.substring(0,4).equals("true")){
					session.setAttribute("userSession", session);
					out.println("WELCOME to Simple Market Place :"+ user);//Displaying the message on the servlet itself.
				}
				else{
					out.println(qdone.substring(6));
					out.println("\n <a href=\"SignUp.jsp\"><br>Go back to SignUp again</a>");
				}*/
		 }
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}

}
