package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Restaurant;

/**Conditions
 * 1.Submit a new restaurant entry that doesn't exists (check for restaurant name, and zipcode alt. phone)
 * 2.Fetch information about a restaurant based on id
 * 3.Fetch a list of restaurant located in the zipcode and that has at least one score for allergy. Sorted in descending order
 */
public interface RestaurantRepo extends JpaRepository<Restaurant, Long>{
	//submit a restaurant entry based on 1. condition
	Optional<Restaurant> findRestaurantByNameAndZip(String name, String zipcode);
	
	//Finding a restaurant based on 2.condition
	Optional<Restaurant> findRestaurantById(Long id);
	
	//Generating a list of restaurant with peanuttscore in the zipcode area
	List<Restaurant> RestaurantPeanuttZip(String zipcode);
	
	//Generating a list of restaurant with dairyscore in the zipcode area
	List<Restaurant> RestaurantDairyZip(String zipcode);
	
	//Generating a list of restaurant with eggscore in the zipcode area
	List<Restaurant> RestaurantEggZip(String zipcode);
	

}
