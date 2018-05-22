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
	Player player1;
	Player player2;
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

		player1  = new Player(new Box(50f, 50f), 0.2f, "Player 1");
		player1.setPosition(250.0f, 100.0f);
		player1.setRotatable(false);
		player1.setMass(20f);
		player1.setFriction(0f);
		
		player2  = new Player(new Box(50f, 50f), 0.2f, "Player 2");
		player2.setPosition(150.0f, 100.0f);
		player2.setRotatable(false);
		player2.setMass(20f);
		player2.setFriction(0f);
		
		world.setGravity(0, 45f);
		world.add(player1);
		world.add(player2);

	}

	public static void main(String args[])
	{
		thisGame game = new thisGame();
		game.start();

	}

	public void update() 
	{
	
		for (int i = 0; i < this.world.getBodies().size(); i++)
		{
			Body currentBod = this.world.getBodies().get(i);
			currentBod.update();
		}
		
		// TODO Auto-generated method stub

	}
	
	protected void draw(Graphics2D g)
	{

		//super.draw(g);
		g.drawImage(player,(int) (player1.getX() - player1.getWidth() / 2),(int) (player1.getY() - player1.getHeight() / 2),(int) player1.getWidth(), (int) player1.getHeight(),null);
		g.drawImage(player,(int) (player2.getX() - player2.getWidth() / 2),(int) (player2.getY() - player2.getHeight() / 2),(int) player2.getWidth(), (int) player2.getHeight(),null);
		
		creator.drawWorld(g);
		
		
	}

	public void run() {
		// TODO Auto-generated method stub

	}
}
