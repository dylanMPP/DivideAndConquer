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

  test("Randomized 3Way Partition:") {
    assert(DivideAndConquer.randomized3WayPartition(List(10, 3, 6, 9), 2, 7, List(), List(), List())._1 == List())
    assert(DivideAndConquer.randomized3WayPartition(List(1, 3, 22), 2, 10, List(), List(), List())._3 == List(22))
    assert(DivideAndConquer.randomized3WayPartition(List(9, 7, 6, 0), 1, 8, List(), List(), List())._2 == List(6, 7))
  }

  test("Mergesort:"){
    assert(DivideAndConquer.mergeSort(normalList)._1 == List(2, 3, 6, 7, 9, 10))
    assert(DivideAndConquer.mergeSort(repeatedList)._1 == List(2, 3, 6, 7, 9, 10, 10))
    assert(DivideAndConquer.mergeSort(allRepeatedList)._1 == List(1, 1, 1, 1, 1, 1))
    assert(DivideAndConquer.mergeSort(sortedList)._1 == sortedList)
    assert(DivideAndConquer.mergeSort(voidList)._1 == voidList)
  }

  test("Merge:"){
    assert(DivideAndConquer.merge(List(10,7,3), List(6,2,9), 0)._1 == List(6,2,9,10,7,3))
    assert(DivideAndConquer.merge(List(10,7,3), List(10,6,2,9), 0)._1 == List(10,7,3,10,6,2,9))
    assert(DivideAndConquer.merge(List(1,1,1), List(1,1,1),0)._1 == List(1, 1, 1, 1, 1, 1))
  }

  val oneSetPoint: List[List[Int]] = List(List(0,0))
  val threeSetPoints: List[List[Int]] = List(List(0,0), List(0,1), List(1,1))
  val normalSetPoints: List[List[Int]] = List(List(0, 0), List(4, 9), List(-1, -3), List(-2, 1))
  val repeatedSetPoints: List[List[Int]] = List(List(4, 9), List(4, 9), List(4, 9), List(4, 9), List(4, 9))
  val oneRepeatedSetPoints: List[List[Int]] = List(List(0, 0), List(4, 9), List(-1, -3), List(-2, 1), List(-2, 1))
  val voidPoints: List[List[Int]] = List(List(), List(), List(), List())
  val oneVoidPoint: List[List[Int]] = List(List(), List(0,0), List(4,9), List(-1, -3))

  test("QuickSort Points:") {
    assert(DivideAndConquer.quickSortPoints(oneSetPoint,0 /*, 1, normalList.length, List()*/) == oneSetPoint)
    assert(DivideAndConquer.quickSortPoints(repeatedSetPoints, 1 /*, 1, repeatedList.length, List()*/) == repeatedSetPoints)
    assert(DivideAndConquer.quickSortPoints(normalSetPoints, 0 /*, 1, allRepeatedList.length, List()*/) == List(List(-2, 1), List(-1, -3), List(0, 0), List(4, 9)))
    assert(DivideAndConquer.quickSortPoints(oneRepeatedSetPoints, 1 /*, 1, sortedList.length, List()*/) == List(List(-2, 1), List(-2, 1), List(-1, -3), List(0, 0), List(4, 9)))
  }

  // I cast the result of the square root to String to only take 4 decimal places,
  // because the result is too long
  val df = new DecimalFormat("#.0000")
  val df2 = new DecimalFormat("#0.0")

  test("Closest Points:") {
    assert(DivideAndConquer.closestPoints(oneSetPoint) == -1.0)
    assert(df.format((DivideAndConquer.closestPoints(threeSetPoints))) == "1,0000")
    assert(df.format((DivideAndConquer.closestPoints(normalSetPoints))) == "2,2361") // sqrt of 5
    assert(DivideAndConquer.closestPoints(repeatedSetPoints) == -1.0) // error
    assert(df.format(DivideAndConquer.closestPoints(oneRepeatedSetPoints)) == "2,2361") // sqrt of 5
    assert(DivideAndConquer.closestPoints(voidPoints) == -1.0) // error
    assert(df.format(DivideAndConquer.closestPoints(oneVoidPoint)) == "3,1623") // sqrt of 10
  }

  val setPoints1: List[List[Int]] = List(List(0, 0), List(-1, -3), List(-2, 1))
  val setVoidPoints: List[List[Int]] = List()
  val setPoints2: List[List[Int]] = List(List(0,0), List(0,1))

  // assert with reverse because the function adds each head to the result list. Doesn't affect the result
  // of closest points
  test("No Void Points:") {
    assert(DivideAndConquer.noVoidPoints(oneSetPoint, List()) == oneSetPoint)
    assert(DivideAndConquer.noVoidPoints(normalSetPoints, List()) == normalSetPoints.reverse)
    assert(DivideAndConquer.noVoidPoints(repeatedSetPoints, List()) == repeatedSetPoints.reverse)
    assert(DivideAndConquer.noVoidPoints(oneVoidPoint, List()) == List(List(-1, -3),List(4,9),List(0,0)))
    assert(DivideAndConquer.noVoidPoints(voidPoints, List()) == List())
  }

  test("Middle line:") {
    assert(DivideAndConquer.middleLine(repeatedSetPoints) == List(4.0,9.0))
    assert(DivideAndConquer.middleLine(normalSetPoints) == List(1.5,3.0))
    assert(DivideAndConquer.middleLine(oneRepeatedSetPoints) == List(-1.0,-3.0))
  }

  test("Find Min Distance:"){
    assert(df.format((DivideAndConquer.findMinDistance(setPoints1, Int.MaxValue))) == "2,2361")
    assert(DivideAndConquer.findMinDistance(setVoidPoints, Int.MaxValue) == Int.MaxValue)
    assert(df.format((DivideAndConquer.findMinDistance(setPoints2, Int.MaxValue))) == "1,0000")
  }

  val firstPair: List[Int] = List(0,0)
  val secondPair: List[Int] = List(4,9)
  val thirdPair: List[Int] = List(-1,3)
  val voidPair: List[Int] = List()
  val samePair: List[Int] = List(9,1)

  test("Euclidean Distance:") {
    assert(df.format(DivideAndConquer.euclideanDistance(firstPair, secondPair)) == "9,8489")
    assert(df.format(DivideAndConquer.euclideanDistance(firstPair, thirdPair)) == "3,1623")
    assert(df.format(DivideAndConquer.euclideanDistance(secondPair, thirdPair)) == "7,8103")
    assert(DivideAndConquer.euclideanDistance(voidPair, secondPair) == -1.0)
    assert(DivideAndConquer.euclideanDistance(thirdPair, voidPair) == -1.0)
    assert(df2.format(DivideAndConquer.euclideanDistance(samePair, samePair)) == "0,0")
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
