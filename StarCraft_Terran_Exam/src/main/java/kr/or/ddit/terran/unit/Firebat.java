package kr.or.ddit.terran.unit;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import kr.or.ddit.terran.tool.FlameThrower;
import kr.or.ddit.terran.tool.Weapon;

@Component
public class Firebat extends FootSoldier {
	Weapon weapon;
	
	public Firebat(@Autowired @Qualifier("flameThrower") Weapon weapon) { //Weapon으로 받고 있어서 뭔지 명시해주기 위해 위해 어노테이션 사용한거임
		super();
		this.weapon = weapon;
	}

	@Override
	public String walking() {
		return "시속 2km/s 의 속도로 걸어감.";
	}

	@Override
	protected String withWeapon() {
		return weapon.damage();
	}

}
