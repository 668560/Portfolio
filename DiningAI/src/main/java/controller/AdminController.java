package controller;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import model.AdminReviewAction;
import model.Restaurant;
import model.Review;
import model.ReviewStatus;
import repository.RestaurantRepo;
import repository.ReviewRepo;
import repository.UserRepo;

@RequestMapping("/admin")
	@RestController
	public class AdminController {
	    private final ReviewRepo reviewRepository;
	    private final UserRepo userRepository;
	    private final RestaurantRepo restaurantRepository;

	    private final DecimalFormat decimalFormat = new DecimalFormat("0.00");

	    public AdminController(ReviewRepo reviewRepository, UserRepo userRepository, RestaurantRepo restaurantRepository) {
	        this.reviewRepository = reviewRepository;
	        this.userRepository = userRepository;
	        this.restaurantRepository = restaurantRepository;
	    }

	    @GetMapping("/reviews")
	    public List<Review> getReviewsByStatus(@RequestParam String review_status) {
	        ReviewStatus reviewStatus = ReviewStatus.PENDING;
	        try {
	            reviewStatus = ReviewStatus.valueOf(review_status.toUpperCase());
	        } catch (IllegalArgumentException ex) {
	            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
	        }

	        return reviewRepository.findReviewsByStatus(reviewStatus);
	    }

	    @PutMapping("/reviews/{reviewId}")
	    public void performReviewAction(@PathVariable Long reviewId, @RequestBody AdminReviewAction adminReviewAction) {
	        Optional<Review> optionalReview = reviewRepository.findById(reviewId);
	        if (optionalReview.isEmpty()) {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	        }

	        Review review = optionalReview.get();

	        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(review.getId());
	        if (optionalRestaurant.isEmpty()) {
	            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
	        }

	        if (adminReviewAction.getAccept()) {
	            review.setStatus(ReviewStatus.ACCEPTED);
	        } else { 
	            review.setStatus(ReviewStatus.REJECTED);
	        }

	        reviewRepository.save(review);
	        updateRestaurantReviewScores(optionalRestaurant.get());
	    }

	    private void updateRestaurantReviewScores(Restaurant restaurant) {
	        List<Review> reviews = reviewRepository.findReviewsByResturantIdAndStatus(restaurant.getId(), ReviewStatus.ACCEPTED);
	        if (reviews.size() == 0) {
	            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
	        }

	        int peanutSum = 0;
	        int peanutCount = 0;
	        int dairySum = 0;
	        int dairyCount = 0;
	        int eggSum = 0;
	        int eggCount = 0;
	        for (Review r : reviews) {
	            if (!ObjectUtils.isEmpty(r.getPeanutScore())) {
	                peanutSum += r.getPeanutScore();
	                peanutCount++;
	            }
	            if (!ObjectUtils.isEmpty(r.getDiaryScore())) {
	                dairySum += r.getDiaryScore();
	                dairyCount++;
	            }
	            if (!ObjectUtils.isEmpty(r.getEggScore())) {
	                eggSum += r.getEggScore();
	                eggCount++;
	            }
	        }

	        int totalCount = peanutCount + dairyCount + eggCount ;
	        int totalSum = peanutSum + dairySum + eggSum;

	        float overallScore = (float) totalSum / totalCount;
	        restaurant.setOverallScore((int) overallScore);

	        if (peanutCount > 0) {
	            float peanutScore = (float) peanutSum / peanutCount;
	            restaurant.setPeanutScore((int)(peanutScore));
	        }

	        if (dairyCount > 0) {
	            float dairyScore = (float) dairySum / dairyCount;
	            restaurant.setDairyScore((int)(dairyScore));
	        }

	        if (eggCount > 0) {
	            float eggScore = (float) eggSum / eggCount;
	            restaurant.setEggScore((int)(eggScore));
	        }

	        restaurantRepository.save(restaurant);
	    }
}
	
