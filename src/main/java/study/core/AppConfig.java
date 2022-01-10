package study.core;

import study.core.discount.DiscountPolicy;
import study.core.discount.FixDiscountPolicy;
import study.core.member.MemberService;
import study.core.member.MemberServiceImpl;
import study.core.member.MemoryMemberRepository;
import study.core.order.OrderService;
import study.core.order.OrderServiceImpl;

// 생성자 주입을 해보자
// AppConfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
// AppConfig는 중복이 없고 역할에 따른 구현이 잘 보여야 한다.
public class AppConfig {

    public MemberService memberService() {
        // 참조 값을 넘겨주는 것.
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
