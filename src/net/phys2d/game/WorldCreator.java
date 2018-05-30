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
	private BufferedImage grassBlock;
	private ClassLoader cldr;
	private Graphics2D graphics;

	public WorldCreator(World world)
	{
		myWorld = world;
		cldr = this.getClass().getClassLoader();


		try {
			dirtBlock = ImageIO.read(cldr.getResource("Images/DirtBlock (2).png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			grassBlock = ImageIO.read(cldr.getResource("Images/GrassBlock.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void createWorld()
	{
		for (int i = 0; i < 32; i++)
		{
			if (i < 2 || i > 27)
			{
				Body block = new Body("GrassBlock", new net.phys2d.raw.shapes.Box(25f, 25f), 20f);
				block.setGravityEffected(false);
				block.setPosition(15f + (25 * i), 430f);
				block.setMoveable(false);
				block.setRotatable(false);
				block.setFriction(0f);

				myWorld.add(block);
			}
		}


		for (int i = 0; i < 27; i++)
		{
			if (i < 3 || i > 23)
			{
				Body block = new Body("GrassBlock", new net.phys2d.raw.shapes.Box(25f, 25f), 20f);
				
				block.setGravityEffected(false);
				block.setPosition(60f + (25 * i), 405f);
				block.setMoveable(false);
				block.setRotatable(false);
				block.setFriction(0f);

				myWorld.add(block);
			}

			
		}

		for (int i = 0; i < 22; i++)
		{
			if (i < 2 || i > 18)
			{
				Body block = new Body("GrassBlock", new net.phys2d.raw.shapes.Box(25f, 25f), 20f);
				
				block.setGravityEffected(false);
				block.setPosition(124f + (25 * i), 380f);
				block.setMoveable(false);
				block.setRotatable(false);
				block.setFriction(0f);

				myWorld.add(block);
			}
		}

		for (int i = 0; i < 18; i++)
		{
			if (i < 2 || i > 15)
			{
				Body block = new Body("GrassBlock", new net.phys2d.raw.shapes.Box(25f, 25f), 20f);
				
				block.setGravityEffected(false);
				block.setPosition(155f + (25 * i), 355f);
				block.setMoveable(false);
				block.setRotatable(false);
				block.setFriction(0f);

				myWorld.add(block);
			}

			
		}

		for (int i = 0; i < 15; i++)
		{
			if (i < 4 || i > 10)
			{
				Body block = new Body("GrassBlock", new net.phys2d.raw.shapes.Box(25f, 25f), 20f);
				
				block.setGravityEffected(false);
				block.setPosition(200f + (25 * i), 330f);
				block.setMoveable(false);
				block.setRotatable(false);
				block.setFriction(0f);

				myWorld.add(block);
			}

			
		}

		for (int i = 0; i < 8; i++)
		{
			if (i < 2 || i > 5)
			{
				Body block = new Body("GrassBlock", new net.phys2d.raw.shapes.Box(25f, 25f), 20f);
				
				block.setGravityEffected(false);
				block.setPosition(279f + (25 * i), 305f);
				block.setMoveable(false);
				block.setRotatable(false);
				block.setFriction(0f);

				myWorld.add(block);
			}

			
		}

		for (int i = 0; i < 5; i++)
		{
			if (i < 2 || i > 2)
			{
				Body block = new Body("GrassBlock", new net.phys2d.raw.shapes.Box(25f, 25f), 20f);
				
				block.setGravityEffected(false);
				block.setPosition(308f + (25 * i), 280f);
				block.setMoveable(false);
				block.setRotatable(false);
				block.setFriction(0f);

				myWorld.add(block);
			}

			
		}

		for (int i = 0; i < 2; i++)
		{
			Body block = new Body("GrassBlock", new net.phys2d.raw.shapes.Box(25f, 25f), 20f);
			block.setGravityEffected(false);
			block.setPosition(348f + (25 * i), 255f);
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
				g.drawImage(dirtBlock, (int)(currentBod.getPosition().getX() - 12.5), (int)(currentBod.getPosition().getY() - 12.5), 25, 25, null);
			}
			else if (currentBod.getName().equals("GrassBlock"))
			{
				g.drawImage(grassBlock, (int)(currentBod.getPosition().getX() - 12.5), (int)(currentBod.getPosition().getY() - 12.5), 25, 25, null);
			}
		}
		
		/*
		for (int i = 0; i < 32; i++)
		{
			g.drawImage(dirtBlock, i * 25, 430, 25, 25, null);
			g.drawImage(dirtBlock, i * 25, 455, 25, 25, null);
			g.drawImage(dirtBlock, i * 25, 480, 25, 25, null);
		}
		
		for (int i = 2; i < 28; i++)
		{
			g.drawImage(dirtBlock, (i * 25) + 2, 405, 25, 25, null);
		}
		for (int i = 5; i < 26; i++)
		{
			g.drawImage(dirtBlock, (i * 25) - 3, 380, 25, 25, null);
		}
		for (int i = 6; i < 23; i++)
		{
			g.drawImage(dirtBlock, (i * 25) + 11, 355, 25, 25, null);
		}
		for (int i = 7; i < 21; i++)
		{
			g.drawImage(dirtBlock, (i * 25) + 17, 330, 25, 25, null);
		}
		for (int i = 10; i < 17; i++)
		{
			g.drawImage(dirtBlock, (i * 25) + 37, 305, 25, 25, null);
		}
		for (int i = 12; i < 16; i++)
		{
			g.drawImage(dirtBlock, (i * 25) + 16, 280, 25, 25, null);
		}
		
		g.drawImage(dirtBlock, 345, 255, 25, 25, null);
*/
	}
}
