package kr.or.ddit.terran.unit;

import kr.or.ddit.terran.tool.NuclearWeapon;

public class Ghost extends FootSoldier {
	NuclearWeapon weapon = new NuclearWeapon();

	@Override
	public String walking() {
		return "시속 1km/s 의 속도로 투명하게 걸어감.";
	}

	@Override
	protected String withWeapon() {
		return weapon.damage();
	}

}
