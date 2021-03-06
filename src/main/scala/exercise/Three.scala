package exercise

import scala.annotation.tailrec

object Three {

  sealed trait List[+A]
  case class Cons[+A](head: A, tail: List[A]) extends List[A]
  case object Nil extends List[Nothing]
  
  object List {
    
    def apply[A](as: A*): List[A] = {
      if (as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))
    }
    
    def sum(ints: List[Int]): Int = ints match {
      case Nil => 0
      case Cons(x, xs) => x + sum(xs)
    }

    def sumFoldLeft(ints: List[Int]): Int = {
      foldLeft(ints, 0)((b,a) => b + a)
    }

    def productFoldLeft(ints: List[Int]): Int = {
      foldLeft(ints, 1)((b,a) => b * a)
    }

    def lengthFoldLeft(ints: List[Int]): Int = {
      foldLeft(ints, 0)((b,a) => b + 1)
    }

    def reverse[A](a: List[A]): List[A] = {
      foldLeft(a, List[A]())((h, t) => Cons(t, h))
    }

    def tail[A](a: List[A]): List[A] = {
      a match {
        case Cons(h, t) => t
        case Nil => List()
      }
    }

    def drop[A](l: List[A], n: Int): List[A] = {
      def go(m: List[A], acc: Int): List[A] = {
        if (n == acc) m
        else go(tail(m), acc + 1)
      }
      go(l, 0)
    }

    def setHead[A](a: List[A], head: A) = {
      List(head, tail(a))
    }

    def dropWhile[A](l: List[A], f: A => Boolean): List[A] = {
      l match {
        case Cons(h, t) if f(h) => dropWhile(drop(t, 0), f)
        case _ => l
      }
    }

    def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = {
      as match {
        case Nil => z
        case Cons(x, xs) => f(x, foldRight(xs, z)(f))
      }
    }

    @tailrec
    def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = {
      as match {
          case Nil => z
          case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
        }
    }

    def length[A](as: List[A]): Int =
      foldRight(as, 0)((_, n) => n + 1)
  }


  val x = List(1, 2, 3, 4, 5) match {
    case Cons(x, Cons(2, Cons(4, _))) => x
    case Nil => 42
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
    case Cons(h, t) => h + List.sum(t)
    case _ => 101
    
    }

}
