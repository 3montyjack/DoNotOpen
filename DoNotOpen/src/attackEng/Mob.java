package attackEng;

import main.AttackInit;

public class Mob {

	Health health;
	Armor armor;
	String name;
	int type;

	public Mob(String name, int type) {
		health = new Health();
		armor = new Armor();
		this.name = name;
		this.type = type;
		switch (type) {
		case 1:
			makeHuman();
			break;
		case 2:
			makeZombie();
			break;
		case 3:
			makeAlien();
			break;
		default:
			System.out.println("no Class");
			makeNull();
			break;
		}
	}

	private void makeNull() {
		health.setInitHealth(0);
		armor.setInitArmor(0);
	}

	private void makeAlien() {
		health.setInitHealth(AttackInit.alienHealth);
		armor.setInitArmor(AttackInit.alienArmor);

	}

	private void makeZombie() {
		health.setInitHealth(AttackInit.zombieHealth);
		armor.setInitArmor(AttackInit.zombieArmor);

	}

	private void makeHuman() {
		health.setInitHealth(AttackInit.humanHealth);
		armor.setInitArmor(AttackInit.humanArmor);

	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health.getHealth();
	}

	public int getArmor() {
		return armor.getArmor();
	}

	//FLAG This math killed me!!!
	private int damage(int ammount) {
		if (ammount > getArmor()) {
			return ammount - getArmor();
		} else
			return 0;
	}

	public void damageHealth(int damage) {
		//System.out.println("Fuck Me");
		health.subtractHealth(damage(damage));
	}

	public void heal(int damage) {
		health.addHealth(damage(damage));
		
	}

}
