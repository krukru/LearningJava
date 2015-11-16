package kru.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersHelper {

	public List<Range> getMissingNumbers(float[] firstArray, float[] secondArray) {
		if (firstArray == null || secondArray == null) {
			throw new NullPointerException();
		}
		List<Range> result = new ArrayList<Range>();
		if (firstArray.length + secondArray.length == 0) {
			Range range = new Range(Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);
			result.add(range);
			return result;
		}
		Arrays.sort(firstArray);
		Arrays.sort(secondArray);
		int p1 = 0;
		int p2 = 0;
		Float smallerNumber;
		Float previousNumber = null;
		for (int i = 0; i < firstArray.length + secondArray.length; i++) {
			if (p1 >= firstArray.length) {
				smallerNumber = secondArray[p2++];
			} else if (p2 >= secondArray.length) {
				smallerNumber = firstArray[p1++];
			} else {
				if (firstArray[p1] <= secondArray[p2]) {
					smallerNumber = firstArray[p1++];
				} else {
					smallerNumber = secondArray[p2++];
				}
			}
			if (previousNumber == null) {
				previousNumber = smallerNumber;
				Range firstRange = new Range(Float.NEGATIVE_INFINITY, smallerNumber);
				result.add(firstRange);
			} else {
				if (previousNumber.equals(smallerNumber) == false) {
					Range range = new Range(previousNumber, smallerNumber);
					result.add(range);
				}
			}
		}
		Range lastRange = new Range(previousNumber, Float.POSITIVE_INFINITY);
		result.add(lastRange);
    return result;
	}

}
