package week06.slot01.assets;

import week06.slot01.assets.interfaces.Consumable;
import week06.slot01.assets.interfaces.Placeable;
import week06.slot01.assets.weapons.Weapon;

public class Map {

	public final static String DIRECTION_UP = "up";
	public final static String DIRECTION_DOWN = "down";
	public final static String DIRECTION_LEFT = "left";
	public final static String DIRECTION_RIGHT = "right";
	private Placeable[][] arena;

	public Map(int width, int height) {
		if(width <= 0) {
			width = 5;
		}
		if(height <= 0) {
			height = 5;
		}
		arena = new Placeable[width][height];
	}

	public boolean checkCoordinate(int x, int y) {
		if(x >= 0 && x < getWidth() && y >= 0 && y < getHeight()) {			
			return true;
		}
		return false;
	}

	public void movePirateUp(int currentX, int currentY) {
		this.movePirate(currentX, currentY, DIRECTION_UP);
	}

	public void movePirateDown(int currentX, int currentY) {
		this.movePirate(currentX, currentY, DIRECTION_DOWN);
	}

	public void movePirateLeft(int currentX, int currentY) {
		this.movePirate(currentX, currentY, DIRECTION_LEFT);
	}

	public void movePirateRight(int currentX, int currentY) {
		this.movePirate(currentX, currentY, DIRECTION_RIGHT);
	}

	public void movePirate(int currentX, int currentY, String direction) {
		if(direction.equalsIgnoreCase(DIRECTION_UP)) {
			this.movePirate(currentX, currentY - 1, currentX, currentY);
		} else if (direction.equalsIgnoreCase(DIRECTION_DOWN)) {
			this.movePirate(currentX, currentY + 1, currentX, currentY);
		} else if (direction.equalsIgnoreCase(DIRECTION_LEFT)) {
			this.movePirate(currentX - 1, currentY, currentX, currentY);
		} else if (direction.equalsIgnoreCase(DIRECTION_RIGHT)) {
			this.movePirate(currentX + 1, currentY, currentX, currentY);
		}
	}

	public void movePirate(int newX, int newY, int currentX, int currentY) {
		Pirate pirate = selectPirate(currentX, currentY);
		if(pirate != null) {
			Placeable newLocation = selectAsset(newX, newY);
			if(newLocation != null) {
				if(newLocation instanceof Pirate) {	
					Pirate otherPirate = (Pirate) newLocation;
					// Attack the other pirate
					pirate.attackOtherPirate(otherPirate);
					if(otherPirate.getHealth() <= 0) {
						arena[newX][newY] = null;
						arena[newX][newY] = pirate;
						arena[currentX][currentY] = null;
					}
					if(pirate.getWeapon() instanceof Consumable) {
						Consumable consumable = (Consumable) pirate.getWeapon();
						consumable.consumedBy(pirate);
						pirate.unEquipWeapon();
					}
				} else if(newLocation instanceof Weapon) {
					Weapon weapon = (Weapon) newLocation;
					pirate.equipWeapon(weapon);
					arena[newX][newY] = null;
					arena[newX][newY] = pirate;
					arena[currentX][currentY] = null;
				} else if(newLocation instanceof Consumable) {
					Consumable consumable = (Consumable) newLocation;
					consumable.consumedBy(pirate);
					arena[newX][newY] = null;
					arena[newX][newY] = pirate;
					arena[currentX][currentY] = null;
				}
			} else {
				if(checkCoordinate(newX, newY)) {					
					// Move the pirate to the new location
					arena[newX][newY] = pirate;
					arena[currentX][currentY] = null;
				}
			}
		}
	}
	
	public void addAsset(int x, int y, Placeable newPlaceable) {
		if(checkCoordinate(x, y)) {
			arena[x][y] = newPlaceable;
		}
	}

	public void addPirate(int x, int y, Pirate newPirate) {
		if(checkCoordinate(x, y)) {			
			arena[x][y] = newPirate;
		}
	}
	
	public Placeable selectAsset(int x, int y) {
		if(checkCoordinate(x, y)) {	
			return arena[x][y];
		}
		return null;
	}

	public Pirate selectPirate(int x, int y) {
		Placeable asset = selectAsset(x, y);
		if(asset instanceof Pirate) {
			return (Pirate) arena[x][y];
		}
		return null;
	}

	public int getWidth() {
		return arena.length;
	}

	public int getHeight() {
		return arena[0].length;
	}

}
