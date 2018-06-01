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
			if(e.getX() > 30 && e.getX() < 200 && e.getY() > 355 && e.getY() < 468)
			{
				System.out.println(e.getX() + " " + e.getY());
				thisGame.currentState = GameState.Rules;
			}
			if(e.getX() > 329 && e.getX() < 499 && e.getY() > 355 && e.getY() < 468)
			{
				System.out.println(e.getX() + " " + e.getY());
				thisGame.currentState = GameState.Game;
			}
			if(e.getX() > 600 && e.getX() < 770 && e.getY() > 355 && e.getY() < 468)
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
		else if(thisGame.currentState.equals((GameState.Credits)))
		{
			if(e.getX() > 350 && e.getX() < 448 && e.getY() > 400 && e.getY() < 449)
				thisGame.currentState = GameState.Menu;
		}
		else if(thisGame.currentState.equals(GameState.Game))
		{
			if(e.getX() > 310 && e.getX() < 410 && e.getY() > 375 && e.getY() < 425)
				thisGame.paused = !thisGame.paused;
		}
	}
	

}
