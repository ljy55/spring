package kr.or.ddit.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import kr.or.ddit.terran.building.Barrack;
import kr.or.ddit.terran.tool.FlameThrower;
import kr.or.ddit.terran.tool.InjectorWeapon;
import kr.or.ddit.terran.tool.NuclearWeapon;
import kr.or.ddit.terran.tool.RifleGun;
import kr.or.ddit.terran.unit.Firebat;
import kr.or.ddit.terran.unit.Ghost;
import kr.or.ddit.terran.unit.Marine;
import kr.or.ddit.terran.unit.Medic;

@Configuration
public class TerranUnitContext {
	@Bean //bean으로 등록됨
	@Scope("prototype")
	public InjectorWeapon injectWeapon() {
		return new InjectorWeapon();
	}
	
	@Bean("rifleFGun") //아이디 설정해준것. 아이디 안주면 메서드 이름이 아이디가됨
	@Scope("prototype")
	public RifleGun rifleGun() {
		return new RifleGun();
	}
	
	@Bean
	@Scope("prototype")
	public NuclearWeapon nuclearWeapon() {
		return new NuclearWeapon();
	}
	
	@Bean
	@Scope("prototype")
	public FlameThrower flameThrower() {
		return new FlameThrower();
	}
	
	@Bean
	public Marine marine(RifleGun weapon) {
		return new Marine(weapon);
	}
	
	@Bean
	public Firebat firebat(FlameThrower weapon) {
		return new Firebat(weapon);
	}
	
	@Bean
	public Ghost ghost(NuclearWeapon weapon) {
		return new Ghost(weapon);
	}
	
	@Bean
	public Medic medic(InjectorWeapon weapon) {
		return new Medic(weapon);
	}
	
	@Bean
	public Barrack barrack() {
		return new Barrack();
	}
}
