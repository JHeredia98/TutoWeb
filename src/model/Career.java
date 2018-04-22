package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the career database table.
 * 
 */
@Entity
@NamedQuery(name="Career.findAll", query="SELECT c FROM Career c")
public class Career implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idCareer;

	private String level;

	private String name;

	//bi-directional many-to-one association to SubjectType
	@OneToMany(mappedBy="career")
	private List<SubjectType> subjectTypes;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="career")
	private List<User> users;

	public Career() {
	}

	public String getIdCareer() {
		return this.idCareer;
	}

	public void setIdCareer(String idCareer) {
		this.idCareer = idCareer;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SubjectType> getSubjectTypes() {
		return this.subjectTypes;
	}

	public void setSubjectTypes(List<SubjectType> subjectTypes) {
		this.subjectTypes = subjectTypes;
	}

	public SubjectType addSubjectType(SubjectType subjectType) {
		getSubjectTypes().add(subjectType);
		subjectType.setCareer(this);

		return subjectType;
	}

	public SubjectType removeSubjectType(SubjectType subjectType) {
		getSubjectTypes().remove(subjectType);
		subjectType.setCareer(null);

		return subjectType;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setCareer(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setCareer(null);

		return user;
	}

}