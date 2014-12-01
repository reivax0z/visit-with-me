/**
 * BLOG SPECIFIC
 */

function addContent(){
	for (var i = 0; i < button.length; i++) {
		if(button[i] == false){
			showContent(i);
			button[i] = true;
			break;
		}
	}
}
function showContent(id){
	var doc = document.getElementById('content'+id);
	doc.style.display = 'block';

	nbButtons++;
	if(nbButtons == maxArticles){
		document.getElementById('buttonAddInit').style.display = 'none';
	}
	var nbRemain = maxArticles-nbButtons;
	document.getElementById('buttonAddInit').innerHTML = 'Add Content ('+nbRemain+' remaining)';
}
function removeContent(id){
	var i = parseInt(id);
	// hide + clear content
	document.getElementById('content'+i).style.display = 'none';
	document.getElementById('content_part_'+i).value = "";
	document.getElementById('title_part_'+i).value = "";
	button[i] = false;

	nbButtons--;
	var nbRemain = maxArticles-nbButtons;
	document.getElementById('buttonAddInit').innerHTML = 'Add Content ('+nbRemain+' remaining)';
	document.getElementById('buttonAddInit').style.display = 'block';
}