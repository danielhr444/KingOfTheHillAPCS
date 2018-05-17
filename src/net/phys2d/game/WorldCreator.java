package net.phys2d.game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.phys2d.raw.Body;
import net.phys2d.raw.World;
import net.phys2d.raw.shapes.Line;


public class WorldCreator 
{
	private World myWorld;
	private BufferedImage dirtBlock;
	private ClassLoader cldr;
	private Graphics2D graphics;
	
	public WorldCreator(World world)
	{
		myWorld = world;
		cldr = this.getClass().getClassLoader();
		
		
		try {
			dirtBlock = ImageIO.read(new File("src/Images/DirtBlock (2).png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		for (int i = 0; i < 26; i++)
		{
			Body block = new Body("FloorBlock", new net.phys2d.raw.shapes.Box(25f, 25f), 20f);
			block.setGravityEffected(false);
			block.setPosition(15f + (60f * i), 430f);
			block.setMoveable(false);
			block.setRotatable(false);
			block.setFriction(0f);
			
			myWorld.add(block);
		}
	}
	
	public void drawWorld(Graphics2D g)
	{
		for (int i = 0; i < myWorld.getBodies().size(); i++)
		{
			Body currentBod = myWorld.getBodies().get(i);
			if (currentBod.getName().equals("FloorBlock"))
			{
				g.drawImage(dirtBlock, (int)currentBod.getPosition().getX() - 20, (int)(currentBod.getPosition().getY() - 12.5), 26, 26, null);
				g.drawImage(dirtBlock, (int)currentBod.getPosition().getX() - 40, (int)(currentBod.getPosition().getY() - 12.5), 26, 26, null);
				g.drawImage(dirtBlock, (int)currentBod.getPosition().getX() - 60, (int)(currentBod.getPosition().getY() - 12.5), 26, 26, null);
			}
		}
	}
}
