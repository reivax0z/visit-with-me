package reivax.norac.website.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CountriesVisitedDTO {

	private int id;
	private String name;
	private String info;
	private String iso;
	private List<CitiesVisitedDTO> cities;
	private List<MustSeeDTO> mustSees;
	
	private Double latitude;
	private Double longitude;
	
	private List<FlickrPhotosDTO> photosList;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public List<CitiesVisitedDTO> getCities() {
		return cities;
	}
	public void setCities(List<CitiesVisitedDTO> cities) {
		this.cities = cities;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public List<FlickrPhotosDTO> getPhotosList() {
		return photosList;
	}
	public void setPhotosList(List<FlickrPhotosDTO> photosList) {
		this.photosList = photosList;
	}
	public String getIso() {
		return iso;
	}
	public void setIso(String iso) {
		this.iso = iso;
	}
	
	public List<MustSeeDTO> getMustSees() {
		return mustSees;
	}
	public void setMustSees(List<MustSeeDTO> mustSees) {
		this.mustSees = mustSees;
	}
	@Override
	public int hashCode(){
		return id;
	}
	
	@Override
	public boolean equals(Object o){
		return o instanceof CountriesVisitedDTO && ((CountriesVisitedDTO)o).getId() == id;
	}
}
