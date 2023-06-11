package cafe.review.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Member {
    // 시퀀스 자동 생성용 id
    private Long id;
    // 로그인 아이디(공백 불가)
    @NotEmpty
    private String loginId;
    // 비밀번호(공백 불가)
    @NotEmpty
    private String password;
    // 사용자 이름
    @NotEmpty
    private String name;
    // 사용자 이메일
    private String email;
    // 사용지 전화번호
    private String phoneNumber;
    // 관리자
//    private Boolean admin;

    // 기본 생성자
    public Member(){}

    //필수 3개만 입력
    public Member(String loginId, String password, String name) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
    }
    // 선택사항 email 입력
    public Member(String loginId, String password, String name, String email) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
    }
    // 모든 생성자
    public Member(String loginId, String password, String name, String email, String phoneNumber) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
