package kr.or.ddit.desc;

import org.springframework.stereotype.Service;

@Service
public class Baz {
	public void init() {
		System.out.println(getClass() + " 객체 초기화");
	}
	
	public void destroy() {
		System.out.println(getClass() + " 객체 소멸");
	}
}
