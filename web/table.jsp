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
            border-collapse: collapse;
        }
        td, th {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<br/><br/>
    <table border="1" width="500" align="center">
        <tr>
            <th>Id</th>
            <th>Kind</th>
            <th>Preciousness</th>
            <th>Origin</th>
            <th>Colour</th>
            <th>Clarity</th><th>FaceCount</th>
            <th>Value</th>
        </tr>
        <c:forEach var="gem" items="${requestScope.gemSetToPage}">
        <tr>
            <td>${gem.id}</td>
            <td>${gem.kind}</td>
            <td>${gem.preciousness}</td>
            <td>${gem.origin}</td>
            <td>${gem.visualParameters.colour}</td>
            <td>${gem.visualParameters.clarity}</td>
            <td>${gem.visualParameters.faceCount}</td>
            <td>${gem.value}</td>
        </tr>
    </c:forEach>
    <table>
        <tr>
            <c:forEach begin="1" end="${requestScope.countPages}" var="i">
                <c:choose>
                    <c:when test="${requestScope.currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="/Controller?page=${i}"><h1>${i}</h1>></a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
</body>
</html>
