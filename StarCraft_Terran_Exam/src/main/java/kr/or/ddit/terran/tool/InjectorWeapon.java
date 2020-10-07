package kr.or.ddit.terran.tool;

import org.springframework.stereotype.Component;

@Component
public class InjectorWeapon implements Weapon {
	
	@Override
	public String damage() {
		return "주사기로 데미지 3의 공격";
	}

}
