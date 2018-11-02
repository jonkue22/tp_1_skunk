import java.io.IOException;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkApp implements Reporter
{

	public static void main(String[] args) throws IOException
	{
		Game game = new Game();

		StdOut.println("Welcome to 635 Skunk project!");
		StdOut.println("Please Enter number of players: ");
		
		int numPlayers = StdIn.readInt();
		StdIn.readLine();
		game.setPlayersNum(numPlayers);
		game.addPlayer();

		while (!game.win())
		{
			String player = game.getPlayerName();

			StdOut.println("Starting Turn " + game.getTurnNumber() + " for " + player);

			while (true)
			{
				StdOut.println(player + ", Do you want to roll the dice? Enter yes or no?");

				String response = StdIn.readLine();

				if (!response.equalsIgnoreCase("no"))
				{
					game.getRound().rollAgain();
					game.getRound().scoreTurn();
					StdOut.println(player + " rolled " + game.getRound().getLastRoll().getDice().getLastRoll());
					StdOut.println(game.getRound().getDiceVals());

					if (game.ends())
						break;
				}
				else
				{
					StdOut.println(player + " declined to roll.");
					break;
				}
			}

			int turnScore = game.getRound().getTurnScore();
			game.getCurrentPlayer().setScore(turnScore);
			StdOut.println(player + " scored " + turnScore + " for this turn.");
			StdOut.println(player + "'s Total Score: " + game.getCurrentPlayer().getScore());

			game.nextPlayerTurn();
			game.getRound().startNewTurn();

		}
		StdOut.println("After " + game.getTurnNumber() + " turns");
		StdOut.println(game.winner());
		
	}

	@Override
	public void showMessage(String msg)
	{
		StdOut.println(msg);
	}
}

