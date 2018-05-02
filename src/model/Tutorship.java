package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tutorship database table.
 * 
 */
@Entity
@NamedQuery(name="Tutorship.findAll", query="SELECT t FROM Tutorship t")
public class Tutorship implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTutorship;

	private double cost;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String genero;

	private String latitude;

	private String longitude;

	private String motive;

	private int rating;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timeStamp;

	//bi-directional many-to-one association to Status
	@ManyToOne
	private Status status;

	//bi-directional many-to-one association to Topic
	@ManyToOne
	private Topic topic;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="User_idUser")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="Tuto_TutoId")
	private User user2;

	public Tutorship() {
	}

	public int getIdTutorship() {
		return this.idTutorship;
	}

	public void setIdTutorship(int idTutorship) {
		this.idTutorship = idTutorship;
	}

	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getMotive() {
		return this.motive;
	}

	public void setMotive(String motive) {
		this.motive = motive;
	}

	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getTimeStamp() {
		return this.timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

}