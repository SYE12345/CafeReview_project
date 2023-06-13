package cafe.review;

import cafe.review.domain.CafeMember;
import cafe.review.domain.Review;
import cafe.review.service.review.ReviewServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor
public class TestReviewDataInit {
    private final ReviewServiceInterface reviewServiceInterface;


    @EventListener(ApplicationReadyEvent.class)
    public void initCafeData(){

        reviewServiceInterface.save(new Review("reviewtest1", "ㅇㅇ"));
    }
}
