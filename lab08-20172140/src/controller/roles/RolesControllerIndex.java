package controller.roles;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import controller.PMF;
import model.entity.*; 
 
@SuppressWarnings("serial") 

public class RolesControllerIndex extends HttpServlet {    
	public void doGet(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException {    
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		@SuppressWarnings("unchecked")
		List<Roles> roles = (List <Roles>) (pm.newQuery(Roles.class)).execute();
		request.setAttribute("roles", roles);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Roles/index.jsp");
		rd.forward(request, response);
		
		}   
	}