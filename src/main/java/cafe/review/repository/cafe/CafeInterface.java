package cafe.review.repository.cafe;

import cafe.review.domain.cafe.CafeMember;

import java.util.List;

public interface CafeInterface {
    CafeMember save(CafeMember cafeMember);
    List<CafeMember> findAll();
}
