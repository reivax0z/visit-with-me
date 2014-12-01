<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="reivax.norac.website.dto.*" %>
<%@ page import="reivax.norac.website.util.*" %>

<%
// RETRIEVE THE MAIN OBJECT
Boolean isLogged = request.getSession().getAttribute("isLogged") != null ? (Boolean)request.getSession().getAttribute("isLogged") : Boolean.FALSE;
ArticleDTO newArticle = (ArticleDTO)request.getSession().getAttribute("newArticle");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<link href='http://fonts.googleapis.com/css?family=UnifrakturMaguntia' rel='stylesheet' type='text/css'>

    <link href="/jsp/bootstrap-3.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/jsp/bootstrap-3.0.0/examples/offcanvas/offcanvas.css" rel="stylesheet">

	<script type="text/javascript">
	var nbButtons = 0;
	var maxArticles = 10;
	var button = new Array();
	button[0] = false;
	button[1] = false;
	button[2] = false;
	button[3] = false;
	button[4] = false;
	button[5] = false;
	button[6] = false;
	button[7] = false;
	button[8] = false;
	button[9] = false;
	</script>

    <script src="/jsp/bootstrap-3.0.0/js/bloghelper.js"></script>
    
    <link rel="shortcut icon" href="<%=Commons.IMG_ICON_ADDRESS%>">

	<title>Add a new Blog Article</title>
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
            <li><a href="Blog"><span class="glyphicon glyphicon-comment"></span> Travel Blog</a></li>
            <li><a href="AboutMe"><span class="glyphicon glyphicon-question-sign"></span> About</a></li>
          </ul>
         <%@include file="includes/header_menu_admin.jsp" %>
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->
    </div><!-- /.navbar -->

    <div class="container">
    
    <%if(isLogged){ %>

      <div class="row row-offcanvas row-offcanvas-right">
        <div class="col-xs-12 col-sm-9">
          <p class="pull-right visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
          </p>
          <div class="jumbotron shadow background-grey">
            <p>Easily add a new entry by completing the following fields.</p>
          </div>
          <div class="row">
          	
          <div class="col-lg-12">

			<form role="form" action="AddArticlePreviewAction" method="post" class="shadow padding20">
			  <div class="form-group">
			    <label for="exampleInputEmail1">Article Details</label>
			    <input type="text" name="title" class="form-control" id="exampleInputEmail1" placeholder="Title" value="<%=newArticle!=null?newArticle.getTitle():""%>">
			  	<textarea name="intro" class="form-control" rows="2" placeholder="Introduction"><%=newArticle!=null?newArticle.getIntro():""%></textarea>
			  </div>
			  <%for(int i=0; i<10; i++){ 
			  ArticlePartDTO part = (newArticle!=null && newArticle.getArticleParts()!=null && newArticle.getArticleParts().size()>i)?newArticle.getArticleParts().get(i):null;
			  %>
			  <div class="form-group" id="content<%=i %>" <%if(part==null){ %>style="display:none"<%} %>>
        		<input type="text" name="part_id_<%=i %>" value="<%=part!=null?part.getId():0%>" style="display:none">
			    <label for="content_<%=i%>">Content nb <%=i+1 %></label>
			    <input type="text" name="title_part_<%=i%>" class="form-control" id="title_part_<%=i%>" placeholder="Title" value="<%=part!=null?part.getTitle():""%>">
 				<textarea name="content_part_<%=i%>" class="form-control" rows="5" placeholder="Content" id="content_part_<%=i%>"><%=part!=null?part.getBody():""%></textarea>
 				<button type="button" class="btn btn-default" onclick="removeContent('<%=i%>')">Remove Content</button>
			  </div>
			  <%} %>
			  <button type="button" class="btn btn-default" id="buttonAddInit" onclick="addContent()">Add Content (<%=(newArticle!=null && newArticle.getArticleParts()!=null)?""+(10-newArticle.getArticleParts().size()):"10" %> remaining)</button>
			  
			  <div class="form-group">
			    <label for="exampleInputEmail1">Conclusion</label>
 				<textarea name="conclusion" class="form-control" rows="2" placeholder="Conclusion"><%=newArticle!=null?newArticle.getConclusion():""%></textarea>
			  </div>			  
			  
			  <hr>
			  <button type="submit" class="btn btn-primary" style="float: right;">Preview Article</button>
			  <br>
			</form>
			</div>
			
			</div>
			</div>
			
			</div>
			
	<%} %>
			
     <jsp:include page="includes/footer.html"></jsp:include>
     
</body>
</html>