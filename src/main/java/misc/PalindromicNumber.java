package misc;

import java.util.ArrayList;
import java.util.List;

/**
 * User: absharma
 * Date: 4/25/12
 */
public class PalindromicNumber {
/*
	First 10 palindromic numbers 0-9
	The two digit palindromic numbers are 11, 22, . 99 (9 of them)
	For each 2 digit palindromic number insert 09 in the middle to generate 9 * 10 = 90 3 digit palindromic numbers
	For each 3 digit palindromic number insert 09 in the middle + 1 to generate the 4 digit palindromic  numbers

And so on  last two steps are repetitive 


*/
    public List<String> generate(int n) {
        List<String> numbers = new ArrayList<String>();
        // Single digit
        for (int i = 0; i <= 9; i++) {
            numbers.add("" + i);
        }

        // Double digit
        List<String> digits = new ArrayList<String>();
        for (int i = 1; i <= 9; i++) {
            digits.add("" + i + i);
        }
        int count = 19;
        numbers.addAll(digits);
        int numDigits = 2;

        while (count < n) {
            digits = nPlusOneDigits(digits, numDigits++, count);
            numbers.addAll(digits);
        }
        return numbers;
    }

    private List<String> nPlusOneDigits(List<String> numbers, int numDigits, int count) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i <= 9; i++) {
            numbers.add("" + i + i);
        }
        return result;
    }

    //todo isPalindromic string & number based

}
