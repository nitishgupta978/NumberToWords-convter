package com.spicenumber;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestCount {
	static String s=""; 
	public String digitToWord(Integer digit) {
		Saved saved = new Saved();
		// Block 1. Base Case
		if (digit == 1 || digit == 2 || digit == 3 || digit == 4 || digit == 5 || digit == 6 || digit == 7 || digit == 8
				|| digit == 9 || digit == 10 || digit == 11 || digit == 12 || digit == 13 || digit == 14 || digit == 15
				|| digit == 16 || digit == 17 || digit == 18 || digit == 19 || digit == 20 || digit == 30 || digit == 40
				|| digit == 50 || digit == 60 || digit == 70 || digit == 80 || digit == 90 || digit == 100
				|| digit == 1000 || digit == 100000) {
			s+=saved.getSaved(digit)+" ";
		} // Block 2
		else if (digit > 20 && digit < 100) {
			// Suppose digit is 25
			digitToWord((digit / 10) * 10); // Print word 'Twenty' (Tens' value). It will come from Base Case
			digitToWord(digit % 10); // Print word 'Five'. It will come from Base Case
		} // Block 3
		else if (digit >= 100 && digit < 1000) {
			// Suppose digit is 525
			digitToWord(digit / 100); // Print word 'Five' here (Hundreds' value)
			digitToWord(100); // Print word 'Hundred'
			digitToWord(digit % 100); // Print 'Twenty Five'. It will recursively go back to block 2
		} // Block 4
		else if (digit >= 1000 && digit < 100000) {
			// Suppose digit is 18,525
			digitToWord(digit / 1000); // Print word 'Eighteen' here (Thosand's value)
			digitToWord(1000); // Print word 'Thousand'
			digitToWord(digit % 1000); // Print 'Five Hundred Twenty Five'. It will recursively go back to block 3
		} // Block 4
		else if (digit >= 1000 && digit < 100000) {
			// Suppose digit is 18,525
			digitToWord(digit / 1000); // Print word 'Eighteen' here (Thosand's value)
			digitToWord(1000); // Print word 'Thousand'
			digitToWord(digit % 1000); // Print 'Five Hundred Twenty Five'. It will recursively go back to block 3
		} // Block 5
		else if (digit >= 100000 && digit < 10000000) {
			// Suppose digit is 98,18,525
			digitToWord(digit / 100000); // Print word 'Ninety Eight' here (Lakh's value)
			digitToWord(100000); // Print word 'Lakh'
			digitToWord(digit % 100000); // Print 'Eighteen Thousand Five Hundred Twenty Five'. It will recursively go
											// back to block 4
		}
		return s;
	}

	public static class Saved {

		private Map<Integer, String> saved = new HashMap<Integer, String>();

		public Saved() {
			saved.put(1, "One");
			saved.put(2, "Two");
			saved.put(3, "Three");
			saved.put(4, "Four");
			saved.put(5, "Five");
			saved.put(6, "Six");
			saved.put(7, "Seven");
			saved.put(8, "Eight");
			saved.put(9, "Nine");

			saved.put(11, "Eleven");
			saved.put(12, "Twelve");
			saved.put(13, "Thirteen");
			saved.put(14, "Fourteen");
			saved.put(15, "Fifteen");
			saved.put(16, "Sixteen");
			saved.put(17, "Seventeen");
			saved.put(18, "Eighteen");
			saved.put(19, "Nineteen");

			saved.put(10, "Ten");
			saved.put(20, "Twenty");
			saved.put(30, "Thirty");
			saved.put(40, "Fourty");
			saved.put(50, "Fifty");
			saved.put(60, "Sixty");
			saved.put(70, "Seventy");
			saved.put(80, "Eighty");
			saved.put(90, "Ninety");

			saved.put(100, "Hundred");
			saved.put(1000, "Thousand");
			saved.put(100000, "Lakh");
			saved.put(1000000, "CR");

		}

		public String getSaved(Integer digit) {
			return saved.get(digit);
		}

	}
public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number: ");
		Integer digit = scanner.nextInt();
		TestCount app = new TestCount();
		String s = app.digitToWord(digit);
		System.out.println("input is: "+s);
	}
}
