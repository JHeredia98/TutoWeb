package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user_type database table.
 * 
 */
@Entity
@Table(name="user_type")
@NamedQuery(name="UserType.findAll", query="SELECT u FROM UserType u")
public class UserType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idUser_Type;

	private byte type;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="userType")
	private List<User> users;

	public UserType() {
	}
	
	public UserType(String idUser_Type, byte type, List<User> users) {
		super();
		this.idUser_Type = idUser_Type;
		this.type = type;
		this.users = users;
	}

	public String getIdUser_Type() {
		return this.idUser_Type;
	}

	public void setIdUser_Type(String idUser_Type) {
		this.idUser_Type = idUser_Type;
	}

	public byte getType() {
		return this.type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setUserType(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setUserType(null);

		return user;
	}

}