package exercise

import org.scalatest.{Matchers, FlatSpec}

class Three$Test extends FlatSpec with Matchers {

  "x" should "match" in {

    Three.x should be (3)

  }

  "tail" should "return tail of list" in {

    Three.List.tail(Three.List()) should be (Three.List())
    Three.List.tail(Three.List(1,2,3)) should be (Three.List(2,3))
  }

  "setHead" should "set head of list" in {

    Three.List.setHead(Three.List(), 1) should be (Three.List(1))
    Three.List.setHead(Three.List(2,3), 1) should be (Three.List(1,2,3))
  }

}
