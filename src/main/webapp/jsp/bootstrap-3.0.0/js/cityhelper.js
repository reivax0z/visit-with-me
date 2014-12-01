/**
 * BLOG SPECIFIC
 */

function addVideo(){
	for (var i = 0; i < button.length; i++) {
		if(button[i] == false){
			showVideo(i);
			button[i] = true;
			break;
		}
	}
}
function showVideo(id){
	var doc = document.getElementById('video'+id);
	doc.style.display = 'block';

	nbButtons++;
	if(nbButtons == maxVideos){
		document.getElementById('buttonAddInit').style.display = 'none';
	}
	var nbRemain = maxVideos-nbButtons;
	document.getElementById('buttonAddInit').innerHTML = 'Add Video Link ('+nbRemain+' remaining)';
}
function removeVideo(id){
	var i = parseInt(id);
	document.getElementById('video'+i).style.display = 'none';
	document.getElementById('video_url_'+i).value = "";
	document.getElementById('video_desc_'+i).value = "";
	document.getElementById('video_name_'+i).value = "";
	button[i] = false;

	nbButtons--;
	var nbRemain = maxVideos-nbButtons;
	document.getElementById('buttonAddInit').innerHTML = 'Add Video Link ('+nbRemain+' remaining)';
	document.getElementById('buttonAddInit').style.display = 'block';
}

function displayCounter(input, display, limit){
	if(input.value.length>limit){
		input.value = input.value.substring(0, limit);
	}
	display.value = limit - input.value.length;
}