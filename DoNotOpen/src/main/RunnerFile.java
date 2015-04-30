package main;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class RunnerFile {

	// static MobList mobs;

	//static ReaderClass reader;
	public static void main(String[] args) {

		try {
			SwingUtilities.invokeAndWait(new Runnable() {

				@Override
				public void run() {
					//reader = new ReaderClass("values.txt");
					JFrame frame = new JFrame();
					MainWindow wind = new MainWindow();
					// Inventory inv = new Inventory();

					frame.getContentPane().add(wind);
					frame.setSize(500, 500);
					frame.setVisible(true);
					wind.init();
					wind.start();
					// System.out.println(inv.getItemName(0, 3));

					// mobs = new MobList();
					// TODO Auto-generated method stub
					// MobList.damageMob(1,99);
					// System.out.println(MobList.getHealth(1));

				}

			});
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			System.out.println("Error001");
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
