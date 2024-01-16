package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Review;
import model.ReviewStatus;

/**Conditions
 * 1.A registered user wants to submit a review (check registered)
 * 2.Admin wants to get list of all reviews that are waiting for approval (check for admin)
 * 3.Admin want to approve or reject a review (check for admin)
 * 4.Fetch all approved reviews for this restaurant (check for approved reviews and restaurant id)
 */
public interface ReviewRepo extends JpaRepository<Review, Long>{
	//generating a list of 2.condition It can also fetch a list based of all three reviewStatus 
	List<Review> findReviewsByStatus(ReviewStatus reviewStatus);
	
	//generating a list of 4.condition. It can fetch a list based of all three reviewStatus for the restaurant
	List<Review> findReviewsByResturantIdAndStatus(Long restaurantId, ReviewStatus reviewStatus);

}
