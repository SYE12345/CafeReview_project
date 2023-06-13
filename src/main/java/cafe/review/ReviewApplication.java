package cafe.review;

import cafe.review.config.BaseConfig;
import cafe.review.config.MybatisConfig;
import cafe.review.repository.cafe.CafeRepository;
import cafe.review.service.MemberServiceInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

	@Profile("local")
	public TestMemberDataInit testMemberDataInit(MemberServiceInterface memberServiceInterface){
		return new TestMemberDataInit(memberServiceInterface);
	}
	@Bean

	@Profile("local")
	public TestCafeDataInit testCafeDataInit(CafeRepository cafeRepository){
		return new TestCafeDataInit(cafeRepository);
	}
}
