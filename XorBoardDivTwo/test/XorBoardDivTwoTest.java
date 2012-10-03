import org.junit.Test;
import static org.junit.Assert.*;

public class XorBoardDivTwoTest {
	
	@Test
	public void test0() {
		String[] board = new String[] {"101",
 "010",
 "101"};
		assertEquals(9, new XorBoardDivTwo().theMax(board));
	}
	
	@Test
	public void test1() {
		String[] board = new String[] {"111",
 "111",
 "111"};
		assertEquals(5, new XorBoardDivTwo().theMax(board));
	}
	
	@Test
	public void test2() {
		String[] board = new String[] {"0101001",
 "1101011"};
		assertEquals(9, new XorBoardDivTwo().theMax(board));
	}
	
	@Test
	public void test3() {
		String[] board = new String[] {"000",
 "001",
 "010",
 "011",
 "100",
 "101",
 "110",
 "111"};
		assertEquals(15, new XorBoardDivTwo().theMax(board));
	}
	
	@Test
	public void test4() {
		String[] board = new String[] {"000000000000000000000000",
 "011111100111111001111110",
 "010000000100000001000000",
 "010000000100000001000000",
 "010000000100000001000000",
 "011111100111111001111110",
 "000000100000001000000010",
 "000000100000001000000010",
 "000000100000001000000010",
 "011111100111111001111110",
 "000000000000000000000000"}
;
		assertEquals(105, new XorBoardDivTwo().theMax(board));
	}
}
