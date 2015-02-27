package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import attackEng.Inventory;
import attackEng.MobList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class MainWindow extends JApplet {

	private final Action goToAttack = new SwingAction();
	private final Action playerDamage = new SwingAction_1();
	private final Action mobDamage = new SwingAction_2();

	private JTabbedPane tabbedPane;
	MobList mobs;
	Inventory inv;
	private JTextField pTxtF;
	private JTextField mTxtF;
	private int pDamageInt;
	private int mDamageInt;
	JSlider pSlider;
	JSlider mSlider;
	JProgressBar CurrentPlayerHealth;
	JProgressBar CurrentEnemyHealth;
	private final ButtonGroup attackBtns = new ButtonGroup();

	public MainWindow() {

		mobs = new MobList();
		inv = new Inventory();

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setSize(500, 500);

		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel MainMenu = new JPanel();
		tabbedPane.addTab("Main Menu", null, MainMenu, null);
		MainMenu.setLayout(null);

		JTextField mainMenuTxt = new JTextField();
		mainMenuTxt.setForeground(new Color(0, 128, 0));
		mainMenuTxt.setText("<Game Title Goes Here>");
		mainMenuTxt.setFont(new Font("Times New Roman",
				Font.BOLD | Font.ITALIC, 31));
		mainMenuTxt.setEditable(false);
		mainMenuTxt.setBounds(26, 25, 409, 80);
		MainMenu.add(mainMenuTxt);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setAction(goToAttack);
		btnNewButton.setBounds(170, 142, 89, 23);
		MainMenu.add(btnNewButton);

		JPanel Attack = new JPanel();
		tabbedPane.addTab("Attack", null, Attack, null);
		Attack.setLayout(null);

		CurrentPlayerHealth = new JProgressBar();
		CurrentPlayerHealth.setBounds(10, 11, 146, 14);
		Attack.add(CurrentPlayerHealth);
		CurrentPlayerHealth.setValue(mobs.getHealth(0));

		CurrentEnemyHealth = new JProgressBar();
		CurrentEnemyHealth.setBounds(289, 11, 146, 14);
		Attack.add(CurrentEnemyHealth);
		CurrentEnemyHealth.setValue(mobs.getHealth(mobs.getCurrentEnemy()));

		JButton btnInventory = new JButton("Inventory");
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

		JPanel Inventory = new JPanel();
		tabbedPane.addTab("Inventory", null, Inventory, null);

	}

	protected void updateBars() {
		CurrentEnemyHealth.setValue(mobs.getHealth(mobs.getCurrentEnemy()));
		CurrentPlayerHealth.setValue(mobs.getHealth(mobs.getPlayerValue()));
		System.out.println("Update?");
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Start\r\n");
			putValue(SHORT_DESCRIPTION, "");
		}

		public void actionPerformed(ActionEvent e) {
			tabbedPane.setSelectedIndex(1);
		}
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "PDamage");
			putValue(SHORT_DESCRIPTION, "Damage the Player");
		}

		public void actionPerformed(ActionEvent e) {
			mobs.damageMob(mobs.getPlayerValue(), pSlider.getValue());
		}
	}

	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "MDamage");
			putValue(SHORT_DESCRIPTION, "Damage to the mob");
		}

		public void actionPerformed(ActionEvent e) {
			mobs.damageMob(mobs.getCurrentEnemy(), mSlider.getValue());
		}
	}
}
