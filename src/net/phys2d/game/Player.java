package net.phys2d.game;
import java.util.Timer;
import java.util.TimerTask;
import net.phys2d.game.*;
import net.phys2d.math.Vector2f;
import net.phys2d.raw.Body;
import net.phys2d.raw.BodyList;
import net.phys2d.raw.World;
import net.phys2d.raw.shapes.DynamicShape;

public class Player extends Body
{
	private World myWorld;
	private boolean movingLeft;
	private boolean movingRight;
	private boolean isUp = false;
	private int points;
	private PointHandler pointHandler;
	
	public Player(DynamicShape shape, float m, String myName) 
	{
		super(myName, shape, m);
		setDamping(0);

		Timer timer = new Timer();
		pointHandler = new PointHandler();
		timer.scheduleAtFixedRate(pointHandler, 1000, 1000);
		setMaxVelocity(75.0f, 5000.0f);
		// TODO Auto-generated constructor stub
	}

	public float getX()
	{
		return (this.getPosition().getX() + 1.35f);
	}
	
	public float getHeight()
	{
		return (this.getShape().getBounds().getHeight() - 19);
	}
	
	public float getWidth()
	{
		return (this.getShape().getBounds().getWidth() - 19);
	}

	public float getY()
	{
		return (this.getPosition().getY());
	}

	public boolean isUp() 
	{
		//this.setCanRest(true);
		BodyList list = this.getTouching();
		if (list.size() == 0)
		{
			return true;
		}
		for (int i = 0; i < list.size(); i++)
		{

			if (list.get(i).getName().equals("Floor") || list.get(i).getName().equals("FloorBlock"))
			{
				System.out.println(list);
				return false;
			}
		}
		
		return true;

	}


	public boolean isMovingLeft() {
		return movingLeft;
	}


	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}


	public boolean isMovingRight() {
		return movingRight;
	}


	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}

	public void moveLeft()
	{
		//setMaxVelocity(75.0f, 5000.0f);
		//adjustVelocity(new Vector2f(-75, 0));
		setVelocity(new Vector2f(-75, this.getVelocity().getY()));
	}

	public void moveRight()
	{

		//setMaxVelocity(75.0f, 5000.0f);
		//adjustVelocity(new Vector2f(75, 0));
		setVelocity(new Vector2f(75f,this.getVelocity().getY()));
	}


	public void jump()
	{
		
		//if (!isUp())
		{
			
			//setMaxVelocity(75.0f, 5000.0f);
			setVelocity(new Vector2f(this.getVelocity().getX(), -75));
			this.clearTouching();
		}
		
		
	}


	public void stop()
	{
		this.setVelocity(new Vector2f(0,this.getVelocity().getY()));

	}


	public void update()
	{
		
		//System.out.println("isrunning");
		//System.out.print(this.getTouching());
		//this.startFrame();
		super.update();
		points = pointHandler.getPoints();
		System.out.println(points);
	}


}

