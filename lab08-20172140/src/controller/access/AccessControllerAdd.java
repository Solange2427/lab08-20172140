package controller.access;

import java.io.IOException;
import java.util.*;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import controller.PMF;
import model.entity.*; 
 
@SuppressWarnings("serial") 

public class AccessControllerAdd extends HttpServlet {    
	public void doGet(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException {      
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Access/add.jsp");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		if(request.getParameter("rol") == null){
			
			final Query query12 = pm.newQuery(Roles.class);
			query12.setOrdering(null);
			
			final Query query22 = pm.newQuery(Resource.class);
			query22.setOrdering(null);
			
			@SuppressWarnings("unchecked")
			List<Roles> roles = (List<Roles>) pm.newQuery(query12).execute();
			request.setAttribute("roles", roles);
			
			@SuppressWarnings("unchecked")
			List<Resource> resources = (List<Resource>) pm.newQuery(query22).execute();
			request.setAttribute("resources", resources);
			
			rd.forward(request, response);
		} else {
			
			//String query1 = "select from" + Access.class.getName();
			//@SuppressWarnings("unchecked")
			//List<Access> ac = (List<Access>) pm.newQuery(query1).execute();
			//if(ac.isEmpty()){
				Access a = new Access(
						request.getParameter("rol"),
						request.getParameter("resource")
						);
				try{
					pm.makePersistent(a);
				} catch (Exception e){
					System.out.println(e);
				} finally{
					pm.close();
					response.sendRedirect("/access/index");
				}
			//} else{
				//response.sendRedirect("/access/index");
			//}
		
		}   
	}
	} 