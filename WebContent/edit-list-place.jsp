<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit List</title>
</head>
<body>
<form action = "editListDetailsServlet" method="post">
<input type ="hidden" name = "id"value= "${listToEdit.id}">
Trips Name: <input type ="text"name = "tripsName"value= "${listToEdit.tripsName}"><br />

Trip date: <input type ="text"name = "month"placeholder="mm"size="4"value= "${month}"> 
<input type ="text"name = "day"placeholder="dd"size="4"value= "${date}">, 
<input type ="text"name = "year"placeholder="yyyy"size="4"value= "${year}">

Shopper Name: <input type = "text"name = "travelersName"value= "${listToEdit.traveler.travelersName}"><br />

Available Places:<br />
<select name="allItemsToAdd"multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
	<option value = "${currentitem.id}">${currentitem.country} | ${currentitem.state} | ${currentitem.city}</option>
</c:forEach>
</select>
<br />
<input type = "submit"value="Edit List and Add Items">
</form>
<a href = "index.html">Go add new items instead.</a>
</body>
</html>