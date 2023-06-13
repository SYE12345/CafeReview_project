package cafe.review.service.cafe;

import cafe.review.domain.CafeMember;

import java.util.List;

public interface CafeMemberServiceInterface {
    CafeMember save(CafeMember cafeMember);

    List<CafeMember> findAll();


}
