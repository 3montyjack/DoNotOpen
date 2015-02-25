package attackEng;

import main.AttackInit;

public class Mob {

	Health health;
	Armor armor;
	String name;
	int type;

	public Mob(String name, int type) {
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
		health = new Health(0);
		armor = new Armor(0);
	}

	private void makeAlien() {
		health = new Health(AttackInit.alienHealth);
		armor = new Armor(AttackInit.alienArmor);

	}

	private void makeZombie() {
		health = new Health(AttackInit.zombieHealth);
		armor = new Armor(AttackInit.zombieArmor);

	}

	private void makeHuman() {
		health = new Health(AttackInit.humanHealth);
		armor = new Armor(AttackInit.humanArmor);

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

	public int damage(int ammount) {
		if (ammount < getArmor()) {
			return ammount - getArmor();
		} else
			return 0;
	}

	public void damageHealth(int damage) {
		health.subtractHealth(damage(damage));
	}

}
