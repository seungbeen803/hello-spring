package hello.hellospring.domain.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // 회원을 저장하면 저장된 회원 반환됨
    Member save(Member member);

    // findById, findByName 로 회원을 찾음
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    // 지금까지 저장된 모든 회원들의 정보를 찾음
    List<Member> findAll();

    void clearStore();
}
