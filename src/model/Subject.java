package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the subject database table.
 * 
 */
@Entity
@NamedQuery(name="Subject.findAll", query="SELECT s FROM Subject s")
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idSubject;

	private String name;

	//bi-directional many-to-one association to SubjectType
	@ManyToOne
	@JoinColumn(name="Type_idType")
	private SubjectType subjectType;

	//bi-directional many-to-one association to Topic
	@OneToMany(mappedBy="subject")
	private List<Topic> topics;

	public Subject() {
	}

	public int getIdSubject() {
		return this.idSubject;
	}

	public void setIdSubject(int idSubject) {
		this.idSubject = idSubject;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SubjectType getSubjectType() {
		return this.subjectType;
	}

	public void setSubjectType(SubjectType subjectType) {
		this.subjectType = subjectType;
	}

	public List<Topic> getTopics() {
		return this.topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public Topic addTopic(Topic topic) {
		getTopics().add(topic);
		topic.setSubject(this);

		return topic;
	}

	public Topic removeTopic(Topic topic) {
		getTopics().remove(topic);
		topic.setSubject(null);

		return topic;
	}

}