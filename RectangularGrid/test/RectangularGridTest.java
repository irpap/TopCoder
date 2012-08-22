import org.junit.Test;
import static org.junit.Assert.*;

public class RectangularGridTest {
	
	@Test
	public void test0() {
		int width = 3;
		int height = 3;
		assertEquals(22L, new RectangularGrid().countRectangles(width, height));
	}
	
	@Test
	public void test1() {
		int width = 5;
		int height = 2;
		assertEquals(31L, new RectangularGrid().countRectangles(width, height));
	}
	
	@Test
	public void test2() {
		int width = 10;
		int height = 10;
		assertEquals(2640L, new RectangularGrid().countRectangles(width, height));
	}
	
	@Test
	public void test3() {
		int width = 1;
		int height = 1;
		assertEquals(0L, new RectangularGrid().countRectangles(width, height));
	}
	
	@Test
	public void test4() {
		int width = 592;
		int height = 964;
		assertEquals(81508708664L, new RectangularGrid().countRectangles(width, height));
	}
}
