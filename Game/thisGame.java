
import net.phys2d.raw.Body;
import net.phys2d.raw.World;
import net.phys2d.raw.shapes.Circle;
import net.phys2d.raw.shapes.*;
import java.awt.*;
public class thisGame extends Game 
{

	public thisGame()
	{
		super("test");
	}

	protected void init(World world) 
	{
		
		Body floor = new Body("Floor", new Line(-2000f, 400f, 2000f, 400f), 100f);
		floor.setGravityEffected(false);
		floor.setPosition(50, 50);
		floor.setMoveable(false);
		floor.setRotatable(false);
		floor.setFriction(0f);
		world.add(floor);
		//Body rectangle = new Body("Player 1", new Box(50f, 50f), 0.25f);
		//rectangle.setMaxVelocity(50, 1000);
		//rectangle.setFriction(0);
		//rectangle.setPosition(250.0f, 100.0f);// TODO Auto-generated method stub
		//world.add(rectangle);
		
		Player me = new Player(new Box(50f, 50f), 0.2f, "Player 1");
		me.setPosition(250.0f, 100.0f);
		me.setRotatable(false);
		me.setMass(10f);
		
		world.setGravity(0, 40f);
		world.add(me);
		
	}

	public static void main(String args[])
	{
		thisGame game = new thisGame();
		game.start();

	}

	public void run() {
		// TODO Auto-generated method stub
		
	}
}
