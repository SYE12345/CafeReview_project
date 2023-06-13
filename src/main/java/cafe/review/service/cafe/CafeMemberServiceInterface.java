package cafe.review.service.cafe;

import cafe.review.domain.CafeMember;

import java.util.List;
import java.util.Optional;

public interface CafeMemberServiceInterface {
    CafeMember save(CafeMember cafeMember);

    List<CafeMember> findAll();

    Optional<CafeMember> findByCafeName(String cafeName);


}
