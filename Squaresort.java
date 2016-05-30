package squaresort;

import java.util.Comparator;

/**
 * Creating methods to sort a one dimensional array of numbers, one dimensional array of objects 
 * and a two dimensional array of objects
 * 
 * @author Rajveer Parikh
 * @version January 28, 2015
 */

public class Squaresort {
	public static void main(String [] args){
		int[] testNum = new int[] {8, 5, 3, 6, 9, 10};
		Person test1 = new Person("Ada", "Adkins", 13);
		Person test2 = new Person("Leroy", "West", 17);
		Person test3 = new Person("Bobby", "Reyes", 25);
		Person test4 = new Person("Josefina", "Doyle", 19);
		Person test5 = new Person("Rebecca", "Mendoza", 8);
		Person test6 = new Person("Stuart", "Moody", 16);
		Person test7 = new Person("Terence", "Page", 14);
		Person test8 = new Person("Van", "Nichols", 21);

		Person[] testPeople1 = new Person[]{test1, test2, test3, test4, test5, test6, test7};
		Person[][] testSquareSort1 = {{test1, test2, test3, test4}, {test5, test6, test7, test8}};
		
		NameComparator nameComp = new NameComparator();
		PayGradeComparator payComp = new PayGradeComparator();
		EmployeeIdComparator empComp = new EmployeeIdComparator();
		
		System.gc();
		long startTime1 = System.nanoTime();
		for (int i = 1; i < 20; i++){
			linearSort(testNum);
		}
		long elapsedTime1 = System.nanoTime() - startTime1;
		elapsedTime1 = elapsedTime1 / 20;
		System.out.printf("Average time elapsed for linearSort= %d \n", elapsedTime1);
		
		System.gc();
		long startTime2 = System.nanoTime();
		for (int i = 1; i < 20; i++){
			linearSort(testPeople1, nameComp);
		}
		long elapsedTime2 = System.nanoTime() - startTime2;
		elapsedTime2 = elapsedTime2 / 20;
		System.out.printf("Average time elapsed for linearSort with name Comparator= %d \n", elapsedTime2);
		
		System.gc();
		long startTime3 = System.nanoTime();
		for (int i = 1; i < 20; i++){
			linearSort(testPeople1, payComp);
		}
		long elapsedTime3 = System.nanoTime() - startTime3;
		elapsedTime3 = elapsedTime3 / 20;
		System.out.printf("Average time elapsed for linearSort with pay grade Comparator= %d \n", elapsedTime3);
		
		System.gc();
		long startTime4 = System.nanoTime();
		for (int i = 1; i < 20; i++){
			linearSort(testPeople1, empComp);
		}
		long elapsedTime4 = System.nanoTime() - startTime4;
		elapsedTime4 = elapsedTime4 / 20;
		System.out.printf("Average time elapsed for linearSort with Employee Id Comparator= %d \n", elapsedTime4);
		
		System.gc();
		long startTime5 = System.nanoTime();
		for (int i = 1; i < 20; i++){
			squaresort(testSquareSort1, nameComp);
		}
		long elapsedTime5 = System.nanoTime() - startTime5;
		elapsedTime5 = elapsedTime5 / 20;
		System.out.printf("Average time elapsed for squaresort with name Comparator= %d \n", elapsedTime5);
		
		System.gc();
		long startTime6 = System.nanoTime();
		for (int i = 1; i < 20; i++){
			squaresort(testSquareSort1, payComp);
		}
		long elapsedTime6 = System.nanoTime() - startTime6;
		elapsedTime6 = elapsedTime6 / 20;
		System.out.printf("Average time elapsed for squaresort with pay grade Comparator= %d \n", elapsedTime6);
		
		System.gc();
		long startTime7 = System.nanoTime();
		for (int i = 1; i < 20; i++){
			squaresort(testSquareSort1, empComp);
		}
		long elapsedTime7 = System.nanoTime() - startTime7;
		elapsedTime7 = elapsedTime7 / 20;
		System.out.printf("Average time elapsed for squaresort with Employee Id Comparator= %d \n", elapsedTime7);		
		
	}
	
	/**
     * Sort an array of integers
     * 
     * @param integer array to be sorted
     */
	
	public static void linearSort(int[] nums){
		int outer, inner, min;
		for (outer = 0; outer < nums.length - 1; outer++){
			min = outer;
			for (inner = outer + 1; inner < nums.length; inner++){
				if (nums[inner] < nums[min]){
					min = inner;
				}
				// Invariant: for all i, if outer <= i <= inner, then nums[min] <= nums[i]
			}
			//nums[min] is least among nums[outer]...nums[nums.length-1]
			int temp = nums[outer];
			nums[outer] = nums[min];
			nums[min]=temp;
			//Invariant: For all i <= outer, if i < j, then nums[i] <= nums[j]
		}
	}
	
	/**
     * Sort a 1D array of objects based on given comparator
     * 
     * @param Object array to be sorted
     * @param Type of comparator to sort based on
     */
	
	public static void linearSort(Person[] people, Comparator<Person> comp){
		int outer, inner;
		int smallest;
		for (outer = 0; outer < people.length -1; outer++){
			smallest = outer;
			for (inner = outer + 1; inner < people.length; inner++){
				if ((comp.compare(people[inner], people[smallest]) < 0)){
					smallest = inner;
				}
				//Invariant: for all i, if outer <= i <= inner, then people[inner] <= people[i]
			}
			//people[inner] is least among people[outer]...people[people.length]
			Person temp;
			temp = people[outer];
			people[outer]= people[smallest];
			people[smallest] = temp;
			//Invariant:For all i <= outer, if i < j, then people[i] <= people[j]
		}
		
	}
	
	/**
     * Sort a 2D array of objects based on given comparator
     * 
     * @param Object array to be sorted
     * @param Type of comparator to sort based on
     */
	
	public static void squaresort(Person[][] people, Comparator<Person> comp){
		int outer, inner, remRow, remCol, innerRemRow;
		int[] smallest = new int[2];
		for (outer = 0; outer < people.length; outer++){
			for (inner = 0; inner < people[outer].length; inner++){
				smallest[0] = outer;
				smallest[1]= inner;
				for (remCol = inner + 1; remCol < people[outer].length; remCol++){
					if (comp.compare(people[outer][remCol], people[smallest[0]][smallest[1]]) < 0){
						smallest[0] = outer;
						smallest[1] = remCol;
					}
					assert remCol >= people[outer].length;
					//Invariant: For all i, if remCol <= i <= people[outer].length, then smallest <= people[outer][i]
				}
				for (remRow = outer + 1; remRow < people.length; remRow++){
					for (innerRemRow = 0; innerRemRow < people[remRow].length; innerRemRow++){
						if (comp.compare(people[remRow][innerRemRow], people[smallest[0]][smallest[1]]) < 0){
							smallest[0] = remRow; 
							smallest[1] = innerRemRow;
						}
						assert innerRemRow >= people[remRow].length;
						//Invariant: For all i, if innerRemRow <= i <= people[remRow].length, smallest <= people[remRow][i]
					}
				}
				Person temp;
				temp = people[outer][inner];
				people[outer][inner] = people[smallest[0]][smallest[1]];
				people[smallest[0]][smallest[1]] = temp;
			}
			assert inner >= people[outer].length;
			//Invariant: For all i, if inner <= i <= people[outer].length, smallest <= people[outer][i]
		}
		assert outer>= people.length;
	}

}
