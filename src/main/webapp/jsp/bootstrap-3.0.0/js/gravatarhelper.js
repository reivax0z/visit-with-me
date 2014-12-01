/**
 * 
 */

function getGravatar(avatarSource){
	
	document.getElementById('about_me_summary').innerHTML = avatarSource.entry[0].aboutMe;
	document.getElementById('about_me_picture').src = avatarSource.entry[0].thumbnailUrl;
	document.getElementById('about_me_currentLocation').innerHTML = avatarSource.entry[0].currentLocation;
	document.getElementById('about_me_website').href = avatarSource.entry[0].urls[0].value;
//	document.getElementById('about_me_website').innerHTML = avatarSource.entry[0].urls[0].title;
}