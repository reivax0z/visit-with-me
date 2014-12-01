package reivax.norac.website.caches;

import java.util.Date;
import java.util.List;
import java.util.Map;

import reivax.norac.website.dto.FlickrPhotosDTO;
import reivax.norac.website.utilities.FlickrHelper;

public class FlickrPhotoCache {
	
	private Date lastSync = null;
	
	private static FlickrPhotoCache instance = new FlickrPhotoCache();
	
	public static FlickrPhotoCache getInstance(){
		return instance;
	}
	
	protected Map<String, List<FlickrPhotosDTO>> elements;
	
	public Map<String, List<FlickrPhotosDTO>> getAll(){
		if(elements == null || elements.isEmpty()){
			refreshAll();
		}
		return elements;
	}
	
	public void refreshAll(){
		elements = FlickrHelper.getURLsFromFlickr();
		lastSync = new Date();
	}
	
	public Date getLastSync(){
		return lastSync;
	}
	
	public int getSize(){
		return elements == null?0:elements.size();
	}
	
	public String getName(){
		return "Flickr Photo cache";
	}
}
