package src;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ProsjektDAO {

	private EntityManagerFactory emf;

	public ProsjektDAO() {
		emf = Persistence.createEntityManagerFactory("oblig3dat107_jpa");
	}

	public Prosjekt finnProsjektMedId(int prosjektid) {

		EntityManager em = emf.createEntityManager();

		Prosjekt prosjekt = null;
		try {
			prosjekt = em.find(Prosjekt.class, prosjektid);
		} finally {
			em.close();
		}
		return prosjekt;
	}
	
	
	
	public List<Prosjekt> hentAlleProsjekt() {

		EntityManager em = emf.createEntityManager();
		String jpqlQuery = "SELECT p FROM Prosjekt as p order by p.prosjektid";

		try {
			TypedQuery<Prosjekt> query = em.createQuery(jpqlQuery, Prosjekt.class);
			return query.getResultList(); // Henter ut basert på spørring
		} finally {
			em.close();
		}
	}

	public void lagreProsjekt(Prosjekt p) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(p); // Oppretter en ny rad i databasen
			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

	public void oppdaterProsjekt(Prosjekt p) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.merge(p); // Oppretter en ny rad i databasen
			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	

}
