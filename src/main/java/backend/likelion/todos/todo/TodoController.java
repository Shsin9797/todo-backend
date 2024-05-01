package backend.likelion.todos.todo;

import backend.likelion.todos.auth.Auth;
import java.net.URI;
import java.time.YearMonth;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/todos")
@RestController
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<Void> create(
            @Auth Long memberId,
            @RequestBody TodoCreateRequest request
    ) {
        // TODO [9단계] TodoCreateRequest에서 goalId, content, date를 추출하여
        //  todoService의 save 메소드를 호출하고,
        //  생성된 Todo의 ID로 URI를 생성하여 ResponseEntity를 반환하세요.
        Long id = todoService.save(request.goalId(),memberId,request.content(),request.date());
        URI uri =URI.create(id.toString());
        ResponseEntity.BodyBuilder response = ResponseEntity.created(uri);
        return response.build();
    }

    @PostMapping("/{id}/check")
    public void check(
            @Auth Long memberId,
            @PathVariable("id") Long todoId
    ) {
        // TODO [9단계] todoId와 memberId를 todoService의 check 메소드에 전달하여
        //  Todo를 완료 상태로 변경하세요.
        todoService.check(todoId,memberId);
    }

    @PostMapping("/{id}/uncheck")
    public void uncheck(
            @Auth Long memberId,
            @PathVariable("id") Long todoId
    ) {
        // TODO [9단계] todoId와 memberId를 todoService의 uncheck 메소드에 전달하여
        //  Todo를 미완료 상태로 변경하세요.
        todoService.uncheck(todoId,memberId);
    }

    @PutMapping("/{id}")
    public void update(
            @Auth Long memberId,
            @PathVariable("id") Long todoId,
            @RequestBody TodoUpdateRequest request
    ) {
        // TODO [9단계] TodoUpdateRequest에서 content, date를 추출하고,
        //  todoId와 memberId를 함께 todoService의 update 메소드에 전달하여
        //  Todo 정보를 업데이트하세요.
        todoService.update(todoId,memberId,request.content(),request.date());
    }

    @DeleteMapping("/{id}")
    public void delete(
            @Auth Long memberId,
            @PathVariable("id") Long todoId
    ) {
        // TODO [9단계] todoId와 memberId를 todoService의 delete 메소드에 전달하여
        //  Todo를 삭제하세요.
    }

    @GetMapping("/my")
    public ResponseEntity<List<TodoWithDayResponse>> findMine(
            @Auth Long memberId,
            @RequestParam(value = "year", required = true) int year,
            @RequestParam(value = "month", required = true) int month
    ) {
        // TODO [9단계] memberId와 YearMonth.of(year, month)를 todoService의 findAllByMemberIdAndDate 메소드에 전달하여
        //  해당 기간의 모든 Todo를 조회하고,
        //  조회된 정보를 ResponseEntity.ok()에 담아 반환하세요.
        return null;
    }
}
