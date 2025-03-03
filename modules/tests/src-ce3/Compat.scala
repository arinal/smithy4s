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

package smithy4s.tests

import cats.effect.IO
import com.comcast.ip4s.Host
import com.comcast.ip4s.Port

object Compat {

  type Ref[F[_], T] = cats.effect.Ref[F, T]

  def ref[T](init: T): IO[Ref[IO, T]] =
    cats.effect.kernel.Ref[IO].of(init)

  def host(hostname: String): Host = Host.fromString(hostname).get
  def port(portNumber: Int): Port = Port.fromInt(portNumber).get
}
