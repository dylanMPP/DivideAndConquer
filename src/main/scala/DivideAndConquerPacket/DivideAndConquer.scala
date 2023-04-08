package DivideAndConquerPacket

import scala.annotation.tailrec
import scala.util.Random

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
        var exchangedList:List[Int] = List()

        if(pivotPos==2){
          exchangedList = list.updated(0, pivot).updated(pivotPos - 1, valueHead).updated(1, anotherPivot).updated(anotherPivotPos - 1, valueHead)
        } else {
          exchangedList = list.updated(0, pivot).updated(pivotPos - 1, valueHead).updated(1, anotherPivot).updated(anotherPivotPos - 1, valueHead2)
        }

        // There are 2 pivots, then I need to compare them to know their respective order
        if(pivot > anotherPivot){
          val (left, center, right) = randomized3WayPartition(exchangedList.tail.tail, anotherPivot, pivot, List(), List(), List())
          improvingQuickSort(left) ::: (anotherPivot :: improvingQuickSort(center) ::: (pivot :: improvingQuickSort(right)))
        } else if(pivot < anotherPivot) {
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
    val xPoints = quickSortPoints(list, 0)
    val yPoints = quickSortPoints(list, 1)

    val (xd1, xd2) = xPoints splitAt(xPoints.length/2)
    val xd1Min = findMinDistance(xd1, Int.MaxValue)
    val xd2Min = findMinDistance(xd2, Int.MaxValue)

    var xMinDistance = -1.0

    if(xd1Min < xd2Min){
      xMinDistance = xd1Min
    } else {
      xMinDistance = xd2Min
    }

    1.0

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


  @tailrec
  def giveMePoints(list: List[List[Int]], whichPoints: Int, result: List[Int]): List[Int] =
    list match
      case Nil => result
      case head::tail =>
        if(whichPoints==0){
          giveMePoints(tail, whichPoints, head.head::result)
        } else {
          giveMePoints(tail, whichPoints, head(1)::result)
        }

  // Min distance for pairs of points
  @tailrec
  def findMinDistance(list: List[List[Int]], min: Double): Double =
    list match
      case Nil => min
      case head :: tail =>
        val possibleMin = parallelForsMinDistance(head, list, 0 , List())

        if(possibleMin < min){
          findMinDistance(tail, possibleMin)
        } else {
          findMinDistance(tail, min)
        }

  // Recursive fors to calculate each distance of a pair of points between it and the rest of pair of points, gives me
  // a list of all the distances
  @tailrec
  def parallelForsMinDistance(pair: List[Int], list: List[List[Int]], count: Int, distances: List[Double]): Double =
    if(count == list.length - 1){
      minDistanceOfPairDistances(distances, distances.head, 0)
    } else {
      parallelForsMinDistance(pair, list.tail, count+1, euclideanDistance(pair, list.head)::distances)
    }

  // Calculates the minimum distance in a list of distances
  @tailrec
  def minDistanceOfPairDistances(distancesList: List[Double], min: Double, count: Int): Double =
    if(count == distancesList.length-1){
      min
    } else {
      if(distancesList.head < min){
        minDistanceOfPairDistances(distancesList.tail, distancesList.head, count+1)
      } else {
        minDistanceOfPairDistances(distancesList.tail, min, count+1)
      }
    }

  // LIST ALREADY SORTED ?
  // It returns 0 if the list is already sorted, 1 or more if isn't sorted
  @tailrec
  def alreadySorted(list: List[Int], cont: Int): Int =
    list match
      case Nil => cont
      case head :: tail => tail match {
        case Nil => cont
        case head2 :: tail2 =>
          if (head > head2) {
            alreadySorted(tail, cont + 1)
          } else {
            alreadySorted(tail, cont)
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
    if (firstPair.length != 2 || secondPair.length != 2) {
      -1.0
    } else {
      var firstPow = -1
      var secondPow = -1

      // We make verifications, for the difference when there are negative numbers or the difference result is a negative
      // number
      if (secondPair.head < 0 && firstPair.head > 0) {
        firstPow = pow(sum(secondPair.head, firstPair.head), 2)
      }

      if (secondPair(1) < 0 && firstPair(1) > 0) {
        secondPow = pow(sum(secondPair.head, firstPair.head), 2)
      }

      if (firstPow == -1 && firstPair.head != 0 && secondPair.head < firstPair.head) {
        firstPow = pow(difference(firstPair.head, secondPair.head), 2)
      }

      if (secondPow == -1 && firstPair(1) != 0 && secondPair(1) < firstPair(1)) {
        secondPow = pow(difference(firstPair(1), secondPair(1)), 2)
      }

      if (firstPow == -1) {
        firstPow = pow(difference(secondPair.head, firstPair.head), 2)
      }

      if (secondPow == -1) {
        secondPow = pow(difference(secondPair(1), firstPair(1)), 2)
      }

      val result = sum(firstPow, secondPow)
      squareRoot(result)
    }

  // PREDECESOR AND SUCESOR
  def pred(n: Int): Int = if (n > 0) n - 1 else 0

  def suc(n: Int): Int = n + 1

  // ABS
  def abs(x: Double) = if (x >= 0) x else -x

  // SUM
  def sum(number: Int, number2: Int): Int =
    if (number == 0) number2 else suc(sum(pred(number), number2))

  // DIFFERENCE
  @tailrec
  def difference(number: Int, number2: Int): Int =
    if (number2 == 0) number else difference(pred(number), pred(number2))

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
