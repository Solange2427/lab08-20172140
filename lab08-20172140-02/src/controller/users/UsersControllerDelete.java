package controller.users;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import controller.PMF;
import model.entity.*; 
 
@SuppressWarnings("serial") 

public class UsersControllerDelete extends HttpServlet {    
	public void doGet(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException {      
		
		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		
		User a = pm.getObjectById(User.class, Long.parseLong(request.getParameter("id")));
		
		try{
			pm.deletePersistent(a);
			response.sendRedirect("/users/index");
		} catch(Exception e){
			System.out.println(e);
			response.sendRedirect("/users/index");
		} finally{
			pm.close();
		}
		}   
	} 