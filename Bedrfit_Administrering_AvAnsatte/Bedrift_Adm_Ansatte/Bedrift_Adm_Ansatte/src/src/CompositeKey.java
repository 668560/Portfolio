package src;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;





@Entity
@IdClass(CompositeKey.class)
public class CompositeKey implements Serializable {
	
	
	
	 @Id private int ansatt;
	  
	  @Id private int prosjekt;
	  
	  
	  public CompositeKey() {}
	 
	  public CompositeKey(int ansatt, int prosjekt) { super(); this.ansatt =
	  ansatt; this.prosjekt = prosjekt; }
	 
	
	
	

}
