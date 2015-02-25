package attackEng;

public class Item {

	String name;
	int type;
	int damage;
	int special;

	public Item(String name, int type, int damage, int special) {
		this.name = name;
		this.type = type;
		this.damage = damage;
		this.special = special;
	}

	public String getName() {
		return name;
	}

	public int getType() {
		return type;
	}

	public int getDamage() {
		return damage;
	}

	public int getSpecial() {
		return special;
	}
}
