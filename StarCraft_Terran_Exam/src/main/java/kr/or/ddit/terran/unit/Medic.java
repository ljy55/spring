package kr.or.ddit.terran.unit;

import kr.or.ddit.terran.tool.InjectorWeapon;

public class Medic extends FootSoldier {

	InjectorWeapon weapon = new InjectorWeapon();
	
	@Override
	public String walking() {
		return "시속 3km/s 의 속도로 걸어감.";
	}

	@Override
	protected String withWeapon() {
		return weapon.damage();
	}

}
