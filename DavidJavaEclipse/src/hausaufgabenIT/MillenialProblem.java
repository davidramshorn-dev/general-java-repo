package hausaufgabenIT;

import java.util.Arrays;

public class MillenialProblem {
	static Integer last=null;

	public static void main(String[] args) {
		System.out.println("Start");
		dif(9991);
	}
	
	public static void dif(Integer n) {

	    if (nichtLangGenug(n, 4)) {
	        System.out.println(n + " nicht lang genug.");
	        return;
	    }

	    n = sortBig(n) - sortSmall(n);

	    if (last != null && last.equals(n)) {
	        System.out.println("Endhaltestelle: " + n);
	        return;
	    }

	    last = n;
	    dif(n);
	}

	private static boolean nichtLangGenug(Integer n, int i) {
		if(n.toString().toCharArray().length==i) {
			return false;
		}
		return true;
	}

	private static int sortSmall(int n) {
	    int[] numbers = getNumbers(n);
	    Arrays.sort(numbers);

	    int result = 0;
	    for (int x : numbers) {
	        result = result * 10 + x;
	    }
	    return result;
	}


	private static int[] getNumbers(int n) {
	    String s = String.valueOf(n);
	    int[] res = new int[s.length()];
	    
	    for (int i = 0; i < s.length(); i++) {
	        res[i] = s.charAt(i) - '0';
	    }
	    return res;
	}

	private static int sortBig(Integer n) {
		  int[] numbers = getNumbers(n);
		    Arrays.sort(numbers);
		    numbers=reversed(numbers);

		    int result = 0;
		    for (int x : numbers) {
		        result = result * 10 + x;
		    }
		    return result;
	}

	private static int[] reversed(int[] numbers) {
		int[] res=new int[numbers.length];
		for(int i=0; i<numbers.length; i++){
			res[numbers.length-1-i]=numbers[i];
		}
		return res;
	}

}
