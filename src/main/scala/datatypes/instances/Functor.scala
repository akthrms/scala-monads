package datatypes.instances

import datatypes.Identity
import typeclasses.Functor

given Functor[Identity] with
  def map[A, B](f: A => B)(fa: Identity[A]): Identity[B] = Identity(f(fa.value))
