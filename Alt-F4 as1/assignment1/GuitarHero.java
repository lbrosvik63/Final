//Team Alt+F4
//Luke Brosvik
//Mark Yevdash
//Mike Probst
//
//CSCD454
//Winter 2014
//Professor Tom Capaul
//1/10/2014

package assignment1;

public class GuitarHero 
{

	public static void main(String[] args) 
	{
		GameCharacter player1 = new JimiHendrix();
		GameCharacter player2 = new AngusYoung();
		GameCharacter player3 = new Slash();
		
		player1.useGuitar();
		player1.performSolo();
		System.out.println("");
		
		player2.useGuitar();
		player2.performSolo();
		System.out.println("");
		
		player3.useGuitar();
		player3.performSolo();
		System.out.println("");
		
		player1.setGuitar(new GibsonSG());
		player1.setSolo(new JumpOffStage());
		player1.useGuitar();
		player1.performSolo();
		
		player2.setGuitar(new GibsonFlyingV());
		player2.setSolo(new SetOnFire());
		player2.useGuitar();
		player2.performSolo();
		
		player3.setGuitar(new FenderTelecaster());
		player3.setSolo(new SmashGuitar());
		player3.useGuitar();
		player3.performSolo();
	}
}