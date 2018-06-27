package controller.resources;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import controller.PMF;
import model.entity.*; 
 
@SuppressWarnings("serial") 

public class ResourcesControllerDelete extends HttpServlet {    
	public void doGet(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException { 
		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Resource a = pm.getObjectById(Resource.class, Long.parseLong(request.getParameter("Resorid")));
		
		try{
			pm.deletePersistent(a);
			response.sendRedirect("/resources/index");
		} catch(Exception e){
			System.out.println(e);
			response.sendRedirect("/resources/index");
		} finally{
			pm.close();
		}
		
		}   
	} 