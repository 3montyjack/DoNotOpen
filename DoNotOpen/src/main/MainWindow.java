package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import attackEng.Inventory;
import attackEng.MobList;
import javax.swing.JLayeredPane;

/* <applet code='MainWindow' width=400 height=100></applet> */

@SuppressWarnings("serial")
public class MainWindow extends JApplet {

	private final Action goToAttack = new SwingAction();
	private final Action playerDamage = new SwingAction_1();
	private final Action mobDamage = new SwingAction_2();
	private final Action goToInventory = new SwingAction_3();
	MobList mobs;
	Inventory inv;
	private JTextField pTxtF;
	private JTextField mTxtF;
	int pDamageInt;
	int mDamageInt;
	JSlider pSlider;
	JSlider mSlider;
	JProgressBar CurrentPlayerHealth;
	JProgressBar CurrentEnemyHealth;
	private final ButtonGroup attackBtns = new ButtonGroup();
	private JTextField pArmor;
	private JTextField mArmor;
	private JTextField potionsListInfo;
	private JTextField currentWeaponInfo;
	private JTextField currentArmorInfo;
	private JTextField currentArmor;
	private JTextField currentAttack;

	private String[] weapondsNEPlayer;
	private String[] armorNEPlayer;
	private JTextField currentWeapon;
	private JTextField currentAttackInfo;

