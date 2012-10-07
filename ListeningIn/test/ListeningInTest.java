import org.junit.Test;
import static org.junit.Assert.*;

public class ListeningInTest {
	
	@Test
	public void test0() {
		String typed = "cptr";
		String phrase = "capture";
		assertEquals("aue", new ListeningIn().probableMatch(typed, phrase));
	}
	
	@Test
	public void test1() {
		String typed = "port to me";
		String phrase = "teleport to me";
		assertEquals("tele", new ListeningIn().probableMatch(typed, phrase));
	}
	
	@Test
	public void test2() {
		String typed = "back  to base";
		String phrase = "back to base";
		assertEquals("UNMATCHED", new ListeningIn().probableMatch(typed, phrase));
	}
}
