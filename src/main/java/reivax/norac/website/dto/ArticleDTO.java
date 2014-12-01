package reivax.norac.website.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ArticleDTO {

	private int id;

	private String conclusion;

	private String date;

	private String intro;

	private String title;
	
	private List<ArticlePartDTO> articleParts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<ArticlePartDTO> getArticleParts() {
		return articleParts;
	}

	public void setArticleParts(List<ArticlePartDTO> articleParts) {
		this.articleParts = articleParts;
	}
	
	@Override
	public int hashCode(){
		return id;
	}
	
	@Override
	public boolean equals(Object o){
		return o instanceof ArticleDTO && ((ArticleDTO)o).getId() == id;
	}
}
