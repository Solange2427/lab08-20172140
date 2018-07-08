package controller.roles;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import controller.PMF;
import model.entity.*; 
 
@SuppressWarnings("serial") 

public class RolesControllerDelete extends HttpServlet {    
	public void doGet(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException {    
		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Role a = pm.getObjectById(Role.class, Long.parseLong(request.getParameter("id")));
		
		try{
			pm.deletePersistent(a);
			response.sendRedirect("/roles/index");
		} catch(Exception e){
			System.out.println(e);
			response.sendRedirect("/roles/index");
		} finally{
			pm.close();
		}
		
		}   
	} 