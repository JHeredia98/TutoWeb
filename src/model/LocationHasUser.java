package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the location_has_user database table.
 * 
 */
@Entity
@Table(name="location_has_user")
@NamedQuery(name="LocationHasUser.findAll", query="SELECT l FROM LocationHasUser l")
public class LocationHasUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idLocation_has_user;

	//bi-directional many-to-one association to Location
	@ManyToOne
	private Location location;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public LocationHasUser() {
	}

	public String getIdLocation_has_user() {
		return this.idLocation_has_user;
	}

	public void setIdLocation_has_user(String idLocation_has_user) {
		this.idLocation_has_user = idLocation_has_user;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}