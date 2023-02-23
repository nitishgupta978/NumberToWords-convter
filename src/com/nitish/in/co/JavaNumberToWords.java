package com.nitish.in.co;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class JavaNumberToWords {
	public static Map<Integer,String> mapOnes=new HashMap<>();
	public static String[] mapTwos=new String[11];
	public static Map<Integer,String> mapMore=new HashMap<>();
	
	static {
		mapOnes.put(0, "Zero");
		mapOnes.put(1, "One");
		mapOnes.put(2, "Two");
		mapOnes.put(3, "Three");
		mapOnes.put(4, "Four");
		mapOnes.put(5, "Five");
		mapOnes.put(6, "Six");
		mapOnes.put(7, "Seven");
		mapOnes.put(8, "Eight");
		mapOnes.put(9, "Nine");
		mapOnes.put(10, "Ten");
		
		mapOnes.put(11, "Eleven");
		mapOnes.put(12, "Twelve");
		mapOnes.put(13, "Thirteen");
		mapOnes.put(14, "Fourteen");
		mapOnes.put(15, "Fiveteen");
		mapOnes.put(16, "Sixteen");
		mapOnes.put(17, "Seventeen");
		mapOnes.put(18, "Eighteen");
		mapOnes.put(19, "Nineteen");
		mapOnes.put(20, "Twenty");
		
		mapTwos[0]="Zero";
		mapTwos[1]="Ten";
		mapTwos[2]="Twenty";
		mapTwos[3]="Thirty";
		mapTwos[4]="Fourty";
		mapTwos[5]="Fifty";
		mapTwos[6]="Sixty";
		mapTwos[7]="Seventy";
		mapTwos[8]="Eighty";
		mapTwos[9]="Ninty";
		mapTwos[10]="hundered";
	}
	
	static String getWordsFromDigits(Integer digit){
		StringJoiner finalWord=new StringJoiner(" ");
		if(digit>100 && digit <1000) {
			finalWord.add(mapTwos[(int)(digit/100)]);
			finalWord.add(mapOnes.get(digit%100));
		}
		else if(digit>20 && digit<100) {
			finalWord.add(mapTwos[(int)(digit/10)]);
			finalWord.add(mapOnes.get(digit%10));
		}else {
			return mapOnes.get(digit);
		}
		return finalWord.toString();
	}
	
	public static String numberToWords(long number) {
	    if (number == 0) {
	        return "zero";
	    }
	    if (number < 0) {
	        return "minus " + numberToWords(Math.abs(number));
	    }
	    String words = "";
	    if ((number / 10000000) > 0) {
	        words += numberToWords(number / 10000000) + " Crore ";
	        number %= 10000000;
	    }
	    if ((number / 100000) > 0) {
	        words += numberToWords(number / 100000) + " Lakh ";
	        number %= 100000;
	    }
	    if ((number / 1000) > 0) {
	        words += numberToWords(number / 1000) + " Thousand ";
	        number %= 1000;
	    }
	    if ((number / 100) > 0) {
	        words += numberToWords(number / 100) + " Hundred ";
	        number %= 100;
	    }
	    if (number > 0) {
	        if (!words.equals("")) {
	            words += "and ";
	        }
	        if (number <= 20) {
	            words += mapOnes.get(Integer.valueOf(number+""));
	        } else {
	            if(number>20 && number<100) {
	            	words+=(mapTwos[Integer.valueOf((number/10)+"")]);
	            	if(number%10!=0)
	            	words+=" "+(mapOnes.get(Integer.valueOf(number%10+"")));
	    		}else {
		            words += (mapOnes.get(Integer.valueOf(number+"")));
	    		}
	            if ((number % 10) > 0 && number<10) {
	                words += mapOnes.get(Integer.valueOf((number % 10)+""));
	            }
	        }
	    }
	    return words;
	}

	public static void main(String[] args) {
		for(int i=0;i<=1000000;i++) {
		System.out.println(numberToWords(i));
		}
		
	}
}
