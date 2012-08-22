import org.junit.Test;
import static org.junit.Assert.*;

public class BonusesTest {
	
	@Test
	public void test0() {
		int[] points = new int[] {1,2,3,4,5};
		assertArrayEquals(new int[] { 6,  13,  20,  27,  34 }, new Bonuses().getDivision(points));
	}
	
	@Test
	public void test1() {
		int[] points = new int[] {5,5,5,5,5,5};
		assertArrayEquals(new int[] { 17,  17,  17,  17,  16,  16 }, new Bonuses().getDivision(points));
	}
	
	@Test
	public void test2() {
		int[] points = new int[] {485, 324, 263, 143, 470, 292, 304, 188, 100, 254, 296,
 255, 360, 231, 311, 275,  93, 463, 115, 366, 197, 470};
		assertArrayEquals(new int[] { 8,  6,  4,  2,  8,  5,  5,  3,  1,  4,  5,  4,  6,  3,  5,  4,  1,  8,  1,  6,  3,  8 }, new Bonuses().getDivision(points));
	}
}
