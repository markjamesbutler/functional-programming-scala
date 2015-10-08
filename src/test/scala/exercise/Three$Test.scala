package exercise

import exercise.Three._
import org.scalatest.{Matchers, FlatSpec}

class Three$Test extends FlatSpec with Matchers {

  "x" should "match" in {

    x should be (3)

  }

  "tail" should "return tail of list" in {

    List.tail(List()) should be (List())
    List.tail(List(1,2,3)) should be (List(2,3))
  }

  "setHead" should "set head of list" in {

    List.setHead(List(), 1) should be (List(1, Nil))
    List.setHead(List(2,3), 1) should be (List(1,Cons(3, Nil)))
  }

}
