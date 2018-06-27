package controller.users;

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

public class UsersControllerView extends HttpServlet {    
	public void doGet(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException {    
		
final PersistenceManager pm = PMF.get().getPersistenceManager();
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Users/edit.jsp");
		Key k = KeyFactory.createKey(User.class.getSimpleName(), new Long(request.getParameter("Userid")).longValue());
		User a = pm.getObjectById(User.class, k);
		
		request.setAttribute("UserObj", a);
		
		final Query query12 = pm.newQuery(Roles.class);
		query12.setOrdering(null);
		@SuppressWarnings("unchecked")
		List<Roles> roles = (List<Roles>) pm.newQuery(query12).execute();
		request.setAttribute("roles", roles);
		
		rd.forward(request, response);
		
		}   
	} 