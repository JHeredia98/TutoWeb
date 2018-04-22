package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the topic database table.
 * 
 */
@Entity
@NamedQuery(name="Topic.findAll", query="SELECT t FROM Topic t")
public class Topic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idTopic;

	private String complexity;

	private String name;

	//bi-directional many-to-one association to Subject
	@ManyToOne
	private Subject subject;

	//bi-directional many-to-one association to Tutorship
	@OneToMany(mappedBy="topic")
	private List<Tutorship> tutorships;

	public Topic() {
	}

	public String getIdTopic() {
		return this.idTopic;
	}

	public void setIdTopic(String idTopic) {
		this.idTopic = idTopic;
	}

	public String getComplexity() {
		return this.complexity;
	}

	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<Tutorship> getTutorships() {
		return this.tutorships;
	}

	public void setTutorships(List<Tutorship> tutorships) {
		this.tutorships = tutorships;
	}

	public Tutorship addTutorship(Tutorship tutorship) {
		getTutorships().add(tutorship);
		tutorship.setTopic(this);

		return tutorship;
	}

	public Tutorship removeTutorship(Tutorship tutorship) {
		getTutorships().remove(tutorship);
		tutorship.setTopic(null);

		return tutorship;
	}

}