<%--
  Created by IntelliJ IDEA.
  User: DNAPC
  Date: 14.11.2017
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="Controller" method="post">
      <input type="hidden" name="method" value="SAX">
      <button type="submit">SAX</button>
  </form>
  <form action="Controller" method="post">
      <input type="hidden" name="method" value="StAX">
      <button type="submit">StAX</button>
  </form>
  <form action="Controller" method="post">
      <input type="hidden" name="method" value="DOM">
      <button type="submit">DOM</button>
  </form>
  </body>
</html>
