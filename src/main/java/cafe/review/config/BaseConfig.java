package cafe.review.config;

import cafe.review.repository.member.MemberInterface;
import cafe.review.repository.member.MemberRepository;
import cafe.review.repository.cafe.CafeInterface;
import cafe.review.repository.cafe.CafeRepository;
import cafe.review.repository.review.ReviewInterface;
import cafe.review.repository.review.ReviewRepository;
import cafe.review.service.login.LoginInterface;
import cafe.review.service.login.LoginService;
import cafe.review.service.member.MemberService;
import cafe.review.service.member.MemberServiceInterface;
import cafe.review.service.cafe.CafeMemberService;
import cafe.review.service.cafe.CafeMemberServiceInterface;
import cafe.review.service.review.ReviewService;
import cafe.review.service.review.ReviewServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfig {

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
    return new MemberRepository();
    }

    @Bean
    public CafeMemberServiceInterface cafeMemberServiceInterface(){
        return new CafeMemberService(cafeInterface());
    }
    @Bean
    public CafeInterface cafeInterface(){
        return new CafeRepository();
    }

    @Bean
    public ReviewServiceInterface reviewServiceInterface(){
        return new ReviewService(reviewInterface());
    }

    @Bean
    public ReviewInterface reviewInterface(){
        return new ReviewRepository();
    }


}
