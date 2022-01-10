package study.core;

import study.core.discount.FixDiscountPolicy;
import study.core.member.MemberService;
import study.core.member.MemberServiceImpl;
import study.core.member.MemoryMemberRepository;
import study.core.order.OrderService;
import study.core.order.OrderServiceImpl;

// 생성자 주입을 해보자
// AppConfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
public class AppConfig {

    public MemberService memberService() {
        // 참조 값을 넘겨주는 것.
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
