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
			//TODO: Primary Attack Button
			if(mx >= 350 && mx <= 550){
				if(my >= 125 && my <= 201){
					//Pressed  Button
					Game.battle.heroPrimaryAttack();
				}
			}
			
			//TODO: secondary Attack Button
			if (mx >= 350 && mx <= 550) {
				if (my >= 225 && my <= 301) {
					// Pressed  Button
					Game.battle.heroSecondaryAttack();
				}
			}

			// TODO: Role Attack Button
			if (mx >= 350 && mx <= 550) {
				if (my >= 325 && my <= 401) {
					// Pressed  Button
					Game.battle.heroRoleAttack();
				}
			}

			// TODO: Weapon Attack Button
			if (mx >= 350 && mx <= 550) {
				if (my >= 425 && my <= 501) {
					// Pressed  Button
					Game.battle.heroWeaponAttack();
				}
			}
			break;
								//TODO: THIS IS EXACT COPY OF case: BATTLE
		case BOSSBATTLE:
			//TODO: Primary Attack Button
			if(mx >= 350 && mx <= 550){
				if(my >= 125 && my <= 201){
					//Pressed  Button
					Game.battle.heroPrimaryAttack();
				}
			}
			
			//TODO: secondary Attack Button
			if (mx >= 350 && mx <= 550) {
				if (my >= 225 && my <= 301) {
					// Pressed  Button
					Game.battle.heroSecondaryAttack();
				}
			}

			// TODO: Role Attack Button
			if (mx >= 350 && mx <= 550) {
				if (my >= 325 && my <= 401) {
					// Pressed  Button
					Game.battle.heroRoleAttack();
				}
			}

			// TODO: Weapon Attack Button
			if (mx >= 350 && mx <= 550) {
				if (my >= 425 && my <= 501) {
					// Pressed  Button
					Game.battle.heroWeaponAttack();
				}
			}
			break;
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
