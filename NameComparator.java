package squaresort;
import java.util.*;

public class NameComparator implements Comparator<Person>{
	public int compare(Person p1, Person p2){
		if(p1.surname.compareTo(p2.surname) < 0){
			return -1;
		}
		else if (p1.surname.compareTo(p2.surname) > 0){
			return 1;
		}
		else if (p1.givenName.compareTo(p2.givenName) < 0){
			return -1;
		}
		else if (p1.givenName.compareTo(p2.givenName) > 0){
			return 1;
		}
		return 0;
	}
}