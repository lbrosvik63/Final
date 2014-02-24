package cs211;

import java.util.Random;
import java.util.Scanner;

import group.Action;
import group.ActionType;
import group.AttackWho;
import character.Character;

public abstract class CS211Enemy extends Character {

	private final int ROLEMAXVALUE = 15;
	private final int ROLEMINVALUE = 11;
	
	public CS211Enemy() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract Action primaryAttack() ;

	@Override
	public abstract Action secondaryAttack();

	@Override
	public Action roleAttack() {
		int value = generateAttackValue(ROLEMINVALUE, ROLEMAXVALUE);
		System.out.println(this + " produces a NullPointerException");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, 5);
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
