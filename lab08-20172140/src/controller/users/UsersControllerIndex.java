package controller.users;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import controller.PMF;
import model.entity.*; 
 
@SuppressWarnings("serial") 

public class UsersControllerIndex extends HttpServlet {    
	public void doGet(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException {    
		
PersistenceManager pm = PMF.get().getPersistenceManager();
		
		@SuppressWarnings("unchecked")
		List<User> users = (List <User>) (pm.newQuery(User.class)).execute();
		request.setAttribute("users", users);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Users/index.jsp");
		rd.forward(request, response);
		
		}   
	} 