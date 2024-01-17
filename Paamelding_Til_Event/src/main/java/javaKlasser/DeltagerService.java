package javaKlasser;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DeltagerService {
	@Autowired
	private DeltagerRepo deltagerRepo;

	@Autowired
	private PassordService passordService;

	public boolean opretteDeltaker(String mobil, String fornavn, String etternavn, String hash, String salt,
			String kjonn) {

		salt = passordService.genererTilfeldigSalt();

		String hashOgSalt = passordService.hashMedSalt(hash, salt);

		if (deltagerRepo.findByMobil(mobil) != null) {
			return false;
		}

		deltagerRepo.save(new Deltager(mobil, fornavn, etternavn, hashOgSalt, salt, kjonn));
		return true;

	}
	
	
	
	
	public boolean passordLikTest(String hash, String salt) {
		if (!hash.equals(salt)) 
		{return false;
				}
		return true;
		}
		
	
	

	public Deltager hentDeltager(String mobil) {
		return deltagerRepo.findByMobil(mobil);
	}
	
	public List<Deltager>finnAlleDeltagere(){
		return deltagerRepo.findAllByOrderByFornavnAscEtternavnAsc();
	}
	
	
}
