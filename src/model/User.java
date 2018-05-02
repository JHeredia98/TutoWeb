package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUser;

	private String email;

	private String lastName;

	private String name;

	private String password;

	private String userLiveLocationLatitude;

	private String userLiveLocationLongitude;

	private String username;

	//bi-directional many-to-one association to LocationHasUser
	@OneToMany(mappedBy="user")
	private List<LocationHasUser> locationHasUsers;

	//bi-directional many-to-one association to Tutorship
	@OneToMany(mappedBy="user1")
	private List<Tutorship> tutorships1;

	//bi-directional many-to-one association to Tutorship
	@OneToMany(mappedBy="user2")
	private List<Tutorship> tutorships2;

	//bi-directional many-to-one association to Firebase
	@ManyToOne
	private Firebase firebase;

	//bi-directional many-to-one association to UserType
	@ManyToOne
	@JoinColumn(name="User_Type_idUser_Type")
	private UserType userType;

	//bi-directional many-to-one association to UserHasCareer
	@OneToMany(mappedBy="user")
	private List<UserHasCareer> userHasCareers;

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserLiveLocationLatitude() {
		return this.userLiveLocationLatitude;
	}

	public void setUserLiveLocationLatitude(String userLiveLocationLatitude) {
		this.userLiveLocationLatitude = userLiveLocationLatitude;
	}

	public String getUserLiveLocationLongitude() {
		return this.userLiveLocationLongitude;
	}

	public void setUserLiveLocationLongitude(String userLiveLocationLongitude) {
		this.userLiveLocationLongitude = userLiveLocationLongitude;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<LocationHasUser> getLocationHasUsers() {
		return this.locationHasUsers;
	}

	public void setLocationHasUsers(List<LocationHasUser> locationHasUsers) {
		this.locationHasUsers = locationHasUsers;
	}

	public LocationHasUser addLocationHasUser(LocationHasUser locationHasUser) {
		getLocationHasUsers().add(locationHasUser);
		locationHasUser.setUser(this);

		return locationHasUser;
	}

	public LocationHasUser removeLocationHasUser(LocationHasUser locationHasUser) {
		getLocationHasUsers().remove(locationHasUser);
		locationHasUser.setUser(null);

		return locationHasUser;
	}

	public List<Tutorship> getTutorships1() {
		return this.tutorships1;
	}

	public void setTutorships1(List<Tutorship> tutorships1) {
		this.tutorships1 = tutorships1;
	}

	public Tutorship addTutorships1(Tutorship tutorships1) {
		getTutorships1().add(tutorships1);
		tutorships1.setUser1(this);

		return tutorships1;
	}

	public Tutorship removeTutorships1(Tutorship tutorships1) {
		getTutorships1().remove(tutorships1);
		tutorships1.setUser1(null);

		return tutorships1;
	}

	public List<Tutorship> getTutorships2() {
		return this.tutorships2;
	}

	public void setTutorships2(List<Tutorship> tutorships2) {
		this.tutorships2 = tutorships2;
	}

	public Tutorship addTutorships2(Tutorship tutorships2) {
		getTutorships2().add(tutorships2);
		tutorships2.setUser2(this);

		return tutorships2;
	}

	public Tutorship removeTutorships2(Tutorship tutorships2) {
		getTutorships2().remove(tutorships2);
		tutorships2.setUser2(null);

		return tutorships2;
	}

	public Firebase getFirebase() {
		return this.firebase;
	}

	public void setFirebase(Firebase firebase) {
		this.firebase = firebase;
	}

	public UserType getUserType() {
		return this.userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public List<UserHasCareer> getUserHasCareers() {
		return this.userHasCareers;
	}

	public void setUserHasCareers(List<UserHasCareer> userHasCareers) {
		this.userHasCareers = userHasCareers;
	}

	public UserHasCareer addUserHasCareer(UserHasCareer userHasCareer) {
		getUserHasCareers().add(userHasCareer);
		userHasCareer.setUser(this);

		return userHasCareer;
	}

	public UserHasCareer removeUserHasCareer(UserHasCareer userHasCareer) {
		getUserHasCareers().remove(userHasCareer);
		userHasCareer.setUser(null);

		return userHasCareer;
	}

}