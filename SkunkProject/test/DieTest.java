import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DieTest
{

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void test_initialization_of_predictable_die()
	{
		int[] init_values = new int[]
		{ 3, 2, 1 };
		Die die = new Die(init_values);
		die.roll();
		int value = die.getLastRoll();

		assertEquals("first value not 3", 3, value);
		
	}
	
	@Test
	public void test_roll_2_of_predictable_die()
	{
		Die die = new Die(new int[] {3,2,1});
		die.roll();
		assertEquals("first value not 3", 3, die.getLastRoll());
		die.roll();
		assertEquals("second value not 2", 2, die.getLastRoll());
	}
	
	@Test
	public void test_roll_3_of_predictable_die()
	{
		Die die = new Die(new int[] {3,2,1});
		die.roll();
		die.roll();
		die.roll();
		assertEquals("third value not 1", 1, die.getLastRoll());
	}
	
	@Test
	public void test_roll_4_of_predictable_die_with_3_rolls()
	{
		Die die = new Die(new int[] {3,2,1});
		die.roll();
		die.roll();
		die.roll();
		die.roll();
		assertEquals("fourth value not wrapping back to first value 3", 3, die.getLastRoll());
	}

}
