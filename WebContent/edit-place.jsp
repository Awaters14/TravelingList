<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action= "editPlaceServlet"method="post">
Country: <input type ="text"name = "country"value= "${placeToEdit.country}">
State: <input type = "text"name = "state"value= "${placeToEdit.state}">
City: <input type = "text"name = "city"value= "${placeToEdit.city}">
<input type = "hidden"name = "id"value="${placeToEdit.id}">
<input type = "submit"value="Save Edited Place">
</form>
</body>
</html>