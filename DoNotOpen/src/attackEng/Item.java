package attackEng;

public class Item {

	String name;
	ItemType type;
	int damage;
	int special;

	public Item(String name, ItemType itemType, int damage, int special) {
		this.name = name;
		this.type = itemType;
		this.damage = damage;
		this.special = special;
	}

	public String getName() {
		return name;
	}

	public ItemType getType() {
		return type;
	}

	public int getDamage() {
		return damage;
	}

	public int getSpecial() {
		return special;
	}
}
