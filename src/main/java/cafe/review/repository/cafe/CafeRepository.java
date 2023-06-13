package cafe.review.repository.cafe;

import cafe.review.domain.cafe.CafeMember;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

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
}
