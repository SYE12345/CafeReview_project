package cafe.review.config;

import cafe.review.repository.MemberInterface;
import cafe.review.repository.MemberRepository;
import cafe.review.repository.cafe.CafeInterface;
import cafe.review.repository.cafe.CafeRepository;
import cafe.review.repository.mybatis.*;
import cafe.review.repository.review.ReviewInterface;
import cafe.review.service.LoginInterface;
import cafe.review.service.LoginService;
import cafe.review.service.MemberService;
import cafe.review.service.MemberServiceInterface;
import cafe.review.service.cafe.CafeMemberService;
import cafe.review.service.cafe.CafeMemberServiceInterface;
import cafe.review.service.review.ReviewService;
import cafe.review.service.review.ReviewServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MybatisConfig {
    private final MemberMapper memberMapper;
    private final CafeMemberMapper cafeMemberMapper;
    private final ReviewMemberMapper reviewMemberMapper;

    @Bean
    public LoginInterface loginInterface () {
        return new LoginService(memberServiceInterface());
    }
    @Bean
    public MemberServiceInterface memberServiceInterface() {
        return new MemberService(memberInterface());
    }
    @Bean
    public MemberInterface memberInterface() {
        return new MybatisMemberRepository(memberMapper);
    }
    @Bean
    public CafeMemberServiceInterface cafeMemberServiceInterface(){
        return new CafeMemberService(cafeInterface());
    }
    @Bean
    public CafeInterface cafeInterface(){
        return new MybatisCafeMemberRepository(cafeMemberMapper);
    }

    @Bean
    public ReviewServiceInterface reviewServiceInterface(){
        return new ReviewService(reviewInterface());
    }

    @Bean
    public ReviewInterface reviewInterface(){
        return new MybatisReviewMemberRepository(reviewMemberMapper);
    }
}
