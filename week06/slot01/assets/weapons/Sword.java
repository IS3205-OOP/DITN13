package week06.slot01.assets.weapons;

import week06.slot01.assets.Pirate;

public class Sword extends Weapon {

	public Sword(int damage) {
		super(damage);
	}

	@Override
	public String toString() {
		return "Sword [damage=" + getDamage() + "]";
	}

	@Override
	public int doDamage(Pirate pirate) {
		if(pirate != null) {
			// weapon damage - pirate defence
			int newDamage = getDamage() - pirate.getDefence();
			return newDamage;
		}
		return -1;
	}
	
}
