import java.util.TimerTask;

public class PointHandler extends TimerTask
{
	private int points;
	
	public int getPoints()
	{
		return points;
	}
	
	public void run()
	{
		points++;
		System.out.println(points);
	}
}
