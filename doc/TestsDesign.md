# **Test Design**

## - **Number Of Inversions**:

### Function
We are going to use the `numberOfInversions(list: List[Int])` function in this tests.

### Objective

The objective of this test design is to validate the functionality of the `numberOfInversions(...)` function on different types of lists.

### Test Plan

Five lists with different characteristics will be used to evaluate the `numberOfInversions(...)` function:

1. `shortList`: List with few elements and no specific order.
2. `normalList`: List with non-repeated values and no specific order.
3. `repeatedList`: List with repeated values and no specific order.
4. `allRepeatedList`: List with repeated values and all equal.
5. `sortedList`: List with values ordered in ascending order.
6. `voidList`: Empty list.
7. `invertedSortedList`: List with values ordered in descending order.

For each list, an assertion will be made to validate that the `numberOfInversions(...)` function returns the correct number of inversions.

### Test Cases

| Test Case | Input List                 | Expected Result |
|-----------|----------------------------|----------------|
| 1         | shortList                  | 2              |  
| 2         | normalList                 | 4              |
| 3         | repeatedList               | 5              |
| 4         | allRepeatedList            | 0              |
| 5         | sortedList                 | 0              |
| 6         | voidList                   | 0              |
| 7         | invertedSortedList | 15             |

### Expected Results

We expect all assertions to pass successfully, indicating that the `numberOfInversions(...)` function is producing the correct number of inversions for each input list.

----

## - **Improving Quicksort**:

### Function
We are going to use the `improvingQuickSort(list: List[Int])` function in this tests.

### Objective

The objective of this test design is to validate the functionality of the `improvingQuickSort(...)` function on different types of lists.

### Test Plan

Six lists with different characteristics will be used to evaluate the `improvingQuickSort(...)` function:

1. `normalList`: List with non-repeated values and no specific order.
2. `repeatedList`: List with repeated values and no specific order.
3. `allRepeatedList`: List with repeated values and all equal.
4. `sortedList`: List with values ordered in ascending order.
5. `voidList`: Empty list.
6. `number3wayRepeatedList`: List with repeated values that occur three times at the start, at the center and at the end.

For each list, an assertion will be made to validate that the `improvingQuickSort(...)` function returns the list sorted in ascending order.

### Test Cases

| Test Case | Input List | Expected Result |
|---|---|---|
| 1 | normalList | List(2,3,6,7,9,10) |
| 2 | repeatedList | List(2,3,6,7,9,10,10) |
| 3 | allRepeatedList | List(1,1,1,1,1,1) |
| 4 | number3wayRepeatedList | List(1,3,7,8,10,10,10) |
| 5 | sortedList | List(1,2,3,10,22) |
| 6 | voidList | List() |

### Expected Results

We expect all assertions to pass successfully, indicating that the `improvingQuickSort(...)` function is returning the input lists sorted in ascending order.

----

## - **Merge Sort:**

### Function
We are going to use the `mergeSort(list: List[Int])` function in this tests.

### Objective

The objective of this test design is to validate the functionality of the `mergeSort(...)` function on different types of lists.

### Test Plan

Six lists with different characteristics will be used to evaluate the `mergeSort(...)` function:

1. `normalList`: List with non-repeated values and no specific order.
2. `repeatedList`: List with repeated values and no specific order.
3. `allRepeatedList`: List with repeated values and all equal.
4. `sortedList`: List with values ordered in ascending order.
5. `voidList`: Empty list.

For each list, an assertion will be made to validate that the `mergeSort(...)` function returns the list sorted in ascending order.

### Test Cases

| Test Case | Input List | Expected Result |
|---|---|---|
| 1 | normalList | List(2,3,6,7,9,10) |
| 2 | repeatedList | List(2,3,6,7,9,10,10) |
| 3 | allRepeatedList | List(1,1,1,1,1,1) |
| 4 | sortedList | List(1,2,3,10,22) |
| 5 | voidList | List() |

### Expected Results

We expect all assertions to pass successfully, indicating that the `mergeSort(...)` function is returning the input lists sorted in ascending order.

----

## - **Randomized Quick Sort**

### Function
We are going to use the `quickSort(list: List[Int], firstPos: Int, lastPos: Int)` function in this tests.

