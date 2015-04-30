package attackEng;

import main.AttackInit;

public class MobList extends AttackInit {

	static Mob[] mobList = new Mob[mobNumber()];
	private int currentEnemy;

	public MobList() {
		currentEnemy = 1;
		try {
			for (int slot = 0; slot <= mobList.length; slot++) {
				// System.out.println("Attempt" + slot);
				mobList[slot] = new Mob(getMobName(slot), getMobType(slot));
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// System.out.println("Umm Error?");
		}
	}
	
	public int getPlayerValue() {
		return 0;
	}
	
	public static void damageMob(int mob, int damage) {
		//System.out.println("Damage^2");
		mobList[mob].damageHealth(damage);
	}
	
	public void healMob(int mob, int damage) {
		mobList[mob].heal(damage);
	}
	
	public static int getArmorValue(int mob) {
		return mobList[mob].getArmor();
	}

	public String getMobName(int slot) {
		return mobList[slot].getName();
	}

	public static int getHealth(int slot) {
		//System.out.println("Umm Checked?");
		return mobList[slot].getHealth();
	}
	
	public int getCurrentMob() {
		return currentEnemy;
	}

}
