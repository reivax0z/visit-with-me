<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="reivax.norac.website.dto.*" %>
<%@ page import="reivax.norac.website.util.*" %>

<%
// RETRIEVE THE MAIN OBJECT
List<ArticleDTO> articles = (List<ArticleDTO>) request.getAttribute("articles");
String month = (String)request.getAttribute("month");
Boolean isLogged = request.getSession().getAttribute("isLogged") != null ? (Boolean)request.getSession().getAttribute("isLogged") : Boolean.FALSE;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="title" content="Travel Blog - <%=month%> - <%=articles.get(0).getTitle()%>">
<meta name="description" content="<%=articles.get(0).getIntro()%>">
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
          <a class="navbar-brand" href="Home">Visit with Me</a>
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
          
          <ol class="breadcrumb">
		  <li><a href="Blog">Travel Blog</a></li>
		  <li class="active"><%=articles.get(0).getDate() %></li>
		  </ol>
          
          <%
          for(ArticleDTO article : articles){
          %>
          <div class="row">
            <div class="col-lg-12">
             <div class="shadow">
	          <div class="jumbotron shadow background-grey">
	            <h1><%=article.getTitle() %></h1>
	            <h2><%=article.getDate() %></h2>
	            <p><%=article.getIntro() %></p>
	          </div>
	          <div class="padding20">
	          <%
	          for(ArticlePartDTO part : article.getArticleParts()){
	          %>
	          <div class="row"  style="text-align:justify;">
	            <div class="col-lg-12">
	          	<h2><%=part.getTitle() %></h2>
	          	<p><%=part.getBody() %></p>
	          	</div>
	          </div><!--/row-->
	          <%
	          }
	          %>
	          <div class="row" style="text-align:justify;">
	            <div class="col-lg-12">
	          	<h2>Conclusion</h2>
	          	<p><%=article.getConclusion() %></p>
	          	</div>
	          </div>
	         </div>
	         </div>
           </div>
          </div>
          <hr>
          <%
          }
          %>
        </div><!--/span-->
        
       <jsp:include page="includes/right_block_blog.jsp"></jsp:include>

     <jsp:include page="includes/footer.html"></jsp:include>
  </body>
</html>
