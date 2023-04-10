# **Structural Induction**

## **Number of Inversions (Problem #1) - MergeSort**

### **Inductive Hypothesis:**

The 'mergeSort' algorithm works correctly for lists of length n or smaller.

### **Base Case:**

The algorithm works correctly for lists of $1$ element or empty lists, as it returns the list without modifying it because it is considered already sorted.

### **Inductive Case:**

We aim to prove that the algorithm also works correctly for lists of length $n+1$. To do this, we must consider two things. The first is that the algorithm correctly sorts the list of length $n+1$, and the second is that the algorithm correctly counts the number of inversions in the original list.

To prove the first, we know that the algorithm works correctly for lists of length $n$ according to the inductive hypothesis. Therefore, the two halves of length $n/2$ and $(n+1)/2$ are sorted, and concatenating these two halves guarantees that the merged list will be sorted.

To prove the second, every time we concatenate two sorted halves, the algorithm counts the number of inversions in the original list. We must ensure that no inversion is counted more than once, meaning that each pair of out-of-order elements in the original list should be compared exactly once. This is ensured because when the two halves are concatenated, the algorithm maintains two indices, one for each half, and compares the first element of each half. If the element in the second half is smaller than that in the first half, then there is an inversion, since the element in the second half appears before the element in the first half in the original list. In this case, the element in the second half is added to the concatenated list, and the inversion counter is incremented. If the element in the first half is smaller than or equal to that in the second half, then there is no inversion, and the element in the first half is added to the concatenated list. Therefore, we can say that each pair of out-of-order elements in the original list is compared exactly once, and is counted as an inversion if the element in the second half appears before the element in the first half in the original list.

Since we have shown that the algorithm works correctly for lists of length $n$, and we know that it works for lists of length $1$ according to the base case, we can conclude that the algorithm also works for lists of length $n+1$.


## **Improved Quicksort (Problem #2) - ImprovingQuickSort**

### **Inductive hypothesis:**

The 'improvingQuickSort' algorithm correctly sorts any list of $n$ elements.

### **Base Case:**

If the input list is an empty list or has only one element, the list is already sorted. Therefore, the algorithm is correct for any list of length $n = 0$ or $n = 1$.

### **Inductive Case:**

We want to prove that the 'improvingQuickSort' algorithm also correctly sorts any list of $n+1$ elements. To demonstrate this, we consider a list of $n+1$ elements. The algorithm chooses two random pivots and performs a triple partition using these pivots. In any of the three possible cases (where the first pivot is greater than the second, where the first pivot is less than the second, or where the two pivots are equal), the elements are divided into three sub-lists: a list of elements smaller than the first pivot, a list of elements between the two pivots, and a list of elements larger than the second pivot. By inductive hypothesis, we know that 'improvingQuickSort' is able to correctly sort lists of length $n$. Therefore, when recursively applying the algorithm to each of these three sub-lists, we can say that they are correctly sorted because they are lists with smaller size than $n$. Consequently, the algorithm concatenates the three sorted sub-lists to obtain the final sorted list of $n+1$ elements, and we can say that the 'improvingQuickSort' algorithm correctly sorts any list of $n+1$ elements.


## **Closest Points (Problem #3) - FindMinDistance**

### **Inductive Hypothesis:**

The findMinDistance algorithm finds the minimum distance between two points in a list of n elements.

### **Base Case:**

If the list is empty, then the minimum distance is equal to Int.MaxValue because there is no possible minimum distance that can be smaller than this value. Therefore, the min parameter will be equal to Int.MaxValue at the end of the algorithm.

### **Inductive Case:**

We want to prove that the 'findMinDistance' algorithm correctly finds the minimum distance between two points in a list of $n+1$ elements.

Since it's a list of $n+1$ elements, we can assume that `p` is the last point added to the list, and we can assume that `d` is the minimum distance between two points in the list of size $n$ before adding `p`. With this, we can say that the minimum distance between two points in the list of size n+1 can still be `d`, or it's the distance between `p` and some other point in the list. If it's the second case, the algorithm finds the distance between p and the closest point in the list of size n using the parallelForsMinDistance algorithm, and if this distance is less than `d`, then it corresponds to the new minimum distance, if not, then the minimum distance remains d. In both cases, the findMinDistance algorithm correctly finds the minimum distance, and the inductive hypothesis is true for the list of size $n+1$.

Therefore, we can conclude that the 'findMinDistance' algorithm correctly finds the minimum distance between two points in a list of any size, as long as the list is well-formed and does not contain null points. This is guaranteed in the 'closestPoints' function, where empty points are removed before calling findMinDistance.