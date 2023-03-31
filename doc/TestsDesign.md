# **Test Design**

## - **Number Of Inversions**:

### Function
We are going to use the `numberOfInversions(list: List[Int])` function in this tests.

### Objective

The objective of this test design is to validate the functionality of the `numberOfInversions(...)` function on different types of lists.

### Test Plan

Five lists with different characteristics will be used to evaluate the `numberOfInversions(...)` function:

1. `normalList`: List with non-repeated values and no specific order.
2. `repeatedList`: List with repeated values and no specific order.
3. `allRepeatedList`: List with repeated values and all equal.
4. `sortedList`: List with values ordered in ascending order.
5. `voidList`: Empty list.

For each list, an assertion will be made to validate that the `numberOfInversions(...)` function returns the correct number of inversions.

### Test Cases

| Test Case | Input List | Expected Result |
|---|---|---|
| 1 | normalList | 4 |
| 2 | repeatedList | 5 |
| 3 | allRepeatedList | 0 |
| 4 | sortedList | 0 |
| 5 | voidList | 0 |

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

## - **Quick Sort**

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
| 1         | 2 | 1 |
| 2         | 0 | 0 |
| 3         | -1 | 0 |

### Expected Results
We expect all assertions to pass successfully, indicating that the `pred(...)` function is returning the expected value for each number.

----

## - **Successor**:

### Function
We are going to use the `suc(n: Int)` function in this tests.

### Objective
The objective of this test design is to validate the functionality of the `suc(...)` function using different integer numbers.

### Test Plan
Three numbers will be used to evaluate `suc(...)` functions:
- `number1:` A positive number.
- `number2:` Zero.
- `number3:` A negative number.

Now, for each number, an assertion will be made to validate that the `suc(...)` function returns the correct result.

### Test Cases
| Test Case | Input Number | Expected Result |
|-----------|--------------|-----------------|
| 1         | number1 | 3 |
| 2         | number2 | 1 |
| 3         | number3 | 0 |

### Expected Results
We expect all assertions to pass successfully, indicating that the `suc(...)` function is returning the expected value for each number.

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

## - **Sum**:

### Function
We are going to use the `sum(number: Int, number2: Int)` function in this tests.

### Objective
The objective of this test design is to validate the functionality of the `sum(...)` function using different integer numbers.

### Test Plan
Four numbers will be used to evaluate `sum(...)` functions, using that three numbers to sum them:
- `number1:` A positive number.
- `number2:` Zero.
- `number3:` A negative number.

It's important to know that the `sum(...)` function uses the `predecessor(...)` function, that only works for positive integers, excluding 0, and for the other numbers (negative integers and zero) the result is 0. So, for each number, an assertion will be made to validate that the `sum(...)` function returns the correct result.

### Test Cases
| Test Case | Input Numbers | Expected Result |
|-----------|--------------|-----------------|
| 1         | number1,number2 | 4 |
| 2         | number2,number3 | -1 |
| 3         | number1,number3 | 1 |

### Expected Results
We expect all assertions to pass successfully, indicating that the `sum(...)` function is returning the expected value for each number.

---

## - **Difference**:

### Function
We are going to use the `difference(number: Int, number2: Int)` function in this tests.

### Objective
The objective of this test design is to validate the functionality of the `difference(...)` function using different integer numbers.

### Test Plan
Three numbers will be used to evaluate `difference(...)` function, using that three numbers to dif them:
- `number1:` A positive number.
- `number2:` Zero.
- `number3:` A negative number.

It's important to know that the `difference(...)` function uses the `predecessor(...)` function, that only works for positive integers, excluding 0, and for the other numbers (negative integers and zero) the result is 0. So, for each number, an assertion will be made to validate that the `difference(...)` function returns the correct result.

### Test Cases
| Test Case | Input Numbers | Expected Result |
|-----------|--------------|-----------------|
| 1         | number1,number2 | 2 |
| 2         | number1,number3 | 1 |
| 3         | number3,number2 | -1 |

### Expected Results
We expect all assertions to pass successfully, indicating that the `difference(...)` function is returning the expected value for each number.

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