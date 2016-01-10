package exercise

object Four {

  case class Some[+A](get: A) extends Option[A]
  case object None extends Option[Nothing]

  trait Option[+A] {
    def map[B](f: A => B): Option[B] =
    this match {
        case Some(a) => Some(f(a))
        case _ => None
      }

    def flatMap[B](f: A=> Option[B]): Option[B] = {
      this.map(f(_)).getOrElse(None)
    }

    def getOrElse[B >: A](default: => B): B = {
      this match {
        case Some(a) => a
        case None => default
      }

    }
    def orElse[B >: A](ob: => Option[B]): Option[B] = {
      this map (Some(_)) getOrElse(ob)
    }

    def filter(f: A => Boolean): Option[A] = {
      this.map{ a =>
        if(f(a)) this
        else None
      }.getOrElse(None)
    }
  }

}
