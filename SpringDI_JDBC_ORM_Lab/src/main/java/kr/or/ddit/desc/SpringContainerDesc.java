package kr.or.ddit.desc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.service.ISampleService;
import kr.or.ddit.service.SampleServiceImpl;

/**
 * Spring DI Container 사용 단계
 * 1. spring-context(core,beans, context, expression) 모듈 추가
 * 2. Spring bean configuration file(bean definition metadata file) 생성
 * 3. config 파일에 컨테이너에 의해 관리될 객체(bean) 등록
 * 4. 등록된 빈들간의 의존관계 형성
 * 	1) 생성자 주입(constructor injection, 필수전략 주입시) : constructor-arg, c 
 * 	2) setter injection(optional 전략 주입시) : property, p 
 * 5. entry point 에서 컨테이너 객체 생성-초기화
 * 6. 컨테이너 내의 객체(bean)을 주입받아 사용(getBean)
 * 
 * Spring DI Container 의 빈 관리 특성
 * 1. 특별한 설정(scope, @Scope)이 없는 한, 빈을 singleton(싱글톤의 대상은 bean)으로 관리함
 * 		- singleton : bean의 instance는 한개 공유
 * 		- prototype : 주입시마다 새로운 객체 생성
 * 		- request/session(web)
 * 2. 특별한 설정(lazy-init, @Lazy)이 없는 한, 컨테이너가 초기화될때 모든 빈의 객체가 생성됨.
 * 		- lazy-init(@Lazy) 설정으로 객체의 생성 시점을 주입 전으로 미뤄놓을 수 있음.
 * 3. 직접적인 객체 생성 순서 제어 : depends-on(@DependsOn)
 * 4. 컨테이너에 의해 관리되는 빈의 생명주기 콜백 지정 : init-method(@PostConstruct), destroy-method(@PreDestroy)
 * 
 * 5. context:component-scan 으로 auto-injection
 * 6. Spring Container는 등록된 빈들중, 
 * 	  ApplicationContextAware 인터페이스의 구현체나,
 * 	  @Inject ApplicationContext context; 형태의 프로퍼티가 있으면,
 * 	   자신의 레퍼런스를 주입함
 * 
 *
 */
public class SpringContainerDesc {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("/kr/or/ddit/conf/Auto-Context.xml", 
																					"/kr/or/ddit/conf/Foo-Context.xml");
//		1. Foo 객체 한개 주입
		Foo foo = context.getBean("foo1",Foo.class);
//		2. Bar 객체 한개 주입
		Bar bar = context.getBean(Bar.class);
//		3. Baz 객체 두개 주입(서로 다른 객체 주입)
		Baz baz1 = context.getBean("baz2", Baz.class);
		Baz baz2 = context.getBean("baz", Baz.class);
//		4. 모든 객체 중에 Bar 객체 가장 먼저 생성.
//		5. 모든 객체는 생명주기 콜백을 가짐.
//		6. 주입되지 않은 객체는 생성하지 않음.
		context.close();
		
	}
}
