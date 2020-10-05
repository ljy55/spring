package kr.or.ddit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kr.or.ddit.terran.building.Barrack;
import kr.or.ddit.terran.unit.FootSoldier;

public class BattlePlay {
	Barrack barrack = new Barrack();
	
	public static void main(String[] args) {
		BattlePlay battle = new BattlePlay();
		battle.play();
	}
	
	public void play(){
		List<FootSoldier> army = new ArrayList<>();
		
		army.addAll(Arrays.asList(barrack.generateMarine(5)));
		army.addAll(Arrays.asList(barrack.generateFirebat(5)));
		army.addAll(Arrays.asList(barrack.generateGhost(5)));
		army.addAll(Arrays.asList(barrack.generateMedic(5)));
		
		for(FootSoldier soldier : army){
			soldier.attack();
		}
	}
}
