package attackEng;


import main.AttackInit;

public class HealthAll {

	int health;
	public HealthAll(int startHealth) {
		setHealth(startHealth);
	}
	
	public void setHealth(int value) {
		this.health = value;
	}
	
	public void subtractHealth(int value) {
		this.health = this.health - value;
		checkSubZero();
	}
	
	public void addHealth(int value) {
		this.health = this.health + value;
		checkAboveMax();
	}

	private void checkAboveMax() {
		if (this.health > AttackInit.maxHealth);	
	}
	
	public int getHealth() {
		return this.health;
	}

	private void checkSubZero() {
		if (this.health < 0)
			this.health = 0;
	}
	
}
