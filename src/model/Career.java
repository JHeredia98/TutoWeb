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
	private int idCareer;

	private String level;

	private String name;

	//bi-directional many-to-one association to SubjectType
	@OneToMany(mappedBy="career")
	private List<SubjectType> subjectTypes;

	//bi-directional many-to-one association to UserHasCareer
	@OneToMany(mappedBy="career")
	private List<UserHasCareer> userHasCareers;

	public Career() {
	}

	public int getIdCareer() {
		return this.idCareer;
	}

	public void setIdCareer(int idCareer) {
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

	public List<UserHasCareer> getUserHasCareers() {
		return this.userHasCareers;
	}

	public void setUserHasCareers(List<UserHasCareer> userHasCareers) {
		this.userHasCareers = userHasCareers;
	}

	public UserHasCareer addUserHasCareer(UserHasCareer userHasCareer) {
		getUserHasCareers().add(userHasCareer);
		userHasCareer.setCareer(this);

		return userHasCareer;
	}

	public UserHasCareer removeUserHasCareer(UserHasCareer userHasCareer) {
		getUserHasCareers().remove(userHasCareer);
		userHasCareer.setCareer(null);

		return userHasCareer;
	}

}