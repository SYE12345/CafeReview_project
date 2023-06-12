package cafe.review.config;

import cafe.review.repository.MemberInterface;
import cafe.review.repository.MemberRepository;
import cafe.review.repository.mybatis.MemberMapper;
import cafe.review.repository.mybatis.MybatisMemberRepository;
import cafe.review.service.LoginInterface;
import cafe.review.service.LoginService;
import cafe.review.service.MemberService;
import cafe.review.service.MemberServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MybatisConfig {
    private final MemberMapper memberMapper;

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


}
