package typeclasses

trait Applicative[F[_]] extends Functor[F] {

  def pure[A](a: A): F[A]

  def ap[A, B](f: F[A => B])(fa: F[A]): F[B]

}

object Applicative {

  def pure[A, F[_]](a: A)(implicit m: Applicative[F]): F[A] =
    m.pure(a)

  def ap[A, B, F[_]](f: F[A => B])(fa: F[A])(implicit m: Applicative[F]): F[B] =
    m.ap(f)(fa)

}
