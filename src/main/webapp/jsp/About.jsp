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
<title>Visit with Me - About</title>

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
            <li class="active"><a href="#"><span class="glyphicon glyphicon-question-sign"></span> About</a></li>
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
            <h1>Why this website?</h1>
            <p>To communicate my passion for travels.</p>
            <p>At the same time, I use this website to keep up-to-date with software 
            engineering technologies.</p>
          </div>
          <div class="row">
            <div class="col-6 col-sm-12 col-lg-6" style="text-align:justify;">
              <div class="shadow padding20">
              <h2>About me</h2>
              <p id="about_me_summary"></p>
              <p>You can find my detailed online resume here:
              <a href="http://au.linkedin.com/in/xavierwilfriddimitrycaron" target="_blank">My Resum&eacute;</a></p>
              </div>
            </div><!--/span-->
            <div class="col-6 col-sm-12 col-lg-6" style="text-align:justify;">
              <div class="shadow padding20">
              <h2>My passions / Interests?</h2>
              <p>Long story short: sports, travels & technology.</p>
              <ul>
              <li>Tennis</li>
              <li>Travels</li>
              <li>Landscape Photography</li>
              <li>Guitar</li>
              <li>Software Engineering</li>
              <li>Internet of Things</li>
              <li>Knowledge Management</li>
              </ul>
            </div>
            </div>
          </div>
          <div class="row">
          	<div class="col-6 col-sm-12 col-lg-6" style="text-align:justify;">
              <div class="shadow padding20">
              <h2>Technologies used</h2>
              <p>This website uses Glassfish Server, with EJB for the back end DB management, 
              JSP for the front end. It uses Hibernate as the DB framework and plans to use 
              Struts are underway.
              </p>
              <p>The website also uses Maven for compiling and dependencies, the 
              integration is done using Jenkins and the versioning is done via Git.
              The deployment / hosting is on <a href="http://www.heroku.com/">Heroku</a>.</p>
              <p>The CSS design and responsiveness is based on the Bootstrap framework.
              I've also used the Google Maps API, following a workshop provided by Google 
              in my university as well as the Flickr Rest API and Gravatar API.</p>
              </div>
            </div><!--/span-->
            <div class="col-6 col-sm-12 col-lg-6" style="text-align:justify;">
              <div class="shadow padding20">
              <h2>Other Projects</h2>
              <p>I have developed different small projects on my free time, including:</p>
			  <ul>
              <li>Address Book - Search, Manage and Compare</li>
              <li>Interview Preparation - Upload your Questions and Rehearse</li>
              <li>Public BBQ in Melbourne - Locate them and get Directions</li>
              <li>Weekend Planner - Top 10 Places: Restaurants, Attractions and Pubs</li>
              </ul>
              <p>For more details, please visit my <a href="http://xavier.w.caron.free.fr/" target="_blank">personal webpage</a>.</p>
              </div>
            </div><!--/span-->
          </div><!--/row-->
        </div><!--/span-->

		<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
          <div>
          	<div class="sidebar-nav padding10" style="text-align:center;">
          		<h3 style="font-family: 'Yesteryear', cursive;">Xavier Caron</h3>        	
  				<img id="about_me_picture" alt="Profile Picture" src="<%= Commons.IMG_PROFILE_ADDRESS %>" width="100px" height="100px" style="margin:auto" class="img-responsive img-circle">
 			</div>
		  </div>
          <div>
          	<div class="sidebar-nav padding10" style="text-align:center;">	
            	<h3>Where am I now?</h3>
	            <p id="about_me_currentLocation"></p>
	            <div id="map_position" style="height: 200px;"></div>
            </div>
          <!--/.well -->
          </div>
        </div>
      </div><!--/row-->

     <jsp:include page="includes/footer.html"></jsp:include>
     
     <script src="http://en.gravatar.com/xavierwcaron.json?callback=getGravatar" type="text/javascript"></script>
    
  </body>
</html>
