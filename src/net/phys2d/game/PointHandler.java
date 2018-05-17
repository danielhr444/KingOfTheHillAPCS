package net.phys2d.game;
import java.util.TimerTask;

public class PointHandler extends TimerTask
{
	private int points;
	
	public PointHandler()
	{
		points = 0;
	}
	
	public int getPoints()
	{
		return points;
	}
	
	public void run()
	{
		points++;
		System.out.println(points);
	}
}
