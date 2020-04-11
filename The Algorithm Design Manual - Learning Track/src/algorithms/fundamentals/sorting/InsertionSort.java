/* 
 * This file implements the insertion sort algorithm.
 * 
 * Complexity: Quadratic-time complexity.
 * Big-Oh Notation: O(N^2), where N is the input size.
 * Input: Presumably unsorted array.
 * Output: Sorted array.
 */

/**
 * Implementation of the insertion sort.
 * 
 * @param arrayToSort array to sort.
 */
public void insertionSort(int[] arrayToSort)
{
	final int ARRAY_SIZE = arrayToSort.length;

	// start i at 1 because any single element is already sorted relative to itself
	for (int i = 1; i < ARRAY_SIZE; i++)
	{
		int j = i;
		while ((j > 0) && (arrayToSort[j] < arrayToSort[j - 1]))
		{
			swap(arrayToSort, j, j - 1);
			j = j - 1;
		}
	}
}

/**
 * Helper method that swaps two elements in an array.
 * 
 * @param array  array whose elements are to be swapped
 * @param index1 index1 of the first element to swap
 * @param index2 index of the other element
 */
private void swap(int [] array, int index1, int index2)
{
	int temp = array[index1];
	array[index1] = array[index2];
	array[index2] = temp;
}
