import java.util.Arrays;
import java.util.Random;

class Sorting{
    // method to perform bubble sort
    int[] numbers = new Random().ints(1, 2147483647).limit(10000).toArray();
    int[] bubbleSort(int array[]) {
        int size = array.length;
        // run loops two times
        // first loop access each element of the array
        for (int i = 0; i < size - 1; i++){
            // second loop performs the comparison in each iteration
            for (int j = 0; j < size - i - 1; j++){
                // sort the array in ascending order
                // compares the adjacent element
                if (array[j] > array[j + 1]) {
                    // swap if left element is greater than right
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    int[] selectionSort(int array[]) {
        int size = array.length;
        for (int step = 0; step < size - 1; step++) {
            int min_idx = step;
            for (int i = step + 1; i < size; i++) {
                // To sort in descending order, change > to < in this line.
                // Select the minimum element in each loop.
                if (array[i] < array[min_idx]) {
                min_idx = i;
                }
            }
            // put min at the correct position
            int temp = array[step];
            array[step] = array[min_idx];
            array[min_idx] = temp;
        }
        return array;
    }

    int[] insertionSort(int array[]) {
        int size = array.length;
        for (int step = 1; step < size; step++) {
            int key = array[step];
            int j = step - 1;
            // Compare key with each element on the left of it until an element smaller than
            // it is found.
            // For descending order, change key<array[j] to key>array[j].
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }
            // Place key at after the element just smaller than it.
            array[j + 1] = key;
        }
        return array;
    }

    public int[] shellSort(int array[]) {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > key) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = key;
            }
        }
        return array;
    }
    
