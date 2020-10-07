package kr.or.ddit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import kr.or.ddit.conf.BattleFiledContext;
import kr.or.ddit.conf.TerranUnitContext;
import kr.or.ddit.terran.building.Barrack;
import kr.or.ddit.terran.unit.FootSoldier;

@Service
public class BattlePlay {
	@Inject
	Barrack barrack;
	
	public void setBarrack(Barrack barrack) {
		this.barrack = barrack;
	}
	
	public static void main(String[] args) {
//		ConfigurableApplicationContext root = 
//				new ClassPathXmlApplicationContext("/kr/or/ddit/conf/auto/TerranUnit-Context.xml");
//		ConfigurableApplicationContext child = 
//				new ClassPathXmlApplicationContext(
//						new String[] {"/kr/or/ddit/conf/auto/BattleFiled-Context.xml"}, root); //컨테이너 사이에 계층구조 형성
		ConfigurableApplicationContext root = 
				new AnnotationConfigApplicationContext(TerranUnitContext.class); //위에 root 설정 작업과 동일
		AnnotationConfigApplicationContext child = 
				new AnnotationConfigApplicationContext();
		child.setParent(root);
		child.register(BattleFiledContext.class); //root가 먼저 생성되어야 battle이 가능해서 순서 이렇게 한 것.
		child.refresh();
		
		BattlePlay battle = child.getBean(BattlePlay.class);
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
