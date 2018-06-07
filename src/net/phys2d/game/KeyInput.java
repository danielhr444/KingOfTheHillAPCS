package net.phys2d.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import net.phys2d.math.Vector2f;
import net.phys2d.raw.Body;
import net.phys2d.raw.BodyList;

public class KeyInput extends KeyAdapter
{
	private BodyList myHandler;
	private Player player1, player2;
	

	public KeyInput(BodyList handler, Player p1, Player p2)
	{
		myHandler = handler;
		player1 = p1;
		player2 = p2;
		
	}

	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_ESCAPE)
		{
			System.exit(1);
		}

		
		{
			switch (key)
			{
			case KeyEvent.VK_W:

				if(!player1.isUp())
				{
					player1.jump();
					//thisPlayer.clearTouching();
				}
				break;

			case KeyEvent.VK_A:

				player1.moveLeft();//set vel to -5
				player1.setMovingLeft(true);
				System.out.println("working");
				break;

			case KeyEvent.VK_D:
				player1.moveRight();
				player1.setMovingRight(true);
				break;



			case KeyEvent.VK_UP:
				if(!player2.isUp())
				{
					player2.jump();
					//thisPlayer.clearTouching();
				}
				break;

			case KeyEvent.VK_LEFT:

				player2.moveLeft();//set vel to -5
				player2.setMovingLeft(true);
				break;

			case KeyEvent.VK_RIGHT:
				player2.moveRight();
				player2.setMovingRight(true);
				break;

			}	
		}	
	}

	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();


		switch (key)
		{
		case KeyEvent.VK_D:
			player1.setMovingRight(false);
			break;

		case KeyEvent.VK_A:
			player1.setMovingLeft(false);
			break;


		case KeyEvent.VK_RIGHT:
			player2.setMovingRight(false);
			break;

		case KeyEvent.VK_LEFT:
			player2.setMovingLeft(false);
			break;

		}
		if (!player2.isMovingLeft() && !player2.isMovingRight())
		{
			player2.stop();
		}

		if (!player1.isMovingLeft() && !player1.isMovingRight())
		{
			player1.stop();
		}
	}
}


