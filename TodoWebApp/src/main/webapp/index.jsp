<%@page import="classes.Todo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todo</title>
</head>
<body style="background: #D9E3EC">

<%

	boolean isLoggedIn = false;

	//request.getSession().setAttribute("username", "yes");

	HttpSession s = request.getSession();
	
	if(s != null && s.getAttribute("username") != null)
	{
		isLoggedIn = true;
	}
	
	System.out.println("LoggedIn : "+ isLoggedIn);
	
	@SuppressWarnings("unchecked")
	List<Todo> todos = (List<Todo>) s.getAttribute("todo");

%>

<div style="border-bottom: 2px solid #A6BDDF;display: flex; flex-direction: row; justify-content:flex-end; " >

<% if(isLoggedIn) { %>
	<%  String userName = (String) s.getAttribute("username"); %>
	
	<div>
    	<p style="padding-right: 10px">  <%=userName %> </p>
    </div>
    <div>
		
		<a data-method="delete" href="user">Logout</a>
    	
     </div>

<% } 

else { %>
    
	<p style="padding-right: 10px"> 
		<a href="login.html">Login</a>
	</p>
	<p> 
		<a href="signup.html">SignUp</a>
	</p>

<% } %>

</div>


<div style="border: 2px solid grey; margin: 30px 20px; padding: 0 10px 10px 10px; background: #FAFBC4" >
<h2 align="center"> Todo App</h2>
<%
if(isLoggedIn) {
%>


 
 
 <% if(todos == null || todos.size() == 0) { %>

<p>  Add todos </p>

<% } 

else  { 

	
	

%>

	<ul>
		
		<% for(int i=0;i<todos.size();i++) { %>
			
			<div style="display: flex; align-items: center;">
			<p style="text-decoration: <%= todos.get(i).isDone() ? "line-through" : "none"%>"> 
				<a href="handleTask?index=<%=i%>" style="text-decoration: none" > <%=todos.get(i).getDescription() %> </a>
				
				<span style="padding-left: 5px">
				<form action="handleTask?index=<%=i%>" method="post" style="display: inline;">
 					<button type="submit" >-</button>
 				</form>
 				</span>
			</p>
			
			</div>
	<%	}%>
	</ul>


<% } %>

 
 
 <form action="add" method="post">
 	<span> Task: </span>
 	<input name="description" type="text"/>
 	<button type="submit">+</button>
 </form>
 
 
<% } 


 else { %>

	<div align="center" style="margin: 50px 0">
		<a href="login.html"><h3> Please Login </h3> </a>
	</div>


<% } %>
</div>

<% String error = (String) request.getAttribute("error");  %>

<% if(error != null) { %>

<p style="color: red"> <%= error %></p>


<% } %>

</body>
</html>