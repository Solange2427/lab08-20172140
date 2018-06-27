package controller.resources;

import java.io.IOException;
//import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import controller.PMF;
import model.entity.Resource;
//import model.entity.*; 
 
@SuppressWarnings("serial") 

public class ResourcesControllerAdd extends HttpServlet {    
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException {      
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Resources/add.jsp");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		if(request.getParameter("nombre") == null){
			rd.forward(request, response);
		} else {
			Resource a = new Resource(
					request.getParameter("nombre")
					);
			try{
				pm.makePersistent(a);
			} catch (Exception e){
				System.out.println(e);
			} finally {
				pm.close();
				response.sendRedirect("/resources/index");
			}
		}
		}   
	}