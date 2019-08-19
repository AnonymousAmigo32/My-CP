package AlgorithmsImpl;

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

	public static byte[] add(byte[] numberInBinaryRep1, byte[] numberInBinaryRep2) {
		int size = numberInBinaryRep1.length;
		byte[] result = new byte[size + 1];
		byte carry = 0;
		for (int i=size-1; i>=0; i--) {
			byte current = (byte)(numberInBinaryRep1[i] + numberInBinaryRep2[i] + carry);
			carry = 0;
			switch (current) {
				case  2 :
					current = 0;
					carry = 1;
					break;
				case 3 :
					current = 1;
					carry = 1;
					break;
			}
			result[i+1] = current;
		}
		if (carry == 1) {
			result[0] = 1;
		}
		return result;
	}

	public static void main(String[] args) {
		byte[] arr1 = new byte[]{1, 1, 0};
		byte[] arr2 = new byte[]{1, 1, 0};
		byte[] result = add(arr1, arr2);
		for (byte b : result) System.out.print(b);
	}
}
