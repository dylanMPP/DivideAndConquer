package DivideAndConquerPacket

import scala.annotation.tailrec
import scala.util.Random
import java.lang.Math
import java.text.DecimalFormat

object DivideAndConquer extends App with IDivideAndConquer {

  // NUMBER OF INVERSIONS -> Returns the number of inversions that are necessary to get the sorted list
  def numberOfInversions(list: List[Int]): Int =
    mergeSort(list)._2

  // IMPROVING QUICKSORT -> Returns the sorted list using quicksort, using a 3-way partition instead of a 2-way
  def improvingQuickSort(list: List[Int]): List[Int] =
    list match
      case Nil => list
      case head :: Nil => list
      case head :: tail =>
        val pivotPos = random(1, list.length - 1)
        val anotherPivotPos = random(pivotPos + 1, list.length)

        val pivot = list(pivotPos - 1)
        val anotherPivot = list(anotherPivotPos - 1)

        val valueHead = list.head
        val valueHead2 = list.tail.head
        var exchangedList: List[Int] = List()

        if (pivotPos == 2) {
          exchangedList = list.updated(0, pivot).updated(pivotPos - 1, valueHead).updated(1, anotherPivot).updated(anotherPivotPos - 1, valueHead)
        } else {
          exchangedList = list.updated(0, pivot).updated(pivotPos - 1, valueHead).updated(1, anotherPivot).updated(anotherPivotPos - 1, valueHead2)
        }

        // There are 2 pivots, then I need to compare them to know their respective order
        if (pivot > anotherPivot) {
          val (left, center, right) = randomized3WayPartition(exchangedList.tail.tail, anotherPivot, pivot, List(), List(), List())
          improvingQuickSort(left) ::: (anotherPivot :: improvingQuickSort(center) ::: (pivot :: improvingQuickSort(right)))
        } else if (pivot < anotherPivot) {
          val (left, center, right) = randomized3WayPartition(exchangedList.tail.tail, pivot, anotherPivot, List(), List(), List())
          improvingQuickSort(left) ::: (pivot :: improvingQuickSort(center) ::: (anotherPivot :: improvingQuickSort(right)))
        } else {
          val (left, center, right) = randomized3WayPartition(exchangedList.tail.tail, pivot, anotherPivot, List(), List(), List())
          improvingQuickSort(left) ::: improvingQuickSort(center) ::: (pivot :: (anotherPivot :: improvingQuickSort(right)))
        }

  @tailrec
  def randomized3WayPartition(list: List[Int], pivot: Int, pivot2: Int, left: List[Int], center: List[Int], right: List[Int]): (List[Int], List[Int], List[Int]) =
    list match
      case Nil => (left, center, right)
      case head :: tail =>
        if (head < pivot2 && head > pivot) {
          randomized3WayPartition(tail, pivot, pivot2, left, head :: center, right)
        } else if (head < pivot) {
          randomized3WayPartition(tail, pivot, pivot2, head :: left, center, right)
        } else {
          randomized3WayPartition(tail, pivot, pivot2, left, center, head :: right)
        }

  // CLOSEST POINTS -> Returns the closest points of a list of points (the points are pair of int numbers)
  def closestPoints(list: List[List[Int]]): Double =
    val listWithNoVoidPoints = noVoidPoints(list, List())

    if(listWithNoVoidPoints == Nil){
      -1.0
    } else {
      val xPoints = quickSortPoints(listWithNoVoidPoints, 0)

      val (xd1, xd2) = xPoints splitAt (xPoints.length / 2)
      val xd1Min = findMinDistance(xd1, Int.MaxValue)
      val xd2Min = findMinDistance(xd2, Int.MaxValue)

      val xMinDistance = min(xd1Min, xd2Min)

      val notExceedXMinDistance = notExceedD(listWithNoVoidPoints, middleLine(xPoints), xMinDistance, List())

      val yPoints = quickSortPoints(notExceedXMinDistance, 1)
      val yMinDistance = findMinDistance(yPoints, Int.MaxValue)

      // Como INT MAX VALUE es el min que paso para comparar, si aun haciendo el
      // findMinDistance me da ese resultado, significa que no hubo uno menor y por tanto
      // todos los puntos son iguales
      if (xMinDistance == Int.MaxValue && yMinDistance == Int.MaxValue) {
        -1.0
      } else {
        min(xMinDistance, yMinDistance)
      }
    }

