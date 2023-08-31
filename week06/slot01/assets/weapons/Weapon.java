package week06.slot01.assets.weapons;

import week06.slot01.assets.Pirate;
import week06.slot01.assets.interfaces.Placeable;

public abstract class Weapon implements Placeable {
	
	private int damage;
	
	public Weapon(int damage) {
		setDamage(damage);
	}
	
	public abstract int doDamage(Pirate pirate);
	
//	public int doDamage(Pirate pirate) {
//		if(pirate != null) {
//			// weapon damage - pirate defence
//			int newDamage = getDamage() - pirate.getDefence();
//			return newDamage;
//		}
//		return -1;
//	}
	
	public void setDamage(int damage) {
		if(damage < 1) {
			damage = 1;
		}
		this.damage = damage;
	}
	
	public int getDamage() {
		return damage;
	}

	@Override
	public String toString() {
		return "Weapon [damage=" + damage + "]";
	}

}
