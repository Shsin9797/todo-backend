package backend.likelion.todos.goal;

import backend.likelion.todos.common.NotFoundException;
import backend.likelion.todos.member.Member;
import backend.likelion.todos.member.MemberRepository;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoalService {

    private final MemberRepository memberRepository;
    private final GoalRepository goalRepository;

    public Long save(String name, String color, Long memberId) {
        // TODO [8단계] memberId로 회원을 조회하고,
        //  조회에 실패하면 "회원 정보가 없습니다."
        //  예외를 발생시키세요.
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isEmpty()) {
            throw new NotFoundException("회원 정보가 없습니다.");
        }
        // TODO [8단계] 조회된 회원 정보를 사용하여 새 Goal 객체를 생성하세요.
        Goal newGoal = new Goal(name,color,member.get());
        // TODO [8단계] 생성된 Goal 객체를 goalRepository에 저장하고,
        goalRepository.save(newGoal);
        // TODO 저장된 Goal의 ID를 반환하세요.
        return newGoal.getId();
    }

    public void update(Long goalId, String name, String color, Long memberId) {
        // TODO [8단계] memberId로 회원을 조회하고,
        //  조회에 실패하면 "회원 정보가 없습니다." 예외를 발생시키세요.


        // TODO [8단계] goalId로 목표(Goal)를 조회하고,
        //  조회에 실패하면 "목표 정보가 없습니다." 예외를 발생시키세요.


        // TODO [8단계] 조회된 Goal의 회원 정보가 입력된 memberId와 일치하는지 검증하세요.

        // TODO [8단계] Goal 객체의 정보를 새로운 name과 color로 업데이트하세요.
    }

    public void delete(Long goalId, Long memberId) {
        // TODO [8단계] memberId로 회원을 조회하고,
        //  조회에 실패하면 "회원 정보가 없습니다." 예외를 발생시키세요.


        // TODO [8단계] goalId로 목표(Goal)를 조회하고,
        //  조회에 실패하면 "목표 정보가 없습니다." 예외를 발생시키세요.


        // TODO [8단계] 조회된 Goal의 회원 정보가 입력된 memberId와 일치하는지 검증하세요.

        // TODO [8단계] 검증이 완료되면 Goal을 goalRepository에서 삭제하세요.
    }

    public List<GoalResponse> findAllByMemberId(Long memberId) {
        // TODO [8단계] memberId로 모든 목표(Goal)를 조회하세요.

        // TODO [8단계] 조회된 Goal들을 GoalResponse 리스트로 변환하여 반환하세요.
        return null;
    }
}
