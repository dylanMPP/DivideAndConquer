package DivideAndConquerTestPacket

import DivideAndConquerPacket.DivideAndConquer

class DivideAndConquerTest extends munit.FunSuite {
  
  def normalList = List(10,7,3,6,2,9)
  def repeatedList = List(10,7,3,10,6,2,9)
  def sortedList = List(1,2,3,10,22)
  def voidList = List()


  test("Number Of Inversions:") {
    assert(DivideAndConquer.numberOfInversions(normalList)==4)
    assert(DivideAndConquer.numberOfInversions(repeatedList)==5)
    assert(DivideAndConquer.numberOfInversions(sortedList)==0)
    assert(DivideAndConquer.numberOfInversions(voidList)==0);
  }

  test("Improved QuickSort:"){
    assert(DivideAndConquer.improvingQuickSort(normalList) == List(2,3,6,7,9,10))
    assert(DivideAndConquer.improvingQuickSort(repeatedList) == List(2,3,6,7,9,10,10))
    assert(DivideAndConquer.improvingQuickSort(sortedList) == sortedList)
    assert(DivideAndConquer.improvingQuickSort(voidList) == voidList)
  }

  test("Closest Points:"){



  }

}
