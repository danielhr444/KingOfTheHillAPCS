import net.phys2d.math.Vector2f;
import net.phys2d.raw.Body;
import net.phys2d.raw.World;
import net.phys2d.raw.shapes.DynamicShape;

public class Player extends Body
{
	private World myWorld;
	private boolean movingLeft;
	private boolean movingRight;


	public Player(DynamicShape shape, float m, String myName) 
	{
		super(myName, shape, m);
		setFriction(0);

		// TODO Auto-generated constructor stub
	}

	public void moveLeft()
	{
		setMaxVelocity(75.0f, 5000.0f);
		if (movingRight)
		{
			adjustVelocity(new Vector2f(-150f, 0));
		}
		adjustVelocity(new Vector2f(-75f, 0));
	}

	public void moveRight()
	{
		setMaxVelocity(75.0f, 5000.0f);
		if (movingLeft)
		{
			adjustVelocity(new Vector2f(150f, 0));
		}
		adjustVelocity(new Vector2f(75f, 0));
	}

	public void jump()
	{
		if (getVelocity().getY() == 0)
		{
			setMaxVelocity(75.0f, 5000.0f);
			adjustVelocity(new Vector2f(0, -100));
		}
	}
}

