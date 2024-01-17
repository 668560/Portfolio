package javaKlasser;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
	public interface DeltagerRepo extends JpaRepository<Deltager, Integer> {
		public Deltager findByMobil(String mobil);
		
		
		public List<Deltager> findAllByOrderByFornavnAscEtternavnAsc();
	}




