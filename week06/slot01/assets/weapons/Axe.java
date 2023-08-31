package week06.slot01.assets.weapons;

import week06.slot01.assets.Pirate;

public class Axe extends Weapon {

	public Axe(int damage) {
		super(damage);
	}

	@Override
	public String toString() {
		return "Axe [damage=" + getDamage() + "]";
	}
	
	public int doDamage(Pirate pirate) {
		if(pirate != null) {
			return getDamage();
		}
		return -1;
	}
	
}
