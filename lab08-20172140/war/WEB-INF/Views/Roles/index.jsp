<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
    <%@ page import = "model.entity.*" %>
    <% List<Roles> roles = (List<Roles>)request.getAttribute("roles"); %>
    
    
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
  		<li class="nav-item dropdown">
    		<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Roles</a>
    		<div class="dropdown-menu">
      			<a class="dropdown-item" href="/roles/index">List Roles</a>
      			<a class="dropdown-item" href="/roles/add">New Roles</a>
  		</li>
        <li class="nav-item dropdown">
    		<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Users</a>
    		<div class="dropdown-menu">
      			<a class="dropdown-item" href="/users/index">List Users</a>
      			<a class="dropdown-item" href="/users/add">New Users</a>
  		</li>
        <li class="nav-item dropdown">
    		<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Resource</a>
    		<div class="dropdown-menu">
      			<a class="dropdown-item" href="/resources/index">List Resource</a>
      			<a class="dropdown-item" href="/resources/add">New Resource</a>
  		</li>
        <li class="nav-item dropdown">
    		<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Access</a>
    		<div class="dropdown-menu">
      			<a class="dropdown-item" href="/access/index">List Access</a>
      			<a class="dropdown-item" href="/access/add">New Access</a>
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
                        <li> List Roles  </li>
                    </ol>
                </div>
            </section>
        </div>
        
        <div class="container">
    		<%if(roles.size() >= 0){ %>
    		<table class="table">
    			<tr style="background:#C0FCD1">
    				<th> ID </th> 
    				<th> Name </th>
    				<th> Status </th>
    				<th> Actions </th>
    			</tr>
    			<%for(int i = 0 ; i < roles.size();i++){ %>
    				<% Roles c = (Roles)roles.get(i); %>
    				<tr>
    					<td><a href="/roles/view?Roleid=<%=c.getRoleid() %>"> <%= c.getRoleid() %></a></td>
    					<td><%= c.getNombre() %> </td>
    					<td><%= c.getStatus() %> </td>
    					<td> 
    						<a href="/roles/delete?Roleid=<%=c.getRoleid()%>"> Delete </a> 
    					</td>
    				</tr>
    			<%} %>
    		</table>
            <%} %>
    	</div>
	</section>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous">					    </script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

</body>
</html>