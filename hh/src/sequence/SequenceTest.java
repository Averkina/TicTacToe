package sequence;

import static sequence.Sequence.findNumberOfOccurrence;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

public class SequenceTest {

	@Test
	public void findNumberOfOccurrenceTest() throws FileNotFoundException {
		Assert.assertEquals(11, findNumberOfOccurrence("0"));
		Assert.assertEquals(6, findNumberOfOccurrence("6789"));
		Assert.assertEquals(12, findNumberOfOccurrence("111"));
		Assert.assertEquals(12, findNumberOfOccurrence("1112"));
		Assert.assertEquals(34, findNumberOfOccurrence("2223"));
		Assert.assertEquals(56, findNumberOfOccurrence("3334"));
		Assert.assertEquals(78, findNumberOfOccurrence("4445"));
		Assert.assertEquals(188, findNumberOfOccurrence("9910"));
		Assert.assertEquals(2890, findNumberOfOccurrence("1000"));
		Assert.assertEquals(38890, findNumberOfOccurrence("10000"));
		Assert.assertEquals(488890, findNumberOfOccurrence("100000"));
		Assert.assertEquals(5888890, findNumberOfOccurrence("1000000"));
		Assert.assertEquals(2930, findNumberOfOccurrence("1010101"));
		Assert.assertEquals(539766, findNumberOfOccurrence("847910"));
		Assert.assertEquals(4222, findNumberOfOccurrence("1333133"));
		Assert.assertEquals(50615, findNumberOfOccurrence("1234512346"));
		Assert.assertEquals(5797649,
				findNumberOfOccurrence("8479398479498479598479698479798479"));
		Assert.assertEquals(16224720, findNumberOfOccurrence("4765472"));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgumentException() throws FileNotFoundException {
		findNumberOfOccurrence("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgumentException1() throws FileNotFoundException {
		findNumberOfOccurrence("1235746a");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgumentException2() throws FileNotFoundException {
		findNumberOfOccurrence("12 35746");
	}

}
