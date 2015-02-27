package attackEng;

import main.AttackInit;

public class MobList extends AttackInit {

	Mob[] mobList = new Mob[mobNumber()];
	private int currentEnemy;

	public MobList() {
		currentEnemy = 1;
		try {
			for (int slot = 0; slot <= mobList.length; slot++) {
				// System.out.println("Attempt" + slot);
				mobList[slot] = new Mob(setMobName(slot), setMobType(slot));
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// System.out.println("Umm Error?");
		}
	}
	
	public int getPlayerValue() {
		return 0;
	}
	
	public void damageMob(int mob, int damage) {
		mobList[mob].damage(damage);
	}
	
	public void healMob(int mob, int damage) {
		mobList[mob].heal(damage);
	}

	public String getMobName(int slot) {
		return mobList[slot].getName();
	}

	public int getHealth(int slot) {
		return mobList[slot].getHealth();
	}
	
	public int getCurrentEnemy() {
		return currentEnemy;
	}

}
