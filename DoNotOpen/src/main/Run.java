package main;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import attackEng.Inventory;
import attackEng.MobList;

public class Run {
	

	static MainWindow wind;
	private Run() {

	}

	public static void main(String[] args) {

		
		
		try {
			SwingUtilities.invokeAndWait(new Runnable() {

				@Override
				public void run() {
					wind = new MainWindow();
					// TODO Auto-generated method stub
					
				}
				
			});
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
