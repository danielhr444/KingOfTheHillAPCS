package net.phys2d.game;

import java.util.TimerTask;

public class boostHandler extends TimerTask
{
	private int time = 0;
	private boolean shouldRun = false;
	
	public void start()
	{
		shouldRun = true;
		time = 0;
	}
	
	public boolean isRunning()
	{
		return shouldRun;
	}
	
	public void run() 
	{
		if (time > 5)
		{
			shouldRun = false;
			time = 0;
			
		}
		if (shouldRun)
		{
			time++;
			System.out.println(this.getClass().getName());
		}
	}
}
