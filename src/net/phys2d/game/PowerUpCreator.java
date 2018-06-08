package net.phys2d.game;

import java.util.TimerTask;

import net.phys2d.raw.World;

public class PowerUpCreator extends TimerTask
{

	private World myWorld;
	
	public void giveWorld(World world)
	{
		myWorld = world;
	}
	@Override
	public void run() 
	{
		double rand = Math.random() * 3;

		if (rand > 0 && rand < 1)

			thisGame.powerups.add(new PowerUp(myWorld, PowerUp.PowerType.Boost));
		else if (rand > 1 && rand < 2)
			thisGame.powerups.add(new PowerUp(myWorld, PowerUp.PowerType.Levitate));
		else
			thisGame.powerups.add(new PowerUp(myWorld, PowerUp.PowerType.Force));
	}

}
