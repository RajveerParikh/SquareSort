package squaresort;

import static org.junit.Assert.*;

import org.junit.Test;

public class SquaresortTest {
	Person test1 = new Person("Ada", "Adkins", 13);
	Person test2 = new Person("Leroy", "West", 17);
	Person test3 = new Person("Bobby", "Reyes", 25);
	Person test4 = new Person("Josefina", "Doyle", 19);
	Person test5 = new Person("Rebecca", "Mendoza", 8);
	Person test6 = new Person("Stuart", "Moody", 16);
	Person test7 = new Person("Terence", "Page", 14);
	Person test8 = new Person("Van", "Nichols", 21);

	Person[] testPeople1 = new Person[]{test1, test2, test3, test4, test5, test6, test7};
	Person[] testPeople2 = new Person[]{test5, test1, test7, test6, test2, test4, test3};
	Person[][] testSquareSort1 = {{test1, test2, test3, test4}, {test5, test6, test7, test8}};
	Person[][] testSquareSort2 = {{test5, test7, test1, test6}, {test8, test3, test2, test4}};
	
	NameComparator nameComp = new NameComparator();
	PayGradeComparator payComp = new PayGradeComparator();
	EmployeeIdComparator empComp = new EmployeeIdComparator();
	
	@Test
	public void testLinearSortIntArray() {
		int[] test1 = new int[] {8, 5, 3, 6, 9, 10};
		int[] result1 = new int[] {3, 5, 6, 8, 9, 10};
		int[] test2 = new int[] {14, 9, 12, 27, 18, 22};
		int[] result2 = new int[]{9, 12, 14, 18, 22, 27};
		Squaresort.linearSort(test1);
		Squaresort.linearSort(test2);
		assertArrayEquals(result1, test1);
		assertArrayEquals(result2, test2);
	}

	@Test
	public void testLinearSortPersonArrayComparatorOfPerson() {
		Person[] testPeopleOrg1 = new Person[]{test1, test4, test5, test6, test7, test3, test2};
		Person[] testPeopleOrg2 = new Person[]{test5, test1, test7, test6, test2, test4, test3};
		Person[] testPeopleOrg3 = new Person[]{test1, test2, test3, test4, test5, test6, test7};
		Squaresort.linearSort(testPeople1, nameComp);
		assertArrayEquals(testPeopleOrg1, testPeople1);
		Squaresort.linearSort(testPeople1, payComp);
		assertArrayEquals(testPeopleOrg2, testPeople1);
		Squaresort.linearSort(testPeople2, empComp);
		assertArrayEquals(testPeopleOrg3, testPeople2);
	}

	@Test
	public void testSquaresort() {
		Person[][] testPeopleOrg1 = {{test1, test4, test5, test6}, {test8, test7, test3, test2}};
		Person[][] testPeopleOrg2 = {{test5, test1, test7, test6}, {test2, test4, test8, test3}};
		Person[][] testPeopleOrg3 = {{test1, test2, test3, test4}, {test5, test6, test7, test8}};
		
		Squaresort.squaresort(testSquareSort1, nameComp);
		assertArrayEquals(testPeopleOrg1, testSquareSort1);
		Squaresort.squaresort(testSquareSort1, payComp);
		assertArrayEquals(testPeopleOrg2, testSquareSort1);
		Squaresort.squaresort(testSquareSort2, empComp);
		assertArrayEquals(testPeopleOrg3, testSquareSort2);
	}

}
