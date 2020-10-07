package kr.or.ddit.terran.unit;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import kr.or.ddit.terran.tool.RifleGun;

@Component
public class Marine extends FootSoldier {

	RifleGun weapon;
	
	@Inject
	public Marine(RifleGun weapon) {
		super();
		this.weapon = weapon;
	}

	@Override
	public String walking() {
		return "시속 5km/s 의 속도로 걸어감.";
	}

	@Override
	protected String withWeapon() {
		return weapon.damage();
	}

}
