package src;

import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class AvdelingDAO {

	private static EntityManagerFactory emf;

	public AvdelingDAO() {
		emf = Persistence.createEntityManagerFactory("oblig3dat107_jpa");
	}

	public static  Avdeling finnAvdelingMedId(int avdelingid) {

		EntityManager em = emf.createEntityManager();

		Avdeling avdeling = null;
		try {
			avdeling = em.find(Avdeling.class, avdelingid);
		} finally {
			em.close();
		}
		
		
		
		
		return avdeling;
	}
	
	
	
	public List<Avdeling> hentAlleAvdelinger() {

		EntityManager em = emf.createEntityManager();
		String jpqlQuery = "SELECT p FROM Avdeling as p order by p.avdelingid";

		try {
			TypedQuery<Avdeling> query = em.createQuery(jpqlQuery, Avdeling.class);
			return query.getResultList(); // Henter ut basert på spørring
		} finally {
			em.close();
		}
	}
	
	public void lagreAvdeling(Avdeling p) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(p); // 
			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

	public void oppdaterAvdeling(Avdeling p) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.merge(p); // 
			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}


}
