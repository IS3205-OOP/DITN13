package week06.slot01.assets.weapons;

import week06.slot01.assets.Pirate;
import week06.slot01.assets.interfaces.Consumable;

public class Drumstick extends Weapon implements Consumable {

	public Drumstick(int damage) {
		super(damage);
	}
	
	public String toString() {
		return "Drumstick [damage=" + getDamage() + "]";
	}
	
	public int doDamage(Pirate pirate) {
		if(pirate != null && pirate.getDefence() > 0) {
			return getDamage() * 2;
		}
		return -1;
	}

	@Override
	public void consumedBy(Pirate pirate) {
		if(pirate != null) {
			pirate.setHealth(getDamage());
		}
	}
	
}
