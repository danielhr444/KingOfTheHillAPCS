package net.phys2d.game;

import net.phys2d.math.ROVector2f;
import net.phys2d.math.Vector2f;
import net.phys2d.raw.BodyList;

/**
 * @author 
 */
public class ColissionHandler 
{

	/**
	 * boolean for checking if two players have collided
	 */
	private boolean collided;


	/**
	 * initalize collision handler
	 */
	public ColissionHandler()
	{	
		collided = false;
	}

	public boolean hasCollided()
	{
		return collided;
	}


	/**
	 * @param player1 the first player
	 * @param player2 the second player
	 * Checks if the two players have collided
	 */
	public void collide(Player player1, Player player2)
	{
		BodyList player1List = player1.getTouching();
		BodyList player2List = player2.getTouching();
		//System.out.println(player1.getVelocity().getX());
		//System.out.println(player2.getVelocity().getX());

		//System.out.println("Player 1 is touching player 2: " + player1List.contains(player2));

		//System.out.println("Player 2 is touching player 1: " + player2List.contains(player1));
		
		if (player1List.contains(player2) && player2List.contains(player1))
		{
			collided = true;
			if (Math.abs(player1.getVelocity().getX()) > Math.abs(player2.getVelocity().getX()))
			{
				//player1.setMoveable(false);
				player2.adjustVelocity(new Vector2f(-5 * player1.getVelocity().getX(), 10));
				player2.setDamping(0.1f);
				//player1.setMoveable(true);
				//ROVector2f currentForce = player1.getForce();
				//System.out.println(currentForce.getX() + " " + currentForce.getY());
				//player2.setForce(0, 0);
				//player2.addForce(new Vector2f(-5, currentForce.getY()));
				
				
				//player2.adjustVelocity(new Vector2f(2 * player1.getVelocity().getX(), player2.getVelocity().getY()));
			}
			else if (Math.abs(player1.getVelocity().getX()) < Math.abs(player2.getVelocity().getX()))
			{
				
				//player1.adjustVelocity(new Vector2f(2 * player2.getVelocity().getX(), player1.getVelocity().getY()));
				//player2.setMoveable(false);
				player1.adjustVelocity(new Vector2f(-5* player2.getVelocity().getX(), 10));
				player1.setDamping(0.1f);
				//player2.setMoveable(true);
				//ROVector2f currentForce = player2.getForce();

				//System.out.println(currentForce.getX() + " " + currentForce.getY());
				//player1.setForce(0, 0);
				//player1.addForce(new Vector2f(-500, currentForce.getY()));
			}
			player1.clearTouching();
			player2.clearTouching();
			
		}
		else
		{
			collided = false;
		}
		
		
		
	}
}
