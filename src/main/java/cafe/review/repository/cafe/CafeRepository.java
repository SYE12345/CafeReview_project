package cafe.review.repository.cafe;

import cafe.review.domain.CafeMember;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

}
