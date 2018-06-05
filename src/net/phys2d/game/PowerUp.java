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

	public enum PowerType
	{
		Force(),
		Levitate(),
		Boost();
	}

	/**
	 * @param world
	 */
	public PowerUp(World world, PowerType type, float f)
	{
		super(new Box(50,50), 1.0f);
		myType = type;

		if (myType.equals(PowerType.Force))
		{
			try {
				myImage = ImageIO.read(this.getClass().getClassLoader().getResource("Images/boxx.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (myType.equals(PowerType.Levitate))
		{
			try {
				myImage = ImageIO.read(this.getClass().getClassLoader().getResource("Images/boxx.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (myType.equals(PowerType.Boost))
		{
			try {
				myImage = ImageIO.read(this.getClass().getClassLoader().getResource("Images/boxx.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.setPosition(f, 0);
		this.setDamping(0.05f);
		this.setRotatable(false);
		
		myWorld = world;
		world.add(this);
	}

	public void update(Player p1, Player p2)
	{
		BodyList list = this.getTouching();
		boolean containsp1 = list.contains(p1);

		boolean containsp2 = list.contains(p2);
		if (containsp1)
		{
			p1.activatePowerup((PowerType) myType);
			System.out.println("p1 touching");
			myWorld.remove(this);
			
		}
		else if (containsp2)
		{
			p2.activatePowerup((PowerType) myType);
			System.out.println("p1 touching");
			myWorld.remove(this);
		}

	}

	public void draw(Graphics2D g)
	{
		g.drawImage(myImage, (int)this.getPosition().getX(), (int)this.getPosition().getY(), 50, 50, null);
	}
}
