package reivax.norac.website.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VideoDTO {

	private int id;
	
	private String description;

	private String link;

	private String name;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
