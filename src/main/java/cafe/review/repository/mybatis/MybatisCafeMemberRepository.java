package cafe.review.repository.mybatis;

import cafe.review.domain.cafe.CafeMember;
import cafe.review.repository.cafe.CafeInterface;
import cafe.review.service.cafe.CafeMemberServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MybatisCafeMemberRepository implements CafeInterface {
    private final CafeMemberMapper cafeMemberMapper;

    @Override
    public CafeMember save(CafeMember cafeMember){
        cafeMemberMapper.save(cafeMember);
        return cafeMember;
    }

    @Override
    public List<CafeMember> findAll() {
        return cafeMemberMapper.findAll();
    }

}
