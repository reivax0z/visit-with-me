<%@page import="org.apache.commons.net.ftp.FTPFile"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="org.apache.commons.net.ftp.*" %>
<%@ page import="reivax.norac.website.dto.*" %>
<%@ page import="reivax.norac.website.util.*" %>

<%
// RETRIEVE THE MAIN OBJECT
List<CountriesVisitedDTO> countries = (List<CountriesVisitedDTO>) request.getAttribute("countries");
CountriesVisitedDTO country = (CountriesVisitedDTO) request.getSession().getAttribute("newCountry");
if(country == null){
	country = (CountriesVisitedDTO) request.getAttribute("country");
}
Boolean isLogged = request.getSession().getAttribute("isLogged") != null ? (Boolean)request.getSession().getAttribute("isLogged") : Boolean.FALSE;
Boolean isEditMode = request.getSession().getAttribute("isEditMode") != null ? (Boolean)request.getSession().getAttribute("isEditMode") : Boolean.FALSE;
List<FlickrPhotosDTO> photosUrls = country.getPhotosList();

String folder = Commons.FTP_PATH_TO_IMG + Commons.SEPARATOR + country.getName().toLowerCase() + Commons.SEPARATOR;
String webLink = Commons.SITE_ADDRESS + folder;
String folderTop = folder + Commons.PATH_TOP;
String webLinkTop = Commons.SITE_ADDRESS + folderTop;
String backgroundImg = "http://flagpedia.net/data/flags/normal/"+country.getIso().toLowerCase()+".png";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="title" content="Visit with Me - <%=country.getName() %>">
<meta name="description" content="<%=country.getInfo()%>">
<meta name="keywords" content="Xavier CARON, travel, blog">
<title>Visit with Me - <%=country.getName() %></title>


	<link href='http://fonts.googleapis.com/css?family=UnifrakturMaguntia' rel='stylesheet' type='text/css'>

    <link href="/jsp/bootstrap-3.0.0/examples/carousel/carousel.css" rel="stylesheet">
    <link href="/jsp/bootstrap-3.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/jsp/bootstrap-3.0.0/examples/offcanvas/offcanvas.css" rel="stylesheet">
    
    <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
    
    <link rel="shortcut icon" href="<%=Commons.IMG_ICON_ADDRESS%>">
	
	<script type="text/javascript">
		// Global variable for Google Maps API
		var position = new google.maps.LatLng(<%=country.getLatitude()%>, <%=country.getLongitude()%>);
	</script>

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
            <li class="active"><a href="#"><span class="glyphicon glyphicon-globe"></span> Travel Tips</a></li>
            <li><a href="Blog"><span class="glyphicon glyphicon-comment"></span> Travel Blog</a></li>
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
          
          <!-- TOP CONTENT -->
          
      <section id="id_top">
      	<ol class="breadcrumb">
		  <li><a href="Home">Travel Tips</a></li>
		  <li class="active"><%=country.getName() %></li>
		</ol>
		
		<div style="position:relative;">
	        <div class="shadow" style="background: url('<%=backgroundImg %>') no-repeat center;background-size: cover;height: 400px;">
		  	</div>
		    <div class="headline_title">
		  		<h1 style="color:black;"><%=country.getName() %></h1>
		  	</div>
	  	</div>
	  </section>
	  
	  <!-- /END TOP CONTENT -->
	  
	  <section id="id_intro">
	      <div class="page-header">
	      	<h1><span class="glyphicon glyphicon-info-sign"></span> About <%=country.getName() %></h1>
		  </div>
	          
          <div class="row">
          	<div class="col-md-12 col-sm-12">
          	<div class="shadow padding20">
            <h2>Info</h2>
              <p><%= country.getInfo() %></p>
              <p><a class="btn btn-large btn-info" href="#id_pictures">Check Photos of <%= country.getName() %></a></p>
            </div>
            </div>
            
