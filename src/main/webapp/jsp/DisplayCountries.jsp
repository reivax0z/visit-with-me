<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="reivax.norac.website.dto.*" %>
<%@ page import="reivax.norac.website.util.*" %>

<%
// RETRIEVE THE MAIN OBJECT
List<CountriesVisitedDTO> countries = (List<CountriesVisitedDTO>) request.getAttribute("countries");
Boolean isLogged = request.getSession().getAttribute("isLogged") != null ? (Boolean)request.getSession().getAttribute("isLogged") : Boolean.FALSE;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="title" content="Visit with Me - Travels">
<meta name="description" content="Visit with Me - Travel tips and a traveller blog">
<meta name="keywords" content="Xavier CARON, travel, blog">
<title>Visit with Me - Travels</title>


	<link href='http://fonts.googleapis.com/css?family=UnifrakturMaguntia' rel='stylesheet' type='text/css'>

    <link href="/jsp/bootstrap-3.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/jsp/bootstrap-3.0.0/examples/offcanvas/offcanvas.css" rel="stylesheet">
    
    <link rel="shortcut icon" href="<%=Commons.IMG_ICON_ADDRESS%>">
    
    <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>

	<script type="text/javascript">
		// Global variable for Google Maps API
		var positions = new Array();
		var countriesArray = new Array();
		
	</script>
	
	<%
		for(CountriesVisitedDTO c: countries){
			double lat = c.getLatitude();
			double lon = c.getLongitude();
			String name = c.getName();%>
			<script type="text/javascript">positions.push(new google.maps.LatLng(<%=lat%>, <%=lon%>));</script>
			<script type="text/javascript">countriesArray.push('<%=name%>');</script>
		<%
		}
	%>

</head>
<body onload="initializeMapCountries(positions, countriesArray, 2)">
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
		  <div class="row">
            <div class="col-lg-12">
              <div class="shadow padding10">
                <div id="map_countries" style="height:500px;"></div>
              </div>
            </div>
          </div>
          
          <div class="row">
          <%
          for(CountriesVisitedDTO country : countries){
          %>
            <div class="col-6 col-sm-6 col-lg-6">
			<div class="shadow">
			  <div style="padding:5px">
			   <div style="background: url('http://flagpedia.net/data/flags/normal/<%=country.getIso().toLowerCase() %>.png') no-repeat center;
			                            background-size: cover; height: 150px;">
			   </div>
			  </div> 
			  <div class="padding10" style="padding-bottom:10px;padding-left:10px;padding-right:10px;">
              <h2><%=country.getName() %></h2>
              <p><%=country.getInfo() %></p>
              <a class="btn btn-primary" href="CountryDetailsAction?country=<%= country.getName() %>">
              	More Details
              </a>
	          <hr>
              
              
            <div class="row">
              <%
              for(CitiesVisitedDTO city : country.getCities()){
              %>
              
             <div class="col-6 col-xs-12 col-sm-6 col-lg-6">
              <a href="CityDetailsAction?city=<%= city.getName() %>">
				<div class="thumbnail shadow" style="background-color:#ECECEC">
				  <img src="http://xavier.w.caron.free.fr/website/resources/img/<%=country.getName().toLowerCase() %>/<%= city.getName().toLowerCase() %>/cover/cover.JPG">
				  <div class="caption">
				    <h4 style="text-align:center"><%= city.getName() %></h4>
				  </div>
				</div>
			  </a>
			  </div>
              <%
              }
              %>
              </div>
			<%if(isLogged){ %>
	        <hr>
	        <form action="AddNewCountryFormAction" method="post">
	        	<input type="text" name="id" value="<%=country.getId()%>" style="display:none">
	        	<button type="submit" class="btn btn-primary">Edit</button>
	        </form>
	        <%} %>
	         </div>
            </div><!--/span-->
            </div>
          <%
          }
          %>
          </div><!--/row-->
          
        </div><!--/span-->

        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
              <div>
          <div class="sidebar-nav padding10">
           <h3>Travel Tips</h3>
            
             <%@include file="includes/right_block_cities.jsp" %>
            
          </div><!--/.well -->
          </div>
        </div><!--/span-->
      </div><!--/row-->

     <jsp:include page="includes/footer.html"></jsp:include>
  </body>
</html>
