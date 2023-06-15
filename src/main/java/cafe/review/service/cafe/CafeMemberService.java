package cafe.review.service.cafe;

import cafe.review.domain.CafeMember;
import cafe.review.repository.cafe.CafeInterface;
import cafe.review.repository.cafe.cafeNameSearchCond;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<CafeMember> findByCafeName(String cafeName) {
        return cafeInterface.findByCafeName(cafeName);
    }

    @Override
    public List<CafeMember> findByFran() {
        return cafeInterface.findByFran();
    }

    @Override
    public List<CafeMember> findByGam() {
        return cafeInterface.findByGam();
    }

//    @Override
//    public List<CafeMember> searchByName(CafeMember member) {
//        return cafeInterface.searchByName(member);
//    }

    @Override
    public List<CafeMember> searchBycafeName(String cafeName) {
        return cafeInterface.searchByCafeName(cafeName);
    }
}
