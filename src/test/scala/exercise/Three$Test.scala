package exercise

import exercise.Three._
import org.scalatest.{Matchers, FlatSpec}

class Three$Test extends FlatSpec with Matchers {

  "x" should "match" in {

    x should be(3)

  }

  "tail" should "return tail of list" in {

    List.tail(List()) should be(List())
    List.tail(List(1, 2, 3)) should be(List(2, 3))
  }

  "setHead" should "set head of list" in {

    List.setHead(List(), 1) should be(List(1, Nil))
    List.setHead(List(2, 3), 1) should be(List(1, Cons(3, Nil)))
  }

  "drop" should "remove elements from a list" in {
    List.drop(List(), 1) should be(List())
    List.drop(List(1), 1) should be(List())
    List.drop(List(1, Cons(2, Nil)), 1) should be(Cons(Cons(2, Nil), Nil))
  }

  "dropWhile" should "remove elements from a list" in {
    def predicate[Integer](a: Integer): Boolean = a != 4
    List.dropWhile(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), predicate) should be(List(4, 5, 6, 7, 8, 9, 10))
  }

  "foldRight Nil and Cons" should "return same list" in {
    List.foldRight(List(1,2,3), Nil:List[Int])(Cons(_,_)) should be (Cons(1,Cons(2,Cons(3,Nil))))
  }

  "length" should "compute length of list " in {
    List.length(List()) should be (0)
    List.length(List(1,2,3)) should be (3)
  }

  "sumFoldRight" should "compute correct sum" in {
    List.sumFoldLeft(List(1,2,3)) should be (6)
  }

  "productFoldLeft" should "compute correct product" in {
    List.productFoldLeft(List(1,2,3,4)) should be (24)
  }

  "lengthFoldLeft" should "compute correct length" in {
    List.lengthFoldLeft(List(1,2,3,4)) should be (4)
  }

}
