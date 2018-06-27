package controller.access;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controller.PMF;
import model.entity.*; 
 
@SuppressWarnings("serial") 

public class AccessControllerView extends HttpServlet {    
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException {      
		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Access/edit.jsp");
		Key k = KeyFactory.createKey(Access.class.getSimpleName(), new Long(request.getParameter("Accessid")).longValue());
		Access a = pm.getObjectById(Access.class, k);
		
		request.setAttribute("AccessObj", a);
		
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
	}
		
		 
	} 