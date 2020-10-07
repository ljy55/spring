package kr.or.ddit.terran.tool;

import org.springframework.stereotype.Component;

@Component
public class NuclearWeapon implements Weapon {
	
	@Override
	public String damage() {
		return "핵무기로 데미지 300의 공격";
	}

}
