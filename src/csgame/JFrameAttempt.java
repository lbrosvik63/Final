package csgame;

import javax.swing.JFrame;


public class JFrameAttempt {

	public JFrameAttempt() {
		JFrame frame = new JFrame();
		frame.setTitle("Map Game");
		frame.add(new StartingClass());
		frame.setSize(900,800);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new JFrameAttempt();

	}

}
