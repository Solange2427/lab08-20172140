<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import ="java.util.List"%>
 	<%@ page import ="model.entity.*" %>
  	<% List<Resource> resources = (List<Resource>)request.getAttribute("resources"); %>
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
                        <li> List Products  </li>
                    </ol>
                </div>
            </section>
        </div>
	</section>
	