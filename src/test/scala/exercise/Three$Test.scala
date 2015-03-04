package exercise

import org.scalatest.{Matchers, FlatSpec}

class Three$Test extends FlatSpec with Matchers {

  "x" should "match" in {

    Three.x should be (3)

  }

}
