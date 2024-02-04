package week04Project;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Week04Project {

	public static void main(String[] args) {

		int[] ages = { 3, 9, 23, 64, 2, 8, 28, 93 }; // 1. Create an array of int called ages...

		subtractFirstLast(ages); // 1.a. programmatically subtract...

		Scanner s = new Scanner(System.in);

		// int arrLength = s.nextInt();

		int[] ages2 = new int[9]; // 1.b. create new array...and 1.b.i...Used a Scanner from above and input below
									// to allow for varied number input.

		for (int i = 0; i < 9; i++) {
			System.out.println("Please enter int Value for array element: " + i);
			int intInputInteger = s.nextInt();
			ages2[i] = intInputInteger;
		}

		subtractFirstLast(ages2); // 1.b.ii. repeat subtraction...for 1.b.iii. see below in "subtractFirstLast"
									// Method.

		averageAge(ages);// 1.c. this line and the next calculate the average of both arrays, though it
							// uses integer division (so it would truncate an decimal places.
		averageAge(ages2);

		String[] names = { "Sam", "Tommy", "Tim", "Sally", "Buck", "Bob" }; // 2. Create an array called names...

		averageLetters(names); // 2.a use a loop to iterate through the array and ... used a method below to do
								// this.

		concatAllStrings(names); // 2.b use a loop to ... concatenate...used a method below to do this.

		/*
		 * 3. How do you access the last element of any array? Answer 1 - Use the index
		 * with the last number for the last element (if the array length is
		 * known).access Answer 2 - use array.length -1 if the array length is not
		 * known. Answer Other - there are other methods, but haven't used those yet...I
		 * am sure there are some that allow for last element in the array though.
		 */

		// 4. How do you access the first element of any array? Answer: Array[0]. Again,
		// I'm sure there are other ways, but this is a solid way of doing so.

		int[] nameLengths = new int[names.length]; // 5. create a new array of int called...

		for (int ii = 0; ii < names.length; ii++) { // 5. (Second part of question)...write a loop...
			nameLengths[ii] = names[ii].length();

		}
		System.out.println(Arrays.toString(nameLengths));

		int sumNameLength = 0;
		for (int nl : nameLengths) { // 6. Write a loop to iterate...
			sumNameLength += nl;
		}
		System.out.println("NameLengths Sum: " + sumNameLength); // 6. (Second part of questions)...print the results to
																	// the console.

		// 7. Write a method (will be down below) that takes a string, ...returns the
		// word concatenated x times.

		System.out.println("Enter a Word.");
		Scanner w = new Scanner(System.in);
		String word = w.nextLine();

		System.out.println("Enter a Number.");
		int n = s.nextInt();

		concatenateWordXTimes(word, n); // Method Call.

		System.out.println("Please enter a first Name."); // 8. Write a method takes two Strings...returns fullname.
		String firstName = w.nextLine();
		System.out.println("Please enter a last Name.");
		String lastName = w.nextLine();

		String fullName = fullName(firstName, lastName);
		System.out.println(fullName);

		// 9. Write a method that takes array of int...returns true/false if > 100.
		// Method down below.
		int[] arrayGreater = { 25, 25, 25, 26 }; // change this value to see results. If equal to 100 it will say false
													// based on method below.

		System.out.println(isGreater100(arrayGreater));

		double[] twice = { 20.3, 80.4, 15.6, 77.5 };// 10. Write a method (below) that takes an array of ... returns
													// average.

		System.out.println(averageTwice(twice)); // Method call and print for 10 above.

		// 11. write a method that takes two...returns true if average in first is >
		// average in second.

		double[] thrice = { 15.7, 18.5, 19.20, 0.2 };// change the 0.2 in the last element to 1000.2 to show false,
														// otherwise, it is true as is.

		System.out.println("Array 1 is > than Array 2:" + isDoubleGreater(twice, thrice));

		// 12. Write a method called willBuyDrink...returns true if hot and money in
		// pocket > 10.50.
		boolean isHotOutside = true;// change here to test variable.
		double moneyInPocket = 9.50;// change here to test variable.

		System.out.println("I will buy a drink? " + willBuyDrink(isHotOutside, moneyInPocket));

		// 13. Method of my own design.  Figure out if i have enough time to submit.
		LocalDateTime dueDateAndTime = LocalDateTime.parse("2024-02-03T23:59:00.000");//Due date and Time.
		LocalDateTime currentDateAndTime = LocalDateTime.now();//Current time.
		
		System.out.println("I need additional time to finish the video?" + doINeedTime(dueDateAndTime, currentDateAndTime));

	}

	private static void subtractFirstLast(int[] ages) {

		int firstValue = ages[0];
		int lastValue = ages[ages.length - 1]; // This line allows for the array to be of any length. 8, 9 or otherwise,
												// though the code above limits to 9.
		System.out.println(lastValue - firstValue);
	}

	private static double averageAge(int[] ages) {// used a double to account for integers that are averaged not
													// equaling a whole (integer) number.
		int sum = 0;

		for (int age : ages) {
			sum += age;
		}
		double averageAge = sum / ages.length;
		System.out.println(averageAge);
		return averageAge;
	}

	private static void averageLetters(String[] names) {
		double sum = 0; // if Int here, then you get 4. If you set this to double you get 3.83. Depends
						// on how accurate you wish to be and whether you wish to round up or not.
		for (String name : names) {
			sum += name.length();
		}
		double averageLetters = sum / names.length;
		System.out.println(averageLetters);
	}

	private static void concatAllStrings(String[] names) {
		String newString = "";

		for (String name : names) {
			newString += name + " ";
		}
		if (newString.endsWith(" ")) {
			newString = newString.trim();
		}
		System.out.println(newString);
	}

	private static void concatenateWordXTimes(String word, int n) {
		String concatWord = "";
		for (int i = 0; i < n; i++) {
			concatWord += word;
		}
		System.out.println(concatWord);

	}

	private static String fullName(String firstName, String lastName) {
		String fullName = firstName + " " + lastName;
		return fullName;
	}

	private static boolean isGreater100(int[] arr) {
		int sum = 0;
		for (int arrn : arr) {
			sum += arrn;
		}
		if (sum > 100) {
			return true;
		}

		return false;
	}

	private static double averageTwice(double[] twice) {
		double sum = 0;
		int twiceLength = twice.length;
		for (double two : twice) {
			sum += two;
		}
		double averageTwice = sum / twiceLength;
		return averageTwice;
	}

	private static boolean isDoubleGreater(double[] twice, double[] thrice) {
		double avg1 = averageTwice(twice);
		double avg2 = averageTwice(thrice);
		if (avg1 > avg2) {
			return true;
		}
		return false;
	}

	private static boolean willBuyDrink(boolean isHotOutside, double moneyInPocket) {
		if (isHotOutside = true && moneyInPocket > 10.50) {
			return true;
		}
		return false;
	}

	private static boolean doINeedTime(LocalDateTime dueDateAndTime, LocalDateTime currentDateAndTime) {
		int diff = currentDateAndTime.compareTo(dueDateAndTime);
		
		System.out.println("Compare Value = " + diff);
		
		if (diff > 0) {
			return true;
		} else if (diff < 0) {
			return false;
		} else {
			System.out.println("Submit NOW!");
		}
		return true;
	}
}