  @tailrec
  def noVoidPoints(list: List[List[Int]], resultList: List[List[Int]]): List[List[Int]] =
    list match
      case Nil => resultList
      case head::tail =>
        if(head == Nil) {
          noVoidPoints(tail, resultList)
        } else {
          noVoidPoints(tail, head::resultList)
        }

  def middleLine(list: List[List[Int]]): List[Double] =
    val center = math.floor(list.length / 2).toInt

    if (list.length % 2 == 0) {
      List( ((list(center-1).head + list(center).head) / 2.0).toDouble, ((list(center-1)(1) + list(center)(1)) / 2.0).toDouble)
    } else {
      List(list(center - 1).head / 1.0, list(center-1)(1) / 1.0)
    }

  @tailrec
  def notExceedD(list: List[List[Int]], middleLine: List[Double], d: Double, resultList: List[List[Int]]): List[List[Int]] =
    list match {
      case Nil => resultList
      case head :: tail =>
        if (head.head - middleLine.head > d) {
          notExceedD(tail, middleLine, d, resultList)
        } else {
          notExceedD(tail, middleLine, d, head :: resultList)
        }
    }

  def min(value: Double, value2: Double): Double =
    if (value < value2) {
      value
    } else {
      value2
    }

  // Sort the points by X or Y
  def quickSortPoints(list: List[List[Int]], whichPoints: Int): List[List[Int]] =
    list match
      case Nil => list
      case head :: Nil => list
      case head :: tail =>
        val pivotPos = random(1, list.length)
        val pivot = list(pivotPos - 1)

        val valueHead = list.head
        val exchangedList = list.updated(0, pivot).updated(pivotPos - 1, valueHead)

        val (left, right): (List[List[Int]], List[List[Int]]) = randomizedPartitionPoints(exchangedList.tail, pivot, List(), List(), whichPoints)
        quickSortPoints(left, whichPoints) ::: (pivot :: quickSortPoints(right, whichPoints))

  // Partition of the list of pair of points for X or Y
  @tailrec
  def randomizedPartitionPoints(list: List[List[Int]], pivot: List[Int], left: List[List[Int]], right: List[List[Int]], whichPoints: Int): (List[List[Int]], List[List[Int]]) =
    list match
      case Nil => (left, right)
      case head :: tail =>
        if(whichPoints == 0){
          if (head.head < pivot.head) randomizedPartitionPoints(tail, pivot, head :: left, right, whichPoints)
          else randomizedPartitionPoints(tail, pivot, left, head :: right, whichPoints)
        } else {
          if (head(1) < pivot(1)) randomizedPartitionPoints(tail, pivot, head :: left, right, whichPoints)
          else randomizedPartitionPoints(tail, pivot, left, head :: right, whichPoints)
        }


  // Min distance for pairs of points
  @tailrec
  def findMinDistance(list: List[List[Int]], min: Double): Double =
    list match
      case Nil => min
      case head :: tail =>
        val possibleMin = parallelForsMinDistance(head, tail, List())

        if(possibleMin < min){
          findMinDistance(tail, possibleMin)
        } else {
          findMinDistance(tail, min)
        }

  // Recursive fors to calculate each distance of a pair of points between it and the rest of pair of points, gives me
  // a list of all the distances
  @tailrec
  def parallelForsMinDistance(pair: List[Int], list: List[List[Int]], distances: List[Double]): Double =
    list match
      case Nil => minDistanceOfPairDistances(distances, Int.MaxValue)
      case head::tail =>
        parallelForsMinDistance(pair, tail, euclideanDistance(pair, head)::distances)

  // Calculates the minimum distance in a list of distances
  @tailrec
  def minDistanceOfPairDistances(distancesList: List[Double], min: Double): Double =
    distancesList match
      case Nil => min
      case head::tail =>
        if(distancesList.head == 0.03125){ // we know that this is the distance calculated
          // and approximated of the functions of same pair of points
          minDistanceOfPairDistances(distancesList.tail, min)
        } else {
          if (distancesList.head < min) {
            minDistanceOfPairDistances(distancesList.tail, distancesList.head)
          } else {
            minDistanceOfPairDistances(distancesList.tail, min)
          }
        }


