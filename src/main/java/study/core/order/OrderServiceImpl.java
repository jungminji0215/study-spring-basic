package study.core.order;

import study.core.discount.DiscountPolicy;
import study.core.discount.FixDiscountPolicy;
import study.core.discount.RateDiscountPolicy;
import study.core.member.Member;
import study.core.member.MemberRepository;
import study.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // 새로운 할인 정책으로 변경해봄 -> 이것은... OCP를 위반한 코드이다. 변경이 일어남...
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    // 다음과 같이 변경하면 된다. 그리고 구현체는 OrderServiceImpl 전 단계에서 DiscountPolicy의 구현 객체를 대신 생성하고 주입해줘야 한다.
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        // 회원 찾기
        Member member = memberRepository.findById(memberId);

        // 할인 정책
        // 단일 책임 원칙 잘 지켜짐... OrderService 입장에서 할인 로직은 몰라도 됨
        int discountPrice = discountPolicy.discount(member, itemPrice);

        // 주문 만들어서 반환
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}