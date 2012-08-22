import org.junit.Test;
import static org.junit.Assert.*;

public class FavouriteDigitsTest {
	
	@Test
	public void test0() {
		long N = 47L;
		int digit1 = 1;
		int count1 = 0;
		int digit2 = 2;
		int count2 = 0;
		assertEquals(47L, new FavouriteDigits().findNext(N, digit1, count1, digit2, count2));
	}
	
	@Test
	public void test1() {
		long N = 47L;
		int digit1 = 5;
		int count1 = 0;
		int digit2 = 9;
		int count2 = 1;
		assertEquals(49L, new FavouriteDigits().findNext(N, digit1, count1, digit2, count2));
	}
	
	@Test
	public void test2() {
		long N = 47L;
		int digit1 = 5;
		int count1 = 0;
		int digit2 = 3;
		int count2 = 1;
		assertEquals(53L, new FavouriteDigits().findNext(N, digit1, count1, digit2, count2));
	}
	
	@Test
	public void test3() {
		long N = 47L;
		int digit1 = 2;
		int count1 = 1;
		int digit2 = 0;
		int count2 = 2;
		assertEquals(200L, new FavouriteDigits().findNext(N, digit1, count1, digit2, count2));
	}
	
	@Test
	public void test4() {
		long N = 123456789012345L;
		int digit1 = 1;
		int count1 = 2;
		int digit2 = 2;
		int count2 = 4;
		assertEquals(123456789012422L, new FavouriteDigits().findNext(N, digit1, count1, digit2, count2));
	}
	
	@Test
	public void test5() {
		long N = 92L;
		int digit1 = 1;
		int count1 = 1;
		int digit2 = 0;
		int count2 = 0;
		assertEquals(100L, new FavouriteDigits().findNext(N, digit1, count1, digit2, count2));
	}
}
