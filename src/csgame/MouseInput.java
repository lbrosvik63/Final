package csgame;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class MouseInput implements MouseListener {

	public MouseInput() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
	
		switch(Game.state){
		
		case MENU:
			//Play Button
			if(mx >= 350 && mx <= 450){
				if(my >= 150 && my <= 200){
					//Pressed Play Button
					Game.state = Game.state.GAME;
				}
			}
			
			// Help Button
			if (mx >= 350 && mx <= 450) {
				if (my >= 250 && my <= 300) {
					// Pressed Help Button
					Game.state = Game.state.BATTLE;
				}
			}

			// Quit Button
			if (mx >= 350	&& mx <= 450) {
				if (my >= 350 && my <= 400) {
					// Pressed Quit Button
					System.exit(1);
				}
			}
			break;
		case BATTLE:
			
		}//end switch
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
