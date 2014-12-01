package reivax.norac.website.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import java.util.List;

import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String info;

	private String name;
	
	private BigDecimal latitude;
	
	private BigDecimal longitude;
	
	private String iso;

	//bi-directional many-to-one association to City
	@OneToMany(mappedBy="country")
	private List<City> cities;

	//bi-directional many-to-one association to Mustsee
	@OneToMany(mappedBy="country")
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE, CascadeType.MERGE, CascadeType.DELETE_ORPHAN})
	private List<Mustsee> mustsees;
	
	public Country() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<City> getCities() {
		return this.cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public City addCity(City city) {
		getCities().add(city);
		city.setCountry(this);

		return city;
	}

	public City removeCity(City city) {
		getCities().remove(city);
		city.setCountry(null);

		return city;
	}
	
	public List<Mustsee> getMustsees() {
		return this.mustsees;
	}

	public void setMustsees(List<Mustsee> mustsees) {
		this.mustsees = mustsees;
	}

	public Mustsee addMustsees(Mustsee mustsee) {
		getMustsees().add(mustsee);
		mustsee.setCountry(this);

		return mustsee;
	}

	public Mustsee removeMustsees(Mustsee mustsee) {
		getMustsees().remove(mustsee);
		mustsee.setCountry(null);

		return mustsee;
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

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

}