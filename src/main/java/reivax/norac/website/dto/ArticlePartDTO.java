package reivax.norac.website.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ArticlePartDTO {

	private int id;

	private String body;

	private String title;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode(){
		return id;
	}
	
	@Override
	public boolean equals(Object o){
		return o instanceof ArticlePartDTO && ((ArticlePartDTO)o).getId() == id;
	}
}
