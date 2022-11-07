# Algorithm Analysis

## Compare with other sorts we have learned, and give a conclusion

* Bubble sort seems to be the slowest
* Insertion sort is fast
* Shell sort comes next to insertion

<img width="1280" alt="Screen Shot 2022-11-07 at 23 05 09" src="https://user-images.githubusercontent.com/26523968/200425331-92950449-8151-469f-9570-0e19f546dd0f.png">


## Can you create a new method and can do merge without initiating a new list?
Yes, this variant of merge implementation is popularly known as inplace merge sort

```

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
    static int[] inplaceMergeSort(int array[], int left, int right) {
        if (left < right) {
  
            // Same as (l + r) / 2, but avoids overflow
            // for large l and r
            int mid = left + (right - left) / 2;
  
            // Sort first and second halves
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
  
            inplaceMerge(array, left, mid, right);
        }
        return array;
    }
```

## Compare the runtime performance between the new merge implementation and the original one, which is more efficient?
The new implementation seems to be more efficient
<img width="1280" alt="Screen Shot 2022-11-07 at 23 05 09" src="https://user-images.githubusercontent.com/26523968/200425331-92950449-8151-469f-9570-0e19f546dd0f.png">

## Give a conclusion about what kinds of operations has the most significant impact on runtime performance.
Iteration

## What kind of Operations in merge sort take the largest amount of time?

## Run sorts on array to prove implementation is working
Result of running implementation on an array of 10 integers
<img width="1280" alt="Screen Shot 2022-11-07 at 23 05 09" src="https://user-images.githubusercontent.com/26523968/200425331-92950449-8151-469f-9570-0e19f546dd0f.png">

## Using times of swap to estimate runtime performance of sorting algorithms
