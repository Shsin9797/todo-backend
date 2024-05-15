package backend.likelion.todos.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TODO [10단계] JpaRepository를 상속받습니다.
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {


    // TODO [10단계] 아래는 기존 코드입니다. 컴파일 오류가 발생하고 있는데, 이를 해결하세요.
    Optional<Member> findByUsername(String username);

    /* public Optional<Member> findByUsername(String username) {
        return members.values()
                .stream()
                .filter(it -> it.getUsername().equals(username))
                .findAny();
    }
     */
}
