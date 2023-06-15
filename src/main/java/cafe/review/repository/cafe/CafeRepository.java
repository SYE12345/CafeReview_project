package cafe.review.repository.cafe;

import cafe.review.domain.CafeMember;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class CafeRepository implements CafeInterface {
    private static final Map<Long, CafeMember> store = new HashMap<>();

    private static long sequence=0l;

    @Override
    public List<CafeMember> findAll() {
       return new ArrayList<>(store.values());
    }

    @Override
    public CafeMember save(CafeMember cafeMember){
        cafeMember.setCafeId(++sequence);
        store.put(cafeMember.getCafeId(),cafeMember);
        return cafeMember;
    }

    @Override
    public Optional<CafeMember> findByCafeName(String cafeName) {
        return findAll().stream()
                .filter(m->m.getCafeName().equals(cafeName)).findFirst();
    }

    @Override
    public List<CafeMember> findByFran() {
       return findAll().stream().filter(m->m.getCafeType().equals("프랜차이즈")).collect(Collectors.toList());
    }

    @Override
    public List<CafeMember> findByGam() {
        return findAll().stream().filter(m->m.getCafeType().equals("감성카페")).collect(Collectors.toList());
    }

//    @Override
//    public List<CafeMember> searchByName(CafeMember member) {
//        return findAll().stream().filter(m->m.getCafeName().contains(member.getCafeName())).collect(Collectors.toList());
//    }


    @Override
    public List<CafeMember> searchByCafeName(String cafeName) {
        return findAll().stream().filter(m->m.getCafeName().contains(cafeName)).collect(Collectors.toList());
    }
}
