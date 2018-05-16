package net.phys2d.game;

import net.phys2d.raw.Body;
import net.phys2d.raw.World;
import net.phys2d.raw.shapes.Line;


public class WorldCreator 
{
	private World myWorld;
	
	public WorldCreator(World world)
	{
		myWorld = world;
	}
	
	private void addPlayers()
	{
		
	}
	
	public void createWorld()
	{
		Body floor = new Body("Floor", new Line(-2000f, 400f, 2000f, 400f), 100f);
		floor.setIsResting(true);
		floor.setGravityEffected(false);
		floor.setPosition(50, 50);
		floor.setMoveable(false);
		floor.setRotatable(false);
		floor.setFriction(0f);
		//myWorld.add(floor);
		
		for (int i = 0; i < 16; i++)
		{
			Body block = new Body("FloorBlock", new net.phys2d.raw.shapes.Box(50f, 50f), 20f);
			block.setGravityEffected(false);
			block.setPosition(20f + (51 * i), 430f);
			block.setMoveable(false);
			block.setRotatable(false);
			myWorld.add(block);
		}
	}
}
