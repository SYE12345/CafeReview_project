package cafe.review.service;

import cafe.review.domain.Member;
import cafe.review.repository.MemberInterface;
import cafe.review.repository.MemberUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberServiceInterface{
    private final MemberInterface memberInterface;

    @Override
    public Member save(Member member) {
        return memberInterface.save(member);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberInterface.findById(id);
    }

    @Override
    public Optional<Member> findByLoginId(String loginId) {
        return memberInterface.findByLoginId(loginId);
    }

    @Override
    public List<Member> findAll() {
        return memberInterface.findAll();
    }

    @Override
    public Optional<Member> findByNameEmail(String name, String email) {
        return memberInterface.findByNameEmail(name, email);
    }

    @Override
    public Optional<Member> findByNamePhone(String name, String phone) {
        return memberInterface.findByNamePhone(name, phone);
    }

    @Override
    public Optional<Member> findPasswordNameEmail(String loginId, String name, String email) {
        return memberInterface.findPasswordNameEmail(loginId, name, email);
    }

    @Override
    public Optional<Member> findPasswordNamePhone(String loginId, String name, String email) {
        return memberInterface.findPasswordNamePhone(loginId, name, email);
    }

    @Override
    public void update(Long id, MemberUpdateDto memberUpdateParam) {
        memberInterface.update(id, memberUpdateParam);
    }
}
