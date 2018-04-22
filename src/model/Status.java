package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the status database table.
 * 
 */
@Entity
@NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idStatus;

	private String description;

	//bi-directional many-to-one association to Tutorship
	@OneToMany(mappedBy="status")
	private List<Tutorship> tutorships;

	public Status() {
	}

	public String getIdStatus() {
		return this.idStatus;
	}

	public void setIdStatus(String idStatus) {
		this.idStatus = idStatus;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Tutorship> getTutorships() {
		return this.tutorships;
	}

	public void setTutorships(List<Tutorship> tutorships) {
		this.tutorships = tutorships;
	}

	public Tutorship addTutorship(Tutorship tutorship) {
		getTutorships().add(tutorship);
		tutorship.setStatus(this);

		return tutorship;
	}

	public Tutorship removeTutorship(Tutorship tutorship) {
		getTutorships().remove(tutorship);
		tutorship.setStatus(null);

		return tutorship;
	}

}