	JPanel MainMenu;
	JPanel Attack;
	JPanel Inventory;
	private JTabbedPane tabbedPane;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MainWindow() {

		mobs = new MobList();
		inv = new Inventory();
		weapondsNEPlayer = new String[inv.getMaxInventory()
				- inv.getNonEquipS()];
		armorNEPlayer = new String[inv.getMaxInventory() - inv.getNonEquipS()];
		getContentPane().setBounds(0, 0, 1000, 1000);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		MainMenu = new JPanel();
		tabbedPane.addTab("Main Menu", null, MainMenu, null);
		MainMenu.setLayout(null);

		JTextField mainMenuTxt = new JTextField();
		mainMenuTxt.setForeground(new Color(0, 128, 0));
		mainMenuTxt.setText("<The Game>");
		mainMenuTxt.setFont(new Font("Times New Roman",
				Font.BOLD | Font.ITALIC, 31));
		mainMenuTxt.setEditable(false);
		mainMenuTxt.setBounds(26, 25, 409, 80);
		MainMenu.add(mainMenuTxt);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setAction(goToAttack);
		btnNewButton.setBounds(170, 142, 89, 23);
		MainMenu.add(btnNewButton);

		Attack = new JPanel();
		tabbedPane.addTab("Attack", null, Attack, null);
		// Attack.setVisible(false);
		Attack.setLayout(null);

		CurrentPlayerHealth = new JProgressBar();
		CurrentPlayerHealth.setBounds(10, 11, 146, 14);
		Attack.add(CurrentPlayerHealth);
		CurrentPlayerHealth.setValue(MobList.getHealth(mobs.getPlayerValue()));

		CurrentEnemyHealth = new JProgressBar();
		CurrentEnemyHealth.setBounds(289, 11, 146, 14);
		Attack.add(CurrentEnemyHealth);
		CurrentEnemyHealth.setValue(MobList.getHealth(mobs.getCurrentMob()));

		JButton btnInventory = new JButton("Inventory");
		btnInventory.setAction(goToInventory);
		attackBtns.add(btnInventory);
		btnInventory.setBounds(10, 238, 89, 23);
		Attack.add(btnInventory);

		JButton btnDamageE = new JButton("Damage E 10");
		btnDamageE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateBars();
			}
		});
		btnDamageE.setAction(mobDamage);
		attackBtns.add(btnDamageE);
		btnDamageE.setBounds(10, 204, 89, 23);
		Attack.add(btnDamageE);

		JButton btnDamageP = new JButton("Self Damage");
		btnDamageP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateBars();
			}
		});
		btnDamageP.setAction(playerDamage);
		attackBtns.add(btnDamageP);
		btnDamageP.setBounds(10, 170, 89, 23);
		Attack.add(btnDamageP);

		JButton btnReset = new JButton("Reset");
		attackBtns.add(btnReset);
		btnReset.setBounds(10, 136, 89, 23);
		Attack.add(btnReset);

		mSlider = new JSlider();
		mSlider.setValue(10);
		mSlider.setSnapToTicks(true);
		mSlider.setPaintTicks(true);
		mSlider.setMajorTickSpacing(1);
		mSlider.setMaximum(15);
		mSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				mTxtF.setText(Integer.toString(mSlider.getValue()));
				mDamageInt = mSlider.getValue();

			}
		});
		mSlider.setBounds(154, 204, 200, 47);
		Attack.add(mSlider);

		pTxtF = new JTextField();
		pTxtF.setToolTipText("Player damage input");
		pTxtF.setEditable(false);
		pTxtF.setBounds(359, 151, 86, 20);
		Attack.add(pTxtF);
		pTxtF.setColumns(10);

		mTxtF = new JTextField();
		mTxtF.setToolTipText("Mob damage Input");
		mTxtF.setEditable(false);
		mTxtF.setBounds(359, 209, 86, 20);
		Attack.add(mTxtF);
		mTxtF.setColumns(10);

		pSlider = new JSlider();
		pSlider.setValue(10);
		pSlider.setMajorTickSpacing(1);
		pSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				pTxtF.setText(Integer.toString(pSlider.getValue()));
				pDamageInt = pSlider.getValue();
			}
		});
		pSlider.setMaximum(15);
		pSlider.setSnapToTicks(true);
		pSlider.setPaintTicks(true);
		pSlider.setBounds(154, 151, 200, 47);
		Attack.add(pSlider);

		pArmor = new JTextField();
		pArmor.setEditable(false);
		pArmor.setBounds(10, 36, 86, 20);
		pArmor.setText(Integer.toString(MobList.getArmorValue(mobs
				.getPlayerValue())));
		Attack.add(pArmor);
		pArmor.setColumns(10);

		mArmor = new JTextField();
		mArmor.setEditable(false);
		mArmor.setBounds(349, 36, 86, 20);
		mArmor.setText(Integer.toString(MobList.getArmorValue(mobs
				.getCurrentMob())));
		Attack.add(mArmor);
		mArmor.setColumns(10);

		Inventory = new JPanel();
		tabbedPane.addTab("Inventory", null, Inventory, null);
		// Inventory.setVisible(false);
		Inventory.setLayout(null);

		currentArmorInfo = new JTextField();
		currentArmorInfo.setEditable(false);
		currentArmorInfo.setText("Current Armor");
		currentArmorInfo.setBounds(10, 10, 96, 20);
		Inventory.add(currentArmorInfo);
		currentArmorInfo.setColumns(10);

		currentWeaponInfo = new JTextField();
		currentWeaponInfo.setHorizontalAlignment(SwingConstants.LEFT);
		currentWeaponInfo.setEditable(false);
		currentWeaponInfo.setText("Current Weapon");
		currentWeaponInfo.setBounds(120, 10, 96, 20);
		Inventory.add(currentWeaponInfo);
		currentWeaponInfo.setColumns(10);

		potionsListInfo = new JTextField();
		potionsListInfo.setEditable(false);
		potionsListInfo.setText("Potions");
		potionsListInfo.setBounds(230, 10, 86, 20);
		Inventory.add(potionsListInfo);
		potionsListInfo.setColumns(10);

		currentWeapon = new JTextField();
		currentWeapon.setEditable(false);
		currentWeapon.setText(inv.getEquipedWeaponName(mobs.getPlayerValue()));
		currentWeapon.setBounds(10, 40, 96, 20);
		Inventory.add(currentWeapon);
		currentWeapon.setColumns(10);

		currentArmor = new JTextField();
		currentArmor.setEditable(false);
		currentArmor.setText(inv.getEquipedArmorName(mobs.getPlayerValue()));
		currentArmor.setBounds(120, 40, 96, 20);
		Inventory.add(currentArmor);
		currentArmor.setColumns(10);

		currentAttackInfo = new JTextField();
		currentAttackInfo.setEditable(false);
		currentAttackInfo.setText("Current Attack");
		currentAttackInfo.setBounds(339, 40, 86, 20);
		Inventory.add(currentAttackInfo);
		currentAttackInfo.setColumns(10);

		currentAttack = new JTextField();
		currentAttack.setEditable(false);
		currentAttack.setBounds(435, 40, 50, 20);
		Inventory.add(currentAttack);
		currentAttack.setColumns(10);

		JList weapondsList = new JList(weapondsNEPlayer);
		weapondsList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && !e.isConsumed()) {
					e.consume();
					// TODO Write override the item and switch
				}
			}
		});
		weapondsList.setBorder(null);
		weapondsList.setValueIsAdjusting(true);
		weapondsList.setBounds(10, 70, 96, 194);
		Inventory.add(weapondsList);

		JList armorList = new JList(armorNEPlayer);
		armorList.setBounds(120, 70, 96, 196);
		Inventory.add(armorList);

		JList potionsList = new JList();
		potionsList.setBounds(230, 41, 86, 222);
		Inventory.add(potionsList);

		writeNameArrayArmorPlayer(mobs.getPlayerValue());
		writeNameArrayWeaponsPlayer(mobs.getPlayerValue());

	}

	public void writeNameArrayArmorPlayer(int mob) {
		try {
			for (int i = 0; i < armorNEPlayer.length; i++) {
				if (inv.checkArmor(inv.getItemType(mob, i + inv.getNonEquipS()))) {
					System.out.println("iteration " + i);
					// System.out.println(inv.getItemName(mob, i));
					armorNEPlayer[i] = inv.getItemName(mob,
							i + inv.getNonEquipS());
				} else {
					System.out.println("iteration else " + i);
					// System.out.println(inv.getItemName(mob, i));
					armorNEPlayer[i] = inv.getNothingSlot();
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error?");
		}
		// catch (NullPointerException e) {System.out.println("Caught it");}
	}

	public void writeNameArrayWeaponsPlayer(int mob) {
		try {
			for (int i = 0; i < weapondsNEPlayer.length; i++) {
				if (inv.checkWeapon(inv.getItemType(mob, i + inv.getNonEquipS()))) {
					System.out.println("iteration " + i);
					// System.out.println(inv.getItemName(mob, i));
					weapondsNEPlayer[i] = inv.getItemName(mob,
							i + inv.getNonEquipS());
				} else {
					System.out.println("iteration else " + i);
					// System.out.println(inv.getItemName(mob, i));
					weapondsNEPlayer[i] = inv.getNothingSlot();
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error?");
		}
		// catch (NullPointerException e) {System.out.println("Caught it");}
	}

	public void writeNameArrayPotionPlayer(int mob) {
		try {
			for (int i = 0; i < weapondsNEPlayer.length; i++) {
				if (inv.checkWeapon(inv.getItemType(mob, i + inv.getNonEquipS()))) {
					System.out.println("iteration " + i);
					// System.out.println(inv.getItemName(mob, i));
					weapondsNEPlayer[i] = inv.getItemName(mob,
							i + inv.getNonEquipS());
				} else {
					System.out.println("iteration else " + i);
					// System.out.println(inv.getItemName(mob, i));
					weapondsNEPlayer[i] = inv.getNothingSlot();
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error?");
		}
		// catch (NullPointerException e) {System.out.println("Caught it");}
	}

	protected void updateBars() {
		CurrentEnemyHealth.setValue(MobList.getHealth(mobs.getCurrentMob()));
		CurrentPlayerHealth.setValue(MobList.getHealth(mobs.getPlayerValue()));
		// System.out.println("Update?");
		// System.out.println(MobList.getHealth(mobs.getPlayerValue()));

	}

	/////////////////////////////////////////////////////////////////////////////

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Start\r\n");
			putValue(SHORT_DESCRIPTION, "");
		}

		public void actionPerformed(ActionEvent e) {
			/*
			 * MainMenu.setVisible(false); Attack.setVisible(true);
			 * Inventory.setVisible(false);
			 */
			tabbedPane.setSelectedIndex(1);;
		}
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "PDamage");
			putValue(SHORT_DESCRIPTION, "Damage the Player");
		}

		public void actionPerformed(ActionEvent e) {
			MobList.damageMob(mobs.getPlayerValue(), pDamageInt);
		}
	}

	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "MDamage");
			putValue(SHORT_DESCRIPTION, "Damage to the mob");
		}

		public void actionPerformed(ActionEvent e) {
			MobList.damageMob(mobs.getCurrentMob(), mDamageInt);
		}
	}

	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Inventory");
			putValue(SHORT_DESCRIPTION, "Go To Inventory");
		}

		public void actionPerformed(ActionEvent e) {
			/*
			 * MainMenu.setVisible(false); Attack.setVisible(false);
			 * Inventory.setVisible(true);
			 */
			tabbedPane.setSelectedIndex(2);
		}
	}
}
