package squaresort;

import java.util.*;

/**
 * Compare array of objects based on pay grade
 * 
 * @param Object array to be sorted
 * @param Type of comparator to sort based on
 */

public class PayGradeComparator implements Comparator<Person> {
	public int compare(Person p1, Person p2){
		if (p1.payGrade < p2.payGrade){
			return -1;
		}
		else if (p1.payGrade > p2.payGrade){
			return 1;
		}
		return 0;
	}
}
