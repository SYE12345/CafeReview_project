package cafe.review.repository.mybatis;

import cafe.review.domain.Member;
import cafe.review.repository.MemberInterface;
import cafe.review.repository.MemberUpdateDto;

import java.util.List;
import java.util.Optional;

public class MybatisMemberRepository implements MemberInterface {
    private MemberMapper memberMapper;
    @Override
    public Member save(Member member) {
        memberMapper.save(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberMapper.findById(id);
    }

    @Override
    public Optional<Member> findByLoginId(String loginId) {
        return memberMapper.findByLoginId(loginId);
    }

    @Override
    public List<Member> findAll() {
        return memberMapper.findAll();
    }

    @Override
    public Optional<Member> findByNameEmail(String name, String email) {
        return memberMapper.findByNameEmail(name, email);
    }

    @Override
    public Optional<Member> findByNamePhone(String name, String phone) {
        return memberMapper.findByNamePhone(name, phone);
    }

    @Override
    public Optional<Member> findPasswordNameEmail(String loginId, String name, String email) {
        return memberMapper.findPasswordNameEmail(loginId, name, email);
    }

    @Override
    public Optional<Member> findPasswordNamePhone(String loginId, String name, String email) {
        return memberMapper.findPasswordNamePhone(loginId, name, email);
    }

    @Override
    public void update(Long id, MemberUpdateDto UpdateParam) {
        memberMapper.update(id, UpdateParam);

    }
}
