package kr.or.ddit.terran.building;

import javax.inject.Inject;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

import kr.or.ddit.terran.unit.Firebat;
import kr.or.ddit.terran.unit.FootSoldier;
import kr.or.ddit.terran.unit.Ghost;
import kr.or.ddit.terran.unit.Marine;
import kr.or.ddit.terran.unit.Medic;

@Repository
public class Barrack implements Trainnable {
	ApplicationContext context;
	
	@Inject
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
		String[] names = applicationContext.getBeanDefinitionNames();
		for(String name :  names) {
			System.err.println(name);
		}
		
	}
	
	@Override
	public FootSoldier traningSoldier(SoldierType type){
		FootSoldier soldier = null;
		switch (type) {
		case MARINE:
			soldier = context.getBean(Marine.class);
			break;
		case FIERBAT:
			soldier = context.getBean(Firebat.class);
			break;
		case MEDIC:
			soldier = context.getBean(Medic.class);
			break;
		case GHOST:
			soldier = context.getBean(Ghost.class);
			break;
		}
		return soldier;
	}
	@Override
	public FootSoldier[] traningSoldiers(SoldierType type, int num){
		if(num <= 0){
			throw new IllegalArgumentException("유닛의 숫자는 양수");
		}
		FootSoldier[] soldiers = new FootSoldier[num];
		for(int i=0; i<num; i++){
			soldiers[i]=traningSoldier(type);
		}
		return soldiers;
	}
	
	public FootSoldier[]  generateMarine(int num){
		return traningSoldiers(SoldierType.MARINE, num);
	}
	public FootSoldier[]  generateFirebat(int num){
		return traningSoldiers(SoldierType.FIERBAT, num);
	}
	public FootSoldier[]  generateGhost(int num){
		return traningSoldiers(SoldierType.GHOST, num);
	}
	public FootSoldier[]  generateMedic(int num){
		return traningSoldiers(SoldierType.MEDIC, num);
	}
	
	
}
