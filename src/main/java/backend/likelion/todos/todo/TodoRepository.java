package backend.likelion.todos.todo;

import java.util.List;
import org.antlr.v4.runtime.atn.SemanticContext.AND;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// TODO [10단계] JpaRepository를 상속받습니다.
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{


    /**
     * TODO [10단계] 아래는 기존 findAllByMemberIdAndDate 코드와 동일한 역할을 합니다.
     * 해당 기능을 완성하세요.
     *
     * 메서드의 이름만으로는 해결할 수 없습니다.
     * 직접 JPQL을 작성해야 합니다.
     * 어떤 어노테이션을 사용해야 할까요?
     *
     * JPQL 수도코드
     * - TODO 와 Goal을 조인합니다.
     * - 조건 : goal의 memberId 가 주어진 인자의 memberId와 동일
     *      AND Todo의 date의 YEAR 부분이 주어진 인자의 year와 동일 (hint: YEAR(date) 시 date의 년도 부분이 나온다.)
     *      AND Todo의 date의 MONTH 부분이 주어진 인자의 month와 동일 (hint: MONTH(date) 시 date의 년도 부분이 나온다.)
     * - 정렬 Todo의 date의 DAY 부분을 오름차순으로. (hint: DAY(date) 시 date의 년도 부분이 나온다.)
     */

    @Query("""
    SELECT Todo FROM Todo
    JOIN Todo.goal ON Todo.goal = Todo
    WHERE Todo.goal.member.id = :memberId
    AND YEAR(Todo.date) = :year
    AND MONTH(Todo.date) = :month
    ORDER BY DAY(Todo.date) ASC
    """)
    List<Todo> findAllByMemberIdAndDateOrderByDayAsc(Long memberId, int year, int month);
}
