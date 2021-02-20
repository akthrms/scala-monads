package typeclasses

/**
 * モナドトレイト
 */
trait Monad[F[_]] extends Applicative[F]:

  def flatMap[A, B](f: A => F[B])(fa: F[A]): F[B]

/**
 * モナド
 */
object Monad:

  def flatMap[A, B, F[_]](f: A => F[B])(fa: F[A])(using monad: Monad[F]): F[B] = monad.flatMap(f)(fa)
