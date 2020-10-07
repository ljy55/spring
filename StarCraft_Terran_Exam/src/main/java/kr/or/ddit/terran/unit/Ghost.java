package kr.or.ddit.terran.unit;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import kr.or.ddit.terran.tool.NuclearWeapon;

@Component
public class Ghost extends FootSoldier {
	NuclearWeapon weapon;
	
	@Inject
	public Ghost(NuclearWeapon weapon) {
		super();
		this.weapon = weapon;
	}

	@Override
	public String walking() {
		return "시속 1km/s 의 속도로 투명하게 걸어감.";
	}

	@Override
	protected String withWeapon() {
		return weapon.damage();
	}

}
