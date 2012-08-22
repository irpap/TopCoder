import org.junit.Test;
import static org.junit.Assert.*;

public class SuperSortTest {
	
	@Test
	public void test0() {
		String sentence = "The big,  brown   dog    ran   down  the street!";
		assertEquals("The big,  brown   dog    down   ran  street the!", new SuperSort().wordSort(sentence));
	}
	
	@Test
	public void test1() {
		String sentence = "This is the first sentence of the paragraph.";
		assertEquals("This first is of paragraph sentence the the.", new SuperSort().wordSort(sentence));
	}
	
	@Test
	public void test2() {
		String sentence = "t.d,a!f?g.b,q!i?p.h,s!u?m.l,e!v?y.c,j!w?k.n,x!o?r.";
		assertEquals("a.b,c!d?e.f,g!h?i.j,k!l?m.n,o!p?q.r,s!t?u.v,w!x?y.", new SuperSort().wordSort(sentence));
	}
	
	@Test
	public void test3() {
		String sentence = "What is this?";
		assertEquals("What is this?", new SuperSort().wordSort(sentence));
	}
	
	@Test
	public void test4() {
		String sentence = "?   .   ,   !   ";
		assertEquals("?   .   ,   !   ", new SuperSort().wordSort(sentence));
	}
	
	@Test
	public void test5() {
		String sentence = "                    ";
		assertEquals("                    ", new SuperSort().wordSort(sentence));
	}
	
	@Test
	public void test6() {
		String sentence = "faecdb";
		assertEquals("faecdb", new SuperSort().wordSort(sentence));
	}
	
	@Test
	public void test7() {
		String sentence = "a A b B c C d D e E";
		assertEquals("A B C D E a b c d e", new SuperSort().wordSort(sentence));
	}
}
