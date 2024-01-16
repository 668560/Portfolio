package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity

//Lombok 
@Getter
@Setter
@ToString
@RequiredArgsConstructor

public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	//review_info
	private String submitter;
/**
 * @OneToOne
	@JoinColumn(name="resturantId")
	???
 */
	private Long restaurantId;
	private String review;
	
	private Integer peanutScore;
	private Integer eggScore;
	private Integer diaryScore;
	
	//Connectiong Review with Admin action
	private ReviewStatus status;

	
	public Review(String submitter, Long restaurantId, String review, Integer peanutScore, Integer eggScore,
			Integer diaryScore, ReviewStatus status) {
		super();
		this.submitter = submitter;
		this.restaurantId = restaurantId;
		this.review = review;
		this.peanutScore = peanutScore;
		this.eggScore = eggScore;
		this.diaryScore = diaryScore;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubmitter() {
		return submitter;
	}

	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}

	public Long getRestaurant() {
		return restaurantId;
	}

	public void setRestaurant(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Integer getPeanutScore() {
		return peanutScore;
	}

	public void setPeanutScore(Integer peanutScore) {
		this.peanutScore = peanutScore;
	}

	public Integer getEggScore() {
		return eggScore;
	}

	public void setEggScore(Integer eggScore) {
		this.eggScore = eggScore;
	}

	public Integer getDiaryScore() {
		return diaryScore;
	}

	public void setDiaryScore(Integer diaryScore) {
		this.diaryScore = diaryScore;
	}

	public ReviewStatus getStatus() {
		return status;
	}

	public void setStatus(ReviewStatus status) {
		this.status = status;
	}

}
