package net.phys2d.game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.phys2d.raw.Body;
import net.phys2d.raw.World;
import net.phys2d.raw.shapes.Box;
import net.phys2d.raw.shapes.Line;
public class thisGame extends Game 
{
	BufferedImage player;
	WorldCreator creator;
	Player me;
	ClassLoader cldr ;	
	public thisGame()
	{
		super("test");
		cldr = getClass().getClassLoader();
		try {
			player = ImageIO.read(new File("src/Images/boxx.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	protected void init(World world) 
	{

		
		creator = new WorldCreator(world);
		creator.createWorld();
		//Shape square = new Rectangle2D.Float(100.0f, 100.0f, 100.0f, 100.0f);
		//Body rectangle = new Body("Player 1", new Box(50f, 50f), 0.25f);
		//rectangle.setMaxVelocity(50, 1000);
		//rectangle.setFriction(0);
		//rectangle.setPosition(250.0f, 100.0f);// TODO Auto-generated method stub
		//world.add(rectangle);

		me  = new Player(new Box(50f, 50f), 0.2f, "Player 1");
		me.setPosition(250.0f, 100.0f);
		me.setRotatable(false);
		me.setMass(20f);
		me.setFriction(0f);
		world.setGravity(0, 45f);
		world.add(me);

	}

	public static void main(String args[])
	{
		thisGame game = new thisGame();
		game.start();

	}

	public void update() {
		
		for (int i = 0; i < this.world.getBodies().size(); i++)
		{
			this.world.getBodies().get(i).update();
		}
		
		// TODO Auto-generated method stub

	}
	
	protected void draw(Graphics2D g)
	{
		
		g.drawImage(player,(int) (me.getX() - me.getWidth() / 2),(int) (me.getY() - me.getHeight() / 2),(int) me.getWidth(), (int) me.getHeight(),null);
		creator.drawWorld(g);
		super.draw(g);
		
	}

	public void run() {
		// TODO Auto-generated method stub

	}
}
