package attackEng;

import main.AttackInit;

public class Inventory extends AttackInit {

	Item[][] itemList;
	Item[] itemMap;

	public Inventory() {
		itemList = new Item[mobNumber()][maxInventory];
		itemMap = new Item[itemNumber()];

		// try {
		for (int slot = 0; slot < itemMap.length; slot++) {
			itemMap[slot] = new Item(setItemName(slot), setItemType(slot),
					setItemDamage(slot), setItemSpecial(slot));
			// System.out.println("Attempt " + slot + ":" +
			// getItemName(slot)
			// + ":" + getItemType(slot) + ":" + getItemDamage(slot)
			// + ":" + getItemSpecial(slot));
		}
		// } //catch (ArrayIndexOutOfBoundsException e) {
		// TODO figure out if this is nessisary to do and why it is throwing
		// an error
		// }
		try {
			for (int mob = 0; mob <= mobNumber(); mob++) {
				for (int slot = 0; slot <= itemList.length; slot++) {
					itemList[mob][slot] = itemMap[getDefaultItems(slot)];
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO figure out if this is nessisary to do and why it is throwing
			// an error
		}

	}

	// Whenever Slots are changed for this update the switch statement
	public void setItem(int mob, int slot, int item) {
		switch (slot) {
		case 0:
			if (checkWeapon(itemMap[item].getType())) {
				itemList[mob][slot] = itemMap[item];
			} else {
				System.out.println("Error in setting item");
			}
			break;
		case 1:
			if (checkArmor(itemMap[item].getType())) {
				itemList[mob][slot] = itemMap[item];
			} else {
				System.out.println("Error in setting item");
			}
			break;
		default:
			itemList[mob][slot] = itemMap[item];

		}
	}

	public int getMaxInvVal() {
		return maxInventory;
	}

	public Item getItem(int mob, int slot) {
		return itemList[mob][slot];
	}

	public Item getItemFromList(int item) {
		return itemMap[item];
	}

	public String getItemName(int mob, int slot) {
		return itemList[mob][slot].getName();
	}

	public int getItemType(int mob, int slot) {
		System.out.println("Ran getType");
		return itemList[mob][slot].getType();
	}

	public int getItemDamage(int mob, int slot) {
		return itemList[mob][slot].getDamage();
	}

	public int getItemSpecial(int mob, int slot) {
		return itemList[mob][slot].getSpecial();
	}

	public void switchItem(int mob, int origSlot, int newSlot) {
		if (origSlot == getWeaponSlot() && newSlot == getWeaponSlot()) {
			
		}
		
	}

	public boolean checkArmor(int type) {
		if (type == getArmorSlot()) {
			return true;
		} else
			return false;
	}

	public boolean checkWeapon(int type) {
		System.out.println("Checked Weapon");
		if (type == getWeaponSlot()) {
			return true;
		} else
			return false;
	}

	public String getEquipedWeaponName(int mob) {
		return getItemName(mob, getWeaponSlot());
	}

	public int getEquipedWeaponDamage(int mob) {
		return getItemDamage(mob, getWeaponSlot());
	}

	public int getEquipedWeaponSpecial(int mob) {
		return getItemSpecial(mob, getWeaponSlot());
	}
	
	public String getEquipedArmorName(int mob) {
		return getItemName(mob, getArmorSlot());
	}

	public int getNonEquipS() {
		return NonEquipS;
	}

}
