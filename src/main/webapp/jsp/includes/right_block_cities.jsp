<%@ page import="java.util.*" %>
<%@ page import="reivax.norac.website.dto.*" %>

<div class="list-group">
<%
for(CountriesVisitedDTO country_it : countries){
%>
  <a class="list-group-item active" href="CountryDetailsAction?country=<%=country_it.getName() %>"><span class="glyphicon glyphicon-map-marker"></span> <%=country_it.getName() %></a></li>
  <%
  for(CitiesVisitedDTO city_it : country_it.getCities()){
  %>
  <a class="list-group-item" style="padding-left:30px" href="CityDetailsAction?city=<%= city_it.getName() %>"><span class="glyphicon glyphicon-zoom-in"></span> <%=city_it.getName() %></a></li>
  <%
  }
}
%>
</div>