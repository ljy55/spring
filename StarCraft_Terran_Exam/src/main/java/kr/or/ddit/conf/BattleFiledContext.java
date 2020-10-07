package kr.or.ddit.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.BattlePlay;
import kr.or.ddit.terran.building.Barrack;

@Configuration
public class BattleFiledContext {
	
	@Bean
	public BattlePlay battlePlay(Barrack barrack) {
		BattlePlay play = new BattlePlay();
		play.setBarrack(barrack);
		return play;
	}
}
