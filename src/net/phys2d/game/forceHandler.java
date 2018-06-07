package net.phys2d.game;

import java.util.TimerTask;

public class forceHandler extends TimerTask
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
		if (time > 4)
		{
			shouldRun = false;
			time = 0;
		}
		if (shouldRun)
		{
			time++;
		}
	}
}
