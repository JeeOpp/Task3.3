<%--
  Created by IntelliJ IDEA.
  User: DNAPC
  Date: 16.11.2017
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Answer</title>
    <style type="text/css">
        table {
            width: 500px;
            border-collapse: collapse;
        }
        td, th {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<br/><br/>
<table border="1" align="center">
    <tr>
        <th>Name</th>
        <th>Kind</th>
        <th>Preciousness</th>
        <th>Origin</th>
        <th>Colour</th>
        <th>Clarity</th>
        <th>FaceCount</th>
        <th>Value</th>
    </tr>
    <c:forEach var="gem" items="${requestScope.entitySet}">
    <tr>
        <td>${gem.name}</td>
        <td>${gem.kind}</td>
        <td>${gem.preciousness}</td>
        <td>${gem.origin}</td>
        <td>${gem.visualParameters.colour}</td>
        <td>${gem.visualParameters.clarity}</td>
        <td>${gem.visualParameters.faceCount}</td>
        <td>${gem.value}</td>
    </tr>
    </c:forEach>
    </tr>
</table>
</body>
</html>
