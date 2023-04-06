package DivideAndConquerPacket

import scala.annotation.tailrec
import scala.util.Random
object DivideAndConquer extends App with IDivideAndConquer {

  // NUMBER OF INVERSIONS -> Returns the number of inversions that are necessary to get the sorted list
  def numberOfInversions(list: List[Int]): Int =


    if (alreadySorted(list, 0) == 0) {
      0
    } else {
      if (list.length % 2 == 0) {
        mergeSort(list, 0, 0)._2
      } else {
        // I subtract 1 to the result of the number of inversions given by 'modifiedMergeSort', because
        // when the list length is odd, the center number is repeated in the two first partitions
        val n = list.length / 2

        if (list(n) > list(n + 1)) {
          mergeSort(list, 0, 0)._2 - 1
        } else {
          mergeSort(list, 0, 0)._2
        }
      }
    }

  // IMPROVING QUICKSORT -> Returns the sorted list using quicksort, using a 3-way partition instead of a 2-way
  def improvingQuickSort(list: List[Int]): List[Int] = ???

  // CLOSEST POINTS -> Returns the closest points of a list of points (the points are pair of int numbers)
  def closestPoints(list: List[List[Int]]): Double = ???

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
  def mergeSort(list: List[Int], inversions: Int, totalInv: Int): (List[Int], Int) =
    // List(10,7,3,6,2,9)
    val n = list.length / 2
    // n = 3
    // n = 1.5
    // n = 0

    // n = 1
    // n = 0
    // n = 0
    if (n == 0) (list, inversions)
    // 10, 0
    // 7, 0
    // 3, 0
    else {
      //l1: (10,7,3)
      //l2: (6,2,9)

      //l1: 10
      //l2: (7,3)

      //l1: 7
      //l2: 3
      val (l1, l2) = list splitAt n

      // (3,7,10),
      // (3,7), 1

      /*totalInv = totalInv + tailMerge(mergeSort(l1, inversions, totalInv)._2 /* 7, 0*/,
        mergeSort(l2, inversions, totalInv)._1 /* 3,0*/, inversions, List())._2*/

      tailMerge(mergeSort(l1, inversions, totalInv)._1 /* 7, 0*/ ,
        mergeSort(l2, inversions, totalInv)._1 /* 3,0*/ , inversions, List())
      //                  (10,7,3), 0             |           (6,2,9), 0
      //                  10, 0                   |           (7,3), 0
      //                  7,0                     |           3,0

    }

  @tailrec
  def tailMerge(l1: List[Int], l2: List[Int], inversions: Int, resultList: List[Int]): (List[Int], Int) =
  // 7, 3

  // 10, (3,7)
  // 10, 7
  // 10, Nil
    (l1, l2) match {
      case (Nil, _) => (resultList.reverse ++ l2, inversions)
      //3::7::10::Nil
      case (_, Nil) => (resultList.reverse ++ l1, inversions)
      case (head1 :: tail1, head2 :: tail2) =>
        if (head1 <= head2)
          tailMerge(tail1, l2, inversions, head1 :: resultList)
        else // (head1 > head2)
        //        7, Nil, 1, 3::Nil

        //      10, 7, 1, 3::Nil
        //      10, Nil, 2, 7::3::Nil
          tailMerge(l1, tail2, inversions + 1, head2 :: resultList)
    }

  /*def merge(l1: List[Int], l2: List[Int], inversions: Int): (List[Int], Int) =
      l1 match
        case Nil => (l2, inversions)
        case head::tail => l2 match {
          case Nil => (l1, inversions)
          case head2::tail2 =>
            if (head<head2) (head::merge(tail, l2, inversions)._1, merge(tail, l2, inversions)._2+1)
            else (head2::merge(l1, tail2, inversions)._1, merge(l1, tail2, inversions)._2+1)
        }*/

  // QUICKSORT
  def random(start: Int, end: Int): Int = {
    val random = new Random()
    random.nextInt(end - start + 1) + start
  }

  def randomizedQuickSort(list: List[Int], firstPos: Int, lastPos: Int, resultList: List[Int]): List[Int] =
    if(firstPos < lastPos) {
      val q = randomizedPartition(list, firstPos, lastPos)._2

      randomizedQuickSort(list, firstPos, q - 1, randomizedPartition(list, firstPos, lastPos)._1)
      randomizedQuickSort(list, q + 1, lastPos, randomizedPartition(list, firstPos, lastPos)._1)
    } else {
      resultList
    }

  def randomizedPartition(list: List[Int], firstPos: Int, lastPos: Int): (List[Int],Int) =
    val i = random(firstPos, lastPos)

    val valueLastPos = list(lastPos - 1)
    val valueI = list(i - 1)

    val exchangedList = list.updated(lastPos - 1, valueI).updated(i - 1, valueLastPos)
    partition(exchangedList, firstPos, lastPos)

  // Devuelvo la lista que se va actualizando más la Q, la posición en la que se va a ir organizando
  def partition(list: List[Int], firstPos: Int, lastPos: Int): (List[Int], Int) =
    val x = list(lastPos - 1)
    var i = firstPos - 1

    @tailrec
    def partitionFor(lastPos: Int, list: List[Int],
                     cont: Int): (List[Int], Int) =

      if (cont == (lastPos - 1)) {
        (list, i)
      } else if (list(cont) <= x) {
        i = i + 1

        val valueCont = list(cont)
        val valueI = list(i)

        partitionFor(lastPos, list.updated(i, valueCont).updated(cont, valueI), cont + 1)
      } else {
        partitionFor(lastPos, list, cont + 1)
      }

    val valueLastPos = list(lastPos - 1)
    val valueI = list(i + 1)

    (list.updated(lastPos - 1, valueI).updated(i + 1, valueLastPos), i + 1)



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

}
