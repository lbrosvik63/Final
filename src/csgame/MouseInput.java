package csgame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MouseInput implements MouseListener {

	public MouseInput() {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
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
			
		case INVENTORY:
			//Inventory Scroll Left
			if(mx >= 58 && mx <= 98){
				if(my >= 272 && my <= 386){
					//Pressed  Button
					Game.inventory.itemsScrollLeft();
				}
			}
			
			//Inventory Scroll Right
			if (mx >= 808 && mx <= 848) {
				if (my >= 272 && my <= 386) {
					// Pressed  Button
					Game.inventory.itemsScrollRight();
				}
			}

			//Weapons Scroll Left
			if (mx >= 58 && mx <= 98) {
				if (my >= 520 && my <= 634) {
					// Pressed  Button
					Game.inventory.weaponsScrollLeft();
				}
			}

			//Weapons Scroll Right
			if (mx >= 808 && mx <= 848) {
				if (my >= 520 && my <= 634) {
					// Pressed Button
					Game.inventory.weaponsScrollRight();
				}
			}

			// Select 1st Item
			if (mx >= 151 && mx <= 291) {
				if (my >= 260 && my <= 405) {
					// Pressed Button
					Game.inventory.selectItem(0);
				}
			}
			// Select 2nd Item
			if (mx >= 378 && mx <= 518) {
				if (my >= 260 && my <= 405) {
					// Pressed Button
					Game.inventory.selectItem(1);
				}
			}
			// Select 3rd Item
			if (mx >= 600 && mx <= 740) {
				if (my >= 260 && my <= 405) {
					// Pressed Button
					Game.inventory.selectItem(2);
				}
			}
			
			// Select 1st Weapon
			if (mx >= 151 && mx <= 291) {
				if (my >= 508 && my <= 653) {
					// Pressed Button
					Game.inventory.selectWeapon(0);
				}
			}
			// Select 2nd Weapon
			if (mx >= 378 && mx <= 518) {
				if (my >= 508 && my <= 653) {
					// Pressed Button
					Game.inventory.selectWeapon(1);
				}
			}
			// Select 3rd Weapon
			if (mx >= 600 && mx <= 740) {
				if (my >= 508 && my <= 653) {
					// Pressed Button
					Game.inventory.selectWeapon(2);
				}
			}

			break;
			
		case BATTLE:
			//Primary Attack Button
			if(mx >= 350 && mx <= 550){
				if(my >= 125 && my <= 201){
					//Pressed  Button
					Game.battle.heroPrimaryAttack();
				}
			}
			
			//secondary Attack Button
			if (mx >= 350 && mx <= 550) {
				if (my >= 225 && my <= 301) {
					// Pressed  Button
					Game.battle.heroSecondaryAttack();
				}
			}

			// Role Attack Button
			if (mx >= 350 && mx <= 550) {
				if (my >= 325 && my <= 401) {
					// Pressed  Button
					Game.battle.heroRoleAttack();
				}
			}

			// Weapon Attack Button
			if (mx >= 350 && mx <= 550) {
				if (my >= 425 && my <= 501) {
					// Pressed  Button
					Game.battle.heroWeaponAttack();
				}
			}
			break;
								//TODO: THIS IS EXACT COPY OF case: BATTLE
		case BOSSBATTLE:
			//Primary Attack Button
			if(mx >= 350 && mx <= 550){
				if(my >= 125 && my <= 201){
					//Pressed  Button
					Game.battle.heroPrimaryAttack();
				}
			}
			
			//secondary Attack Button
			if (mx >= 350 && mx <= 550) {
				if (my >= 225 && my <= 301) {
					// Pressed  Button
					Game.battle.heroSecondaryAttack();
				}
			}

			// Role Attack Button
			if (mx >= 350 && mx <= 550) {
				if (my >= 325 && my <= 401) {
					// Pressed  Button
					Game.battle.heroRoleAttack();
				}
			}

			// Weapon Attack Button
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
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
