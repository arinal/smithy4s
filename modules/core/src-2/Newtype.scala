/*
 *  Copyright 2021 Disney Streaming
 *
 *  Licensed under the Tomorrow Open Source Technology License, Version 1.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     https://disneystreaming.github.io/TOST-1.0.txt
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package smithy4s

abstract class Newtype[A] extends HasId { self =>
  // This encoding originally comes from this library:
  // https://github.com/alexknvl/newtypes#what-does-it-do
  type Base
  trait _Tag extends Any
  type Type <: Base with _Tag

  @inline final def apply(a: A): Type = a.asInstanceOf[Type]

  @inline final def value(x: Type): A =
    x.asInstanceOf[A]

  implicit final class Ops(val self: Type) {
    @inline def value: A = Newtype.this.value(self)
  }

  implicit val key: Hints.Key[Type] = new Hints.Key[Type] {
    def id: ShapeId = self.id
  }

  def unapply(t: Type): Some[A] = Some(t.value)

}
