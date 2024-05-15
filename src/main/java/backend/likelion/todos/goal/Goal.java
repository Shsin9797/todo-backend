package backend.likelion.todos.goal;

import backend.likelion.todos.common.ForbiddenException;
import backend.likelion.todos.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
// TODO [10 단계] : 롬봉을 통해 기본 생성자를 PROTECTED 접근 제한자로 생성하세요.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// TODO [10 단계] : Goal 객체를 Entity 로 정의하세요.
@Entity
public class Goal {

    // TODO [10 단계] : id를 PK, Auto Increment로 설정하세요.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String color;

    // TODO [10 단계] : goal 과 member와의 관계를 설정합니다. (join 하는 컬럼명은 member_id로 설정합니다.), 지연 로딩을 사용합니다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public Goal(String name, String color, Member member) {
        this.name = name;
        this.color = color;
        this.member = member;
    }

    public void validateMember(Member member) {
        if (!this.member.equals(member)) {
            throw new ForbiddenException("해당 목표에 대한 권한이 없습니다.");
        }
    }

    public void update(String name, String color) {
        this.name = name;
        this.color = color;
    }
}
