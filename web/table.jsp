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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
</head>
<body>
<br/><br/>
    <div class="container" align="center">
    <table class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th>Id</th>
            <th>Kind</th>
            <th>Preciousness</th>
            <th>Origin</th>
            <th>Colour</th>
            <th>Clarity</th><th>FaceCount</th>
            <th>Value</th>
        </tr>
        </thead>
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
    </table>
    <table>
        <tr>
            <c:forEach begin="1" end="${requestScope.countPages}" var="i">
                <c:choose>
                    <c:when test="${requestScope.currentPage eq i}">
                        <td><h1>${i}</h1>></td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="/Controller?page=${i}"><h1>${i}</h1>></a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
    </div>
</body>
</html>
