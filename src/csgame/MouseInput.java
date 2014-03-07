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
			if(mx >= 75 && mx <= 275){
				if(my >= 420 && my <= 496){
					//Pressed Play Button
					Game.state = Game.state.CHARACTERSELECT;
				}
			}
		

			// Quit Button
			if (mx >= 75	&& mx <= 275) {
				if (my >= 520 && my <= 596) {
					// Pressed Quit Button
					System.exit(1);
				}
			}
			break;
		case CHARACTERSELECT:
			//Cheater
			if(mx >= 75 && mx <= 171){
				if(my >= 200 && my <= 296){
					//Pressed  Button
					Game.cselect.addCharacter("Cheater");
				}
			}
			
			//Genius
			if (mx >= 75 && mx <= 171) {
				if (my >= 325 && my <= 419) {
					// Pressed  Button
					Game.cselect.addCharacter("Genius");
				}
			}

			//Jock
			if (mx >= 75 && mx <= 171) {
				if (my >= 450 && my <= 544) {
					// Pressed  Button
					Game.cselect.addCharacter("Jock");
				}
			}

			// Nerd
			if (mx >= 475 && mx <= 571) {
				if (my >= 200 && my <= 296) {
					// Pressed Button
					Game.cselect.addCharacter("Nerd");
				}
			}

			// Slacker
			if (mx >= 475 && mx <= 571) {
				if (my >= 325 && my <= 419) {
					// Pressed Button
					Game.cselect.addCharacter("Slacker");
				}
			}

			// Tutor
			if (mx >= 475 && mx <= 571) {
				if (my >= 450 && my <= 544)  {
					// Pressed Button
					Game.cselect.addCharacter("Tutor");
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
