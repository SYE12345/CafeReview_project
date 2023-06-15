package cafe.review.testData;

import cafe.review.domain.CafeMember;
import cafe.review.service.cafe.CafeMemberServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor
@Slf4j
public class TestCafeDataInit {

    private final CafeMemberServiceInterface cafeRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initCafeData(){
        log.info("initData] CafeRepository = "+ cafeRepository );
        cafeRepository.save(new CafeMember("더즌매터","인천 부평구 부평대로 38번길 28","070-8860-4926","더스위크림 6000원","엑설러트 라떼 6000원","너티브라운 6000원","감성카페"));
        cafeRepository.save(new CafeMember("카페스물하나","인천 부평구 부평문화로 65번길 17","0507-1313-5521","생과일와플 14000원","수제딸기우유 6500원","딸기케이크 6500원","감성카페"));
    }
}
