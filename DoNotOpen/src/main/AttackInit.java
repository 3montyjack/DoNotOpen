package main;

import input.ItemReaderClass;
import input.MobReaderClass;
import attackEng.ItemType;
import attackEng.MobType;

public class AttackInit {
	static ItemReaderClass items = new ItemReaderClass("items.txt");
	static MobReaderClass mobs = new MobReaderClass("mobs.txt");
	
	// Health of Mobs
	public static int humanHealth = 100, zombieHealth = 100, alienHealth = 100;

	// Armor of Mobs
	public static int humanArmor = 10, zombieArmor = 10, alienArmor = 10;

	// MobList MOBS : Types List 0 = human, 1 = zombie, 2 = alien
	private static MobType[] mobType = new MobType[mobs.getNumValues()];

	private static String[] mobName = new String[mobs.getNumValues()];

	public static int mobNumber() {
		if (mobType.length == mobName.length)
			return mobType.length;
		else
			return 0;
	}
	
	public void readToMobList() {
		for (int i = 0; i < mobs.getNumValues(); i++) {
			mobName[i] = mobs.getName(i);
			mobType[i] = mobs.getType(i);
		}
	}

	// Items and Inventory

	// Whenever this is changed update set item in Inventory
	private static int weaponSlot = 0, armorSlot = 1;
	
	public static int maxInventory = 10;
	
	private String[] itemName = new String[items.getNumValues()];
	
	private ItemType[] itemType = new ItemType[items.getNumValues()];
	
	private int[] itemDamage = new int[items.getNumValues()];

	private int[] itemSpecial = new int[items.getNumValues()];
	
	public void readToItemList() {
		for (int i = 0; i < items.getNumValues(); i++) {
			itemName[i] = items.getName(i);
			itemType[i] = items.getType(i);
			itemDamage[i] = items.getDamage(i);
			itemSpecial[i] = items.getSpecial(i);
		}
	}

	

	// Item types 0 = Weapon , 1 = Armor , 2 = Potion , 3 = Whatever
	



	public static int maxHealth = 120;

	public static String emptySlot = "-Nothing-";

	public static int NonEquipS = 2;

	public int itemNumber() {
		if (itemName.length == itemType.length
				&& itemName.length == itemDamage.length
				&& itemName.length == itemSpecial.length)
			return itemName.length;
		else
			return 0;
	}

	public int getArmorSlot() {
		return armorSlot;
	}

	public int getWeaponSlot() {
		return weaponSlot;
	}

	/////////////////////////////////////////////////////

	private static int[] defaultItems = { 0, 1, 2, 3, 3, 3, 3, 2, 1, 0 };

	/////////////////////////////////////////////////////

	public MobType getMobType(int slot) {
		return mobType[slot];
	}

	public String getMobName(int slot) {
		return mobName[slot];
	}

	// //////////////////////////////////

	public ItemType getItemType(int slot) {
		return itemType[slot];
	}

	public String getItemName(int slot) {
		return itemName[slot];
	}

	public int getItemDamage(int slot) {
		return itemDamage[slot];
	}

	public int getItemSpecial(int slot) {
		return itemSpecial[slot];
	}

	// ///////////////////////////////////

	public int getMaxInventory() {
		return maxInventory;
	}

	// ///////////////////////////////////

	public int getDefaultItems(int slot) {
		return defaultItems[slot];
	}

	public String getNothingSlot() {
		return emptySlot;
	}

}
