package controller.roles;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controller.PMF;
import model.entity.*; 
 
@SuppressWarnings("serial") 

public class RolesControllerView extends HttpServlet {    
	public void doGet(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException { 
		
final PersistenceManager pm = PMF.get().getPersistenceManager();
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Roles/edit.jsp");
		Key k = KeyFactory.createKey(Roles.class.getSimpleName(), new Long(request.getParameter("Roleid")).longValue());
		Roles a = pm.getObjectById(Roles.class, k);
		
		request.setAttribute("RoleObj", a);
		rd.forward(request, response);
		
		}   
	} 