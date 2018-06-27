package controller.access;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import controller.PMF;
import model.entity.*; 
 
@SuppressWarnings("serial") 

public class AccessControllerDelete extends HttpServlet {    
	public void doGet(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException {  
		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Access a = pm.getObjectById(Access.class, Long.parseLong(request.getParameter("Accessid")));
		
		try{
			pm.deletePersistent(a);
			response.sendRedirect("/access/index");
		} catch(Exception e){
			System.out.println(e);
			response.sendRedirect("/access/index");
		} finally{
			pm.close();
		}
		
		
		}   
	} 