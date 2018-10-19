import java.util.ArrayList;

public class Turn
{
	private int turnScore;
	private Roll lastRoll;
	private ArrayList<Roll> rollSequence;
	
	public Turn()
	{
		this.turnScore = 0;
		this.lastRoll = null;
		this.rollSequence = new ArrayList<>();
	}
	
	public int getTurnScore() {
		
		return this.turnScore;
	}

	public Roll getLastRoll()
	{
		return this.lastRoll;
	}

	public void rollAgain()
	{
		this.lastRoll = new Roll();
		rollSequence.add(this.lastRoll);
		
	}
	
	public void scoreTurn()
	{
		if (getLastRoll().isDoubleSkunk())
		{
			turnScore = 0;
		}
		else if (getLastRoll().isDeuceSkunk())
		{
			turnScore = 0;
		}
		else if (getLastRoll().isSingleSkunk())
		{
			turnScore = 0;
		}
		else
		{
			turnScore += lastRoll.getDice().getLastRoll();
		}
	}

	public boolean ends()
	{
		// TODO Auto-generated method stub
		return lastRoll.isDeuceSkunk() || lastRoll.isDoubleSkunk() || lastRoll.isSingleSkunk();
	}
}
