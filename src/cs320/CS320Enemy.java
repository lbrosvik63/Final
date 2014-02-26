package cs320;

import java.util.Random;
import java.util.Scanner;

import group.Action;
import group.ActionType;
import group.AttackWho;
import character.Character;
/*
 * All CS320 enemies can heal
 */
public abstract class CS320Enemy extends Character {
	
	public CS320Enemy() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract Action primaryAttack() ;

	@Override
	public abstract Action secondaryAttack();

	@Override
	public Action roleAttack() {
		System.out.println(this + " Increases its Space Complexity");
		int value = generateAttackValue2(stats.getBaseAttack(), stats.getAttackVariation());
		return new Action(ActionType.HEAL, AttackWho.ONE, value, 0);
	}

	@Override
	public void menuDisplay() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public Action menuSelection(Scanner sysIn){
		Random rand = new Random();
		int choice = rand.nextInt(4) + 1;//Number between 1 - 3
		if(choice == 1)
			return primaryAttack();
		if(choice == 2)
			return secondaryAttack();
		if(choice == 3)
			return roleAttack();
		else//TODO HANDLE ERROR CHECKING
			return actionMenu(sysIn);//Recursive Call if dont select number from menu
	}

}
