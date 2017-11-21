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
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
      <title>$Title$</title>
  </head>
  <body>
  <div align="center">
      <br><br>
  <form action="Controller" method="post">
      <input type="hidden" name="method" value="SAX">
      <button class="col-3 btn btn-primary" type="submit">SAX</button>
  </form>
  <form action="Controller" method="post">
      <input type="hidden" name="method" value="StAX">
      <button class="col-3 btn btn-primary" type="submit">StAX</button>
  </form>
  <form action="Controller" method="post">
      <input type="hidden" name="method" value="DOM">
      <button class="col-3 btn btn-primary" type="submit">DOM</button>
  </form>
  </div>


  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

  </body>
</html>
