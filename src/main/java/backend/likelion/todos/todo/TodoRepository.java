package backend.likelion.todos.todo;

import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepository {

    private final Map<Long, Todo> todos = new HashMap<>();
    private Long id = 1L;

    // Todo를 저장하고 저장된 Todo를 반환합니다.
    public Todo save(Todo todo) {
        // TODO [3단계] todo의 id를 설정하고, todos 맵에 추가하세요. 그리고 todo를 반환하세요.
        todo.setId(id++);
        todos.put(todo.getId(),todo);
        return todo;
    }

    // 주어진 id로 Todo를 찾아 Optional로 반환합니다.
    public Optional<Todo> findById(Long id) {
        // TODO [3단계] id를 사용하여 todos 맵에서 Todo를 찾고, 찾은 Todo를 Optional로 감싸서 반환하세요.
        Optional<Todo> todo= Optional.of(todos.get(id));
        return todo;
    }

    // 모든 Todo를 삭제합니다.
    public void clear() {
        // TODO [3단계] todos 맵의 모든 내용을 제거하세요.
        todos.clear();
    }

    // 주어진 Todo를 삭제합니다.
    public void delete(Todo todo) {
        // TODO [3단계] todos 맵에서 주어진 todo의 id를 사용하여 해당 Todo를 삭제하세요.
        todos.remove(todo.getId());
    }

    // 특정 회원 ID와 날짜에 해당하는 모든 Todo를 찾아 리스트로 반환합니다.
    public List<Todo> findAllByMemberIdAndDate(Long memberId, YearMonth yearMonth) {
        // TODO [3단계] todos 맵에서 memberId와 일치하고, yearMonth에 속하는 모든 Todo를 찾아 리스트로 반환하세요.
        List<Todo> todoList = new ArrayList<>();
        for (int todoId = 1; todoId<=id ; todoId++) {
            Todo todo = todos.get(todoId);
            if ((todo.getGoal().getMember().getId().equals(memberId))
                && (todo.getDate().getYear()==yearMonth.getYear())
                    && (todo.getDate().getMonth()==yearMonth.getMonth())) {
                todoList.add(todo);
            }

        }
        // TODO [3단계] 찾은 Todo 리스트를 날짜 순으로 정렬하세요.
        todoList.stream()
                .sorted(Comparator.comparing(Todo::getDate))
                .collect(Collectors.toList());
        return todoList;
    }
}
