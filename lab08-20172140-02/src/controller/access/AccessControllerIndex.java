package controller.access;

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

public class AccessControllerIndex extends HttpServlet {    
	public void doGet(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException {      
		com.google.appengine.api.users.User uGoogle = UserServiceFactory.getUserService().getCurrentUser();
	 	
		 /*Verifica login */
		 if(uGoogle == null){
			 RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/Error1.jsp");
			 dp.forward(request, response);
	 	}else {
	 		/* PMF de consultas */
	 		PersistenceManager pm = PMF.get().getPersistenceManager();
	 		/* Buscando usuario registrado activo con el email*/
	 		String query = "select from " + model.entity.User.class.getName() + " where email=='"+uGoogle.getEmail()+"'"+" && status==true";
	 		@SuppressWarnings("unchecked")
			List<model.entity.User> uSearch = (List<model.entity.User>) pm.newQuery(query).execute();
	 		/* Verificando usuario registrado */
	 		if(uSearch.isEmpty()){
	 			RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/Error2.jsp");
	 			dp.forward(request, response);
	 		}else{
	 			System.out.println(request.getServletPath());
	 			/* Buscando resource registrado activo de acuerdo a la URL */
	 			String query2 = "select from "+model.entity.Resource.class.getName() + " where nombre=='"+request.getServletPath()+"'"+" && status==true";
	 			@SuppressWarnings("unchecked")
				List<model.entity.Resource> rSearch = (List<model.entity.Resource>) pm.newQuery(query2).execute();
	 			/*verificando recurso de registrado */
	 			if(rSearch.isEmpty()){
	 				RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/Error3.jsp");
	 	 			dp.forward(request, response);
	 		/**	}else {
	 				/* Buscando acceso registrado activo para el Rol y Recurso */
	 		/**		String query3 = "select from "+ Access.class.getName() + " where Roleid ==" + uSearch.get(0).getRoleid()+
	 						"&& Resoid=="+rSearch.get(0).getId()+ " && status==true";
	 				@SuppressWarnings("unchecked")
					List<Access> aSearch =(List<Access>) pm.newQuery(query3).execute();
	 				/* Verificando acceso registrado */
	 		/**		if(aSearch.isEmpty()){
	 					RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/Error4.jsp");
	 	 	 			dp.forward(request, response); **/
	 				}else{

	 					PersistenceManager pm2 = PMF.get().getPersistenceManager();
	 					
	 					@SuppressWarnings("unchecked")
	 					List<Access> access = (List <Access>) (pm2.newQuery(Access.class)).execute();
	 					request.setAttribute("access", access);
	 					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Access/index.jsp");
	 					rd.forward(request, response);
	 				}
	 		}
	 	}
	}   
} 