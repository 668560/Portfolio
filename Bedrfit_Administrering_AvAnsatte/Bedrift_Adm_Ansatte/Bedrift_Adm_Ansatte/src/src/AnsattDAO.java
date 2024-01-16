package src;

import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class AnsattDAO {

	private EntityManagerFactory emf;

	public AnsattDAO() {
		emf = Persistence.createEntityManagerFactory("oblig3dat107_jpa");
			//	,Map.of("jakarta.persistence.jdbc.password", "pass")
				
	}

	
	public void lagreAnsatt(Ansatt p) {

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
	

	public void oppdaterAnsatt(Ansatt p) {

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

	
	public Ansatt hentAnsattId(int ansattid) {
		Ansatt a;
		EntityManager em = emf.createEntityManager();

		try {
			 a= em.find(Ansatt.class, ansattid); // Henter ut på primærnøkkel
		} finally {
			em.close();
		}
		return a;
	}
	
	
	/*
	 * public Ansatt hentBrukernavn(String brukernavn) { Ansatt a; EntityManager em
	 * = emf.createEntityManager();
	 * 
	 * try { a= em.find(Ansatt.class, brukernavn); // Henter ut på primærnøkkel }
	 * finally { em.close(); } return a; }
	 */
	
	
	
	public Ansatt hentBrukernavn(String brukernavn) {
		Ansatt a;
		
		EntityManager em = emf.createEntityManager();
		String jpqlQuery = "SELECT p FROM Ansatt as p  WHERE p.brukernavn ='" + brukernavn +"'";

		try {
			TypedQuery<Ansatt> query = em.createQuery(jpqlQuery, Ansatt.class);
			return query.getResultList().get(0); // Henter ut basert på spørring
		} finally {
			em.close();
		}
	}
	
	
	
	
	public List<Ansatt> hentAlleAnsatte() {

		EntityManager em = emf.createEntityManager();
		String jpqlQuery = "SELECT p FROM Ansatt as p order by p.brukernavn";

		try {
			TypedQuery<Ansatt> query = em.createQuery(jpqlQuery, Ansatt.class);
			return query.getResultList(); // Henter ut basert på spørring
		} finally {
			em.close();
		}
	}

	public List<Ansatt> hentAlleAnsattePaaAvdeling(int avdelingId) {

		EntityManager em = emf.createEntityManager();
		String jpqlQuery = "SELECT p FROM Ansatt as p WHERE p.avdelingid ='"+avdelingId + "'" + " order by p.brukernavn";

		try {
			TypedQuery<Ansatt> query = em.createQuery(jpqlQuery, Ansatt.class);
			return query.getResultList(); // Henter ut basert på spørring
		} finally {
			em.close();
		}
	}
	
	
	public void oppdaterLoenn(int ansattid, int maanedslonn) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			// enten
			// em.merge(new Ansatt(brukernavn, maanedslonn));
			// eller

			Ansatt p = em.find(Ansatt.class, ansattid); // Finne rad som skal oppdateres
			p.setMaanedslonn(maanedslonn); // Oppdatere managed oject p => sync med database
			
			em.persist(p); //MULIGENS-----------------------
			
			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	
	
	public void oppdaterStilling(int ansattid, String stilling) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			// enten
			// em.merge(new Ansatt(brukernavn, stilling));
			// eller

			Ansatt p = em.find(Ansatt.class, ansattid); // Finne rad som skal oppdateres
			p.setStilling(stilling); // Oppdatere managed oject p => sync med database

			
			em.persist(p); //MULIGENS-----------------------
			
			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

	
	public void slettAnsatt(int ansattid) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Ansatt p = em.find(Ansatt.class, ansattid); // Finne rad som skal slettes
			em.remove(p); // Slette rad som tilsvarer managed oject p

			
			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}





////////opgv9?

public void oppdaterAnsattAvdeling (int ansattid, int avdelingid) {

	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();

	try {
		tx.begin();

		// enten
		// em.merge(new Ansatt(brukernavn, stilling));
		// eller

		//Avdeling n = getAvdeling();
//	n.setAnsatte(List<Ansatt> ansatte);

		Ansatt p = em.find(Ansatt.class, ansattid); // Finne rad som skal oppdateres
		p.setAvdeling(AvdelingDAO.finnAvdelingMedId(avdelingid)); // Oppdatere managed oject p => sync med database

		
		em.persist(p); //MULIGENS-----------------------
		
		tx.commit();

	} catch (Throwable e) {
		e.printStackTrace();
		tx.rollback();
	} finally {
		em.close();
	}
}}

