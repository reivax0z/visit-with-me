package reivax.norac.website.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FlickrPhotosDTO {

	private String url;
	private String caption;

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String cpation) {
		this.caption = cpation;
	}
}
