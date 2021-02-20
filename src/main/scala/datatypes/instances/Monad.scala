package datatypes.instances

import datatypes.Identity
import typeclasses.{Applicative, Monad}

given (using applicative: Applicative[Identity]): Monad[Identity] with

  export applicative._

  def flatMap[A, B](f: A => Identity[B])(fa: Identity[A]): Identity[B] = f(fa.value)
