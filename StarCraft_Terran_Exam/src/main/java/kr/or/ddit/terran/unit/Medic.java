package kr.or.ddit.terran.unit;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import kr.or.ddit.terran.tool.InjectorWeapon;

@Component
public class Medic extends FootSoldier {

	InjectorWeapon weapon;
	
	@Inject
	public Medic(InjectorWeapon weapon) {
		super();
		this.weapon = weapon;
	}

	@Override
	public String walking() {
		return "시속 3km/s 의 속도로 걸어감.";
	}

	@Override
	protected String withWeapon() {
		return weapon.damage();
	}

}
