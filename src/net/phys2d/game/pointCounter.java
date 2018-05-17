package net.phys2d.game;
import java.util.TimerTask;

public class pointCounter extends TimerTask
{
	private int points;
	
	public pointCounter()
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
