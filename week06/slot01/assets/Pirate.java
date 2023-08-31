package week06.slot01.assets;

import week06.slot01.assets.interfaces.Placeable;
import week06.slot01.assets.weapons.Weapon;

public class Pirate implements Placeable {

	private final static int DEFAULT_HEALTH = 3;
	private final static String DEFAULT_NAME_PREFIX = "Pirate";
	private static int totalPirates = 1;
	public String name;
	private int health;
	private int defence;
	private Weapon weapon;
	
	public Pirate() {
		this(null, DEFAULT_HEALTH);
	}
	
	public Pirate(String name, int health) {
		if(name == null || name.isEmpty()) {
			this.name = DEFAULT_NAME_PREFIX + totalPirates;
			totalPirates++;
		} else {			
			this.name = name;
		}
		if(health <= 0) {
			this.health = DEFAULT_HEALTH;
		} else {			
			this.health = health;
		}
	}
	
	public Pirate(String name, int health, int defence) {
		this(name, health);
		if(defence < 0) {
			defence = 0;
		}
		this.defence = defence;
	}
	
	public void attackOtherPirate(Pirate otherPirate) {
		if(otherPirate != null) {
			if(weapon == null) {
				// If pirate not holding a weapon
				if(otherPirate.getDefence() <= 0) {			
					otherPirate.health--;
				}
			} else {
				// If pirate holding a weapon
				int damage = weapon.doDamage(otherPirate);
				if(damage > 0) {					
					int newHealth = otherPirate.health - damage;
					otherPirate.health = newHealth;
				}
			}
		}
	}
	
	public void equipWeapon(Weapon weapon) {
		if(weapon != null) {
			this.weapon = weapon;
		}
	}
	
	public void unEquipWeapon() {
		this.weapon = null;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		if(health < 0) {
			health = 1;
		}
		this.health = health;
	}
	
	public int getDefence() {
		return defence;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}

	public String toString() {
		return "[" + name + ", " + health + "h, " 
				+ defence + "d, " + weapon + "]";
	}
	
}
