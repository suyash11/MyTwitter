package org.suyash.twitter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
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
		String hdnParam	=	request.getParameter("pagename");
		if(hdnParam.equals("register")){
			String username	=	request.getParameter("txtFName");
			String email	=	request.getParameter("txtEmail");
		    String pw	=	request.getParameter("txtPassword");
			GetsSets sets	=	new GetsSets();
			
			sets.setUsername(username);
			sets.setEmail(email);
			sets.setPw(pw);
			
			
			try {
				DManager.Insert(sets);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		if(hdnParam.equals("login")){
				String userName	=	request.getParameter("txtUserName");
				String password	=	request.getParameter("txtPassword");
				if((userName.equals("admin")) && (password.equals("admin"))){
					response.sendRedirect("admin.jsp");
				}else{
					GetsSets set	=	new GetsSets();
					
					set.setEmail(userName);
					set.setPw(password);
					try {
						int checkUser	=	DManager.checkUser(set);
						System.out.println(checkUser);
							if(checkUser == 1){
								response.sendRedirect("welcome.jsp");
							}else{
								response.sendRedirect("login.jsp");
							}
					} catch (ClassNotFoundException | SQLException  e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		}
		
	}

}