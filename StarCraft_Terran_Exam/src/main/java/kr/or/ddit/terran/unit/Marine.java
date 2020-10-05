package kr.or.ddit.terran.unit;

import kr.or.ddit.terran.tool.RifleGun;

public class Marine extends FootSoldier {

	RifleGun weapon = new RifleGun();
	@Override
	public String walking() {
		return "시속 5km/s 의 속도로 걸어감.";
	}

	@Override
	protected String withWeapon() {
		return weapon.damage();
	}

}
