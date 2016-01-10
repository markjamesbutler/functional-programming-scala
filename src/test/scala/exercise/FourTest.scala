package exercise

import org.scalatest.{Matchers, FlatSpec}

class FourTest extends FlatSpec with Matchers {

  import exercise.Four._

  it should "map" in {
    Some(1).map(_ * 2) should be(Some(2))
  }

  it should "flatMap" in {
    Some(1).flatMap(a => Some(a * 2)) should be(Some(2))
    None.flatMap(a => Some(2)) should be(None)
  }

  it should "getOrElse" in {
    Some(1).getOrElse(2) should be(1)
    None.getOrElse(2) should be(2)
  }

  it should "orElse" in {
    Some(1).orElse(Some(2)) should be(Some(1))
    None.orElse(Some(2)) should be(Some(2))
  }

  it should "filter" in {
    Some(1).filter(_ == 1) should be(Some(1))
    Some(2).filter(_ == 1) should be(None)
    None.filter(_ == 1) should be(None)
  }

}
