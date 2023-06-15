package cafe.review.service.review;

import cafe.review.domain.Review;

import java.util.List;

public interface ReviewServiceInterface {
    Review save(Review review);

    List<Review> findAll();

    List<Review> searchByReviewTitle(String reviewTitle);


}
