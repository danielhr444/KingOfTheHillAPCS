import net.phys2d.math.Vector2f;
import net.phys2d.raw.Body;
import net.phys2d.raw.World;
import net.phys2d.raw.shapes.DynamicShape;

public class Player extends Body
{
	private World myWorld;
	private boolean movingLeft;
	private boolean movingRight;
	private boolean isFacingRight;
	private boolean isFacingLeft;
	private boolean isMovingLeft = false;
	private boolean isMovingRight = false;
	String nation = "hi";
	private double runningTime;
	private double lastJump;
	private boolean isUp = false;


	public Player(DynamicShape shape, float m, String myName) 
	{
		super(myName, shape, m);
		setDamping(0);

		// TODO Auto-generated constructor stub
	}

	
	public void moveLeft()
	{
		setMaxVelocity(75.0f, 5000.0f);
		//adjustVelocity(new Vector2f(-75, 0));
		setVelocity(new Vector2f(-75, 0));
	}

	public void moveRight()
	{

		setMaxVelocity(75.0f, 5000.0f);
		//adjustVelocity(new Vector2f(75, 0));
		setVelocity(new Vector2f(75f,0));
	}


	public void jump()
	{
		
		if (getVelocity().getY() <= 0.0001)
		{
			setMaxVelocity(75.0f, 5000.0f);
			adjustVelocity(new Vector2f(0, -100));
		}
	
	}


	public void stop()
	{
		this.adjustVelocity(new Vector2f(-this.getVelocity().getX(),0));
	}
	



}

