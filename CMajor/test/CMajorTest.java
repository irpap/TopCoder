import org.junit.Test;
import static org.junit.Assert.*;

public class CMajorTest {
	
	@Test
	public void test0() {
		String[] fragments = new String[] {"2 2 1 2 2 2 1","2 1 2 2 2 1 2"};
		assertEquals(1, new CMajor().getLongest(fragments));
	}
	
	@Test
	public void test1() {
		String[] fragments = new String[] {"2","2","1","2","2","2","1","2","2","1","2","2","2","1","2","2","1","2","2"};
		assertEquals(19, new CMajor().getLongest(fragments));
	}
	
	@Test
	public void test2() {
		String[] fragments = new String[] {"2 2 2 2","1 1","5 -4 12 -11","0 2 -2 5 -1 -4 2 -2 7 -2"};
		assertEquals(1, new CMajor().getLongest(fragments));
	}
	
	@Test
	public void test3() {
		String[] fragments = new String[] {"2 0 2 0 -2 -2 -1 5 1 2 2 2 1"};
		assertEquals(1, new CMajor().getLongest(fragments));
	}
	
	@Test
	public void test4() {
		String[] fragments = new String[] {"5748 -4385 -790 5294 3349","-3279 -1783 3768 -2459 6066 2556 -8138 -4982 1435",
 "2951","-2405 2104 3756","5578 -5040 -9497 -4868 7407 9305 -6701",
 "-3339 9514 -787 7209 7467 -4467", "7496 3011 9941 -8340 3012"};
		assertEquals(4, new CMajor().getLongest(fragments));
	}
	
	@Test
	public void test5() {
		String[] fragments = new String[] {"72","1872","8916","-288","2208","-4716","2328","9516",
 "-5472","9840","6420","3492","-1608","4176","264","-6264",
 "1176","-684","3984"};
		assertEquals(19, new CMajor().getLongest(fragments));
	}
}
