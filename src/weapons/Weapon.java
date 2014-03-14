/**
 * 
 */
package weapons;

import group.Action;

/**
 * @author 2Watch
 *
 */
public interface Weapon{

	public String itemDescription();
	
	public Action weaponAttack();
	
	public int affectSpeed(int speed);
	
	public int getMissPercent();
	
	public String attackName();
}
