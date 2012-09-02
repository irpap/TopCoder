import org.junit.Test;
import static org.junit.Assert.*;

public class TheBrickTowerEasyDivTwoTest {
	
	@Test
	public void test0() {
		int redCount = 1;
		int redHeight = 2;
		int blueCount = 3;
		int blueHeight = 4;
		assertEquals(4, new TheBrickTowerEasyDivTwo().find(redCount, redHeight, blueCount, blueHeight));
	}
	
	@Test
	public void test1() {
		int redCount = 4;
		int redHeight = 4;
		int blueCount = 4;
		int blueHeight = 7;
		assertEquals(12, new TheBrickTowerEasyDivTwo().find(redCount, redHeight, blueCount, blueHeight));
	}
	
	@Test
	public void test2() {
		int redCount = 7;
		int redHeight = 7;
		int blueCount = 4;
		int blueHeight = 4;
		assertEquals(13, new TheBrickTowerEasyDivTwo().find(redCount, redHeight, blueCount, blueHeight));
	}
	
	@Test
	public void test3() {
		int redCount = 47;
		int redHeight = 47;
		int blueCount = 47;
		int blueHeight = 47;
		assertEquals(94, new TheBrickTowerEasyDivTwo().find(redCount, redHeight, blueCount, blueHeight));
	}
}
