<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ page import="reivax.norac.website.util.*" %>

<%
// RETRIEVE THE MAIN OBJECT
Boolean isLogged = request.getSession().getAttribute("isLogged") != null ? (Boolean)request.getSession().getAttribute("isLogged") : Boolean.FALSE;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="description" content="Visit with Me - Travel tips and a traveller blog">
<meta name="keywords" content="Xavier CARON, travel, blog">
<title>Visit with Me - Rest Services</title>

	<link href='http://fonts.googleapis.com/css?family=Yesteryear|UnifrakturMaguntia' rel='stylesheet' type='text/css'>

    <link href="/jsp/bootstrap-3.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/jsp/bootstrap-3.0.0/examples/offcanvas/offcanvas.css" rel="stylesheet">
    
    <link rel="shortcut icon" href="<%=Commons.IMG_ICON_ADDRESS%>">
	
    <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
	
	<script type="text/javascript">
		// Global variable for Google Maps API
		var position = new google.maps.LatLng(-37.820698, 144.957393);
	</script>
	
    <!-- Gravatar API -->
    <script src="/jsp/bootstrap-3.0.0/js/gravatarhelper.js"></script>
	
</head>
<body onload="initializeMapPosition(position, 3)">
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
            <li><a href="About"><span class="glyphicon glyphicon-question-sign"></span> About</a></li>
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
            <h1>Rest Services</h1>
            <p>You can find here links to the Rest services available for this website.</p>
          </div>
          <div class="row">
            <div class="col-12 col-sm-12 col-lg-12" style="text-align:justify;">
              <div class="shadow padding20">
              <h2>Services available</h2>
              <ul>
              <li><a href="./rest/countries">List of Countries</a></li>
              <li><a href="./rest/cities">List of Cities</a></li>
              <li><a href="./rest/articles">List of Articles</a></li>
              </ul>
              </div>
            </div><!--/span-->
        </div><!--/span-->
      </div><!--/row-->

     </div><!--/row-->

     <jsp:include page="includes/footer.html"></jsp:include>
     
     <script src="http://en.gravatar.com/xavierwcaron.json?callback=getGravatar" type="text/javascript"></script>
    
  </body>
</html>
