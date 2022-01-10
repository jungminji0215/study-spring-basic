package study.core.member;

public class MemberServiceImpl implements MemberService {

    // MemberServiceImpl은 MemberRepository도 의존하고 (추상화에 의존),
    // MemoryMemberRepository도 의존하는 문제점이 있음 (구체화에 의존)
    // -> DIP 위반...
//    private final MemberRepository memberRepository = new MemoryMemberRepository();


    private final MemberRepository memberRepository;

    // 생서자를 통해서 memberRepository의 구현체에 뭐가 들어갈지 정한다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void join(Member member) {

        // 다형성에 의해서 MemoryMemberRepository의 오버라이딩한 save 호출!
        memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
