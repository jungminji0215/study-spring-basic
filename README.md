# 스프링 핵심 원리

<br>

## 주요 내용
- ApplicationContext를 스프링 컨테이너라고 한다.
- 예전에는 AppConfig를 사용해서 객체를 생성했지만 이제 스프링이 알아서 객체를 생성해 준다.
- 싱글톤
  - 싱글톤 패턴은 여러 클라이언트가 하나의 객체 인스턴스를 공유하므로, 싱글톤 객체는 무상태(Stateless)로 설계해야 한다. 
  - 스프링 설정 정보는 @Configuration을 사용해야 싱글톤이 보장된다.
- 의존관계 주입
  - ⭐ 생성자 주입
    - 생성자가 1개면 @Autiwired 생략 가능
    - 생성자 주입을 사용하자.
  - 수정자 주입
  - 필드 주입
    - 외부에서 변경 불가능해서 테스트하기 힘들다.
    - 그냥 사용하지 말자.
  - 일반 메서드 주입
    - 거의 사용 X  
