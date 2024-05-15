package backend.likelion.todos.goal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TODO [10단계] JpaRepository를 상속받습니다.
@Repository
public interface GoalRepository extends JpaRepository<Goal,Long> {


    // TODO [10단계] 아래는 기존 코드입니다. 컴파일 오류가 발생하고 있는데, 이를 해결하세요.
    List<Goal> findAllByMemberId(Long memberId);
    /* public List<Goal> findAllByMemberId(Long memberId) {
        return goals.values()
                .stream()
                .filter(it -> it.getMember().getId().equals(memberId))
                .toList();
    }

    */
}
