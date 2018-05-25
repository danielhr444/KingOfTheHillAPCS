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
	private boolean contested;
	private pointCounter pointHandler;
	
	public Player(DynamicShape shape, float m, String myName) 
	{
		super(myName, shape, m);
		setDamping(0);

		Timer timer = new Timer();
		pointHandler = new pointCounter();
	
		timer.scheduleAtFixedRate(pointHandler, 1000, 1000);
		setMaxVelocity(75.0f, 5000.0f);
		contested = false;
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

			String name = list.get(i).getName();
			if (name.equals("Floor") || name.equals("FloorBlock") || name.equals("GrassBlock"))
			{
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
	
	public int getPoints()
	{
		return points;
	}
	
	public boolean topOfHill()
	{
		//System.out.println(this.getClass().getName() + this.getX() + " " +  this.getY());
		return (this.getX() > 315 && this.getX() < 410 && this.getY() < 220);
	}

	public void setContested(boolean isContested)
	{
		contested = isContested;
	}
	
	public boolean getContested()
	{
		return contested;
	}
	
	public void update()
	{
		
		//System.out.println("isrunning");
		//System.out.print(this.getTouching());
		//this.startFrame();
		super.update();
		if (this.topOfHill() && !this.getContested())
		{
			pointHandler.setOnHill(true);
		}
		else
		{
			pointHandler.setOnHill(false);
		}
		points = pointHandler.getPoints();
		
		//this.punch();
		/*
		BodyList touching = this.getTouching();
		for(int i = 0; i < touching.size(); i++)
		{
			if(touching.get(i) instanceof Player)
			{
				Player temp = (Player) touching.get(i);
				
				System.out.println(temp.getVelocity().getX() + " " + temp.getVelocity().getY());
				
				if((temp.getVelocity().getX()) > (this.getVelocity().getX()) )
					this.setVelocity(new Vector2f(10 * temp.getVelocity().getX(), temp.getVelocity().getY()));
				else if(temp.getVelocity().getX() < this.getVelocity().getX()) 
					temp.setVelocity(new Vector2f(10 * this.getVelocity().getX(), this.getVelocity().getY()));
				this.clearTouching();
				//System.out.println("help");
				return;
			}
			//System.out.println("hi there");
		}
		*/
	//	System.out.println(points);
	}
	
	public void punch()
	{
		BodyList touching = this.getTouching();
		for(int i = 0; i < touching.size(); i++)
		{
			if(touching.get(i) instanceof Player)
			{
				Player temp = (Player) touching.get(i);
				
				if(Math.abs(temp.getForce().getX()) > Math.abs(this.getForce().getX()) )
					this.addForce(new Vector2f(temp.getForce().getX(), temp.getForce().getY()));
				else if(Math.abs(temp.getForce().getX()) < Math.abs(this.getForce().getX()) )
					temp.addForce(new Vector2f(this.getForce().getX(), this.getForce().getY()));
				this.clearTouching();
				System.out.println("help");
			}
		}
	}


}

