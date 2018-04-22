package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the subject_type database table.
 * 
 */
@Entity
@Table(name="subject_type")
@NamedQuery(name="SubjectType.findAll", query="SELECT s FROM SubjectType s")
public class SubjectType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idType;

	private String name;

	//bi-directional many-to-one association to Subject
	@OneToMany(mappedBy="subjectType")
	private List<Subject> subjects;

	//bi-directional many-to-one association to Career
	@ManyToOne
	private Career career;

	public SubjectType() {
	}

	public String getIdType() {
		return this.idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Subject> getSubjects() {
		return this.subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Subject addSubject(Subject subject) {
		getSubjects().add(subject);
		subject.setSubjectType(this);

		return subject;
	}

	public Subject removeSubject(Subject subject) {
		getSubjects().remove(subject);
		subject.setSubjectType(null);

		return subject;
	}

	public Career getCareer() {
		return this.career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}

}