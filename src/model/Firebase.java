package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the firebase database table.
 * 
 */
@Entity
@NamedQuery(name="Firebase.findAll", query="SELECT f FROM Firebase f")
public class Firebase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idFirebase;

	private String idRealTime;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="firebase")
	private List<User> users;

	public Firebase() {
	}

	public int getIdFirebase() {
		return this.idFirebase;
	}

	public void setIdFirebase(int idFirebase) {
		this.idFirebase = idFirebase;
	}

	public String getIdRealTime() {
		return this.idRealTime;
	}

	public void setIdRealTime(String idRealTime) {
		this.idRealTime = idRealTime;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setFirebase(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setFirebase(null);

		return user;
	}

}