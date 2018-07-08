package controller.products;

import java.io.IOException;

import java.util.List;

import javax.annotation.Resource;
import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import model.entity.Access;

@SuppressWarnings("serial")
public class ProductsControllerIndex extends HttpServlet {
 @SuppressWarnings("unchecked")
 public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
 
	 com.google.appengine.api.users.User uGoogle = UserServiceFactory.getUserService().getCurrentUser();
 	
	 /*Verifica login */
	 if(uGoogle == null){
		 RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/Error1.jsp");
		 dp.forward(req, resp);
 	}else {
 		/* PMF de consultas */
 		PersistenceManager pm = PMF.get().getPersistenceManager();
 		/* Buscando usuario registrado activo con el email*/
 		String query = "select from " + model.entity.User.class.getName() + " where email=='"+uGoogle.getEmail()+"'"+" && status==true";
 		List<model.entity.User> uSearch = (List<model.entity.User>) pm.newQuery(query).execute();
 		/* Verificando usuario registrado */
 		if(uSearch.isEmpty()){
 			RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/Error2.jsp");
 			dp.forward(req, resp);
 		}else{
 			System.out.println(req.getServletPath());
 			/* Buscando resource registrado activo de acuerdo a la URL */
 			String query2 = "select from "+model.entity.Resource.class.getName() + " where nombre=='"+req.getServletPath()+"'"+" && status==true";
 			List<model.entity.Resource> rSearch = (List<model.entity.Resource>) pm.newQuery(query2).execute();
 			/*verificando recurso de registrado */
 			if(rSearch.isEmpty()){
 				RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/Error3.jsp");
 	 			dp.forward(req, resp);
 			}else {
 				/* Buscando acceso registrado activo para el Rol y Recurso */
 				String query3 = "select from "+ Access.class.getName() + " where Roleid ==" + uSearch.get(0).getRoleid()+
 						"&& Resoid=="+rSearch.get(0).getId()+ " && status==true";
 				List<Access> aSearch =(List<Access>) pm.newQuery(query3).execute();
 				/* Verificando acceso registrado */
 				if(aSearch.isEmpty()){
 					RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/Error4.jsp");
 	 	 			dp.forward(req, resp);
 				}else{
 					RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Products/index.jsp");
 	 	 			dp.forward(req, resp);
 				}
 			}
 			
 		}	
 	}
 }
}