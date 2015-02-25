package attackEng;

import main.AttackInit;

public class MobList extends AttackInit {

	Mob[] mobList = new Mob[mobNumber()];

	public MobList() {
		try {
			for (int slot = 0; slot <= mobList.length; slot++) {
				// System.out.println("Attempt" + slot);
				mobList[slot] = new Mob(setMobName(slot), setMobType(slot));
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// System.out.println("Umm Error?");
		}
	}

	public String getMobName(int slot) {
		return mobList[slot].getName();
	}

	public int getHealth(int slot) {
		return mobList[slot].getHealth();
	}

}
