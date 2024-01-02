package hello.hellospring.domain.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    // seqence : 키 값 하나씩 생성
    private static long seqence = 0L;

    // 회원 저장
    @Override
    public Member save(Member member) {
        member.setId(++seqence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // 결과가 없으면 null
        // null이 반환될 가능성이 있어 Optional로 감싸서 반환
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // 파라미터로 넘어온 이름과 같은지 확인
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        // store 안의 member 들이 전부 반환
        // values() : store의 멤버들
        return new ArrayList<>(store.values());
    }
}
