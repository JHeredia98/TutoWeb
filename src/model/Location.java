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
	private String idLocation;

	private String latitude;

	private String longitude;

	//bi-directional many-to-one association to LocationHasUser
	@OneToMany(mappedBy="location", cascade= {CascadeType.PERSIST})
	private List<LocationHasUser> locationHasUsers;

	//bi-directional many-to-one association to Tutorship
	@OneToMany(mappedBy="location", cascade= {CascadeType.PERSIST})
	private List<Tutorship> tutorships;

	public Location() {
	}
	
	public Location(String idLocation, String latitude, String longitude) {
		super();
		this.idLocation = idLocation;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Location(String idLocation, String latitude, String longitude, List<LocationHasUser> locationHasUsers,
			List<Tutorship> tutorships) {
		super();
		this.idLocation = idLocation;
		this.latitude = latitude;
		this.longitude = longitude;
		this.locationHasUsers = locationHasUsers;
		this.tutorships = tutorships;
	}

	public String getIdLocation() {
		return this.idLocation;
	}

	public void setIdLocation(String idLocation) {
		this.idLocation = idLocation;
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

	public List<Tutorship> getTutorships() {
		return this.tutorships;
	}

	public void setTutorships(List<Tutorship> tutorships) {
		this.tutorships = tutorships;
	}

	public Tutorship addTutorship(Tutorship tutorship) {
		getTutorships().add(tutorship);
		tutorship.setLocation(this);

		return tutorship;
	}

	public Tutorship removeTutorship(Tutorship tutorship) {
		getTutorships().remove(tutorship);
		tutorship.setLocation(null);

		return tutorship;
	}

}