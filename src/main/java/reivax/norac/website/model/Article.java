package reivax.norac.website.model;

import java.io.Serializable;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


/**
 * The persistent class for the article database table.
 * 
 */
@Entity
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String conclusion;

	private String date;

	private String intro;

	private String title;

	//bi-directional many-to-one association to ArticlePart
	@OneToMany(mappedBy="article")
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE, CascadeType.MERGE, CascadeType.DELETE_ORPHAN})
	private List<ArticlePart> articleParts;

	public Article() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConclusion() {
		return this.conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<ArticlePart> getArticleParts() {
		return this.articleParts;
	}

	public void setArticleParts(List<ArticlePart> articleParts) {
		this.articleParts = articleParts;
	}

	public ArticlePart addArticlePart(ArticlePart articlePart) {
		getArticleParts().add(articlePart);
		articlePart.setArticle(this);

		return articlePart;
	}

	public ArticlePart removeArticlePart(ArticlePart articlePart) {
		getArticleParts().remove(articlePart);
		articlePart.setArticle(null);

		return articlePart;
	}

}