### Objective
The objective of this test design is to validate the functionality of the `quickSort()` function on different types of lists.

### Test Plan
Six lists with different characteristics will be used to evaluate the `quickSort()` function:

1. `normalList`: List with non-repeated values and no specific order.
2. `repeatedList`: List with repeated values and no specific order.
3. `allRepeatedList`: List with repeated values and all equal.
4. `sortedList`: List with values ordered in ascending order.
5. `voidList`: Empty list.
6. `number3wayRepeatedList`: List with repeated values that occur three times at the start, at the center and at the end.

For each list, an assertion will be made to validate that the `quickSort()` function returns the list sorted in ascending order.

### Test Cases

| Test Case | Input List | Expected Result |
|---|---|---|
| 1 | normalList | List(2,3,6,7,9,10) |
| 2 | repeatedList | List(2,3,6,7,9,10,10) |
| 3 | allRepeatedList | List(1,1,1,1,1,1) |
| 4 | number3wayRepeatedList | List(1,3,7,8,10,10,10) |
| 5 | sortedList | List(1,2,3,10,22) |
| 6 | voidList | List() |

### Expected Results

We expect all assertions to pass successfully, indicating that the `quickSort()` function is returning the input lists sorted in ascending order.

----

## - **Closest Points**

### Function
We are going to use the `closestPoints(list: List[List[Int]])` function in this tests.

### Objective
The objective of this test design is to validate the functionality of the `closestPoints(...)` function using different types of sets of points.

### Test Plan
Five sets of points with different characteristics will be used to evaluate the `closestPoints(...)` function:
- `normalSetPoints:` List with non-repeated points and no specific order.
- `repeatedSetPoints:` List with repeated points.
- `oneRepeatedSetPoints:` List with only one repeated point.
- `voidPoints:` List of empty points.
- `oneVoidPoint:` List with only one empty point.

For each set of points, an assertion will be made to validate that the `closestPoints(...)` function returns the correct result.

### Test Cases
| Test Case | Input Points | Expected Result |
|-----------|--------------|-----------------|
| 1         | normalSetPoints | 2.2360 |
| 2         | repeatedSetPoints | -1.0 |
| 3         | oneRepeatedSetPoints | 2.2360 |
| 4         | voidPoints | -1.0 |
| 5         | oneVoidPoint | 3.1622 |

### Expected Results
We expect all assertions to pass successfully, indicating that the `closestPoints(...)` function is returning the expected result for each set of points.

----

## - **Find Min Distance**

### Function
We are going to use the `findMinDistance(list: List[List[Int]], min: Double)` function in this tests.

### Objective
The objective of this test design is to validate the functionality of the `findMinDistance(...)` function using different types of sets of points.

### Test Plan
Five sets of points with different characteristics will be used to evaluate the `findMinDistance(...)` function:
- `setPoints1:` List with n (n > 2) pair of points.
- `setVoidPoins:` List with no elements.
- `setPoints2:` List with only two pair of points.

For each set of points, an assertion will be made to validate that the `findMinDistance(...)` function returns the correct result.

### Test Cases
| Test Case | Input Points | Expected Result |
|-----------|------------|-----------------|
| 1         | setPoints1 | 2.2360          |
| 2         | setVoidPoints | Int.MaxValue    |
| 3         | setPoints2 | 1.0000          |


### Expected Results
We expect all assertions to pass successfully, indicating that the `findMinDistance(...)` function is returning the expected result for each set of points.

----

## - **Euclidean Distance**

### Function
We are going to use the `euclideanDistance(firstPair: List[Int], secondPair: List[Int])` function in this tests.

### Objective
The objective of this test design is to validate the functionality of the `euclideanDistance(...)` function using different pairs of points.

### Test Plan
Six pairs of points with different characteristics will be used to evaluate the `euclideanDistance(...)` function:
- `firstPair:` A list of two non-negative integers.
- `secondPair:` A list of two non-negative integers.
- `thirdPair:` A list of two integers, where one or both may be negative.
- `voidPair:` An empty list.
- `samePair:` A list of two identical non-negative integers.

For each pair of points, an assertion will be made to validate that the `euclideanDistance(...)` function returns the correct result.

