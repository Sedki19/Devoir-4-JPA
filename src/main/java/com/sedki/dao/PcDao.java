package com.sedki.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.sedki.entities.Pc;
import com.sedki.util.JPAutil;

//classe contenant les méthodes génériques ajouter, supprimer,
//consulter par clé primaire (Id)
public class PcDao {
	private EntityManager entityManager = JPAutil.getEntityManager("MonProjetJPA");

//méthode ajouter d'une entité à la bd
	public void ajouter(Pc p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(p);

		tx.commit();
	}

//méthode modifier d'une entité à partir de la bd
	public void modifier(Pc p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(p);
		tx.commit();
	}

//méthode Supprimer d'une entité à partir de la bd
	public void supprimer(Pc p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		p = entityManager.merge(p); // important
		entityManager.remove(p);
		tx.commit();
	}

//méthode Consulter d'une entité à partir de la bd
	public Pc consulter(Pc p, Object id) {
		return entityManager.find(p.getClass(), id);
	}

//méthode pour lister tous les objets à partir de la bd
	public List<Pc> listerTous() {
		List<Pc> pcs = entityManager.createQuery("select p from Pc p").getResultList();

		return pcs;
	}

//méthode pour lister tous les pc dont le nom contient un
//texte donné en paramètre (pnom)
	public List<Pc> listerParNom(String nom) {
		List<Pc> pcs = entityManager.createQuery("select p from Pc p where p.nom_pc like :pnom")
				.setParameter("pnom", "%" + nom + "%").getResultList();

		return pcs;
	}
}