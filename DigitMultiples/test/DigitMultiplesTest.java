import org.junit.Test;
import static org.junit.Assert.*;

public class DigitMultiplesTest {
	
	@Test
	public void test0() {
		String single = "3211113321571";
		String multiple = "5555266420";
		assertEquals(5, new DigitMultiples().getLongest(single, multiple));
	}
	
	@Test
	public void test1() {
		String single = "100200300";
		String multiple = "100400600";
		assertEquals(8, new DigitMultiples().getLongest(single, multiple));
	}
	
	@Test
	public void test2() {
		String single = "111111111100000000000000000000000000000000000";
		String multiple = "122333444455555666666777777788888888999999999";
		assertEquals(9, new DigitMultiples().getLongest(single, multiple));
	}
	
	@Test
	public void test3() {
		String single = "000000000000";
		String multiple = "000000000000";
		assertEquals(12, new DigitMultiples().getLongest(single, multiple));
	}
	
	@Test
	public void test4() {
		String single = "11111111111";
		String multiple = "11111111111";
		assertEquals(11, new DigitMultiples().getLongest(single, multiple));
	}
	
	@Test
	public void test5() {
		String single = "89248987092734709478099";
		String multiple = "00000000000000000000000";
		assertEquals(23, new DigitMultiples().getLongest(single, multiple));
	}
	
	@Test
	public void test6() {
		String single = "11111111111111111111111111111111111111111111111111";
		String multiple = "00000000000000000000000001111111111111111111111111";
		assertEquals(25, new DigitMultiples().getLongest(single, multiple));
	}
}
