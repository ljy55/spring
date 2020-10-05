package kr.or.ddit.terran.building;

import kr.or.ddit.terran.unit.Firebat;
import kr.or.ddit.terran.unit.FootSoldier;
import kr.or.ddit.terran.unit.Ghost;
import kr.or.ddit.terran.unit.Marine;
import kr.or.ddit.terran.unit.Medic;

public interface Trainnable {
	public static enum SoldierType{
		MARINE(Marine.class), MEDIC(Medic.class), FIERBAT(Firebat.class), GHOST(Ghost.class);
		Class<? extends FootSoldier> soldierClass;
		SoldierType(Class<? extends FootSoldier> clz){
			this.soldierClass = clz;
		}
	}
	
	public FootSoldier traningSoldier(SoldierType type);
	
	public FootSoldier[] traningSoldiers(SoldierType type, int num);
	
}