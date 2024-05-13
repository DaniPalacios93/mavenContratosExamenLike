package mavenContratosExamenLike.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import mavenContratosExamenLike.entities.Entidad;




public class SuperControladorJPA {
	
	private String unidadDePersistencia = "papeleria";
	
	private EntityManager em = null;
	private String nombreTabla ="";
	private Class tipoEntidad;
	

	
	
	//==================== CONSTRUCTORS ===========================//
	
	public SuperControladorJPA (String nombreTabla, Class tipoEntidad) {
		this.nombreTabla = nombreTabla;
		this.tipoEntidad = tipoEntidad;
	}
	
	
	
	//====================== MANAGER =============================//
	
	//Protected, para que las subclases tengan visibilidad sobre este metodo. 
	//Singleton para que solo haya un EntityManager en el programa
	protected EntityManager getEntityManager () {
		if(em == null) {
			em =  Persistence.createEntityManagerFactory(unidadDePersistencia).createEntityManager();
		}
		return em;
	}
	
	
	

	//====================== FINDERS ============================//
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Entidad findById(int id) {
		try {
			
			EntityManager em = getEntityManager();
			Entidad entidad = (Entidad) em.find(this.tipoEntidad, id);
			return entidad;
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Esto devuelve una lista de cualquier objeto que extienda de entidad
	 * COmo a la query le metemos como segundo argumento el "tipoEntidad" la lista resiltante sera de ese tipo.
	 * @return
	 */
	public List<? extends Entidad> findAll (){
		return getEntityManager().createNativeQuery("SELECT * FROM " + this.nombreTabla, this.tipoEntidad).getResultList();
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Entidad findFirst () {
		try {
			EntityManager em = getEntityManager();
			
			return (Entidad) em.createNativeQuery(
					"SELECT * FROM " + this.nombreTabla + " ORDER BY id ASC LIMIT 1", this.tipoEntidad).getSingleResult();
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	/**
	 * 
	 * @return
	 */
	public Entidad findLast () {
		try {
			EntityManager em = getEntityManager();
			return (Entidad) em.createNativeQuery(
					"SELECT * FROM " + this.nombreTabla + " ORDER BY id DESC LIMIT 1", this.tipoEntidad).getSingleResult();
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	/**
	 * 
	 * @return
	 */
	public Entidad findNext (Entidad e) {
		try {
			EntityManager em = getEntityManager();
			return (Entidad) em.createNativeQuery(
					"SELECT * FROM " + this.nombreTabla + " WHERE id > " + e.getId() +
					" ORDER BY id ASC LIMIT 1", this.tipoEntidad).getSingleResult();
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public Entidad findPrevious (Entidad e) {
		try {
			EntityManager em = getEntityManager();
			return (Entidad) em.createNativeQuery(
					"SELECT * FROM " + this.nombreTabla + " WHERE id < " + e.getId() +
					" ORDER BY id DESC LIMIT 1", this.tipoEntidad).getSingleResult();
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	
	
	//================= DATABASE MODIFIERS ====================//
	
	/**
	 * 
	 * @param e
	 */
	public void updateEntidad (Entidad e) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}
	
	/**
	 * 
	 */
	public void deleteEntidad (Entidad e) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
	}
	
	/**
	 * 
	 */
	public void insertEntidad (Entidad e) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	/**
	 * 
	 * @param e
	 */
	public void save(Entidad e) {
		
		if (e.getId() != 0) {
			updateEntidad(e);
		}
		else {
			insertEntidad(e);
		}
	}
	
	
}
