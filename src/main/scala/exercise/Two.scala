package exercise

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

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {

    @tailrec
    def loop(n: Int): Boolean = {
      if (n + 1 >= as.length) true
      else if (!ordered(as(n), as(n + 1))) false
      else loop(n + 1)
    }
    loop(0)
  }

  def curry[A, B, C](f: (A, B) => C): A => (B => C) =
    (a: A) => f(a, _)

  def uncurry[A, B, C](f: A => B => C): (A, B) => C =
    (a: A, b: B) => f(a)(b)

  
  def compose[A, B, C](f: B => C, g: A => B): A => C =
    (a: A) => f(g(a))
 
  val f = (x: Double) => math.Pi / 2 -x 
  
  val cos = f andThen math.sin
  
}
