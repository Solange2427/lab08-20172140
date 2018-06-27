package controller.resources;

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

public class ResourcesControllerView extends HttpServlet {    
	public void doGet(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException {      
		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Resources/edit.jsp");
		Key k = KeyFactory.createKey(Resource.class.getSimpleName(), new Long(request.getParameter("Resorid")).longValue());
		Resource a = pm.getObjectById(Resource.class, k);
		
		request.setAttribute("ResoObj", a);
		rd.forward(request, response);
		}   
	} 