package kr.or.ddit.terran.building;

import kr.or.ddit.terran.unit.Firebat;
import kr.or.ddit.terran.unit.FootSoldier;
import kr.or.ddit.terran.unit.Ghost;
import kr.or.ddit.terran.unit.Marine;
import kr.or.ddit.terran.unit.Medic;

public class Barrack implements Trainnable {
	@Override
	public FootSoldier traningSoldier(SoldierType type){
		FootSoldier soldier = null;
		switch (type) {
		case MARINE:
			soldier = new Marine();
			break;
		case FIERBAT:
			soldier = new Firebat();
			break;
		case MEDIC:
			soldier = new Medic();
			break;
		case GHOST:
			soldier = new Ghost();
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
