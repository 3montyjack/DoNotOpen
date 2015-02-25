package attackEng;

import main.AttackInit;

public class Inventory extends AttackInit {

	Item[][] itemList;
	Item[] itemMap;

	public Inventory() {
		itemList = new Item[mobNumber()][maxInventory];
		itemMap = new Item[itemNumber()];
		try {
			for (int slot = 0; slot <= itemMap.length; slot++) {
				itemMap[slot] = new Item(setItemName(slot), setItemType(slot),
						setItemDamage(slot), setItemSpecial(slot));
				//System.out.println("Attempt " + slot + ":" + getItemName(slot)
				//		+ ":" + getItemType(slot) + ":" + getItemDamage(slot)
				//		+ ":" + getItemSpecial(slot));
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO figure out if this is nessisary to do and why it is throwing
			// an error
		}
	}

	public void setItem(int mob, int slot, int item) {
		itemList[mob][slot] = itemMap[item];
	}

	public String getItemName(int mob, int slot) {
		return itemList[mob][slot].getName();
	}

	public int getItemType(int mob, int slot) {
		return itemList[mob][slot].getType();
	}

	public int getItemDamage(int mob, int slot) {
		return itemList[mob][slot].getDamage();
	}

	public int getItemSpecial(int mob, int slot) {
		return itemList[mob][slot].getSpecial();
	}

}
