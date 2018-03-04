package e_01_LinearDS;

import java.lang.reflect.Array;
import java.util.ArrayDeque;

public class MatchingBrackes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String input = "1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5";				
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		
		for (int i = 0; i < input.length(); i++) {
			char current = input.charAt(i);
			if (current == '(') {
				stack.push(i);
			} else if (current == ')') {
				int previous = stack.pop();								
				System.out.println(input.substring(previous, i + 1));
			}
		}
	}

}
