package DivideAndConquerPacket

import scala.annotation.tailrec

object DivideAndConquer extends App with IDivideAndConquer {

  // NUMBER OF INVERSIONS -> Returns the number of inversions that are necessary to get the sorted list
  def numberOfInversions(list: List[Int]): Int = ???

  // IMPROVING QUICKSORT -> Returns the sorted list using quicksort, using a 3-way partition instead of a 2-way
  def improvingQuickSort(list: List[Int]): List[Int] = ???

  // CLOSEST POINTS -> Returns the closest points of a list of points (the points are pair of int numbers)
  def closestPoints(list: List[List[Int]]): Double = ???

  // EUCLIDEAN DISTANCE -> Returns the distance between 2 points (pairs of int numbers) using the euclidean method
  def euclideanDistance(firstPair: List[Int], secondPair: List[Int]): Double =
    if (firstPair.length != 2 || secondPair.length != 2) {
      -1.0
    } else {
      var firstPow = -1
      var secondPow = -1

      // We make verifications, for the difference when there are negative numbers or the difference result is a negative
      // number
      if(secondPair.head < 0 && firstPair.head > 0){
        firstPow = pow(sum(secondPair.head, firstPair.head), 2)
      }

      if(secondPair(1) < 0 && firstPair(1) > 0){
        secondPow = pow(sum(secondPair.head, firstPair.head), 2)
      }

      if(firstPow == -1 && firstPair.head != 0 && secondPair.head < firstPair.head){
        firstPow = pow(difference(firstPair.head, secondPair.head), 2)
      }

      if (secondPow == -1 && firstPair(1) != 0 && secondPair(1) < firstPair(1)) {
        secondPow = pow(difference(firstPair(1), secondPair(1)), 2)
      }

      if(firstPow == -1) {
        firstPow = pow(difference(secondPair.head, firstPair.head), 2)
      }

      if(secondPow == -1){
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
    abs(aprox*aprox - number) < 0.001

  @tailrec
  def iterativeSquareRoot(number: Double, aprox: Double) : Double =
    if(isGoodEstimation(number, aprox)) aprox
    else iterativeSquareRoot(number, upgrade(number, aprox))

  def squareRoot(number: Double): Double = iterativeSquareRoot(number, 1)
  // END OF SQRT METHODS

  // MERGE SORT
  def mergeSort(list: List[Int]): List[Int] = ???

  def merge(l1: List[Int], l2: List[Int]) = ???

  def quickSort(list:List[Int], firstPos:Int, lastPos:Int): List[Int] = ???

  def quickSortPartition(list: List[Int], firstPos: Int, lastPos: Int): Int = ???
}
