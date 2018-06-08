package net.phys2d.game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.phys2d.raw.Body;
import net.phys2d.raw.BodyList;
import net.phys2d.raw.World;
import net.phys2d.raw.shapes.Box;

public class PowerUp extends Body
{
	private Object myType;
	private BufferedImage myImage;
	private World myWorld;
	private boolean isHere = true;
	
	public enum PowerType
	{
		Force(),
		Levitate(),
		Boost();
	}

	/**
	 * @param world
	 */
	
	public boolean isAlive()
	{
		return isHere;
	}
	
	public PowerUp(World world, PowerType type)
	{
		super(new Box(25,25), 1.0f);
		myType = type;

		if (myType.equals(PowerType.Force))
		{
			try {
				myImage = ImageIO.read(this.getClass().getClassLoader().getResource("Images/hammer.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (myType.equals(PowerType.Levitate))
		{
			try {
				myImage = ImageIO.read(this.getClass().getClassLoader().getResource("Images/wings.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (myType.equals(PowerType.Boost))
		{
			try {
				myImage = ImageIO.read(this.getClass().getClassLoader().getResource("Images/up-circular-xxl.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.setPosition((float) Math.random() * 800, 0);
		this.setDamping(0.05f);
		this.setRotatable(false);
		
		myWorld = world;
		System.out.print(this);
		world.add(this);
	}

	public void update(Player p1, Player p2)
	{
		BodyList list = this.getTouching();
		boolean containsp1 = list.contains(p1);
		//System.out.println(containsp1);
		boolean containsp2 = list.contains(p2);
		if (containsp1)
		{
			p1.activatePowerup((PowerType) myType);
			//System.out.println("p1 touching");
			myWorld.remove(this);
			isHere = false;
			
		}
		else if (containsp2)
		{
			p2.activatePowerup((PowerType) myType);
			//System.out.println("p1 touching");
			myWorld.remove(this);
			isHere = false;
			
		}

	}

	public void draw(Graphics2D g)
	{
		g.drawImage(myImage, (int)(this.getPosition().getX() - 12.5), (int)(this.getPosition().getY() - 12.5), 25, 25, null);
	}
}
