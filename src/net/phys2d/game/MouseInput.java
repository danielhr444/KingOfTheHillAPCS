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
	}
	

}
