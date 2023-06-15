package cafe.review.repository.mybatis;

import cafe.review.domain.Review;
import cafe.review.repository.review.ReviewInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class MybatisReviewMemberRepository implements ReviewInterface {
    private final ReviewMemberMapper reviewMemberMapper;
    @Override
    public Review save(Review review) {
        reviewMemberMapper.save(review);
        return review;
    }

    @Override
    public List<Review> findAll() {
        return reviewMemberMapper.findAll();
    }

    @Override
    public List<Review> searchByReviewTitle(String reviewTitle) {
        return reviewMemberMapper.searchByReviewTitle(reviewTitle);
    }
}
