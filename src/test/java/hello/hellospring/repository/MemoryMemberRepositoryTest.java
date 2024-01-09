package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.repository.MemberRepository;
import hello.hellospring.domain.repository.MemoryMemberRepository;
//import org.junit.jupiter.api.Assertions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*; // static import 단축키 alt + enter

class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    // test가 끝날 때마다 repository를 지워주는 메서드가 필요
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        // Optional 에서 값을 꺼내기 위에 마지막에 get()을 사용 (별로 좋은 방법은 아님)
        Member result = repository.findById(member.getId()).get();

        // 검증
        // 객체로 저장한 값과 DB로 저장한 값이 일치한지 검증
        // org.junit.jupiter.api 방법
        // Assertions.assertEquals(member, result);

        // org.assertj.core.api 방법
        assertThat(member).isEqualTo(result);

        // assertThat(member).isEqualTo(null);

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member(); // shift + F6 -> Rename
        member2.setName("spring2");
        repository.save(member2);

        // Optional<Member> result = repository.findByName("spring1");
        // get() 붙이면 Optional 제외 가능
        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
