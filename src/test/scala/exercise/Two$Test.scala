package exercise

import Two
import org.scalatest.{FlatSpec, Matchers}

class Two$Test extends FlatSpec with Matchers {

  "A Fibonacci generator" should "generate the correct Fibonacci values" in {

    Two fib 0 should be (0)
    Two fib 1 should be (1)
    Two fib 2 should be (1)
    Two fib 3 should be (2)
    Two fib 4 should be (3)
    Two fib 5 should be (5)
    Two fib 6 should be (8)
    Two fib 7 should be (13)

  }

  "isSorted" should "determine if an array is sorted" in {

    def ordered[A](a: A, b: A):Boolean = true
    def notOrdered[A](a: A, b: A):Boolean = false

    Two.isSorted(Array("One", "Two"), ordered) should be (true)
    Two.isSorted(Array("Two", "One"), notOrdered) should be (false)

  }

}
