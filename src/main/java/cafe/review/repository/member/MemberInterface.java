package cafe.review.repository.member;

import cafe.review.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberInterface {
    // 회원가입
    Member save(Member member);

    // 레코드 아이디로 찾기
    Optional<Member> findById(Long id);

    // 로그인 아이디로 찾기
    Optional<Member> findByLoginId(String loginId);

    // 전체 출력
    List<Member> findAll();

    // 아이디 찾기용 이름과 이메일로 찾기
    Optional<Member> findByNameEmail(String name, String email);

    // 아이디 찾기용 이름과 폰번호로 찾기
    Optional<Member> findByNamePhone(String name, String phone);

    // 비밀번호 찾기용 (로그인 아이디, 이름, 이메일)
    Optional<Member> findPasswordNameEmail(String loginId, String name, String email);

    // 비밀번호 찾기용(로그인 아이디, 이름, 폰번호)
    Optional<Member> findPasswordNamePhone(String loginId, String name, String email);

    // 회원 정보 수정용(MemberUpdateDto 클래스 사용)
    void update(String loginId, MemberUpdateDto memberUpdateParam);

}
