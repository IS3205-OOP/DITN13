package week06.slot01.assets.weapons;

import week06.slot01.assets.Pirate;

public class Gun extends Weapon {

	private int ammo;
	
	public Gun(int damage, int ammo) {
		super(damage);
		if(ammo <= 0) {
			ammo = 1;
		}
		this.ammo = ammo;
	}
	
	public String toString() {
		return "Gun [ammo=" + ammo + ", damage=" + getDamage() + "]";
	}
	
	public int doDamage(Pirate pirate) {
		if(pirate != null && ammo > 0) {
			ammo--;
			return getDamage();
		}
		return -1;
	}
	
}
