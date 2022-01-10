package study.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.core.discount.DiscountPolicy;
import study.core.discount.FixDiscountPolicy;
import study.core.discount.RateDiscountPolicy;
import study.core.member.MemberService;
import study.core.member.MemberServiceImpl;
import study.core.member.MemoryMemberRepository;
import study.core.order.OrderService;
import study.core.order.OrderServiceImpl;

/*
     생성자 주입을 해보자
     AppConfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
     AppConfig는 중복이 없고 역할에 따른 구현이 잘 보여야 한다.
     이것이 바로 DI 컨테이너라 할 수 있다. 스프링을 사용하면 스프링이 DI 컨테이너 역할을 한다.
 */
@Configuration
public class AppConfig {

    /*
        @Bean : 스프링 컨테이너에
     */
    @Bean
    public MemberService memberService() {
        // 참조 값을 넘겨주는 것.
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    // 할인 정책
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
