package study.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.core.member.Grade;
import study.core.member.Member;
import study.core.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {
        /*
           <스프링 없이 개발 해보기>
            MemberService memberService = new MemberServiceImpl(); // 이것을 수정한 것이 아래 두 줄

            AppConfig appConfig = new AppConfig();
            MemberService memberService = appConfig.memberService();
         */


        /*
            스프링은 모든 것이 ApplicationContext 라는 곳에서 시작. 얘가 모든 것을 관리해줌 예를들어 @Bean 붙인 것들...
            그러면 AppConfig에 있는 환경 설정 가지고 스프링이 객체 생성하고 컨테이너에 key, value로 넣어서 관리 함
            key : memberService
            value : new MemberServiceImpl
         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // 테스트 : main에서 테스트하는 것은 한계 있음 -> 테스트코드 작성하자
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
