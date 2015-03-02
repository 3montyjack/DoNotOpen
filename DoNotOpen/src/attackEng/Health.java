package attackEng;

import main.AttackInit;

public class Health {

	int health;

	public Health() {
	}

	public void setHealth(int value) {
		health = value;
	}

	public void subtractHealth(int value) {
		health = health - value;
		System.out.println("Health " + value + "  " + health);
		checkSubZero();
	}

	public void addHealth(int value) {
		health = health + value;
		checkAboveMax();
	}

	private void checkAboveMax() {
		if (health > AttackInit.maxHealth)
			health = AttackInit.maxHealth;
	}

	public int getHealth() {
		return health;
	}

	private void checkSubZero() {
		if (health < 0)
			health = 0;
	}

	public void setInitHealth(int i) {
		setHealth(i);
		
	}

}
