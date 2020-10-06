package kr.or.ddit.desc;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("foo1")
@Scope("singleton")
@Lazy
@DependsOn("baz2")
public class Foo {
	private Bar bar; //required
	private Baz baz; //optional
	
//	@Autowired
	@Inject
	public Foo(Bar bar) {
		super();
		this.bar = bar;
		System.out.println(bar + "가 주입됨, 생성자 주입");
	}
	
//	@Autowired
	@Resource(name="baz2")
	public void setBaz(Baz baz) {
		this.baz = baz;
		System.out.println(baz + "가 주입됨, setter injection");
	}
	
	public void init() {
		System.out.println(getClass() + " 객체 초기화");
	}
	
	public void destroy() {
		System.out.println(getClass() + " 객체 소멸");
	}
}
