package kr.or.ddit.terran.tool;

import org.springframework.stereotype.Component;

@Component
public class RifleGun implements Weapon {
	
	@Override
	public String damage() {
		return "라이플건으로 데미지 10의 공격";
	}

}
