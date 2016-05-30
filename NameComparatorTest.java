package squaresort;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Compare array of objects based on surname or given name
 * 
 * @param Object array to be sorted
 * @param Type of comparator to sort based on
 */

public class NameComparatorTest {
	Person test1 = new Person("Ada", "Adkins", 13);
	Person test2 = new Person("Leroy", "West", 17);
	Person test3 = new Person("Bobby", "Reyes", 11);
	NameComparator comp = new NameComparator();

	@Test
	public void testCompare() {
		assertEquals(-1, comp.compare(test1, test2));
		assertEquals(0, comp.compare(test3, test3));
		assertEquals(1, comp.compare(test2, test3));

	}
}
