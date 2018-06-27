package controller.users;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import controller.PMF;
import model.entity.*;
 
 
@SuppressWarnings("serial") 

public class UsersControllerAdd extends HttpServlet {    
	public void doGet(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Users/add.jsp");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		if(request.getParameter("rol") == null){
			
			final Query query12 = pm.newQuery(Roles.class);
			query12.setOrdering(null);
			
			@SuppressWarnings("unchecked")
			List<Roles> roles = (List<Roles>) pm.newQuery(query12).execute();
			request.setAttribute("roles", roles);
			
			rd.forward(request, response);
		} else {
			
			//String query1 = "select from" + User.class.getName();
			//@SuppressWarnings("unchecked")
			//List <User> us = (List <User>) pm.newQuery(query1).execute();
			//if(us.isEmpty()){
				User a = new User(
						request.getParameter("rol"),
						request.getParameter("email"),
						request.getParameter("cumple"),
						request.getParameter("optionsRadios")
						);
				try{
					pm.makePersistent(a);
				} catch(Exception e){
					System.out.println(e);
				} finally{
					pm.close();
					response.sendRedirect("/users/index");
				}
				
			//} else {
				//response.sendRedirect("/users/index");
			//}
		}
		}   
	} 