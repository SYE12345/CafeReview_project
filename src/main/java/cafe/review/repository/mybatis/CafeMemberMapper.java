package cafe.review.repository.mybatis;

import cafe.review.domain.cafe.CafeMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CafeMemberMapper {
    void save(CafeMember cafeMember);
    List<CafeMember> findAll();
    Optional<CafeMember> findByCafeName(String cafeName);
}
