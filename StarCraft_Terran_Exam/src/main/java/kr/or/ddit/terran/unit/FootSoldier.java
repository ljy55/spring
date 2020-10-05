package kr.or.ddit.terran.unit;

public abstract class FootSoldier {

	
	protected abstract String walking();
	
	protected abstract String withWeapon();
	
	public void attack(){
		System.out.println("======="+this.getClass().getSimpleName()+"=======");
		System.out.println(walking());
		System.out.println(withWeapon());
		System.out.println("==============");
	}
	
}
