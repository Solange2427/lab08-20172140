package controller.resources;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Key;

import controller.PMF;
import model.entity.*; 
 
@SuppressWarnings("serial") 

public class ResourcesControllerEdit extends HttpServlet {  
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException {      
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Key k = KeyFactory.createKey(Resource.class.getSimpleName(), new Long(request.getParameter("lok")).longValue());
		Resource a = pm.getObjectById(Resource.class , k);
		
		String nombre = request.getParameter("nombre");
		
			
		a.setNombre(nombre);
			
		pm.close();
		response.sendRedirect("/resources/index");
		
		}   
	} 