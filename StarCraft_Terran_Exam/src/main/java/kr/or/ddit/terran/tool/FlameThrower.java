package kr.or.ddit.terran.tool;

import org.springframework.stereotype.Component;

@Component
public class FlameThrower implements Weapon {
	
	@Override
	public String damage() {
		return "화염방사기로 데미지 30의 공격";
	}

}
