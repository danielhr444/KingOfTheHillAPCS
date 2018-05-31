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
		if(thisGame.currentState.equals(GameState.Game))
			
		
		if(e.getX() > 100 && e.getX() < 300 && e.getY() > 100 && e.getY() < 200)
			System.out.println(e.getX() + " " + e.getY());
		
		
	}
	

}
