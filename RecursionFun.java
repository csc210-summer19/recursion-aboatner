/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Arianna Boatner
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (k == 1) {
			return n;
		}
		if (k == n) {
			return 1;
		}

		return combinations(n - 1, k - 1) + combinations(n - 1, k);
	}

	// Complete recursive method intWithCommas that returns the argument as a
	// String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		String strInt = "";
		int val = n / 1000;

		if (val > 0) {
			if (n % 1000 < 100) {
				return strInt + intWithCommas(val) + ",0" + (n % 1000);
			}

			if (n % 1000 < 10) {
				return strInt + intWithCommas(val) + ",0" + (n % 1000);
			}

			return strInt + intWithCommas(val) + "," + (n % 1000);
		}

		return strInt + n;

	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		reverseArray(x, 0, x.length);
	}

	private void reverseArray(int[] x, int index, int len) {
		if (len - 1 > index) {
			int temp = x[index];
			x[index] = x[len - 1];
			x[len - 1] = temp;
			reverseArray(x, index + 1, len - 1);
		}

	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		return rangeHelper(a, 0, a.length, a[0], a[0]);
	}

	private int rangeHelper(int[] a, int index, int len, int min, int max) {
		if (index == len) {
			return max - min;
		}

		else {
			if (a[index] < min) {
				min = a[index];
			}

			if (a[index] > max) {
				max = a[index];
			}

			return rangeHelper(a, index + 1, len, min, max);
		}

	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		// Need to send down 0 to keep track of the index
		return sortedHelper(nums, 0, nums.length);
	}

	private boolean sortedHelper(int[] nums, int index, int len) {
		if (index < len - 1) {
			if (nums[index] > nums[index + 1]) {
				return false;
			}
			return sortedHelper(nums, index + 1, len);
		}

		return true;
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		return foundHelper(strs, 0, strs.length, search);
	}

	private boolean foundHelper(String[] strs, int index, int len,
			String search) {
		if (index == len) {
			return false;
		} else {
			if (strs[index].equals(search)) {
				return true;
			}
			return foundHelper(strs, index + 1, len, search);
		}

	}

}
