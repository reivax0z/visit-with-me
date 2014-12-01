package reivax.norac.website.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the mustsee database table.
 * 
 */
@Entity
@NamedQuery(name="Mustsee.findAll", query="SELECT m FROM Mustsee m")
public class Mustsee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to City
	@ManyToOne
	private Country country;

	private String description;

	private String inbrief;

	private String name;

	public Mustsee() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInbrief() {
		return this.inbrief;
	}

	public void setInbrief(String inbrief) {
		this.inbrief = inbrief;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}