package net.phys2d.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import net.phys2d.raw.Body;
import net.phys2d.raw.World;
import net.phys2d.raw.shapes.Box;
import net.phys2d.raw.shapes.Line;
public class thisGame extends Game 
{
	BufferedImage player;
	BufferedImage menu;
	BufferedImage hillBG;
	WorldCreator creator;
	Player player1;
	Player player2;
	ClassLoader cldr ;	
	ColissionHandler colHandler;
	boolean worldDrawn = false;

	static Object currentState = null;

	public thisGame()
	{
		super("King of the Hill");

		cldr = getClass().getClassLoader();
		try {
			player = ImageIO.read(cldr.getResource("Images/boxx.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			menu = ImageIO.read(cldr.getResource("Images/MenuScreenMeme.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			hillBG = ImageIO.read(cldr.getResource("Images/Background3.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		currentState = GameState.Menu;
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

		player1  = new Player(new Box(35, 35f), 0.2f, "Player 1");
		player1.setPosition(50.0f, 100.0f);
		player1.setSpawn(50, 100);
		player1.setRotatable(false);
		player1.setMass(20f);
		player1.setFriction(0f);

		player2  = new Player(new Box(35f, 35f), 0.2f, "Player 2");
		player2.setPosition(750.0f, 100.0f);
		player2.setSpawn(750, 100);
		player2.setRotatable(false);
		player2.setMass(20f);
		player2.setFriction(0f);

		world.setGravity(0, 45f);
		world.add(player1);
		world.add(player2);
		super.frame.addKeyListener(new KeyInput(world.getBodies(), player1, player2));
		super.frame.addMouseListener(new MouseInput());
		colHandler = new ColissionHandler();

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
		if (player1.topOfHill() && player2.topOfHill())
		{
			player1.setContested(true);
			player2.setContested(true);
		}
		else
		{
			player1.setContested(false);
			player2.setContested(false);
		}

		if (player1.getPoints() > 20)
		{
			//g.drawString("Player 1 wins!", 350, 100);
			JOptionPane.showMessageDialog(new JFrame(),  "Player 1", "WINNER!!!", JOptionPane.PLAIN_MESSAGE);
			this.init(world);
			//System.exit(0);
		}
		else if (player2.getPoints() > 20)
		{
			//g.drawString("Player 2 wins!", 350, 100);
			JOptionPane.showMessageDialog(new JFrame(),  "Player 2", "WINNER!!!", JOptionPane.PLAIN_MESSAGE);

			this.init(world);
			//System.exit(0);
		}


		colHandler.collide(player1, player2);
		//System.out.println("Has Collided: " + colHandler.hasCollided());
		// TODO Auto-generated method stub

	}

	protected void draw(Graphics2D g)
	{
		g.setColor(Color.black);
		if (currentState.equals(GameState.Menu))
		{
			g.drawImage(menu, 0, 0, null);
			g.drawString("here is a menu", 300, 100);
		}
		else if (currentState.equals(GameState.Paused))
		{
			
		}
		else if (currentState.equals(GameState.Rules))
		{
			g.drawString("here are some rules", 300, 100);
		}
		else if (currentState.equals(GameState.Credits))
		{
			g.drawString("here are some credits", 300, 100);
		}
		else if (currentState.equals(GameState.Game))
		{
			//super.draw(g);

			//g.drawImage(bg, 0, -75, 800, 500, null);

			//g.drawImage(player,(int) (player1.getX() - player1.getWidth() / 2),(int) (player1.getY() - player1.getHeight() / 2),(int) player1.getWidth(), (int) player1.getHeight(),null);
			//g.drawImage(player,(int) (player2.getX() - player2.getWidth() / 2),(int) (player2.getY() - player2.getHeight() / 2),(int) player2.getWidth(), (int) player2.getHeight(),null);
			//g.fillRect((int)player1.getPositionDelta().getX(),(int)player1.getPositionDelta().getY() , 50, 50);
			g.drawImage(hillBG, 1, 10, 800, 500, null);
			player1.draw(g);
			player2.draw(g);

			//creator.drawWorld(g);


			g.setColor(Color.BLACK);

			g.drawString("Player 1", player1.getX() - 21, player1.getY() - 30);
			g.drawString("Player 2", player2.getX() - 21, player2.getY() - 30);

			g.drawString("Player 1 Points: " + player1.getPoints(), 25, 100);
			g.drawString("Player 2 Points: " + player2.getPoints(), 675, 100);



			//g.fillRect(100, 100, 200, 100);

			if (player1.getContested() && player2.getContested())
			{
				g.drawString("Hill contested!", 350, 100);
			}
			else if (player1.topOfHill())
			{
				g.drawString("Player 1 in control!", 350, 100);
			}
			else if (player2.topOfHill())
			{
				g.drawString("Player 2 in control!", 350, 100);
			}
		}
	}

	public void run() {
		// TODO Auto-generated method stub

	}
}
