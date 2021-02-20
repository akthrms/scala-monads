package typeclasses

/**
 * アプリカティブ トレイト
 */
trait Applicative[F[_]] extends Functor[F]:

  def pure[A](a: A): F[A]

  def ap[A, B](f: F[A => B])(fa: F[A]): F[B]

/**
 * アプリカティブ
 */
object Applicative:

  def pure[A, F[_]](a: A)(using applicative: Applicative[F]): F[A] = applicative.pure(a)

  def ap[A, B, F[_]](f: F[A => B])(fa: F[A])(using applicative: Applicative[F]): F[B] = applicative.ap(f)(fa)
