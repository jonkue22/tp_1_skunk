public class Player
{
	private String name;
	private Roll diceRoll;
	private Turn turn;
	private int score;
	private int chips;
	private final int initChips = 50;

	public Player(String name)
	{
		this.name = name;
		this.score = 0;
		this.chips = this.initChips;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getScore()
	{
		return this.score;
	}

	public void setScore(int score)
	{		
		this.score += score;
	}

	public void playerRoll()
	{
		this.diceRoll = new Roll();
	}

	public String toString()
	{
		return name + " HAS WON WITH A TOTAL SCORE OF " + score;
	}

}
