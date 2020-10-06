package kr.or.ddit.desc;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component("bar")
public class Bar {
	@PostConstruct
	public void init() {
		System.out.println(getClass() + " 객체 초기화");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println(getClass() + " 객체 소멸");
	}
}
