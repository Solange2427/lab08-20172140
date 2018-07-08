<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="java.util.List"%>
 	<%@ page import ="model.entity.*" %>
 	<% List<Role> roles = (List<Role>)request.getAttribute("roles"); %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rey de Reyes</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">

<style>
.jumbotron{
	background-color:#C0FCD1;
}
.breadcrumb{
	background-color:#C0FCD1;
}
</style>
</head>

<body>
	<div class="container">
		<ul class="nav justify-content-end">
		<li class="nav-item">
    		<a class="nav-link active" href="/index.html">Inicio</a>
  		</li>
  		<li class="nav-item">
      		<a class="nav-link" href="/roles/index">Roles</a>	
  		</li>
        <li class="nav-item">
      		<a class="nav-link" href="/users/index">Users</a>	
  		</li>
        <li class="nav-item">
      		<a class="nav-link" href="/resources/index">Resource</a>	
  		</li>
        <li class="nav-item">
      		<a class="nav-link" href="/access/index">Access</a>	
  		</li>
  		<li class="nav-item">
   		 	<a class="nav-link" href="/products/index">Products</a>
  		</li>
  		<li class="nav-item">
    		<a class="nav-link" href="/users/login">Login</a>
  		</li>
  		<li class="nav-item">
    		<a class="nav-link" href="/users/logout">Logout</a>
  		</li>
		</ul>
	</div>
    
    <section class="jumbotron">
    	<div class="container">
        	<h1 class="titulo-blog"> REY DE REYES</h1>
            <p> Targeteria fina </p>
        </div>
     </section>
     
     <section class="main container">
     	<div class="row">
        	<section class="post col-md-auto">
            	<div class="miga-de-pan">
                	<ol class="breadcrumb">
                    	<li> Inicio / </li>
                        <li> New User  </li>
                    </ol>
                </div>
            </section>
        </div>
        
        
        <table class= table>
        <tr>
        	<th style="background:#C0FCD1"> ACTIONS: <br> <a href="/users/index">List Users </a> </th>
        </tr>
        <tr>
        	<th>
    			<form method="get" action="/users/add">
        		<div class="form-group">
                	<label for="rol" class="mr-sm-2">Rol:</label>
            		<select class="custom-select mr-2 mr-sm-2 mb-sm-0" name="rol" required>
                    	<%for (int i = 0 ; i < roles.size() ; i++) { %>
                    		<%Role a = (Role)roles.get(i); %>
                    			<option value="<%= a.getId() %>"> <%= a.getNombre() %> </option>
                    	<%} %>
                    </select>
            	</div>
                <div class="form-group row">
                	<label for="email" class="col-2 col-form-label">Email:</label>
                    <div class="col-10">
                    	<input class="form-control" name="email" type="email" placeholder="Email:" required>
                    </div>
                </div>
                <div class="form-group row">
                	<label for="cumple" class="col-2 col-form-label">Cumpleaños:</label>
                    <div class="col-10">
                    <input class="form-control" name="cumple" type="date" placeholder="DD/MM/AAAA" required>
                    </div>
                </div>
                
                <div class="form-group ">
                	<div class="form-check">
                		<label for="genero" class="form-check-label">
                    	<input class="form-check-input" name="optionsRadios" id="femenino" type="radio" value="femenino"  > Femenino
                    	</label>
                    </div>
                    <div class="form-check">
                		<label for="genero" class="form-check-label">
                    	<input class="form-check-input" name="optionsRadios" id="masculino" type="radio" value="masculino" > Masculino
                    	</label>
                    </div>
                </div>                
                	<input class="btn btn-outline-success" type="submit" value="Enviar">

        	</form>
    		</th>
    	</tr>	
    	</table>
    	
	</section>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous">					    </script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

</body>
</html>