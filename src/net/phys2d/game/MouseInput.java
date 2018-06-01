package net.phys2d.game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class MouseInput extends MouseAdapter
{
	public MouseInput()
	{
		
	}
	
	public void mouseClicked(MouseEvent e)
	{
		if(thisGame.currentState.equals(GameState.Menu))
		{
			if(e.getX() > 35 && e.getX() < 235 && e.getY() > 370 && e.getY() < 430)
			{
				System.out.println(e.getX() + " " + e.getY());
				thisGame.currentState = GameState.Rules;
			}
			if(e.getX() > 310 && e.getX() < 475 && e.getY() > 375 && e.getY() < 425)
			{
				System.out.println(e.getX() + " " + e.getY());
				thisGame.currentState = GameState.Game;
			}
			if(e.getX() > 535 && e.getX() < 910 && e.getY() > 360 && e.getY() < 420)
			{
				System.out.println(e.getX() + " " + e.getY());
				thisGame.currentState = GameState.Credits;
			}
		}
		else if(thisGame.currentState.equals((GameState.Rules)))
		{
			if(e.getX() > 350 && e.getX() < 448 && e.getY() > 400 && e.getY() < 449)
				thisGame.currentState = GameState.Menu;
		}
		else if(thisGame.currentState.equals(GameState.Game))
		{
			if(e.getX() > 310 && e.getX() < 410 && e.getY() > 375 && e.getY() < 425)
				thisGame.currentState = GameState.Paused;
		}
	}
	

}
