package backend.likelion.todos.member;

import backend.likelion.todos.common.ConflictException;
import backend.likelion.todos.common.NotFoundException;
import backend.likelion.todos.common.UnAuthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원 가입을 처리하고, 저장된 회원의 ID를 반환합니다.
    public Long signup(String username, String password, String nickname, String profileImageUrl) {
        // TODO [1단계] username으로 기존 회원이 있는지 확인하고, 있으면 "해당 아이디로 이미 가입한 회원이 있습니다" 메시지와 함께 ConflictException을 발생시키세요.
        if (memberRepository.findByUsername(username).isPresent()) {
            throw new ConflictException("해당 아이디로 이미 가입한 회원이 있습니다");
        }

        // TODO [1단계] Member 인스턴스를 생성하세요.
        Member newMember = new Member(username,password,nickname,profileImageUrl);
        // TODO [1단계] 생성된 Member 인스턴스를 memberRepository에 저장하고, 저장된 멤버의 ID를 반환하세요.
        return memberRepository.save(newMember).getId();
    }

    // 로그인을 처리하고, 로그인한 회원의 ID를 반환합니다.
    public Long login(String username, String password) {
        // TODO [1단계] username으로 회원을 찾아오고, 없으면 "존재하지 않는 아이디입니다" 메시지와 함께 UnAuthorizedException을 발생시키세요.
        Optional<Member> member=  memberRepository.findByUsername(username);
        if (member.isEmpty()) {
            throw new UnAuthorizedException("존재하지 않는 아이디입니다");
        }
        // TODO [1단계] 찾아온 Member 인스턴스에 대해 password를 검증하세요.
        member.get().login(password);
        // TODO [1단계] 검증이 성공적이면, 해당 회원의 ID를 반환하세요.
        return member.get().getId();
    }

    // 회원 ID로 회원 정보를 조회하고, 그 결과를 MemberResponse로 반환합니다.
    public MemberResponse findById(Long memberId) {
        // TODO [1단계] memberId로 회원 정보를 찾아오고, 없으면 "회원 정보가 없습니다" 메시지와 함께 NotFoundException을 발생시키세요.
        Optional<Member> memberInfo = memberRepository.findById(memberId);
        if (memberInfo.isEmpty()) {
            throw new NotFoundException("회원 정보가 없습니다");
        }
        // TODO [1단계] 찾아온 Member 인스턴스로부터 MemberResponse 객체를 생성하여 반환하세요.
        Member member= memberInfo.get();
        return new MemberResponse(member.getId(),member.getUsername(),member.getNickname(),member.getProfileImageUrl());
    }
}
