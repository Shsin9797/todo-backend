package backend.likelion.todos.member;

import backend.likelion.todos.common.UnAuthorizedException;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
// TODO [10 단계] : 롬봉을 통해 기본 생성자를 PROTECTED 접근 제한자로 생성하세요.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
// TODO [10 단계] : Member 객체를 Entity 로 정의하세요.
public class Member {

    // TODO [10 단계] : id를 PK, Auto Increment로 설정하세요.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO [10 단계] : 아이디는 unique 제약 조건이 필요합니다.
    @Column(unique = true)
    private String username;

    private String password;
    private String nickname;
    private String profileImageUrl;

    public Member(String username, String password, String nickname, String profileImageUrl) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
    }

    public void login(String password) {
        if (this.password.equals(password)) {
            return;
        }
        throw new UnAuthorizedException("비밀번호가 일치하지 않습니다");
    }
}
