package backend.likelion.todos.member;

import backend.likelion.todos.common.UnAuthorizedException;
import lombok.Getter;

@Getter
public class Member {

    private Long id;
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

    public void setId(Long id) {
        this.id = id;
    }

    // 로그인을 시도하고 비밀번호가 일치하지 않으면 UnAuthorizedException을 발생시킵니다.
    public void login(String password) {
        // TODO [1단계] 입력받은 password가 이 객체의 password와 같은지 확인하세요. 같지 않다면 "비밀번호가 일치하지 않습니다" 메시지와 함께 UnAuthorizedException을 발생시키세요.
        if (password != this.password) {
            throw new UnAuthorizedException("비밀번호가 일치하지 않습니다");
        }
    }
}
