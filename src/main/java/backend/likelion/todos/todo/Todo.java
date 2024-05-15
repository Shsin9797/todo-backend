package backend.likelion.todos.todo;

import backend.likelion.todos.common.ForbiddenException;
import backend.likelion.todos.goal.Goal;
import backend.likelion.todos.member.Member;
import jakarta.persistence.*;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
// TODO [10 단계] : 롬봉을 통해 기본 생성자를 PROTECTED 접근 제한자로 생성하세요.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// TODO [10 단계] : Todo 객체를 Entity 로 정의하세요.
@Entity
public class Todo {

    // TODO [10 단계] : id를 PK, Auto Increment로 설정하세요.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private LocalDate date;

    // TODO [10 단계] : todo 와 goal 과의 관계를 설정합니다. (join 하는 컬럼명은 goal_id로 설정합니다.), 지연 로딩을 사용합니다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goal_id")
    private Goal goal;
    private boolean isCompleted;

    public Todo(String content, LocalDate date, Goal goal) {
        this.content = content;
        this.date = date;
        this.goal = goal;
        this.isCompleted = false;
    }

    public void validateMember(Member member) {
        if (!this.goal.getMember().equals(member)) {
            throw new ForbiddenException("해당 투두에 대한 권한이 없습니다.");
        }
    }

    public void update(String content, LocalDate date) {
        this.content = content;
        this.date = date;
    }

    public void check() {
        this.isCompleted = true;
    }

    public void uncheck() {
        this.isCompleted = false;
    }
}
