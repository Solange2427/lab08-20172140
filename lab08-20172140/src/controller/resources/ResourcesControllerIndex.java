package controller.resources;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import controller.PMF;
import model.entity.*; 
 
@SuppressWarnings("serial") 

public class ResourcesControllerIndex extends HttpServlet {    
	public void doGet(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException {   
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		@SuppressWarnings("unchecked")
		List<Resource> resor = (List <Resource>) (pm.newQuery(Resource.class)).execute();
		request.setAttribute("resor", resor);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Resources/index.jsp");
		rd.forward(request, response);
		
		}   
	} 