<!--           	<div class="col-md-6 col-sm-12"> -->
<!--             <div class="shadow padding20"> -->
<!--             <h2>Did You Know?</h2> -->
<%--               <p><%= city.getDidYouKnow() %></p> --%>
<%--               <p><a class="btn btn-large btn-info" href="#id_videos">Watch Videos of <%= city.getName() %></a></p> --%>
<!--           	</div> -->
<!--           	</div> -->
          </div>
      </section>


	  <!-- FEATURETTES -->

	  <section id="id_top_5">
	  
	  <div class="page-header">
      	<h1><span class="glyphicon glyphicon-eye-open"></span> Must See</h1>
	  </div>
	  
	  <div class="col-md-12">
	  
 	  <% 
	  int currIteration = 1;
 	  
 	  if(country.getMustSees() != null && !country.getMustSees().isEmpty()){
	  
 		  for(MustSeeDTO mustSee : country.getMustSees()){
	  %>
	  
      <div class="row shadow padding20">
      <% 
      if(currIteration%2 == 0){ 
      %>
        <div class="col-md-7">
          <h2 class="featurette-heading">Must-Do n&deg;<%=currIteration %>: <span class="text-muted"><%= mustSee.getName() %></span></h2>
          <p class="lead"><%= mustSee.getInbrief() %></p>
		  <p class="lead"><%= mustSee.getDescription() %></p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive" src="<%=webLinkTop + currIteration + Commons.IMG_EXTENSION %>" alt="<%=mustSee.getName()%>">
        </div>
      <%
      }else{ 
      %>
        <div class="col-md-5">
          <img class="featurette-image img-responsive" src="<%=webLinkTop + currIteration + Commons.IMG_EXTENSION %>" alt="<%=mustSee.getName()%>">
        </div>
        <div class="col-md-7">
          <h2 class="featurette-heading">Must-Do n&deg;<%=currIteration %>: <span class="text-muted"><%= mustSee.getName() %></span></h2>
          <p class="lead"><%= mustSee.getInbrief() %></p>
		  <p class="lead"><%= mustSee.getDescription() %></p>
        </div>
        <%
        } // close else
        %>
      </div>

      <%
      currIteration++;
      } // close for
 	  }else{
      %>
      
      <div class="row shadow padding20">
      <p>Coming soon...</p>
      </div>
      <%} %>
      </div>

	</section>
	

      <!-- /END FEATURETTES -->
      
       <!-- CITIES GALLERY -->
	  
	  <section id="id_videos">
	  <div class="page-header">
		<h1><span class="glyphicon glyphicon-map-marker"></span> City Focus</h1>
		</div>
		
		<div class="col-md-12">
	  
		<% 
		for(CitiesVisitedDTO c : country.getCities()){
		%>
		  <div class="row shadow padding10">
			  <div class="col-md-9 col-sm-12">
			    <div class="media">
				  <div style="background:url(http://xavier.w.caron.free.fr/website/resources/img/<%=country.getName().toLowerCase() %>/<%= c.getName().toLowerCase() %>/cover/cover.JPG) no-repeat 50% 75%;background-size:cover;height:315px"></div>
			  	</div>
			  </div>
			  <div class="col-md-3 col-sm-12">
				<div class="media-body">
					<h3 class="media-heading"><%=c.getName() %></h3>
					<p><%=c.getInfo() %></p>
	    			<a class="btn btn-large btn-info" href="CityDetailsAction?city=<%= c.getName() %>">More Details</a>
				 </div>
			  </div>
		  </div>
	  <%
	  }
	  %>
	  </div>
	  </section>
	  
	  <!-- /END CITIES GALLERY -->
	  
	  
	  <!-- PICTURE GALLERY -->
	  
	  <section id="id_pictures">
		
		<div class="page-header">
		<h1><span class="glyphicon glyphicon-picture"></span> Countryside Gallery</h1>
	  </div>
	  
	  <%
		if(photosUrls != null){%>
		
	    <div class="row">
		<%	
		for(FlickrPhotosDTO entry: photosUrls){			
 		%>
		<div class="col-sm-12 col-md-6">
		  <div class="thumbnail shadow">
            <img class="img-rounded" src="<%= entry.getUrl() %>" alt="<%= entry.getCaption() %>">
            <div class="caption">
		 	  <h3><%= entry.getCaption() %></h3>
		    </div>
		  </div>
        </div>
        <%}	%>
		</div>
		<%} else{%>
		
		<div class="col-md-12">
	      <div class="row shadow padding20">
	      <p>Coming soon...</p>
	      </div>
        </div>
		<%} %>

	  </section>
	  
      <!-- /END PICTURE GALLERY -->
	  
	  
        <%if(isLogged){ %>
	        <hr>
	        <form action="AddNewCountryFormAction" method="post">
	        	<input type="text" name="id" value="<%=country.getId()%>" style="display:none">
	        	<button type="submit" class="btn btn-primary">Edit</button>
	        </form>
	        <%if(isEditMode){ %>
        	<form action="AddCountryAction" method="post">
	        	<button type="submit" class="btn btn-primary" style="float: right;">Save Modifications</button>
	        </form>
	        <%} %>
        <%} %>
	  
	  </div><!--/span-->

        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
              <div>
          <div class="sidebar-nav padding10">
          	<h3>Overview</h3>
            <div id="map_position" style="height: 200px;"></div>
            <hr>
            <h3>Check also</h3>
            
            <%@include file="includes/right_block_cities.jsp" %>
            
          </div><!--/.well -->
        </div><!--/span-->
        </div>
      </div><!--/row-->

      <!-- FOOTER -->
      
      <jsp:include page="includes/footer.html"></jsp:include>
      
      <!-- /END FOOTER -->
</body>
</html>