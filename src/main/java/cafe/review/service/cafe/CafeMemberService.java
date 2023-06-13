package cafe.review.service.cafe;

import cafe.review.domain.CafeMember;
import cafe.review.repository.cafe.CafeInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeMemberService implements CafeMemberServiceInterface {
    private final CafeInterface cafeInterface;

    @Override
    public CafeMember save(CafeMember cafeMember){
        return cafeInterface.save(cafeMember);
    }

    @Override
    public List<CafeMember> findAll(){
        return cafeInterface.findAll();
    }
}
