package cafe.review.repository.mybatis;

import cafe.review.domain.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ReviewMemberMapper {

    void save(Review review);

    List<Review> findAll();
    List<Review> searchByReviewTitle(String reviewTitle);
}
