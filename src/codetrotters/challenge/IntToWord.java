package codetrotters.challenge;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author      Emanuel Correa Rivera <emanuel.correa@upr.edu>
 * @version     1.8
 * @since       2015-11-17
 */

public class IntToWord {

	/**
	 * String arrays that hold each word necessary for the conversion.
	 */
	static String[] ones = {"", "one","two","three","four","five","six","seven","eight","nine","ten",
			"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	static String[] tens = {"ten", "twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
	static String[] hundreds = {"one hundred", "two hundred", "three hundred", "four hundred", "five hundred",
			"six hundred", "seven hundred", "eight hundred", "nine hundred"};
	static String[] thousands = {"thousand", "one thousand", "two thousand", "three thousand", "four thousand",
			"five thousand", "six thousand", "seven thousand", "eight thousand", "nine thousand"};
	static String[] millions = {"million", "one million", "two million", "three million", "four million", "five million",
			"sixe million", "seven million", "eight million", "nine million"};

	public static void main(String[] args) {

		System.out.println("Write an integer you wish to convert to a word: ");
		Scanner kb = new Scanner(System.in);

		try {
			System.out.println("\nThe word is: " + int_to_word(kb.nextInt()).trim().replaceAll(" +", " "));
		} catch (InputMismatchException e) {
			System.out.print("Not a valid integer.");
		}
		kb.close();

	}

	/**
	 * Converts an integer to an English word.
	 * 
	 * It is assumed the function will never receive a number greater than 999,999,999.
	 * 
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param  i integer to be converted.
	 * @return English word equivalent of the integer.
	 */
	private static String int_to_word(int i) {

		String word = "";

		if(i < 0) {
			i *= -1;
			word += "negative ";
		}

		if(i < 20)
			word = ones[i];
		else if(i < 100)
			word += tens[(i / 10) - 1] + " " + int_to_word(i % 10);
		else if(i < 1000)
			word += hundreds[(i / 100) - 1] + " " + int_to_word(i % 100);
		else if(i < 10000)
			word += thousands[i / 1000] + " " + int_to_word(i % 1000);
		else if(i < 100000)
			word += int_to_word(i / 1000) + " " + thousands[0] + " " + int_to_word(i % 1000);
		else if(i < 1000000)
			word += int_to_word(i / 1000) + " " + thousands[0] + " " + int_to_word(i % 1000);
		else if(i < 10000000)
			word += millions[i / 1000000] + " " + int_to_word(i % 1000000);
		else if(i < 100000000)
			word += int_to_word(i / 1000000) + " " + millions[0] + " " + int_to_word(i % 1000000);
		else
			word += int_to_word(i / 1000000) + " " + millions[0] + " " + int_to_word(i % 1000000);

		return word;
	}

}