    // Merge two sub arrays L and M into array
    static void merge(int array[], int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int M[] = new int[n2];

        // fill the left and right array
        for (int i = 0; i < n1; i++)
            L[i] = array[p + i];
        for (int j = 0; j < n2; j++)
            M[j] = array[q + 1 + j];

        // Maintain current index of sub-arrays and main array
        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        // Until we reach either end of either L or M, pick larger among
        // elements L and M and place them in the correct position at A[p..r]
        // for sorting in descending
        // use if(L[i] >= <[j])
        while (i < n1 && j < n2) {
        if (L[i] <= M[j]) {
            array[k] = L[i];
            i++;
        } else {
            array[k] = M[j];
            j++;
        }
            k++;
        }

        // When we run out of elements in either L or M,
        // pick up the remaining elements and put in A[p..r]
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = M[j];
            j++;
            k++;
        }
    }

    static void inplaceMerge(int arr[], int start, int mid, int end)
    {
        int start2 = mid + 1;
  
        // If the direct merge is already sorted
        if (arr[mid] <= arr[start2]) {
            return;
        }
  
        // Two pointers to maintain start
        // of both arrays to merge
        while (start <= mid && start2 <= end) {
  
            // If element 1 is in right place
            if (arr[start] <= arr[start2]) {
                start++;
            }
            else {
                int value = arr[start2];
                int index = start2;
  
                // Shift all the elements between element 1
                // element 2, right by 1.
                while (index != start) {
                    arr[index] = arr[index - 1];
                    index--;
                }
                arr[start] = value;
  
                // Update all the pointers
                start++;
                mid++;
                start2++;
            }
        }
    }

    // Divide the array into two sub arrays, sort them and merge them
    int[] mergeSort(int array[], int left, int right) {
        if (left < right) {
            // m is the point where the array is divided into two sub arrays
            int mid = (left + right) / 2;

            // recursive call to each sub arrays
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted sub arrays
            merge(array, left, mid, right);
        }
        return array;
    }

    // Divide the array into two sub arrays, sort them and merge them
    int[] inplaceMergeSort(int array[], int left, int right) {
        if (left < right) {
  
            // Same as (l + r) / 2, but avoids overflow
            // for large l and r
            int mid = left + (right - left) / 2;
  
            // Sort first and second halves
            inplaceMergeSort(array, left, mid);
            inplaceMergeSort(array, mid + 1, right);
  
            inplaceMerge(array, left, mid, right);
        }
        return array;
    }

    public static void main(String[] args){

        Sorting sorting = new Sorting();
        Long startAt, endedAt, timeDifference;

        int[] numbers = sorting.numbers;

        startAt = System.currentTimeMillis();
        
        int[] bubbleSortedNumbers = sorting.bubbleSort(numbers.clone());
        
        endedAt = System.currentTimeMillis();
        timeDifference = endedAt - startAt;
        
        // System.out.println("Numbers to be sorted:");
        // System.out.println(Arrays.toString(numbers.clone()));
        // System.out.println("Bubble Sorted Array in Ascending Order:");
        // System.out.println(Arrays.toString(bubbleSortedNumbers));
        System.out.println("Time Difference for Bubble Sort: "+timeDifference+" milliseconds");
 
        startAt = System.currentTimeMillis();
        
        int[] selectionSortedNumbers = sorting.selectionSort(numbers.clone());
        
        endedAt = System.currentTimeMillis();
        timeDifference = endedAt - startAt;
        
        // System.out.println("Numbers to be sorted:");
        // System.out.println(Arrays.toString(numbers.clone()));
        // System.out.println("Selection Sorted Array in Ascending Order:");
        // System.out.println(Arrays.toString(selectionSortedNumbers));
        System.out.println("Time Difference for Selection Sort: "+timeDifference+" milliseconds");
 
        startAt = System.currentTimeMillis();
        
        int[] insertionSortedNumbers = sorting.insertionSort(numbers.clone());
        
        endedAt = System.currentTimeMillis();
        timeDifference = endedAt - startAt;
        
        // System.out.println("Numbers to be sorted:");
        // System.out.println(Arrays.toString(numbers.clone()));
        // System.out.println("Insertion Sorted Array in Ascending Order:");
        // System.out.println(Arrays.toString(insertionSortedNumbers));
        System.out.println("Time Difference for Insertion Sort: "+timeDifference+" milliseconds");
 
        startAt = System.currentTimeMillis();
        
        int[] shellSortedNumbers = sorting.shellSort(numbers.clone());
        
        endedAt = System.currentTimeMillis();
        timeDifference = endedAt - startAt;
        
        // System.out.println("Numbers to be sorted:");
        // System.out.println(Arrays.toString(numbers.clone()));
        // System.out.println("Shell Sorted Array in Ascending Order:");
        // System.out.println(Arrays.toString(shellSortedNumbers));
        System.out.println("Time Difference for Shell Sort: "+timeDifference+" milliseconds");

        startAt = System.currentTimeMillis();
        
        int[] mergeSortedNumbers = sorting.mergeSort(numbers.clone(), 0, numbers.clone().length - 1);
        
        endedAt = System.currentTimeMillis();
        timeDifference = endedAt - startAt;
        
        // System.out.println("Numbers to be sorted:");
        // System.out.println(Arrays.toString(numbers.clone()));
        // System.out.println("Merge Sorted Array in Ascending Order:");
        // System.out.println(Arrays.toString(mergeSortedNumbers));
        System.out.println("Time Difference for Merge Sort: "+timeDifference+" milliseconds");

        startAt = System.currentTimeMillis();
        
        int[] inplaceMergeSortedNumbers = sorting.inplaceMergeSort(numbers.clone(), 0, numbers.clone().length - 1);
        
        endedAt = System.currentTimeMillis();
        timeDifference = endedAt - startAt;
        
        // System.out.println("Numbers to be sorted:");
        // System.out.println(Arrays.toString(numbers.clone()));
        // System.out.println("Inplace Merge Sorted Array in Ascending Order:");
        // System.out.println(Arrays.toString(inplaceMergeSortedNumbers));
        System.out.println("Time Difference for Inplace Merge Sort: "+timeDifference+" milliseconds");       
    }
}