<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Table of meals</h2>
<table>
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
    </tr>
    <c:forEach var="meal" items="${meals}">
        <tr style="${meal.excess ? "color:red" : "color:green"}">
            <td>"${meal.dateTime}/></td>
            <td><${meal.description}/></td>
            <td><${meal.calories}/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
