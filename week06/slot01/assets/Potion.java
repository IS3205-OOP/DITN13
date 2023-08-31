package week06.slot01.assets;

import week06.slot01.assets.interfaces.Consumable;
import week06.slot01.assets.interfaces.Placeable;

public class Potion implements Placeable, Consumable {

	int heal;
	
	public Potion(int heal) {
		if(heal <= 0) {
			heal = 1;
		}
		this.heal = heal;
	}
	
	public int getHeal() {
		return heal;
	}
	
	public String toString() {
		return "Potion [heal=" + heal + "]";
	}

	@Override
	public void consumedBy(Pirate pirate) {
		if(pirate != null) {
			int newHealth = pirate.getHealth() + heal;
			pirate.setHealth(newHealth);
		}
	}
	
}
