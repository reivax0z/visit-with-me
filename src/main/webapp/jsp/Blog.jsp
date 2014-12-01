<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="reivax.norac.website.dto.ArticleDTO" %>
<%@ page import="reivax.norac.website.util.*" %>

<%
// RETRIEVE THE MAIN OBJECT
List<ArticleDTO> articles = (List<ArticleDTO>) request.getAttribute("blogArticles");
Boolean isLogged = request.getSession().getAttribute("isLogged") != null ? (Boolean)request.getSession().getAttribute("isLogged") : Boolean.FALSE;
Integer nbMaxArticleDisplay = (Integer)request.getAttribute("nbMaxArticleDisplay");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="description" content="Visit with Me - Travel tips and a traveller blog">
<meta name="keywords" content="Xavier CARON, travel, blog">
<title>Visit with Me - Blog</title>


	<link href='http://fonts.googleapis.com/css?family=UnifrakturMaguntia' rel='stylesheet' type='text/css'>

    <link href="/jsp/bootstrap-3.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/jsp/bootstrap-3.0.0/examples/offcanvas/offcanvas.css" rel="stylesheet">
    
    <link rel="shortcut icon" href="<%=Commons.IMG_ICON_ADDRESS%>">

</head>
<body>
	<div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Visit with Me</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="Home"><span class="glyphicon glyphicon-globe"></span> Travel Tips</a></li>
            <li class="active"><a href="#"><span class="glyphicon glyphicon-comment"></span> Travel Blog</a></li>
            <li><a href="AboutMe"><span class="glyphicon glyphicon-question-sign"></span> About</a></li>
          </ul>
         <%@include file="includes/header_menu_admin.jsp" %>
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->
    </div><!-- /.navbar -->

    <div class="container">

      <div class="row row-offcanvas row-offcanvas-right">
        <div class="col-xs-12 col-sm-9">
          <p class="pull-right visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
          </p>
          <div class="jumbotron shadow background-grey">
            <h1>Travel Blog</h1>
            <p>This section is dedicated to give you my feedback about my daily experiences overseas.</p>
            <p>I'll try to keep it updated as much as I can.</p>
          </div>
          <div class="row">
          <%
          for(int i=0; i<Math.min(articles.size(), nbMaxArticleDisplay); i++){
        	  ArticleDTO article = articles.get(articles.size()-1-i);
          %>
            <div class="col-6 col-sm-12 col-lg-4">
              <div class="shadow padding20">
              <h2><%=article.getTitle() %></h2>
              <h4><%=article.getDate() %></h4>
              <p><%=article.getIntro() %></p>
              <p><a class="btn btn-default" href="ArticleDetailsAction?date=<%=article.getDate() %>">Read the full article</a></p>
            </div><!--/span-->
            </div>
          <%
          }
          %>
          </div><!--/row-->
        </div><!--/span-->

       <jsp:include page="includes/right_block_blog.jsp"></jsp:include>

     <jsp:include page="includes/footer.html"></jsp:include>
  </body>
</html>
