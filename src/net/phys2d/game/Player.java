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
	
	/**
	 * @param shape
	 * @param mass
	 * @param myName
	 */
	public Player(DynamicShape shape, float mass, String myName) 
	{
		super(myName, shape, mass);
		setDamping(0);

		Timer timer = new Timer();
		pointHandler = new pointCounter();
	
		timer.scheduleAtFixedRate(pointHandler, 1000, 1000);
		setMaxVelocity(75.0f, 75.0f);
		contested = false;
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @return current X position
	 */
	public float getX()
	{
		return (this.getPosition().getX() + 1.35f);
	}
	
	/**
	 * @return player height
	 */
	public float getHeight()
	{
		return (this.getShape().getBounds().getHeight() - 19);
	}
	
	/**
	 * @return player width
	 */
	public float getWidth()
	{
		return (this.getShape().getBounds().getWidth() - 19);
	}

	/**
	 * @return current Y position
	 */
	public float getY()
	{
		return (this.getPosition().getY());
	}

	/**
	 * @return if the player is off the ground
	 */
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


	/**
	 * @return if the player is moving left
	 */
	public boolean isMovingLeft() {
		return movingLeft;
	}


	/**
	 * @param movingLeft- set if player is moving left
	 */
	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}


	/**
	 * @return if the player is moving right
	 */
	public boolean isMovingRight() {
		return movingRight;
	}


	/**
	 * @param movingRight- set if player is moving right
	 */
	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}

	/**
	 *  makes player move left
	 */
	public void moveLeft()
	{
		//setMaxVelocity(75.0f, 5000.0f);
		//adjustVelocity(new Vector2f(-75, 0));
		setVelocity(new Vector2f(-75, this.getVelocity().getY()));
	}

	/**
	 * makes player move right
	 */
	public void moveRight()
	{

		//setMaxVelocity(75.0f, 5000.0f);
		//adjustVelocity(new Vector2f(75, 0));
		setVelocity(new Vector2f(75f,this.getVelocity().getY()));
	}


	/**
	 * makes player jump
	 */
	public void jump()
	{
		
		//if (!isUp())
		{
			
			//setMaxVelocity(75.0f, 5000.0f);
			setVelocity(new Vector2f(this.getVelocity().getX(), -75));
			this.clearTouching();
		}
		
		
	}


	/**
	 * makes player stop moving
	 */
	public void stop()
	{
		this.setVelocity(new Vector2f(0,this.getVelocity().getY()));

	}
	
	/**
	 * @return number of points player has
	 */
	public int getPoints()
	{
		return points;
	}
	
	/**
	 * @return if the player is at the top of the hill
	 */
	public boolean topOfHill()
	{
		//System.out.println(this.getClass().getName() + this.getX() + " " +  this.getY());
		return (this.getX() > 315 && this.getX() < 410 && this.getY() < 220);
	}

	/**
	 * @param isContested- set if hill is contested
	 */
	public void setContested(boolean isContested)
	{
		contested = isContested;
	}
	
	/**
	 * @return contested
	 */
	public boolean getContested()
	{
		return contested;
	}
	
	/* (non-Javadoc)
	 * @see net.phys2d.raw.Body#update()
	 */
	public void update()
	{
		
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
		
	
	}
	
	/**
	 * work in progress- collide with other player
	 */
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

