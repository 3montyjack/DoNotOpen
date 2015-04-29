package attackEng;

import main.AttackInit;

public class Inventory extends AttackInit {

	Item[][] itemList;
	Item[] itemMap;

	public Inventory() {
		itemList = new Item[mobNumber()][maxInventory];
		itemMap = new Item[itemNumber()];
		readToItemList();
		for (int slot = 0; slot < itemMap.length; slot++) {
			itemMap[slot] = new Item(getItemName(slot), getItemType(slot),
					getItemDamage(slot), getItemSpecial(slot));
		}
		try {
			for (int mob = 0; mob <= mobNumber() - 1; mob++) {
				for (int slot = 0; slot <= itemList.length - 1; slot++) {
					itemList[mob][slot] = itemMap[getDefaultItems(slot)];
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
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

	public ItemType getItemType(int mob, int slot) {
		//System.out.println("Ran getType");
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
			//TODO not done yet
		}
		
	}

	public boolean checkArmor(ItemType itemType) {
		if (itemType == ItemType.Armor) {
			return true;
		} else
			return false;
	}

	public boolean checkWeapon(ItemType itemType) {
		if (itemType == ItemType.Weapon) {
			return true;
		} else
			return false;
	}
	
	public boolean checkPotion(ItemType itemType) {
		if (itemType == ItemType.Potion) {
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
