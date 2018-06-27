package controller.products;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import model.entity.*; 
 
@SuppressWarnings("serial") 

public class ProductsControllerIndex extends HttpServlet { 
	@SuppressWarnings("unchecked")
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException {    
		
		com.google.appengine.api.users.User uGoogle = UserServiceFactory.getUserService().getCurrentUser();
		
		/* Verificando login presente */
		if(uGoogle == null){
			RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/error1.jsp");
			dp.forward(request, response);
		} else {
			/* PMF para consultas */
			final PersistenceManager pm = PMF.get().getPersistenceManager();
			/* Buscando usuario registrado activo con el email */
			String query1 = "select from" + User.class.getName() + 
					"where email == '" + uGoogle.getEmail() + "'" ; //+ 
					//"&&status==true";
			List<model.entity.User> uSearch = (List <model.entity.User>) pm.newQuery(query1).execute();
			if(uSearch.isEmpty()){
				RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/error2.jsp");
				dp.forward(request, response);
			} else {
				System.out.println(request.getServletPath());
				/*Buscando resource registrado activo de acuerdo a la URL*/
				String query2 = "select from " + Resource.class.getName() + 
						"where name= ' " + request.getServletPath() + "'" + 
						"&& status == true";
				List<Resource> rSearch = (List<Resource>) pm.newQuery(query2).execute();
				/* Verificando recurso registrado*/
				if( rSearch.isEmpty()){
					RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/error3.jsp");
					dp.forward(request, response);
				} else {
					/* Buscando acceso registrado activo para el rol y recurso */
					String query3 = "select from " + Access.class.getName() + 
							"where Roleid == " + uSearch.get(0).getRoleid() +
							"&&Resoid == " + rSearch.get(0).getResoid() + 
							"&&status==true";
					List<Access> aSearch = (List <Access>) pm.newQuery(query3).execute();
					/* Verificando acceso registrado*/
					if( aSearch.isEmpty()){
						RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/error4.jsp");
						dp.forward(request, response);
					} else {
						RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Products/index.jsp");
						dp.forward(request, response);
					}
				}
				
			}
			
		}

	}   
} 