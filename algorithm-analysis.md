# Algorithm Analysis

## Compare with other sorts we have learned, and give a conclusion

* Bubble sort seems to be the slowest
* Insertion sort is fast
* Shell sort comes next to insertion

```
incified@Iniobongs-MBP Java Assignment % javac Sorting.java
incified@Iniobongs-MBP Java Assignment % java Sorting      
Time Difference for Bubble Sort: 163 milliseconds
Time Difference for Selection Sort: 72 milliseconds
Time Difference for Insertion Sort: 21 milliseconds
Time Difference for Shell Sort: 5 milliseconds
Time Difference for Merge Sort: 4 milliseconds
Time Difference for Inplace Merge Sort: 104 milliseconds
```

```
incified@Iniobongs-MBP Java Assignment % javac Sorting.java
incified@Iniobongs-MBP Java Assignment % java Sorting      
Time Difference for Bubble Sort: 194 milliseconds
Time Difference for Selection Sort: 71 milliseconds
Time Difference for Insertion Sort: 24 milliseconds
Time Difference for Shell Sort: 11 milliseconds
Time Difference for Merge Sort: 62 milliseconds
Time Difference for Inplace Merge Sort: 98 milliseconds
```

```
incified@Iniobongs-MBP Java Assignment % javac Sorting.java
incified@Iniobongs-MBP Java Assignment % java Sorting      
Time Difference for Bubble Sort: 174 milliseconds
Time Difference for Selection Sort: 65 milliseconds
Time Difference for Insertion Sort: 21 milliseconds
Time Difference for Shell Sort: 6 milliseconds
Time Difference for Merge Sort: 3 milliseconds
Time Difference for Inplace Merge Sort: 92 milliseconds
```

```
incified@Iniobongs-MBP Java Assignment % javac Sorting.java
incified@Iniobongs-MBP Java Assignment % java Sorting      
Time Difference for Bubble Sort: 170 milliseconds
Time Difference for Selection Sort: 66 milliseconds
Time Difference for Insertion Sort: 24 milliseconds
Time Difference for Shell Sort: 5 milliseconds
Time Difference for Merge Sort: 16 milliseconds
Time Difference for Inplace Merge Sort: 57 milliseconds
```

```
incified@Iniobongs-MBP Java Assignment % javac Sorting.java
incified@Iniobongs-MBP Java Assignment % java Sorting      
Time Difference for Bubble Sort: 172 milliseconds
Time Difference for Selection Sort: 67 milliseconds
Time Difference for Insertion Sort: 22 milliseconds
Time Difference for Shell Sort: 4 milliseconds
Time Difference for Merge Sort: 6 milliseconds
Time Difference for Inplace Merge Sort: 69 milliseconds
```

```
incified@Iniobongs-MBP Java Assignment % javac Sorting.java
incified@Iniobongs-MBP Java Assignment % java Sorting      
Time Difference for Bubble Sort: 167 milliseconds
Time Difference for Selection Sort: 64 milliseconds
Time Difference for Insertion Sort: 27 milliseconds
Time Difference for Shell Sort: 5 milliseconds
Time Difference for Merge Sort: 4 milliseconds
Time Difference for Inplace Merge Sort: 74 milliseconds
```

<img width="1280" alt="Screen Shot 2022-11-08 at 12 01 02" src="https://user-images.githubusercontent.com/26523968/200548927-bd4822d9-dd94-4928-a92a-6adbac414cdb.png">


## Can you create a new method and can do merge without initiating a new list?
Yes, this variant of merge implementation is popularly known as inplace merge sort

```

    void inplaceMerge(int arr[], int start, int mid, int end)
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
```

## Compare the runtime performance between the new merge implementation and the original one, which is more efficient?

```
incified@Iniobongs-MBP Java Assignment % javac Sorting.java
incified@Iniobongs-MBP Java Assignment % java Sorting     
Time Difference for Merge Sort: 4 milliseconds
Time Difference for Inplace Merge Sort: 104 milliseconds
```

```
incified@Iniobongs-MBP Java Assignment % javac Sorting.java
incified@Iniobongs-MBP Java Assignment % java Sorting     
Time Difference for Merge Sort: 62 milliseconds
Time Difference for Inplace Merge Sort: 98 milliseconds
```

```
incified@Iniobongs-MBP Java Assignment % javac Sorting.java
incified@Iniobongs-MBP Java Assignment % java Sorting      
Time Difference for Merge Sort: 3 milliseconds
Time Difference for Inplace Merge Sort: 92 milliseconds
```

```
incified@Iniobongs-MBP Java Assignment % javac Sorting.java
incified@Iniobongs-MBP Java Assignment % java Sorting      
Time Difference for Merge Sort: 16 milliseconds
Time Difference for Inplace Merge Sort: 57 milliseconds
```

```
incified@Iniobongs-MBP Java Assignment % javac Sorting.java
incified@Iniobongs-MBP Java Assignment % java Sorting   
Time Difference for Merge Sort: 6 milliseconds
Time Difference for Inplace Merge Sort: 69 milliseconds
```

```
incified@Iniobongs-MBP Java Assignment % javac Sorting.java
incified@Iniobongs-MBP Java Assignment % java Sorting     
Time Difference for Merge Sort: 4 milliseconds
Time Difference for Inplace Merge Sort: 74 milliseconds
```

<img width="1280" alt="Screen Shot 2022-11-08 at 12 01 02" src="https://user-images.githubusercontent.com/26523968/200548927-bd4822d9-dd94-4928-a92a-6adbac414cdb.png">

## Give a conclusion about what kinds of operations has the most significant impact on runtime performance.
`Partitioning has the most significant impact on runtime performance with regards to space and time`



## What kind of operations in merge sort take the largest amount of time?
`Paritioning takes the largest amount of time`

## Run sorts on array to prove implementation is working
Result of running implementation on an array of 10 integers
<img width="1280" alt="Screen Shot 2022-11-07 at 23 05 09" src="https://user-images.githubusercontent.com/26523968/200425331-92950449-8151-469f-9570-0e19f546dd0f.png">

## Using times of swap to estimate runtime performance of sorting algorithms
* Bubble sort: The total number of swaps is n * (n – 1) /2. This is O(n^2) worst case 
* Insertion sort: The number of swaps for insertion sort is n - 1 where n is the number of comparisons. This is 0 in the best case, and O(n^2) in the average and worst cases.
* Merge sort: Merge sort Since each step requires O(n)
* Selection sort: Just like in bubble sort, the total number of swaps is n * (n – 1) /2. This is O(n^2) worst case 
* Shell sort: The number of swaps for shell sort is similar to insertion sort n - 1 where n is the number of comparisons. This is 0 in the best case, and O(n^2) in the average and worst cases.
