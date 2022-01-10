package study.core.order;

import study.core.discount.DiscountPolicy;
import study.core.discount.FixDiscountPolicy;
import study.core.member.Member;
import study.core.member.MemberRepository;
import study.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

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