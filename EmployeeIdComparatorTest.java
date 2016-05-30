package squaresort;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeIdComparatorTest {
	Person test1 = new Person("Ada", "Adkins", 13);
	Person test2 = new Person("Leroy", "West", 17);
	Person test3 = new Person("Bobby", "Reyes", 25);
	EmployeeIdComparator comp = new EmployeeIdComparator();
	@Test
	public void testCompare() {
		
		assertEquals(-1, comp.compare(test1, test2));
		assertEquals(0, comp.compare(test3, test3));
		assertEquals(1, comp.compare(test3, test1));

	}
}
