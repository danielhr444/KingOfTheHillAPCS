package net.phys2d.game;
import java.util.TimerTask;

public class pointCounter extends TimerTask
{
	private int points;
	private boolean playerOnHill = false;

	public void setOnHill(boolean onHill)
	{
		playerOnHill = onHill;
	}

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
		if (playerOnHill)
		{
			points++;
		}
	}
}
