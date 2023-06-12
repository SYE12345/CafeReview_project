package cafe.review.config;

import cafe.review.repository.MemberInterface;
import cafe.review.repository.MemberRepository;
import cafe.review.service.LoginInterface;
import cafe.review.service.LoginService;
import cafe.review.service.MemberService;
import cafe.review.service.MemberServiceInterface;
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


}
