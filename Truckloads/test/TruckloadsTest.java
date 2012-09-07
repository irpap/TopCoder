import org.junit.Test;
import static org.junit.Assert.*;

public class TruckloadsTest {
	
	@Test
	public void test0() {
		int numCrates = 14;
		int loadSize = 3;
		assertEquals(6, new Truckloads().numTrucks(numCrates, loadSize));
	}
	
	@Test
	public void test1() {
		int numCrates = 15;
		int loadSize = 1;
		assertEquals(15, new Truckloads().numTrucks(numCrates, loadSize));
	}
	
	@Test
	public void test2() {
		int numCrates = 1024;
		int loadSize = 5;
		assertEquals(256, new Truckloads().numTrucks(numCrates, loadSize));
	}
}
