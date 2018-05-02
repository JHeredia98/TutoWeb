package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_has_career database table.
 * 
 */
@Entity
@Table(name="user_has_career")
@NamedQuery(name="UserHasCareer.findAll", query="SELECT u FROM UserHasCareer u")
public class UserHasCareer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUser_has_Career;

	//bi-directional many-to-one association to Career
	@ManyToOne
	private Career career;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public UserHasCareer() {
	}

	public int getIdUser_has_Career() {
		return this.idUser_has_Career;
	}

	public void setIdUser_has_Career(int idUser_has_Career) {
		this.idUser_has_Career = idUser_has_Career;
	}

	public Career getCareer() {
		return this.career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}