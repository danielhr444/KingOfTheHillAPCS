import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
			if (thisObj.getUserData().equals("Player 1"))
			{
				switch (key)
				{
				case KeyEvent.VK_A:
					thisObj.setForce(-5, 0); //set vel to -5
					break;

				case KeyEvent.VK_D:
					thisObj.setForce(5, 0);
					break;

				case KeyEvent.VK_W:
					if (thisObj.getTouching().size() == 0)
					{
						thisObj.setForce(0, -10);
						//thisObj.setJumping(true);
					}
				}
			}
			if (thisObj.getUserData().equals("Player 2"))
			{
				switch (key)
				{
				case KeyEvent.VK_RIGHT:
					thisObj.setForce(5, 0);
					break;

				case KeyEvent.VK_LEFT:
					thisObj.setForce(-5, 0);
					break;

				case KeyEvent.VK_UP:
					if (thisObj.getTouching().size() == 0)
					{
						thisObj.setForce(-0, 5);
						//thisObj.setJumping(true);
					}
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
			if (thisObj.getUserData().equals("Player 1"))
			{
				switch (key)
				{
				case KeyEvent.VK_RIGHT:
					thisObj.setForce(0, 0);
					break;

				case KeyEvent.VK_LEFT:
					thisObj.setForce(0, 0);
					break;

				}
			}
			if (thisObj.getUserData().equals("Player 2"))
			{
				switch (key)
				{
				case KeyEvent.VK_D:
					thisObj.setForce(0, 0);
					break;

				case KeyEvent.VK_A:
					thisObj.setForce(0, 0);
					break;

				}
			}
			
		}
	}
}
