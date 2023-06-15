package cafe.review.service.cafe;

import cafe.review.domain.CafeMember;
import cafe.review.repository.cafe.cafeNameSearchCond;

import java.util.List;
import java.util.Optional;

public interface CafeMemberServiceInterface {
    CafeMember save(CafeMember cafeMember);

    List<CafeMember> findAll();

    Optional<CafeMember> findByCafeName(String cafeName);

    List<CafeMember> findByFran();

    List<CafeMember> findByGam();

//    List<CafeMember> searchByName(CafeMember member);
    List<CafeMember> searchBycafeName(String cafeName);
}
