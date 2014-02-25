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

	public Action weaponAttack();
	
	public int getAttackSpeed();
	
	public int getMissPercent();
	
	public String attackName();
}
