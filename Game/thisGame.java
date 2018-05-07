
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
		world.add(floor);
		Body wheel = new Body("Player 1", new Circle(50f), 0.25f);
		wheel.setFriction(1000.0f);
		wheel.setPosition(250.0f, 100.0f);// TODO Auto-generated method stub
		world.add(wheel);
		
		
		
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
