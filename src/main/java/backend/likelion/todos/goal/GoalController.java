package backend.likelion.todos.goal;

import backend.likelion.todos.auth.Auth;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/goals")
@RestController
public class GoalController {

    private final GoalService goalService;

    @PostMapping
    public ResponseEntity<Void> create(
            @Auth Long memberId,
            @RequestBody GoalCreateRequest request
    ) {
        // TODO [8단계] GoalCreateRequest에서 이름과 색상을 추출하여 goalService의 save 메소드를 호출하고,
        String name = request.name();
        String color = request.color();
        long saveInfo = goalService.save(name,color,memberId);
        //  TODO 생성된 Goal의 ID로 URI를 생성하여 ResponseEntity를 반환하세요.
        URI uri = URI.create(String.valueOf(saveInfo));
        ResponseEntity.BodyBuilder responseEntity = ResponseEntity.created(uri);

        return responseEntity.build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable("id") Long id,
            @Auth Long memberId,
            @RequestBody GoalUpdateRequest request
    ) {
        // TODO [8단계] GoalUpdateRequest에서 이름과 색상을 추출하고,
        //  id와 memberId를 함께 goalService의 update 메소드에 전달하여
        //  Goal 정보를 업데이트한 후,
        //  ResponseEntity.ok()를 반환하세요.
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable("id") Long id,
            @Auth Long memberId
    ) {
        // TODO [8단계] id와 memberId를 goalService의 delete 메소드에 전달하여 Goal을 삭제하고,
        //  ResponseEntity.ok()를 반환하세요.
        return null;
    }

    @GetMapping("/my")
    public ResponseEntity<List<GoalResponse>> findMine(
            @Auth Long memberId
    ) {
        // TODO [8단계] memberId를 goalService의 findAllByMemberId 메소드에 전달하여
        //  해당 회원의 모든 Goal 정보를 조회하고,
        //  조회된 정보를 ResponseEntity.ok()에 담아 반환하세요.
        return null;
    }
}
