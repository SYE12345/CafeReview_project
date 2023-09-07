package cafe.review;

import cafe.review.config.BaseConfig;
import cafe.review.config.MybatisConfig;
import cafe.review.service.cafe.CafeMemberServiceInterface;
import cafe.review.service.member.MemberServiceInterface;
import cafe.review.service.review.ReviewServiceInterface;
import cafe.review.testData.TestCafeDataInit;
import cafe.review.testData.TestMemberDataInit;
import cafe.review.testData.TestReviewDataInit;
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
	public TestCafeDataInit testCafeDataInit(CafeMemberServiceInterface cafeRepository){
		return new TestCafeDataInit(cafeRepository);
	}

	@Bean
	@Profile("local")
	public TestReviewDataInit testReviewDataInit(ReviewServiceInterface reviewServiceInterface){
		return new TestReviewDataInit(reviewServiceInterface);
	}
}
