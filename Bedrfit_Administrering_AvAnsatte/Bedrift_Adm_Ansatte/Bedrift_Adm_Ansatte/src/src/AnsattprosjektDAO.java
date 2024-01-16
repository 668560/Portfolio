package src;




import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;



public class AnsattprosjektDAO {
	
	
	
	
	
	private EntityManagerFactory emf;
	
	
	public AnsattprosjektDAO() {
		
		emf = Persistence.createEntityManagerFactory("oblig3dat107_jpa");
			
	}
	
	
	
	
	public void lagreAnsattprosjekt(Ansattprosjekt p) {

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
	

	public void oppdaterAnsattprosjekt(Ansattprosjekt p) {

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
