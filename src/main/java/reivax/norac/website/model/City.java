package reivax.norac.website.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import java.util.List;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


/**
 * The persistent class for the city database table.
 * 
 */
@Entity
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	private BigDecimal latitude;
	
	private BigDecimal longitude;
	
	private String didyouknow;

	private String info;

	//bi-directional many-to-one association to Country
	@ManyToOne
	private Country country;

	private BigDecimal area;

	private String currency;

	private String established;

	private String languages;

	private String population;

	private String timezone;

	//bi-directional many-to-one association to Topfive
	@OneToMany(mappedBy="city")
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE, CascadeType.MERGE, CascadeType.DELETE_ORPHAN})
	private List<Topfive> topfives;

	//bi-directional many-to-one association to Video
	@OneToMany(mappedBy="city")
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE, CascadeType.MERGE, CascadeType.DELETE_ORPHAN})
	private List<Video> videos;

	public City() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Topfive> getTopfives() {
		return this.topfives;
	}

	public void setTopfives(List<Topfive> topfives) {
		this.topfives = topfives;
	}

	public Topfive addTopfive(Topfive topfive) {
		getTopfives().add(topfive);
		topfive.setCity(this);

		return topfive;
	}

	public Topfive removeTopfive(Topfive topfive) {
		getTopfives().remove(topfive);
		topfive.setCity(null);

		return topfive;
	}

	public List<Video> getVideos() {
		return this.videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public Video addVideo(Video video) {
		getVideos().add(video);
		video.setCity(this);

		return video;
	}

	public Video removeVideo(Video video) {
		getVideos().remove(video);
		video.setCity(null);

		return video;
	}

	public String getDidyouknow() {
		return didyouknow;
	}

	public void setDidyouknow(String didyouknow) {
		this.didyouknow = didyouknow;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getEstablished() {
		return established;
	}

	public void setEstablished(String established) {
		this.established = established;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

}