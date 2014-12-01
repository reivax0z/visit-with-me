/**
 * 
 */

//Global variables
var map;

function initializeMapPosition(position, zoomVal) {
	// Init the map
	var myOptions = {
			zoom: zoomVal,
			center: position,
			mapTypeId: google.maps.MapTypeId.ROADMAP
	};

	map = new google.maps.Map(document.getElementById('map_position'), myOptions);
	addLocation(position);
}

function initializeEditMapPosition(position, zoomVal) {
	// Init the map
	var myOptions = {
			zoom: zoomVal,
			center: position,
			mapTypeId: google.maps.MapTypeId.ROADMAP
	};

	map = new google.maps.Map(document.getElementById('map_position'), myOptions);
	addEditLocation(position);
}

function addEditLocation(position){
	// Get coordinates
	var options = {
			position: position
	};
	var marker = new google.maps.Marker(options);
	
	google.maps.event.addListener(map, 'click', function(event) {
      document.getElementById('latitude').value = event.latLng.lat();
      document.getElementById('longitude').value = event.latLng.lng();
      
      var pos = new google.maps.LatLng(event.latLng.lat(), event.latLng.lng());
      
      options = {
  			position: pos
  	  };
	  marker.setMap(null);
  	  marker = new google.maps.Marker(options);
  	  marker.setMap(map);
    });

	// Show marker on map
	marker.setMap(map);
}

function initializeMapCountries(positions, countries, zoomVal) {
	var sumLat = 0;
	var sumLong = 0;
	for (var i = 0; i < positions.length; i++) {
		sumLat+=positions[i].lat();
		sumLong+=positions[i].lng();
	}
	sumLat/=positions.length;
	sumLong/=positions.length;
	var centerPos = new google.maps.LatLng(sumLat, sumLong);
	
	// Init the map
	var myOptions = {
			zoom: zoomVal,
			center: centerPos,
			mapTypeId: google.maps.MapTypeId.ROADMAP
	};

	map = new google.maps.Map(document.getElementById('map_countries'), myOptions);
	
	// delegate it with a parameter containing all the positions
	for (var i = 0; i < positions.length; i++) {
		addLocationAndLink(positions[i], countries[i]);
	}
}

function addLocationAndLink(pos, link){
	// Get coordinates
	var options = {
			position: pos,
			title: link
	};
	var marker = new google.maps.Marker(options);
	
	google.maps.event.addListener(marker, 'click', function() {
      window.location.href = "CountryDetailsAction?country="+marker.title;
    });

	// Show marker on map
	marker.setMap(map);
}

function addLocation(pos){
	// Get coordinates
	var options = {
			position: pos
	};
	var marker = new google.maps.Marker(options);

	// Show marker on map
	marker.setMap(map);
	bounce(marker);
}

function bounce(marker) {
	// Is the marker already animating?
	if (marker.getAnimation()) {
		marker.setAnimation(null);
	} else {
		// Make it bounce!
		marker.setAnimation(google.maps.Animation.BOUNCE);
	}
}