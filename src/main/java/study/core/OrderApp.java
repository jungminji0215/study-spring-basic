package study.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.core.member.Grade;
import study.core.member.Member;
import study.core.member.MemberService;
import study.core.order.Order;
import study.core.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {

//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        /*
            AppConfig appConfig = new AppConfig();
            MemberService memberService = appConfig.memberService();
            OrderService orderService = appConfig.orderService();

         */

        // 스프링으로 변경
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order.toString());
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
