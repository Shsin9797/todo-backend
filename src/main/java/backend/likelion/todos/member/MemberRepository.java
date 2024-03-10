package backend.likelion.todos.member;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    private final Map<Long, Member> members = new HashMap<>();
    private Long id = 1L;

    // 멤버를 저장소에 저장하고 저장된 멤버를 반환합니다.
    public Member save(Member member) {
        // TODO [1단계] member의 id를 설정하세요.
        member.setId(id++);
        // TODO [1단계] members 맵에 member를 추가하세요.
        members.put(member.getId(),member);
        // TODO [1단계] member를 반환하세요.
        return member;
    }

    // 주어진 id에 해당하는 멤버를 찾아 Optional로 반환합니다.
    public Optional<Member> findById(Long id) {
        // TODO [1단계] id를 이용하여 members 맵에서 멤버를 찾으세요.
        // TODO [1단계] 찾은 멤버를 Optional로 감싸서 반환하세요.
        return null;
    }

    // 주어진 username과 일치하는 멤버를 찾아 Optional로 반환합니다.
    public Optional<Member> findByUsername(String username) {
        // TODO [1단계] members 맵에서 username이 일치하는 멤버를 스트림을 사용해 찾으세요.
        // TODO [1단계] 찾은 멤버를 Optional로 감싸서 반환하세요.
        return null;
    }

    // 저장소의 모든 멤버를 제거합니다.
    public void clear() {
        // TODO [1단계] members 맵의 모든 내용을 제거하세요.
    }
}