### Test Cases
| Test Case | Input Points | Expected Result |
|-----------|--------------|-----------------|
| 1         | firstPair, secondPair | 9.8489 |
| 2         | firstPair, thirdPair | 3.1623 |
| 3         | secondPair, thirdPair | 7.8103 |
| 4         | voidPair, secondPair | -1.0 |
| 5         | thirdPair, voidPair | -1.0 |
| 6         | samePair, samePair | 0.0 |

### Expected Results
We expect all assertions to pass successfully, indicating that the `euclideanDistance(...)` function is returning the expected distance value for each pair of points.

----

## - **Predecessor**

### Function
We are going to use the `pred(n: Int)` function in this tests.

### Objective
The objective of this test design is to validate the functionality of the `pred(...)` function using different integer numbers.

### Test Plan
Three numbers will be used to evaluate `pred(...)` function:
- `number1:` A positive number.
- `number2:` Zero.
- `number3:` A negative number.

It's important to know that the `pred(...)` function, only works for positive integers, excluding 0, and for the other numbers (negative integers and zero) the result is 0. So, for each number, an assertion will be made to validate that the Predecessor function returns the correct result.

### Test Cases
| Test Case | Input Number | Expected Result |
|-----------|--------------|-----------------|
| 1         | number1 | 1 |
| 2         | number2 | 0 |
| 3         | number3 | 0 |

### Expected Results
We expect all assertions to pass successfully, indicating that the `pred(...)` function is returning the expected value for each number.

----

## - **Square Root**:

### Function
We are going to use the `squareRoot(number: Double)` function in this tests.

### Objective
The objective of this test design is to validate the functionality of the `squareRoot(...)` function using different integer numbers.

### Test Plan
Three numbers will be used to evaluate `squareRoot(...)` functions:
- `number1ToSquareRoot:` A positive number with exact square root.
- `number2ToSquareRoot:` A positive number with no exact square root.
- `number3ToSquareRoot:` Zero.

Now, for each number, an assertion will be made to validate that the `squareRoot(...)` function returns the correct result.

### Test Cases
| Test Case | Input Number | Expected Result |
|-----------|--------------|-----------------|
| 1         | numer1ToSquareRoot | 2.0000 |
| 2         | number2ToSquareRoot | 1.4142 |
| 3         | number3ToSquareRoot | 0.0 |

### Expected Results
We expect all assertions to pass successfully, indicating that the `squareRoot(...)` function is returning the expected value for each number.

----

## - **Abs**:

### Function
We are going to use the `abs(x: Int)` function in this tests.

### Objective
The objective of this test design is to validate the functionality of the `abs(...)` function using different integer numbers.

### Test Plan
Three numbers will be used to evaluate `abs(...)` functions:
- `number1:` A positive number.
- `number2:` Zero.
- `number3:` A negative number.

Now, for each number, an assertion will be made to validate that the `abs(...)` function returns the correct result.

### Test Cases
| Test Case | Input Number | Expected Result |
|-----------|--------------|-----------------|
| 1         | number1 | 2 |
| 2         | number2 | 0 |
| 3         | number3 | 4 |

### Expected Results
We expect all assertions to pass successfully, indicating that the `abs(...)` function is returning the expected value for each number.

----

## - **Pow**:

### Function
We are going to use the `pow(base: Int, exp: Int)` function in this tests.

### Objective
The objective of this test design is to validate the functionality of the `pow(...)` function using different integer numbers.

### Test Plan
Three numbers will be used to evaluate `pow(...)` function as the base and other three numbers will be used as the exp:
- `number1:` A positive number.
- `number2:` Zero.
- `number3:` A negative number.
- `exp1:` A positive number.
- `exp2:` Zero.
- `exp3:` A positive number.

Now, for each number, an assertion will be made to validate that the `pow(...)` function returns the correct result.

### Test Cases
| Test Case | Input Numbers (base, exp) | Expected Result |
|-----------|--------------|-----------------|
| 1         | number1,exp1 | 4 |
| 2         | number3,exp1 | 1 |
| 3         | number1,exp2 | 1 |
| 4         | number2,exp3 | 0 |

### Expected Results
We expect all assertions to pass successfully, indicating that the `pow(...)` function is returning the expected value for each number.