  // MODIFIED MERGE SORT
  def mergeSort(list: List[Int]): (List[Int], Int) = {
    if (list.length <= 1) (list, 0)
    else {
      val (left, right) = list.splitAt(list.length / 2)
      val (leftSorted, leftInversions) = mergeSort(left)
      val (rightSorted, rightInversions) = mergeSort(right)
      val (merged, mergeInversions) = merge(leftSorted, rightSorted, 0)
      (merged, leftInversions + rightInversions + mergeInversions)
    }
  }

  def merge(list_left: List[Int], list_right: List[Int], countInv: Int): (List[Int], Int) =
    (list_left, list_right) match {
      case (Nil, _) => (list_right, countInv)
      case (_, Nil) => (list_left, countInv)
      case (head1 :: tail1, head2 :: tail2) =>
        if (head1 <= head2) {
          val (merged, inversions) = merge(tail1, list_right, countInv)
          (head1 :: merged, inversions)
        } else {
          val (merged, inversions) = merge(list_left, tail2, countInv + list_left.length)
          (head2 :: merged, inversions)
        }
    }

  @tailrec
  def verifyElements(list: List[Int], value: Int, amount: Int): Int =
    list match
      case Nil => amount
      case head :: tail => if (head > value) verifyElements(tail, value, amount + 1) else verifyElements(tail, value, amount)

  // QUICKSORT
  def random(start: Int, end: Int): Int = {
    val random = new Random()
    random.nextInt(end - start + 1) + start
  }

  def randomizedQuickSort(list: List[Int]): List[Int] =
    list match
      case Nil => list
      case head :: Nil => list
      case head :: tail =>
        val pivotPos = random(1, list.length)
        val pivot = list(pivotPos - 1)

        val valueHead = list.head
        val exchangedList = list.updated(0, pivot).updated(pivotPos - 1, valueHead)

        val (left, right): (List[Int], List[Int]) = randomizedPartition(exchangedList.tail, pivot, List(), List())
        randomizedQuickSort(left) ::: (pivot :: randomizedQuickSort(right))

  @tailrec
  def randomizedPartition(list: List[Int], pivot: Int, left: List[Int], right: List[Int]): (List[Int], List[Int]) =
    list match
      case Nil => (left, right)
      case head :: tail =>
        if (head < pivot) randomizedPartition(tail, pivot, head :: left, right)
        else randomizedPartition(tail, pivot, left, head :: right)


  // EUCLIDEAN DISTANCE -> Returns the distance between 2 points (pairs of int numbers) using the euclidean method
  def euclideanDistance(firstPair: List[Int], secondPair: List[Int]): Double =
    val distanceWithoutSqrt = euclideanDistanceRecursive(firstPair, secondPair, 0.0)

    if(distanceWithoutSqrt == -1.0){
      distanceWithoutSqrt
    } else {
      squareRoot(distanceWithoutSqrt)
    }


  @tailrec
  def euclideanDistanceRecursive(firstPair: List[Int], secondPair: List[Int], result: Double): Double =
    (firstPair, secondPair) match
      case (Nil, Nil) => result
      case (Nil, _) => -1.0
      case (_, Nil) => -1.0
      case (head :: tail, head2 :: tail2) =>
        val difference = head2 - head

        euclideanDistanceRecursive(tail, tail2, result + pow(difference, 2))

  // PREDECESOR AND SUCESOR
  def pred(n: Int): Int = if (n > 0) n - 1 else 0

  // ABS
  def abs(x: Double) = if (x >= 0) x else -x

  // POW
  def pow(base: Int, exp: Int): Int =
    if (exp == 0) 1 else base * pow(base, pred(exp))

  // SQRT METHODS
  def upgrade(number: Double, aprox: Double) =
    (aprox + number / aprox) / 2

  def isGoodEstimation(number: Double, aprox: Double) =
    abs(aprox * aprox - number) < 0.001

  @tailrec
  def iterativeSquareRoot(number: Double, aprox: Double): Double =
    if (isGoodEstimation(number, aprox)) aprox
    else iterativeSquareRoot(number, upgrade(number, aprox))

  def squareRoot(number: Double): Double = iterativeSquareRoot(number, 1)
  // END OF SQRT METHODS
   
}
