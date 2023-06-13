package cafe.review.repository.mybatis;

import cafe.review.domain.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class MybatisReviewMemberRepository implements ReviewMemberMapper{
    private final ReviewMemberMapper reviewMemberMapper;
    @Override
    public Review save(Review review) {
        return reviewMemberMapper.save(review);
    }

    @Override
    public List<Review> findAll() {
        return reviewMemberMapper.findAll();
    }
}
