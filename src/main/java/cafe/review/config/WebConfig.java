package cafe.review.config;


import cafe.review.web.interceptor.LogInterceptor;
import cafe.review.web.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 설정 관련 스프링 빈을 등록
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1) // 인터셉터 적용 순위
                .addPathPatterns("/**") // 모든 경로에 적용
                .excludePathPatterns("/css/**", "/*.ico", "/error");
//        /css/**는 /css로 시작하는 모든 경로를 제외합니다.
//         /*.ico는 루트 경로(/)에 있는 .ico 파일을 제외합니다.
//         /error는 /error 경로를 제외합니다.

        registry.addInterceptor(new LoginCheckInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/login", "/logout",
                        "/css/**", "/*.ico", "/error", "/join", "/All_list_login");
    }


    // @Bean: 메소드 단위로 빈을 등록할 때 사용
/*    @Bean
    public FilterRegistrationBean logFilter() {
//        Filter 인터페이스를 구현한 클래스를 제네릭타입으로 설정
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
//        필터 등록
        filterRegistrationBean.setFilter(new LogFilter());
//        필터는 체인으로 동작한다. 아래는 1번 순서로 지정
        filterRegistrationBean.setOrder(1);
//        필터를 적용할 URL 패턴을 지정한다.
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }*/



}
