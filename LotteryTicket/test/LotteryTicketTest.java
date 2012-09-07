import org.junit.Test;
import static org.junit.Assert.*;

public class LotteryTicketTest {
	
	@Test
	public void test0() {
		int price = 10;
		int b1 = 1;
		int b2 = 5;
		int b3 = 10;
		int b4 = 50;
		assertEquals("POSSIBLE", new LotteryTicket().buy(price, b1, b2, b3, b4));
	}
	
	@Test
	public void test1() {
		int price = 15;
		int b1 = 1;
		int b2 = 5;
		int b3 = 10;
		int b4 = 50;
		assertEquals("POSSIBLE", new LotteryTicket().buy(price, b1, b2, b3, b4));
	}
	
	@Test
	public void test2() {
		int price = 65;
		int b1 = 1;
		int b2 = 5;
		int b3 = 10;
		int b4 = 50;
		assertEquals("POSSIBLE", new LotteryTicket().buy(price, b1, b2, b3, b4));
	}
	
	@Test
	public void test3() {
		int price = 66;
		int b1 = 1;
		int b2 = 5;
		int b3 = 10;
		int b4 = 50;
		assertEquals("POSSIBLE", new LotteryTicket().buy(price, b1, b2, b3, b4));
	}
	
	@Test
	public void test4() {
		int price = 1000;
		int b1 = 999;
		int b2 = 998;
		int b3 = 997;
		int b4 = 996;
		assertEquals("IMPOSSIBLE", new LotteryTicket().buy(price, b1, b2, b3, b4));
	}
	
	@Test
	public void test5() {
		int price = 20;
		int b1 = 5;
		int b2 = 5;
		int b3 = 5;
		int b4 = 5;
		assertEquals("POSSIBLE", new LotteryTicket().buy(price, b1, b2, b3, b4));
	}
	
	@Test
	public void test6() {
		int price = 2;
		int b1 = 1;
		int b2 = 5;
		int b3 = 10;
		int b4 = 50;
		assertEquals("IMPOSSIBLE", new LotteryTicket().buy(price, b1, b2, b3, b4));
	}
}
