<%@ page import="reivax.norac.website.util.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    
    <link rel="shortcut icon" href="<%=Commons.IMG_ICON_ADDRESS%>">

    <title>Signin Form</title>

    <!-- Bootstrap core CSS -->
    <link href="/jsp/bootstrap-3.0.0/dist/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/jsp/bootstrap-3.0.0/examples/signin/signin.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">

      <form class="form-signin" action="LoginAction" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" name="login" class="form-control" placeholder="Login" autofocus>
        <input type="password" name="password" class="form-control" placeholder="Password">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->
  </body>
</html>