package cafe.review.repository.review;

import cafe.review.domain.Review;
import lombok.Data;

import java.util.List;

public interface ReviewInterface {

    Review save(Review review);

    List<Review> findAll();

    List<Review> searchByReviewTitle(String reviewTitle);

}
