package backend.likelion.todos.goal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class GoalRepository {

    private final Map<Long, Goal> goals = new HashMap<>();
    private Long id = 1L;

    // 목표(Goal)를 저장하고 저장된 목표를 반환합니다.
    public Goal save(Goal goal) {
        // TODO [2단계] goal의 id를 설정하고, goals 맵에 추가하세요. 그리고 goal을 반환하세요.
        goals.put(id++,goal);
        return goal;
    }

    // 주어진 id로 목표를 찾아 Optional로 반환합니다.
    public Optional<Goal> findById(Long id) {
        // TODO [2단계] id를 사용하여 goals 맵에서 목표를 찾고, 찾은 목표를 Optional로 감싸서 반환하세요.
        Goal goal = goals.get(id);
        return Optional.of(goal);
    }

    // 모든 목표를 삭제합니다.
    public void clear() {
        // TODO [2단계] goals 맵의 모든 내용을 제거하세요.
        this.goals.clear();
    }

    // 주어진 목표를 삭제합니다.
    public void delete(Goal goal) {
        // TODO [2단계] goals 맵에서 주어진 goal의 id를 사용하여 해당 목표를 삭제하세요.
        goals.remove(goal.getId());
    }

    // 특정 회원 ID에 속하는 모든 목표를 찾아 리스트로 반환합니다.
    public List<Goal> findAllByMemberId(Long memberId) {
        // TODO [2단계] goals 맵에서 memberId와 일치하는 모든 목표를 스트림을 사용해 찾아, 리스트로 반환하세요.
        return null;
    }
}
