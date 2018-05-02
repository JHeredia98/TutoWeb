package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the location database table.
 * 
 */
@Entity
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idLocation;

	private String description;

	private String latitude;

	private String longitude;

	//bi-directional many-to-one association to LocationHasUser
	@OneToMany(mappedBy="location")
	private List<LocationHasUser> locationHasUsers;

	public Location() {
	}

	public int getIdLocation() {
		return this.idLocation;
	}

	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public List<LocationHasUser> getLocationHasUsers() {
		return this.locationHasUsers;
	}

	public void setLocationHasUsers(List<LocationHasUser> locationHasUsers) {
		this.locationHasUsers = locationHasUsers;
	}

	public LocationHasUser addLocationHasUser(LocationHasUser locationHasUser) {
		getLocationHasUsers().add(locationHasUser);
		locationHasUser.setLocation(this);

		return locationHasUser;
	}

	public LocationHasUser removeLocationHasUser(LocationHasUser locationHasUser) {
		getLocationHasUsers().remove(locationHasUser);
		locationHasUser.setLocation(null);

		return locationHasUser;
	}

}