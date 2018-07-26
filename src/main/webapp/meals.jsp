<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meals</title>
</head>

<style type="text/css">
    tr.urgent td {
        background-color: red;
    }

    tr.okay td {
        background-color: green;
    }
</style>

<body>
<h3><a href="index.html">Home</a></h3>
<h2>Meals</h2>
<table>
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
    </tr>
    <c:forEach var="meal" items="${meals}">

        <c:choose>

            <c:when test="${meal.exceed==true}">
                <tr class="urgent">
                    <td>${meal.dateTime}</td>
                    <td>${meal.description}</td>
                    <td>${meal.calories}</td>
                </tr>
            </c:when>

            <c:otherwise>
                <tr class="okay">
                    <td>${meal.dateTime}</td>
                    <td>${meal.description}</td>
                    <td>${meal.calories}</td>
                </tr>
            </c:otherwise>

        </c:choose>


    </c:forEach>
</table>
</body>
</html>