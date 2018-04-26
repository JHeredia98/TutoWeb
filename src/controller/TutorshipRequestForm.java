package controller;

import java.util.ArrayList;
import java.util.List;

import model.Location;
import model.Subject;
import model.SubjectType;
import model.Topic;
import model.Tutorship;

public class TutorshipRequestForm {
	
	private List<Subject> subjects;
	
	private List<String> stringSubject;
	
	public TutorshipRequestForm() {
		super();
		this.subjects = new ArrayList<>();
		this.stringSubject = new ArrayList<>();
		for (Subject subject : subjects) {
			stringSubject.add(subject.getName());
		}
	}
	
	public List<String> getStringSubject() {
		return stringSubject;
	}

	public void setStringSubject(List<String> stringSubject) {
		this.stringSubject = stringSubject;
	}

	public void createTutorship() {
		
	}
}