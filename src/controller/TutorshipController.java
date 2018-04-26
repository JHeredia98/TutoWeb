package controller;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Subject;

public class TutorshipController {

	private EntityManagerFactory emf;
	private EntityManager em;
	private List<Subject> subjects;
	private Subject subject;
	private String palabraClave;
	private Date date;

	// Constructor
	public TutorshipController() {
		this.emf = Persistence.createEntityManagerFactory("Tuto");
		this.em = this.emf.createEntityManager();
		this.subjects = consultarSubjects();
		this.subject = new Subject();
	}

	// Metodos Privados
	private List<Subject> consultarSubjects() {
		String jpql = " SELECT cat FROM Subject cat ";
		Query query = this.em.createQuery(jpql);
		List<Subject> categorias = query.getResultList();
		return categorias;
	}

	// Metodos Publicos
	public void crearCategoria(Subject categoria) {
		try {
			this.em.getTransaction().begin();
			this.em.persist(categoria);
			this.em.getTransaction().commit();
			this.em = this.emf.createEntityManager();
			this.subject = new Subject();
			this.subjects = consultarSubjects();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

	/*public void eliminarCategoria() {
		this.categoria = this.categorias.get(0);
		if (this.subject != null) {
			try {
				
				this.em.getTransaction().begin();
				this.em.remove(categoria);
				this.em.getTransaction().commit();
				this.em = this.emf.createEntityManager();
				this.categoria = new Categoria();
				this.categorias = consultarSubjects();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
	}

	//Metodo de ejemplo.
	public void modificarCategoria(Categoria categoria) {
		try {
			this.em.getTransaction().begin();
			this.em.merge(categoria);
			this.em.getTransaction().commit();
			this.categoria = new Categoria();
			this.categorias = consultarSubjects();
		} catch (Exception e) {
			System.out.println(e);
		}
	}*/

	
	
	
}
