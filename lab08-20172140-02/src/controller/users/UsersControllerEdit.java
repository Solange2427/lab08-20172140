package controller.users;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Key;

import controller.PMF;
import model.entity.*; 
 
@SuppressWarnings("serial") 

public class UsersControllerEdit extends HttpServlet {  
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException {      
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Key k = KeyFactory.createKey(User.class.getSimpleName(), new Long(request.getParameter("lok")).longValue());
		User a = pm.getObjectById(User.class , k);
		
		Long rol = Long.parseLong(request.getParameter("rol"));
		String email = request.getParameter("email");
		String cumple = request.getParameter("cumple");
		String genero = request.getParameter("optionsRadios");
			
		a.setRoleid(rol);
		a.setEmail(email);
		a.setBirth(cumple);
		a.setGender(genero);
		
			
		pm.close();
		response.sendRedirect("/users/index");
		
		}   
	} 