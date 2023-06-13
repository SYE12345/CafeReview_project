package cafe.review.repository.mybatis;

import cafe.review.domain.CafeMember;
import cafe.review.repository.cafe.CafeInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<CafeMember> findByCafeName(String cafeName) {
        return cafeMemberMapper.findByCafeName(cafeName);
    }
}
