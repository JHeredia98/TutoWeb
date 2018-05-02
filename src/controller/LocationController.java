package controller;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Location;
public class LocationController {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private List<Location> locations;
	private Location location;

	// Constructor
	public LocationController() {
		this.emf = Persistence.createEntityManagerFactory("Tuto");
		this.em = this.emf.createEntityManager();
		this.locations = consultarLocations();
		this.location = new Location();
	}

	// Metodos Privados
	private List<Location> consultarLocations() {
		String jpql = " SELECT cat FROM Location cat ";
		Query query = this.em.createQuery(jpql);
		List<Location> locations = query.getResultList();
		return locations;
	}

	// Metodos Publicos
	
	public void crearLocation() {
		try {
			this.em.getTransaction().begin();
			this.em.persist(location);
			this.em.getTransaction().commit();
			this.em = this.emf.createEntityManager();
			this.location = new Location();
			this.locations = consultarLocations();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void seleccionarLocation(Location location) {
		this.location = location;
	}
	
	public void eliminarLocation() {
		this.location = this.locations.get(0);
		if (this.location != null) {
			try {
				
				this.em.getTransaction().begin();
				this.em.remove(location);
				this.em.getTransaction().commit();
				this.em = this.emf.createEntityManager();
				this.location = new Location();
				this.locations = consultarLocations();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
	}
	//Metodo de ejemplo.
	public void modificarLocation() {
		try {
			this.em.getTransaction().begin();
			this.em.merge(location);
			this.em.getTransaction().commit();
			this.location = new Location();
			this.locations = consultarLocations();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	

	
}
