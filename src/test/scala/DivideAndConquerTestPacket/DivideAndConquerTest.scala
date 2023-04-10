package DivideAndConquerTestPacket

import DivideAndConquerPacket.DivideAndConquer
import java.text.DecimalFormat

class DivideAndConquerTest extends munit.FunSuite {

  val shortList: List[Int] = List(3,1,2)
  val normalList: List[Int] = List(10,7,3,6,2,9)
  val repeatedList: List[Int] = List(10,7,3,10,6,2,9)
  val allRepeatedList: List[Int] = List(1,1,1,1,1,1)
  val sortedList: List[Int] = List(1,2,3,10,22)
  val voidList: List[Int] = List()
  val invertedSortedList: List[Int] = List(9,8,7,6,1,0)

  test("Number Of Inversions:") {
    assert(DivideAndConquer.numberOfInversions(shortList)==2)
    assert(DivideAndConquer.numberOfInversions(normalList)==10)
    assert(DivideAndConquer.numberOfInversions(repeatedList)==13)
    assert(DivideAndConquer.numberOfInversions(allRepeatedList)==0)
    assert(DivideAndConquer.numberOfInversions(sortedList)==0)
    assert(DivideAndConquer.numberOfInversions(voidList)==0)
    assert(DivideAndConquer.numberOfInversions(invertedSortedList)==15)
  }

  val number3wayRepeatedList: List[Int] = List(10, 7, 3, 10, 8, 1, 10)

  test("Improved QuickSort:") {
    assert(DivideAndConquer.improvingQuickSort(normalList) == List(2,3,6,7,9,10))
    assert(DivideAndConquer.improvingQuickSort(repeatedList) == List(2,3,6,7,9,10,10))
    assert(DivideAndConquer.improvingQuickSort(allRepeatedList)== List(1,1,1,1,1,1))
    assert(DivideAndConquer.improvingQuickSort(number3wayRepeatedList) == List(1,3,7,8,10,10,10))
    assert(DivideAndConquer.improvingQuickSort(sortedList) == sortedList)
    assert(DivideAndConquer.improvingQuickSort(voidList) == voidList)
  }

  test("Mergesort:"){
    assert(DivideAndConquer.mergeSort(normalList)._1 == List(2, 3, 6, 7, 9, 10))
    assert(DivideAndConquer.mergeSort(repeatedList)._1 == List(2, 3, 6, 7, 9, 10, 10))
    assert(DivideAndConquer.mergeSort(allRepeatedList)._1 == List(1, 1, 1, 1, 1, 1))
    assert(DivideAndConquer.mergeSort(sortedList)._1 == sortedList)
    assert(DivideAndConquer.mergeSort(voidList)._1 == voidList)
  }

  test("Randomized Quicksort:"){
    assert(DivideAndConquer.randomizedQuickSort(normalList/*, 1, normalList.length, List()*/) == List(2, 3, 6, 7, 9, 10))
    assert(DivideAndConquer.randomizedQuickSort(repeatedList/*, 1, repeatedList.length, List()*/) == List(2, 3, 6, 7, 9, 10, 10))
    assert(DivideAndConquer.randomizedQuickSort(allRepeatedList/*, 1, allRepeatedList.length, List()*/) == List(1, 1, 1, 1, 1, 1))
    assert(DivideAndConquer.randomizedQuickSort(number3wayRepeatedList/*, 1, number3wayRepeatedList.length, List()*/) == List(1, 3, 7, 8, 10, 10, 10))
    assert(DivideAndConquer.randomizedQuickSort(sortedList/*, 1, sortedList.length, List()*/) == sortedList)
    assert(DivideAndConquer.randomizedQuickSort(voidList/*, 1, voidList.length, List()*/) == voidList)
  }

  val normalSetPoints: List[List[Int]] = List(List(0, 0), List(4, 9), List(-1, -3), List(-2, 1))
  val repeatedSetPoints: List[List[Int]] = List(List(4, 9), List(4, 9), List(4, 9), List(4, 9), List(4, 9))
  val oneRepeatedSetPoints: List[List[Int]] = List(List(0, 0), List(4, 9), List(-1, -3), List(-2, 1), List(-2, 1))
  val voidPoints: List[List[Int]] = List(List(), List(), List(), List())
  val oneVoidPoint: List[List[Int]] = List(List(), List(0,0), List(4,9), List(-1, -3))

  // I cast the result of the square root to String to only take 4 decimal places,
  // because the result is too long
  val df = new DecimalFormat("#.0000")
  val df2 = new DecimalFormat("#0.0")

  test("Closest Points:") {
    assert(df.format((DivideAndConquer.closestPoints(normalSetPoints))) == "2,2361") // sqrt of 5
    assert(DivideAndConquer.closestPoints(repeatedSetPoints) == -1.0) // error
    assert(df.format(DivideAndConquer.closestPoints(oneRepeatedSetPoints)) == "2,2361") // sqrt of 5
    assert(DivideAndConquer.closestPoints(voidPoints) == -1.0) // error
    assert(df.format(DivideAndConquer.closestPoints(oneVoidPoint)) == "3,1623") // sqrt of 10
  }

  
  
  val firstPair: List[Int] = List(0,0)
  val secondPair: List[Int] = List(4,9)
  val thirdPair: List[Int] = List(-1,3)
  val voidPair: List[Int] = List()

  test("Euclidean Distance:") {
    assert(df.format(DivideAndConquer.euclideanDistance(firstPair, secondPair)) == "9,8489")
    assert(df.format(DivideAndConquer.euclideanDistance(firstPair, thirdPair)) == "3,1623")
    assert(df.format(DivideAndConquer.euclideanDistance(secondPair, thirdPair)) == "7,8103")
    assert(DivideAndConquer.euclideanDistance(voidPair, secondPair) == -1.0)
    assert(DivideAndConquer.euclideanDistance(thirdPair, voidPair) == -1.0)
    assert(df2.format(DivideAndConquer.euclideanDistance(secondPair, secondPair)) == "0,0")
  }

  val number1ToSquareRoot: Int = 4
  val number2ToSquareRoot: Int = 2
  val number3ToSquareRoot: Int = 0

  test("Square Root:") {
    assert(df.format(DivideAndConquer.squareRoot(number1ToSquareRoot)) == "2,0000")
    assert(df.format(DivideAndConquer.squareRoot(number2ToSquareRoot)) == "1,4142")
    assert(df2.format(DivideAndConquer.squareRoot(number3ToSquareRoot)) == "0,0")
  }

  val number1: Int = 2
  val number2: Int = 0
  val number3: Int = -1
  val exp1: Int = 2
  val exp2: Int = 0
  val exp3: Int = 1

  test("Pred:") {
    assert(DivideAndConquer.pred(number1) == 1)
    assert(DivideAndConquer.pred(number2) == 0)
    assert(DivideAndConquer.pred(number3) == 0)
  }

  val number4: Int = -4

  test("Abs:"){
    assert(DivideAndConquer.abs(number1) == 2)
    assert(DivideAndConquer.abs(number2) == 0)
    assert(DivideAndConquer.abs(number4) == 4)
  }

  test("Pow:") {
    assert(DivideAndConquer.pow(number1, exp1) == 4)
    assert(DivideAndConquer.pow(number3, exp1) == 1)
    assert(DivideAndConquer.pow(number1, exp2) == 1)
    assert(DivideAndConquer.pow(number2, exp3) == 0)
  }
}
