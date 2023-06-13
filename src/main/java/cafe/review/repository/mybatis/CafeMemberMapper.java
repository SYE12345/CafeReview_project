package cafe.review.repository.mybatis;

import cafe.review.domain.CafeMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CafeMemberMapper {
    void save(CafeMember cafeMember);
    List<CafeMember> findAll();
}
