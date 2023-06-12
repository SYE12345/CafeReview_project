package cafe.review;

import cafe.review.domain.Member;
import cafe.review.service.MemberServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
@RequiredArgsConstructor
@Slf4j
public class TestDataInit {

    private final MemberServiceInterface memberServiceInterface;
    @EventListener(ApplicationReadyEvent.class)
    public void initData(){
        log.info("initData] memberServiceInterface = "+ memberServiceInterface );
        memberServiceInterface.save(new Member("test1", "1234", "1234", "홍길동", "s@naver.com", "010"));
    }
}
