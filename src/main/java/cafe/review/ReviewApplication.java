package cafe.review;

import cafe.review.config.BaseConfig;
import cafe.review.config.MybatisConfig;
import cafe.review.repository.MemberInterface;
import cafe.review.repository.MemberRepository;
import cafe.review.service.MemberServiceInterface;
import cafe.review.web.controller.member.MemberController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Import(BaseConfig.class)
@SpringBootApplication(scanBasePackages = "cafe.review.web")
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

	@Bean
	// Profile은 빈을 선택적으로 등록하고 싶을 때 Profile명을 지정하여 사용
	// resources/appication.properties 파일에 아래 설정을 하게 된다면
	// spring.profiles.active=local
	// profile이 local인 메소드에 대해서 선택적으로 빈을 생성한다.
	@Profile("local")
	public TestDataInit testDataInit(MemberServiceInterface memberServiceInterface ){
		return new TestDataInit(memberServiceInterface);
	}
}
