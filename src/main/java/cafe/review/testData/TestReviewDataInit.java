package cafe.review.testData;

import cafe.review.domain.CafeMember;
import cafe.review.domain.Review;
import cafe.review.service.review.ReviewServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@RequiredArgsConstructor
public class TestReviewDataInit {
    private final ReviewServiceInterface reviewServiceInterface;


    @EventListener(ApplicationReadyEvent.class)
    public void initCafeData(){
        log.info("initCafeData] "+ reviewServiceInterface );
        reviewServiceInterface.save(new Review("reviewtest1", "ㅇㅇ"));
    }
}
