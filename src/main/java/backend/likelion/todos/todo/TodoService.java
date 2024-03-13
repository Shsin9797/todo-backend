package backend.likelion.todos.todo;


import backend.likelion.todos.common.NotFoundException;
import backend.likelion.todos.goal.Goal;
import backend.likelion.todos.goal.GoalRepository;
import backend.likelion.todos.member.Member;
import backend.likelion.todos.member.MemberRepository;
import backend.likelion.todos.todo.TodoWithDayResponse.TodoResponse;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final MemberRepository memberRepository;
    private final GoalRepository goalRepository;
    private final TodoRepository todoRepository;

    // Todo를 저장하고 저장된 Todo의 ID를 반환합니다.
    public Long save(Long goalId, Long memberId, String content, LocalDate date) {
        // TODO [3단계] memberId로 회원 정보를 조회하고, 없으면 "회원 정보가 없습니다." 메시지와 함께 NotFoundException을 발생시키세요.
        Optional<Member> member = memberRepository.findById(memberId);
        if(member.isEmpty()) {
            throw new NotFoundException("회원 정보가 없습니다.");
        }
        // TODO [3단계] goalId로 목표 정보를 조회하고, 없으면 "목표 정보가 없습니다." 메시지와 함께 NotFoundException을 발생시키세요.
        Optional<Goal> goal = goalRepository.findById(goalId);
        if (goal.isEmpty()) {
            throw new NotFoundException("목표 정보가 없습니다.");
        }
        // TODO [3단계] 조회한 목표의 멤버가 입력된 멤버와 동일한지 확인하세요.
        goal.get().validateMember(member.get());
        // TODO [3단계] Todo 인스턴스를 생성하고 todoRepository에 저장한 후, 저장된 Todo의 ID를 반환하세요.
        Todo todo = new Todo(content,date,goal.get());

        return todoRepository.save(todo).getId();
    }

    // 주어진 Todo의 내용과 날짜를 업데이트합니다.
    public void update(Long todoId, Long memberId, String content, LocalDate date) {
        // TODO [3단계] memberId로 회원 정보를 조회하고, 없으면 "회원 정보가 없습니다." 메시지와 함께 NotFoundException을 발생시키세요.
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isEmpty()) {
            throw new NotFoundException("회원 정보가 없습니다.");
        }
        // TODO [3단계] todoId로 투두 정보를 조회하고, 없으면 "투두 정보가 없습니다." 메시지와 함께 NotFoundException을 발생시키세요.
        Optional<Todo> todo = todoRepository.findById(todoId);
        if (todo.isEmpty()) {
            throw new NotFoundException("투두 정보가 없습니다.");
        }
        // TODO [3단계] 조회한 투두의 멤버가 입력된 멤버와 동일한지 확인하고, 내용 및 날짜를 업데이트하세요.
        todo.get().validateMember(member.get());
        todo.get().update(content,date);
    }

    // 주어진 Todo를 완료 상태로 표시합니다.
    public void check(Long todoId, Long memberId) {
        // TODO [3단계] memberId로 회원 정보를 조회하고, 없으면 "회원 정보가 없습니다." 메시지와 함께 NotFoundException을 발생시키세요.
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isEmpty()) {
            throw new NotFoundException("회원 정보가 없습니다.");
        }
        // TODO [3단계] todoId로 투두 정보를 조회하고, 없으면 "투두 정보가 없습니다." 메시지와 함께 NotFoundException을 발생시키세요.
        Optional<Todo> todo = todoRepository.findById(todoId);
        if (todo.isEmpty()) {
            throw new NotFoundException("투두 정보가 없습니다.");
        }
        // TODO [3단계] 조회한 투두의 멤버가 입력된 멤버와 동일한지 확인하고, 투두를 완료 상태로 표시하세요.
        todo.get().validateMember(member.get());
        todo.get().check();
    }

    // 주어진 Todo를 미완료 상태로 표시합니다.
    public void uncheck(Long todoId, Long memberId) {
        // TODO [3단계] memberId로 회원 정보를 조회하고, 없으면 "회원 정보가 없습니다." 메시지와 함께 NotFoundException을 발생시키세요.
        // TODO [3단계] todoId로 투두 정보를 조회하고, 없으면 "투두 정보가 없습니다." 메시지와 함께 NotFoundException을 발생시키세요.
        // TODO [3단계] 조회한 투두의 멤버가 입력된 멤버와 동일한지 확인하고, 투두를 미완료 상태로 표시하세요.
    }

    // 주어진 Todo를 삭제합니다.
    public void delete(Long todoId, Long memberId) {
        // TODO [3단계] memberId로 회원 정보를 조회하고, 없으면 "회원 정보가 없습니다." 메시지와 함께 NotFoundException을 발생시키세요.
        // TODO [3단계] todoId로 투두 정보를 조회하고, 없으면 "투두 정보가 없습니다." 메시지와 함께 NotFoundException을 발생시키세요.
        // TODO [3단계] 조회한 투두의 멤버가 입력된 멤버와 동일한지 확인하고, 투두를 삭제하세요.
    }

    // 특정 회원 ID와 날짜에 해당하는 모든 Todo를 찾아 TodoWithDayResponse 리스트로 반환합니다.
    public List<TodoWithDayResponse> findAllByMemberIdAndDate(Long memberId, YearMonth date) {
        // TODO [3단계] memberId와 date를 사용하여 해당하는 모든 Todo를 조회하세요.
        // TODO [3단계] 조회된 Todo를 날짜별로 그룹화하고, 각 그룹을 TodoWithDayResponse 객체로 변환하여 리스트로 반환하세요.
        return null;
    }
}
