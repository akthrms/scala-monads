package typeclasses

trait Functor[F[_]]:

  def map[A, B](f: A => B)(fa: F[A]): F[B]

object Functor:

  def map[A, B, F[_]](f: A => B)(fa: F[A])(using m: Functor[F]): F[B] = m.map(f)(fa)
