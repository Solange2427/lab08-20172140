package controller.access;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Key;

import controller.PMF;
import model.entity.*; 
 
@SuppressWarnings("serial") 

public class AccessControllerEdit extends HttpServlet {  
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException {      
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Key k = KeyFactory.createKey(Access.class.getSimpleName(), new Long(request.getParameter("lok")).longValue());
		Access a = pm.getObjectById(Access.class , k);
		
		String rol = request.getParameter("rol");
		String resource = request.getParameter("resource");
			
		a.setRole(rol);
		a.setResource(resource);
			
		pm.close();
		response.sendRedirect("/access/index");
		
		}   
	} 