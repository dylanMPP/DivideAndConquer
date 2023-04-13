# **Structural Induction**

## **Number of Inversions (Problem #1) - MergeSort**

### **BASE CASE:** 
To complete this step, we need to show that $mergeSort(list)$ where $list.length = k$ and $k \leq 1$, yields the ascending sorted list $list$ and the number of inversions needed to sort it. Indeed, the algorithm gives us the expected result, since when executed, enter evaluates the first $if$ and enters there, since $k\leq1$, thus returning the same list without modifications, because it is ordered ascending and has a number of investments $=0$

### **INDUCTIVE STEP:** 
We assume that the algorithm $mergeSort(list)$ where $list.length=n$ and $n>1$ works correctly, that is, it gives us the ascending sorted list and the number of reversals needed. By H.I (inductive hypothesis) we know that with $mergeSort(list2)$, where $list2.length=n+1$, the algorithm in the first execution enters $else$ last, where it splits the list in half $(\frac {n+1}{2})$ into two sublists: $(left, right)$. After this: on the one hand, it calls itself with $left$ as a parameter, obtaining as a result this ascending ordered list and the number of necessary inversions; otherwise, it calls itself with $right$ as a parameter, returning this ascending-ordered list and the number of inversions required. We can note that $left.length < n$ and that $right.length < n$, so, having already assumed that the algorithm works correctly for a list whose length is $n$, obviously it will work for these two sublists as well. successfully, returning the expected result. Now, looking at it further, the $mergeSort(...)$ function calls the $merge(List[Int], List[Int], Int)$ function, which merges both lists that are passed to it as a parameter and has the following conditions to order the elements of the lists, and that we will assume as correct and that returns the expected result. Recursive calls with $left$ and $right$ as parameters of $mergeSort$ will execute and keep calling $mergeSort$ recursively until, by the halving, they fall into the base case and return the same list and $0 $ as inversions, then the call to $merge$ will be executed sequentially to compare the elements of the lists and merge them, after all the recursive calls to $mergeSort(left)$ and to $mergeSort(right)$ have been executed, $merge(left, right, 0)$ will be called to join the lists depending on the order and return a specific number of investments, finally, we return the list resulting from $merge$ (already joined and ordered ascending) and the number of inversions that were necessary for $left$, for $right$ and for their union.

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