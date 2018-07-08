package controller.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
 
@SuppressWarnings("serial") 

public class UsersControllerLogout extends HttpServlet {    
	public void doGet(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException {
		
		UserService us = UserServiceFactory.getUserService();
		User user = us.getCurrentUser();
		if(user == null){
			response.sendRedirect(us.createLoginURL("/users/login"));
		} else {
			response.sendRedirect(us.createLogoutURL("/users/login"));
		}		
	}
} 