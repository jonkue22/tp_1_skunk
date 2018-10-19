import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkApp implements Reporter
{

	public static void main(String[] args)
	{
		StdOut.println("Welcome to 635 Skunk project!");

		StdOut.println("Please enter name for player1 to begin:");

		String player = StdIn.readLine();

		Turn turn = new Turn();

		while (true)
		{
			StdOut.print(player + "," + " do you want to roll? Enter y or n");

			String response = StdIn.readLine();

			if (response.equals("y"))
			{
				turn.rollAgain();
				turn.scoreTurn();
				StdOut.println("You rolled a " + turn.getLastRoll().getDice().getLastRoll());
				if (turn.ends())
					break;
			}
			else
			{
				StdOut.println("You declined to roll.");
				break;
			}

		}
		
		int turnScore = turn.getTurnScore();
		StdOut.println("You scored " + turnScore + " for this turn.");

	}

	@Override
	public void showMessage(String msg)
	{
		StdOut.println(msg);

	}

}
