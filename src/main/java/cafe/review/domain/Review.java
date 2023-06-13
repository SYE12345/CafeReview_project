package cafe.review.domain;

import lombok.Data;

@Data
public class Review {
    private Long reviewId;
    private String reviewTitle;
    private String reviewContent;

    public Review(){

    }

    public Review( String reviewTitle, String reviewContent) {
        this.reviewTitle = reviewTitle;
        this.reviewContent = reviewContent;
    }
}
