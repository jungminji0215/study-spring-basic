package study.core.member;

public interface MemberService {
    
    // 회원 조회
    void join(Member member);
    
    // 회원 찾기
    Member findMember(Long memberId);
}
