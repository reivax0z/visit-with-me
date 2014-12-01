package reivax.norac.website.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TopFiveDTO {

	private int id;
	
	private String description;

	private String inbrief;

	private String name;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInbrief() {
		return inbrief;
	}

	public void setInbrief(String inbrief) {
		this.inbrief = inbrief;
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
