package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the cost database table.
 * 
 */
@Entity
@NamedQuery(name="Cost.findAll", query="SELECT c FROM Cost c")
public class Cost implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idCost;

	private BigDecimal cost;

	//bi-directional many-to-one association to Tutorship
	@OneToMany(mappedBy="cost")
	private List<Tutorship> tutorships;

	public Cost() {
	}
	
	public Cost(String idCost, BigDecimal cost, List<Tutorship> tutorships) {
		super();
		this.idCost = idCost;
		this.cost = cost;
		this.tutorships = tutorships;
	}

	public String getIdCost() {
		return this.idCost;
	}

	public void setIdCost(String idCost) {
		this.idCost = idCost;
	}

	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public List<Tutorship> getTutorships() {
		return this.tutorships;
	}

	public void setTutorships(List<Tutorship> tutorships) {
		this.tutorships = tutorships;
	}

	public Tutorship addTutorship(Tutorship tutorship) {
		getTutorships().add(tutorship);
		tutorship.setCost(this);

		return tutorship;
	}

	public Tutorship removeTutorship(Tutorship tutorship) {
		getTutorships().remove(tutorship);
		tutorship.setCost(null);

		return tutorship;
	}

}