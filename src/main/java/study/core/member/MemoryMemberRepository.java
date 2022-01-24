package study.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// 데이터베이스라고 가정
@Component
public class MemoryMemberRepository implements MemberRepository {

    // 동시성 문제 때문에 ConcurrentHashMap 쓰는 것이 좋음
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}