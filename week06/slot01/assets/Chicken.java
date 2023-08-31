package week06.slot01.assets;

import week06.slot01.assets.interfaces.Consumable;
import week06.slot01.assets.interfaces.Placeable;

public class Chicken implements Placeable, Consumable {

	private boolean raw;
	
	public Chicken(boolean raw) {
		this.raw = raw;
	}
	
	@Override
	public void consumedBy(Pirate pirate) {
		if(raw) {
			int newHealth = pirate.getHealth() - 1;
			pirate.setHealth(newHealth);
		} else {
			int newHealth = pirate.getHealth() + 2;
			pirate.setHealth(newHealth);
		}
	}

	@Override
	public String toString() {
		return "Chicken [raw=" + raw + "]";
	}

}
