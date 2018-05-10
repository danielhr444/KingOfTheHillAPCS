import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import net.phys2d.math.Vector2f;
import net.phys2d.raw.Body;
import net.phys2d.raw.BodyList;

public class KeyInput extends KeyAdapter
{
	private BodyList myHandler;

	public KeyInput(BodyList handler)
	{
		myHandler = handler;
	}

	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_ESCAPE)
		{
			System.exit(1);
		}

		for(int i = 0; i < myHandler.size(); i++)
		{
			Body thisObj = myHandler.get(i);
			//thisObj.setMaxVelocity(75, 10000);
			if (thisObj.getName().equals("Player 1") && thisObj instanceof Player)
			{
				Player thisPlayer = (Player)thisObj;

				switch (key)
				{
				case KeyEvent.VK_A:

					thisPlayer.moveLeft();//set vel to -5
					thisPlayer.setMovingLeft(true);
					break;

				case KeyEvent.VK_D:
					thisPlayer.moveRight();
					thisPlayer.setMovingRight(true);
					break;

				case KeyEvent.VK_W:

					thisPlayer.jump();

					break;
				}
			}
			if (thisObj.getName().equals("Player 2"))
			{
				switch (key)
				{
				case KeyEvent.VK_LEFT:
					thisObj.addForce(new Vector2f(-thisObj.getForce().getX(), -thisObj.getForce().getY()));
					thisObj.addForce(new Vector2f(-150, 0));
					//set vel to -5
					break;

				case KeyEvent.VK_RIGHT:
					thisObj.addForce(new Vector2f(-thisObj.getForce().getX(), -thisObj.getForce().getY()));
					thisObj.addForce(new Vector2f(150, 0));
					break;

				case KeyEvent.VK_UP:

					//System.out.println(thisObj.getTouching().size());
					//for (int l = 0; l < thisObj.getTouching().size(); l++)

					if (thisObj.getVelocity().getY() == 0)
					{
						//thisObj.addForce(new Vector2f(-thisObj.getForce().getX(), -thisObj.getForce().getY()));
						thisObj.addForce(new Vector2f(0, -500));
					}
					//thisObj.setJumping(true);

					break;
				}
			}
		}
	}

	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();

		for(int i = 0; i < myHandler.size(); i++)
		{
			Body thisObj = myHandler.get(i);
			if (thisObj.getName().equals("Player 1") && thisObj instanceof Player)
			{
				Player thisPlayer = (Player)thisObj;
				switch (key)
				{
				case KeyEvent.VK_D:
					thisPlayer.setMovingRight(false);
					break;

				case KeyEvent.VK_A:
					thisPlayer.setMovingLeft(false);
					break;

				}

				if (!thisPlayer.isMovingLeft() && !thisPlayer.isMovingRight())
				{
					thisPlayer.stop();
				}

			}
			if (thisObj.getName().equals("Player 2"))
			{
				switch (key)
				{
				case KeyEvent.VK_LEFT:
					thisObj.setForce(0, 0);
					break;

				case KeyEvent.VK_RIGHT:
					thisObj.setForce(0, 0);
					break;

				}
			}

		}
	}
}
