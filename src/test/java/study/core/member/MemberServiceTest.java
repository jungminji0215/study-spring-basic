// MemberApp이랑 거의 같넹?
package study.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.core.AppConfig;

public class MemberServiceTest {
//    MemberService memberService = new MemberServiceImpl();

    MemberService memberService;
    
    @BeforeEach // 테스트 실행 전 무조건 실행
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given - ~~ 가 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when - 그것을 했을 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then - 결과
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
