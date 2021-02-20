package typeclasses

trait Monad[F[_]] extends Applicative[F] {

  def flatMap[A, B](f: A => F[B])(fa: F[A]): F[B]

}

object Monad {

  def flatMap[A, B, F[_]](f: A => F[B])(fa: F[A])(implicit m: Monad[F]): F[B] =
    m.flatMap(f)(fa)

}
