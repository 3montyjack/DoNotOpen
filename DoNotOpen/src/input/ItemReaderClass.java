package input;

import attackEng.ItemType;

public class ItemReaderClass extends ReaderClass {

	public ItemReaderClass(String path) {
		super(path);

	}

	public String getName(int itemNumber) {
		return getData(itemNumber, 0);
	}

	public ItemType getType(int itemNumber) {
		switch (Integer.parseInt(getData(itemNumber, 1))) {
		case 0:
			return ItemType.Weapon;
		case 1:
			return ItemType.Armor;
		case 3:
			return ItemType.Magic_Thing;
		default:
			return ItemType.none;

		}
	}

	public int getDamage(int itemNumber) {
		return Integer.parseInt(getData(itemNumber, 2));
	}

	public int getSpecial(int itemNumber) {
		return Integer.parseInt(getData(itemNumber, 3));
	}

}
