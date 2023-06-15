package cafe.review.service.review;

import cafe.review.domain.Review;
import cafe.review.repository.review.ReviewInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService implements ReviewServiceInterface{
    private final ReviewInterface reviewInterface;
    @Override
    public Review save(Review review) {
        return reviewInterface.save(review);
    }

    @Override
    public List<Review> findAll() {
        return reviewInterface.findAll();
    }

    @Override
    public List<Review> searchByReviewTitle(String reviewTitle) {
        return reviewInterface.searchByReviewTitle(reviewTitle);
    }
}
