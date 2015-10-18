package median;

import static median.Median.searchMedian;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

public class MedianTest {

	@Test
	public void searchMedianTest() throws FileNotFoundException {

		final double delta = 0.0000000000000000000000000000001;
		Assert.assertEquals(6.0,
				searchMedian(new double[] { 1, 2 }, new double[] { 10, 20 }),
				delta);
		Assert.assertEquals(
				10.0,
				searchMedian(new double[] { 1, 2, 3, 10 }, new double[] { 10,
						20, 30, 40 }), delta);
		Assert.assertEquals(
				3.5,
				searchMedian(new double[] { 1, 2, 3, 4 }, new double[] { 1, 4,
						5, 6 }), delta);
		Assert.assertEquals(
				3.5,
				searchMedian(new double[] { -2, -1, 3, 4 }, new double[] { -1,
						4, 5, 6 }), delta);
		Assert.assertEquals(0,
				searchMedian(new double[] { 0 }, new double[] { 0 }), delta);
		Assert.assertEquals(-5.5,
				searchMedian(new double[] { -1 }, new double[] { -10 }), delta);
		Assert.assertEquals(-10.0,
				searchMedian(new double[] { -10 }, new double[] { -10 }), delta);
		Assert.assertEquals(
				6.5,
				searchMedian(new double[] { 7, 8, 9, 10, 11, 12 },
						new double[] { 1, 2, 3, 4, 5, 6 }), delta);
		Assert.assertEquals(
				6.5,
				searchMedian(new double[] { 1, 2, 3, 4, 5, 6 }, new double[] {
						7, 8, 9, 10, 11, 12 }), delta);
		Assert.assertEquals(
				19.5,
				searchMedian(new double[] { 1, 2, 3, 10, 15, 20 },
						new double[] { 19, 20, 21, 22, 23, 24 }), delta);
		Assert.assertEquals(
				16.5,
				searchMedian(new double[] { 1, 2, 3, 10, 15, 17 },
						new double[] { 16, 19, 20, 21, 22, 23 }), delta);
		Assert.assertEquals(1.5,
				searchMedian(new double[] { 1, 2 }, new double[] { 1, 2 }),
				delta);
		Assert.assertEquals(
				2,
				searchMedian(new double[] { 1, 2, 2 }, new double[] { 2, 2, 2 }),
				delta);
		Assert.assertEquals(
				2,
				searchMedian(new double[] { 1, 3, 3 }, new double[] { 2, 2, 2 }),
				delta);
		Assert.assertEquals(0,
				searchMedian(new double[] { -1, 0 }, new double[] { 0, 1 }),
				delta);
		Assert.assertEquals(2,
				searchMedian(new double[] { 1, 2 }, new double[] { 2, 2 }),
				delta);
		Assert.assertEquals(
				1.5,
				searchMedian(new double[] { 1, 1, 2, 2 }, new double[] { 1, 1,
						2, 2 }), delta);
		Assert.assertEquals(
				1,
				searchMedian(new double[] { 1, 1, 2 }, new double[] { 1, 1, 2 }),
				delta);

		Assert.assertEquals(1.5,
				searchMedian(new double[] { 1, }, new double[] { 2, }), delta);
		Assert.assertEquals(
				2.5,
				searchMedian(new double[] { 1, 8, 9 }, new double[] { 1, 2, 3 }),
				delta);
		Assert.assertEquals(
				5.0,
				searchMedian(new double[] { 1, 8, 9 }, new double[] { 1, 2, 8 }),
				delta);
		Assert.assertEquals(3.5,
				searchMedian(new double[] { 7 }, new double[] { 0 }), delta);
		Assert.assertEquals(-3.5,
				searchMedian(new double[] { -7 }, new double[] { 0 }), delta);
		Assert.assertEquals(0.5,
				searchMedian(new double[] { -1 }, new double[] { 2 }), delta);
		Assert.assertEquals(-1.0,
				searchMedian(new double[] { -1 }, new double[] { -1 }), delta);
		Assert.assertEquals(
				3.5,
				searchMedian(new double[] { 1, 2, 3 }, new double[] { 4, 5, 6 }),
				delta);
		Assert.assertEquals(
				3.5,
				searchMedian(new double[] { 4, 5, 6 }, new double[] { 1, 2, 3 }),
				delta);
		Assert.assertEquals(
				2.0,
				searchMedian(new double[] { 1, 2, 3 }, new double[] { 1, 2, 3 }),
				delta);

		Assert.assertEquals(
				2.5,
				searchMedian(new double[] { 1, 2, 3, 4 }, new double[] { 1, 2,
						3, 4 }), delta);
		Assert.assertEquals(
				3.5,
				searchMedian(new double[] { -1.0, 0.0, 5.0, 7.0, 8.0 },
						new double[] { -10.0, -2.0, 3.0, 4.0, 70.0 }), delta);

		Assert.assertEquals(
				3.5,
				searchMedian(new double[] { -10.0, -2.0, 3.0, 4.0, 70.0 },
						new double[] { -1.0, 0.0, 5.0, 7.0, 8.0 }), delta);

		Assert.assertEquals(
				4.0,
				searchMedian(new double[] { -2.2, -2.1, 3.5, 4.5, 70.0 },
						new double[] { -1.1, 0.0, 5.7, 7.2, 8.0 }), delta);

		Assert.assertEquals(
				1.0005,
				searchMedian(new double[] { 1, 1.001, 1.011 }, new double[] {
						1, 1, 1.001 }), delta);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgumentException() throws FileNotFoundException {
		searchMedian(new double[] { 1, 2, 3, 4 }, new double[] { 4, 5, 6 });
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgumentException2() throws FileNotFoundException {
		searchMedian(new double[] { 3, 2, 1, 0 }, new double[] { 4, 5, 6 });
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgumentException3() throws FileNotFoundException {
		searchMedian(new double[] {}, new double[] {});
	}

}