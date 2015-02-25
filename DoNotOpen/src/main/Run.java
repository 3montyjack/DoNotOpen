package main;

import javax.swing.SwingUtilities;

import attackEng.Inventory;
import attackEng.MobList;

public class Run {

	static MobList mobs;
	static Inventory inv;

	private Run() {

	}

	public static void main(String[] args) {
		mobs = new MobList();
		inv = new Inventory();
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				/*
				 * for (int i = 0; i < AttackInit.mobNumber(); i++) {
				 * System.out.println(mobs.getName(i));
				 * System.out.println(mobs.getType(i));
				 *  System.out.println(mobs.getHealth(i)); }
				 */

			}

		});
	}

}
