package exercise

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

    def tail[A](a: List[A]): List[A] = {
      a match {
        case Cons(h, t) => t
        case Nil => List()
      }
    }

    def setHead[A](a: List[A], head: A): List[A] = {
      a match {
        case Cons(h, t) => Cons(head, t)
        case Nil => List(head)
      }
    }
  }
  
  val x = List(1, 2, 3, 4, 5) match {
    case Cons(x, Cons(2, Cons(4, _))) => x
    case Nil => 42
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
    case Cons(h, t) => h + List.sum(t)
    case _ => 101
    
    }
}
