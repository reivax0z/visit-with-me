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
<meta name="description" content="Xavier CARON Resume">
<meta name="keywords" content="Xavier CARON, resume, curriculum vitae">
<title>Xavier CARON - Resum&eacute;</title>

	<link href='http://fonts.googleapis.com/css?family=Yesteryear|UnifrakturMaguntia' rel='stylesheet' type='text/css'>


    <link href="/jsp/bootstrap-3.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/jsp/bootstrap-3.0.0/examples/offcanvas/offcanvas.css" rel="stylesheet">
    
    <link rel="shortcut icon" href="<%=Commons.IMG_ICON_ADDRESS%>">
	
    <!-- Gravatar API -->
    <script src="/jsp/bootstrap-3.0.0/js/gravatarhelper.js"></script>
	
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
          <a class="navbar-brand" href="Home">Xavier Caron</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active" style="font-family: 'Yesteryear', cursive;font-size: 20px;"><a href="#">Profile</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
  			<li style="font-family: 'Yesteryear', cursive;font-size: 20px;"><a href="#" style="color:black;">Software Engineer</a></li>
  		  </ul>
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
            <h1>Summary</h1>
            <p id="about_me_summary"></p>
		  </div>
		  
		  <div class="page-header">
	      	<h1><span class="glyphicon glyphicon-tag"></span> Work Experiences</h1>
		  </div>
		  
          <div class="row">
            <div class="col-12">
              <div class="shadow padding20">
              <h2>Software Engineering Consultant </h2>
              <h3><a href="http://www.airfrance.com">Air France</a> <small>Oct 2013 - Feb 2014</small></h3>
              <p>Working on the B2C (Business-to-Consumer) e-commerce internet site www.airfrance.com which allows users to book / cancel / modify their flights and membership information. The web site is developed in Java JEE and uses web services to call other third-party applications, such as Amadeus.</p>
				<ul>
				<li>The maintenance tasks on this project allowed me to work in cooperation with the business team and the incident team based in Paris.</li>
				<li>Worked in pair with another engineer to develop a new feature on the website.</li></ul>
              </div>
            </div><!--/span-->
            
            <div class="col-12">
              <div class="shadow padding20">
              <h2>Software Engineering Consultant</h2>
              <h3><a href="http://www.amundi.com">Amundi Asset Management</a> <small>Oct 2011 - Oct 2013</small></h3>
			  <p>Working on the OMS (Order Management System) of the Amundi Asset Management company, which enables traders and managers to create / send / place / integrate orders through the financial environment (via fix protocol for instance).</p>
				<ul>
				<li>Development of new important features on the application, including a new order creation process for the London branch, a constraints system fed by daily batch and a pre-trade constraints monitoring tool</li>
				<li>Improvement of the application performances by developing a configurable stress test and monitoring regressions via Unit Tests and continuous integration (JProfiler, Hudson)</li>
				<li>Other activities include many evolutions and bug fixes on the software (both Client and Server side), support team for the production technical problems and system trainer of new teammates</li></ul>
            </div>
            </div>
          	
          	<div class="col-12">
              <div class="shadow padding20">
              <h2>Software Engineer Intern</h2>
              <h3><a href="http://www.misys.com">Misys</a> <small>Mar 2011 - Sep 2011</small></h3>
              <p>Working inside the GUI team of the Kondor+ Software (Trade and Risk Management System).</p>
				<ul>
				<li>Development of a configuration upgrading tool which aimed at tracing all the graphical evolution that appeared between 2 versions of the company software's product and update the users configurations regarding those changes, since the users could build their own personal interfaces.</li>
				<li>The tool is now used by both the engineering teams and the end user. </li></ul>
              </div>
            </div><!--/span-->
            
            <div class="col-12">
              <div class="shadow padding20">
              <h2>Student Software Developer</h2>
              <h3><a href="http://www.statpro.com">StatPro</a> <small>Sep 2010 - Feb 2011</small></h3>
              <p>Contributing, as a study project, to the open-source financial library Quantlib.</p>
				<ul>
				<li>Development of pricers for exotic options.</li>
				<li>Implementation of a pricing engine for spread options.</li>
				<li>Development of a specific user interface (GUI) for pricing simulations.</li></ul>
              </div>
            </div><!--/span-->
          </div><!--/row-->

		  <div class="page-header">
	      	<h1><span class="glyphicon glyphicon-book"></span> Education</h1>
		  </div>
		  
		  <div class="row">
            <div class="col-12">
              <div class="shadow padding20">
              <h2>Master of Information Systems</h2>
              <h3><a href="http://www.unimelb.edu.au">University of Melbourne</a> <small>2014</small></h3>
              <p>This 1-year Master's degree in Information Systems (MIS) focuses on developing strong capability in supporting, managing and changing business processes through information and communications technology and information systems.</p>
              </div>
            </div><!--/span-->
            
            <div class="col-12">
              <div class="shadow padding20">
              <h2>Master of Software Engineering</h2>
              <h3><a href="http://www.unice.fr">Universit&eacute; de Nice-Sophia Antipolis</a> <small>2006 - 2011</small></h3>
			  <p>A 5-year engineering degree, composed of: 
			  <ul>
					<li>a 4-year Bachelor's degree with a major in Computer Science, followed by</li> 
					<li>a 1-year Master's degree in Software Engineering & Mathematics applied to Finance.</li></ul>
            </div>
            </div>
            
            <div class="col-12">
              <div class="shadow padding20">
              <h2>International Student Exchange</h2>
              <h3><a href="http://www.tcd.ie">Trinity College Dublin</a> <small>2009 - 2010</small></h3>
              <p>Computer Software Engineering. Grade "First".</p>
              </div>
            </div><!--/span-->
            
          </div>
        </div><!--/span-->
		
        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
          <div>
          	<div class="sidebar-nav padding10">
  				<img id="about_me_picture" alt="Profile Picture" src="<%= Commons.IMG_PROFILE_ADDRESS %>" width="100px" height="100px" style="margin:auto" class="img-responsive img-circle">
	 			<p style="text-align:center;" >
	 				<a href="http://au.linkedin.com/in/xavierwilfriddimitrycaron">
      		          <img src="http://s.c.lnkd.licdn.com/scds/common/u/img/webpromo/btn_liprofile_blue_80x15.png" width="80" height="15" border="0" alt="View Xavier CARON's profile on LinkedIn">
        		    </a>
   	   			</p>
 			</div>
		  </div>
          <div>
          	<div class="sidebar-nav padding10" style="text-align:center">	
            	<h3><span class="glyphicon glyphicon-bullhorn"></span> Languages</h3>
	            <p>French: Mother tongue</p>
				<p>English: Fluent - IELTS 8</p>
				<p>German: Limited working proficiency</p>
				<hr>
				<h3><span class="glyphicon glyphicon-flash"></span> Programming Skills</h3>
				<p>Oracle Certified Java SE 6 Programmer</p>
				<p>Web (HTML 5, CSS 3, Javascript, jQuery)</p>
				<p>Android, SQL, C++, C#, PHP, Unix</p>
            </div>
          <!--/.well -->
          </div>
        </div>
      </div><!--/row-->

     <jsp:include page="includes/footer.html"></jsp:include>
     
     <script src="http://en.gravatar.com/xavierwcaron.json?callback=getGravatar" type="text/javascript"></script>
    
  </body>
</html>
