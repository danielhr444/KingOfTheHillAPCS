package net.phys2d.game;

import net.phys2d.math.Vector2f;
import net.phys2d.raw.Body;
import net.phys2d.raw.BodyList;

public class ColissionHandler 
{
	private Player player1;
	private Player player2;
	private boolean collided;
	
	
	public ColissionHandler(Player p1, Player p2)
	{
		player1 = p1;
		player2 = p2;
		collided = false;
	}
	
	public boolean hasCollided()
	{
		return collided;
	}
	
	public void collide()
	{
		BodyList player1List = player1.getTouching();
		BodyList player2List = player2.getTouching();
		
		for (int i = 0; i < player1List.size(); i++)
		{
			Body thisBod = player1List.get(i);
			if (thisBod instanceof Player)
			{
				Player thisPlayer = (Player)thisBod;
				if (thisPlayer.equals(player1))
				{
					player2.adjustVelocity(new Vector2f(-player1.getVelocity().getX(), player2.getVelocity().getY()));
					System.out.println("player 1 collided");
				}
				else if (thisPlayer.equals(player2))
				{
					player1.adjustVelocity(new Vector2f(-player2.getVelocity().getX(), player1.getVelocity().getY()));
					System.out.println("player 2 collided");
				}
				
			}
		}
	}
}
