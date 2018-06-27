package controller.access;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import controller.PMF;
import model.entity.*; 
 
@SuppressWarnings("serial") 

public class AccessControllerIndex extends HttpServlet {    
	public void doGet(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException {      
		

		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		@SuppressWarnings("unchecked")
		List<Access> access = (List <Access>) (pm.newQuery(Access.class)).execute();
		request.setAttribute("access", access);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Access/index.jsp");
		rd.forward(request, response);
		
		}   
	} 