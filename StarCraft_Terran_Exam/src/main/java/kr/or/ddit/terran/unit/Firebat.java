package kr.or.ddit.terran.unit;

import kr.or.ddit.terran.tool.FlameThrower;
import kr.or.ddit.terran.tool.Weapon;

public class Firebat extends FootSoldier {
	Weapon weapon = new FlameThrower();
	
	@Override
	public String walking() {
		return "시속 2km/s 의 속도로 걸어감.";
	}

	@Override
	protected String withWeapon() {
		return weapon.damage();
	}

}
