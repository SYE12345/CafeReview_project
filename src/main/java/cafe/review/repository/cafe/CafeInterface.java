package cafe.review.repository.cafe;

import cafe.review.domain.CafeMember;

import java.util.List;
import java.util.Optional;

public interface CafeInterface {
    CafeMember save(CafeMember cafeMember);
    List<CafeMember> findAll();
    Optional<CafeMember> findByCafeName(String cafeName);

    List<CafeMember> findByFran();

    List<CafeMember> findByGam();

    List<CafeMember> searchByCafeName(String cafeName);
}
