package reivax.norac.website.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.ManyToOne;


/**
 * The persistent class for the article_part database table.
 * 
 */
@Entity
@Table(name="article_part")
@NamedQuery(name="ArticlePart.findAll", query="SELECT a FROM ArticlePart a")
public class ArticlePart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String body;

	private String title;

	//bi-directional many-to-one association to Article
	@ManyToOne
	private Article article;

	public ArticlePart() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}