# java-reflection-dynamic_proxy


### 리플렉션
* 리플렉션이란 클래스의 메소드, 클래스 생성자, 인터페이스 등의 행위를 Runtime시에 검사하거나 수정하기 위해 사용되는 Java API 이다.

* 활용 및 주의
  * 스프링
    * 의존성 주입
    * MVC 뷰에서 넘어온 데이터를 객체에 바인딩 할 때
  * 하이버네이트
    * @Entity 클래스에 Setter가 없다면 리플렉션을 사용한다. 
  * Junit 
    *  https://junit.org/junit5/docs/5.0.3/api/org/junit/platform/commons/util/ReflectionUtils.html
  * 참고
    * https://docs.oracle.com/javase/tutorial/reflect/index.html
    
  * 리플렉션 사용 시 주의할 것
    * 지나친 사용은 성능 이슈를 야기할 수 있다. 반드시 필요한 경우에만 사용할 것
    * 컴파일 타임에 확인되지 않고 런타임 시에만 발생하는 문제를 만들 가능성이 있다.
    * 접근 지시자를 무시할 수 있다
   
  
### 다이나믹 프록시
* 런타임에 인터페이스 또는 클래스의 프록시 인스턴스 또는 클래스를 만들어 사용하는 프로그래밍 기법이다.

* 다이나믹 프록시 활용
  * Spring Data JPA
  * Hibernate Lazy Initialzation
  * Spring AOP
  * Mockito

* 참고
  * https://jenkov.com/tutorials/java-reflection/dynamic-proxies.html
  
  
