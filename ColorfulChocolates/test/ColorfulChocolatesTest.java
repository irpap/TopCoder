import org.junit.Test;
import static org.junit.Assert.*;

public class ColorfulChocolatesTest {
	
	@Test
	public void test0() {
		String chocolates = "ABCDCBC";
		int maxSwaps = 1;
		assertEquals(2, new ColorfulChocolates().maximumSpread(chocolates, maxSwaps));
	}
	
	@Test
	public void test1() {
		String chocolates = "ABCDCBC";
		int maxSwaps = 2;
		assertEquals(3, new ColorfulChocolates().maximumSpread(chocolates, maxSwaps));
	}
	
	@Test
	public void test2() {
		String chocolates = "ABBABABBA";
		int maxSwaps = 3;
		assertEquals(4, new ColorfulChocolates().maximumSpread(chocolates, maxSwaps));
	}
	
	@Test
	public void test3() {
		String chocolates = "ABBABABBA";
		int maxSwaps = 4;
		assertEquals(5, new ColorfulChocolates().maximumSpread(chocolates, maxSwaps));
	}
	
	@Test
	public void test4() {
		String chocolates = "QASOKZNHWNFODOQNHGQKGLIHTPJUVGKLHFZTGPDCEKSJYIWFOO";
		int maxSwaps = 77;
		assertEquals(5, new ColorfulChocolates().maximumSpread(chocolates, maxSwaps));
	}
}
