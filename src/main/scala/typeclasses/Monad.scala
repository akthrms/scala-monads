package typeclasses

trait Monad[F[_]] extends Applicative[F]:
  def flatMap[A, B](f: A => F[B])(fa: F[A]): F[B]

object Monad:
  def flatMap[A, B, F[_]](f: A => F[B])(fa: F[A])(using monad: Monad[F]): F[B] = monad.flatMap(f)(fa)

extension [A, B, F[_]](fa: F[A])(using monad: Monad[F])
  def flatMap(f: A => F[B]): F[B] = monad.flatMap(f)(fa)

  def >>=(f: A => F[B]): F[B] = monad.flatMap(f)(fa)
