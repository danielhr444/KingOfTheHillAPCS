package net.phys2d.game;

import java.awt.Color;
import java.awt.Font;
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
	//BufferedImage menuBG;
	BufferedImage hillBG;
	BufferedImage bg;
	BufferedImage pause;
	BufferedImage rules;
	BufferedImage credits;
	BufferedImage play;
	WorldCreator creator;
	Player player1;
	Player player2;
	ClassLoader cldr ;	
	ColissionHandler colHandler;
	boolean worldDrawn = false;
	boolean gameStarted = false;

	public static boolean paused;
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
			bg = ImageIO.read(cldr.getResource("Images/BackgroundImage2.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			menu = ImageIO.read(cldr.getResource("Images/Testing_logo_2.png"));
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

		try {
			pause = ImageIO.read(cldr.getResource("Images/King_Button_Pause.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			rules = ImageIO.read(cldr.getResource("Images/Testing_Button_Rules.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			credits = ImageIO.read(cldr.getResource("Images/Testing_Button_Credits.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			play = ImageIO.read(cldr.getResource("Images/Testing_Button_Play.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		currentState = GameState.Menu;
		paused = false;
	}

	protected void init(World world) 
	{


		creator = new WorldCreator(world);
		creator.createWorld();
		super.frame.addMouseListener(new MouseInput());
		//Shape square = new Rectangle2D.Float(100.0f, 100.0f, 100.0f, 100.0f);
		//Body rectangle = new Body("Player 1", new Box(50f, 50f), 0.25f);
		//rectangle.setMaxVelocity(50, 1000);
		//rectangle.setFriction(0);
		//rectangle.setPosition(250.0f, 100.0f);// TODO Auto-generated method stub
		//world.add(rectangle);


	}

	public void play(World world)
	{
		if (!gameStarted)
		{
			player1  = new Player(new Box(35, 35f), 0.2f, "Player 1");
			player1.setPosition(45.0f, 100.0f);
			player1.setSpawn(45, 100);
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

			colHandler = new ColissionHandler();
			gameStarted = true;
		}
	}

	public static void main(String args[])
	{
		thisGame game = new thisGame();
		game.start();

	}



	public void update() 
	{
		if (currentState.equals(GameState.Game) && gameStarted)
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
				//this.init(world);
				//System.exit(0);
				currentState = GameState.Menu;
				gameStarted = false;
				world.clear();
				this.init(world);
			}
			else if (player2.getPoints() > 20)
			{
				//g.drawString("Player 2 wins!", 350, 100);
				JOptionPane.showMessageDialog(new JFrame(),  "Player 2", "WINNER!!!", JOptionPane.PLAIN_MESSAGE);
				currentState = GameState.Menu;
				//this.init(world);
				//System.exit(0);
				gameStarted = false;
				world.clear();
				this.init(world);
			}


			colHandler.collide(player1, player2);
			//System.out.println("Has Collided: " + colHandler.hasCollided());
			// TODO Auto-generated method stub
		}
	}

	protected void draw(Graphics2D g)
	{
		g.setColor(Color.black);
		if (currentState.equals(GameState.Menu))
		{
			
			g.drawImage(bg, 1, 10, 800, 500, null);
			g.drawImage(menu, 25, 50, 750, 100, null);
			//g.drawString("here is a menu", 300, 100);

			//g.drawRect(600, 355, 170, 113);
			paused = false;

			//g.drawRect(600, 355, 170, 113);
			
			g.drawImage(play, 300, 370, null);
			//g.drawImage(credits, 540, 350, 200, 90, null);
			g.drawImage(credits, 530, 350, null);
			g.drawImage(rules, 30, 370, null);

			try {
				g.drawImage(ImageIO.read(cldr.getResource("Images/PlayerFrame3.png")), 165, -120, 600, 600, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			//g.drawRect(535, 360, 275, 60);

		}
		else if (currentState.equals(GameState.Paused))
		{


		}
		else if (currentState.equals(GameState.Rules))
		{
			g.drawImage(bg, 0, 0, 800, 500, null);
			g.setFont(new Font("Monospaced", Font.PLAIN, 24));
			g.drawString("Rules: ", 50, 100);
			g.drawString("Player 1 Controls: ", 50, 250);
			g.drawString("Player 2 Controls: ", 500, 250);
			g.setFont(new Font("Monospaced", Font.PLAIN, 18));
			g.drawString("Each player gains a point each second they are on the hill.", 50, 150 );
			g.drawString("First player to 20 points wins!", 50, 200);
			g.drawString("W: Jump", 50, 300);
			g.drawString("D: Right", 50, 325);
			g.drawString("A: Left", 50, 350);

			g.drawString("Up Arrow: Jump", 500, 300);
			g.drawString("Right Arrow: Right", 500, 325);
			g.drawString("Left Arrow: Left", 500, 350);

			g.setColor(Color.gray);
			g.fillRect(350, 400, 100, 50);
			g.setColor(Color.black);
			g.drawString("Menu", 377, 427);
			paused = false;

			//g.drawRect(350, 400, 98, 49);

		}
		else if (currentState.equals(GameState.Credits))
		{
			g.drawImage(bg, 0, 0, 800, 500, null);
			g.setFont(new Font("Monospaced", Font.PLAIN, 24));
			g.drawString("Credits: ", 50, 100);
			g.drawString("Made using Phys2D.", 50, 150);
			g.drawString("Ankit B, Daniel R, Aaron H, Andrew T.", 50, 200);
			g.drawString("Neuhaus APCS, Period 1", 50, 250);
			g.setFont(new Font("Monospaced", Font.PLAIN, 18));
			g.drawString("", 50, 150 );
			try {
				g.drawImage(ImageIO.read(cldr.getResource("Images/PlayerFrame1.png")), 450, 100, 400, 400, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				g.drawImage(ImageIO.read(cldr.getResource("Images/PlayerFrame2.png")), 50, 100, 400, 400, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				g.drawImage(ImageIO.read(cldr.getResource("Images/PlayerFrame3.png")), 250, 100, 400, 400, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			g.setColor(Color.gray);
			g.fillRect(350, 400, 100, 50);
			g.setColor(Color.black);
			g.drawString("Menu", 377, 427);
			paused = false;
			
			
		}
		else if (currentState.equals(GameState.Game))
		{
			this.play(world);
			//super.draw(g);
			
			//g.drawImage(bg, 0, -75, 800, 500, null);

			//g.drawImage(player,(int) (player1.getX() - player1.getWidth() / 2),(int) (player1.getY() - player1.getHeight() / 2),(int) player1.getWidth(), (int) player1.getHeight(),null);
			//g.drawImage(player,(int) (player2.getX() - player2.getWidth() / 2),(int) (player2.getY() - player2.getHeight() / 2),(int) player2.getWidth(), (int) player2.getHeight(),null);
			//g.fillRect((int)player1.getPositionDelta().getX(),(int)player1.getPositionDelta().getY() , 50, 50);
			g.drawImage(hillBG, 1, 10, 800, 500, null);
			player1.draw(g);
			player2.draw(g);

			//g.setColor(Color.green);
			//g.fillRect(310, 60, 100, 50);
			//g.setColor(Color.black);
			//g.drawString("Pause", 377, 427);
			
			g.drawImage(pause, 310, 450, 100, 50, null);
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
