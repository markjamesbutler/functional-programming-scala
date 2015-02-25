package exercise.two

import scala.annotation.tailrec

object Two {

  def fib(n: Int): Int = {
    @tailrec
    def go(a: Int, b: Int, count: Int): Int = {
      if (count == n) a
      else go(b, a + b, count + 1)
    }
    go(0, 1, 0)
  }
}
