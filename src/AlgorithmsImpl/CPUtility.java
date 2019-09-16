package AlgorithmsImpl;

import java.util.ArrayList;

/**
 * @author kishore
 */
public class CPUtility {
	/**
	 * Swaps two elements in an array. O(1);
	 *
	 * @param index1 index of an element.
	 * @param index2 index of another element.
	 * @param array  array in which the elements are to be swapped.
	 */
	public static void swap(int index1, int index2, int[] array) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	/**
	 * finds gcd of two integers
	 *
	 * @param a first number
	 * @param b second number
	 * @return GCD of the two integers
	 */
	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	/**
	 * gives lcm of two numbers
	 *
	 * @param a an integer
	 * @param b an integer
	 * @return lcm of a and b
	 */
	public static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}

	/**
	 * returns sum of two binary numbers in byte array
	 *
	 * @param numberInBinaryRep1 first array of length n
	 * @param numberInBinaryRep2 second array of length n
	 * @return resultant sum as byte array with n+1 size
	 */
	public static byte[] add(byte[] numberInBinaryRep1, byte[] numberInBinaryRep2) {
		int size = numberInBinaryRep1.length;
		byte[] result = new byte[size + 1];
		byte carry = 0;
		for (int i = size - 1; i >= 0; i--) {
			byte current = (byte) (numberInBinaryRep1[i] + numberInBinaryRep2[i] + carry);
			carry = 0;
			switch (current) {
				case 2:
					current = 0;
					carry = 1;
					break;
				case 3:
					current = 1;
					carry = 1;
					break;
			}
			result[i + 1] = current;
		}
		if (carry == 1) {
			result[0] = 1;
		}
		return result;
	}

	/**
	 * returns maxSubArraySum in given array
	 *
	 * @param array The array containing values
	 * @param left  leftMost index of array
	 * @param right rightMost index of array
	 * @return sum of longest continues subArray
	 */
	public static long maxSubArraySum(int array[], int left, int right) {
		if (left == right) {
			return array[left];
		}
		int middle = (left + right) / 2;
		return Math.max(Math.max(maxSubArraySum(array, left, middle), maxSubArraySum(array, middle + 1, right)),
				maxCrossingSubArraySum(array, left, middle, right));
	}

	private static long maxCrossingSubArraySum(int[] array, int left, int middle, int right) {
		long sum = 0;
		long leftSum = Long.MIN_VALUE;
		for (int i = middle; i >= left; i--) {
			sum += array[i];
			if (sum > leftSum) {
				leftSum = sum;
			}
		}
		sum = 0;
		long rightSum = Long.MIN_VALUE;
		for (int i = middle; i <= right; i++) {
			sum += array[i];
			if (sum > rightSum) {
				rightSum = sum;
			}
		}
		return leftSum + rightSum;
	}

	public static ArrayList<String> permutations(String s) {
		ArrayList<String> result = new ArrayList<>();
		permutations("", s, result);
		return result;
	}

	private static void permutations(String prefix, String suffix, ArrayList<String> result) {
		if (suffix.length() == 0) {
			result.add(prefix);
		} else {
			for (int i = 0; i < suffix.length(); i++) {
				permutations(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1), result);
			}
		}
	}

	public static ArrayList<String> combinations(String s) {
		ArrayList<String> result = new ArrayList<>();
		combinations("", s, result);
		return result;
	}

	private static void combinations(String prefix, String suffix, ArrayList<String> result) {
		result.add(prefix);
		for (int i=0; i<suffix.length(); i++) {
			combinations(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i+1), result);
		}
	}

	public static void main(String[] args) {
		System.out.println(combinations("abc"));
	}
}
