package datatypes.instances

import datatypes.Identity
import typeclasses.{Applicative, Functor}

given (using functor: Functor[Identity]): Applicative[Identity] with

  export functor._

  def pure[A](a: A): Identity[A] = Identity(a)

  def ap[A, B](f: Identity[A => B])(fa: Identity[A]): Identity[B] = map(f.value)(fa)
