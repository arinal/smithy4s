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

package smithy4s.api;

import software.amazon.smithy.model.SourceLocation;
import software.amazon.smithy.model.shapes.ShapeId;
import software.amazon.smithy.model.traits.StringTrait;

public final class DiscriminatedUnionTrait extends StringTrait {

    public static final ShapeId ID = ShapeId.from("smithy4s.api#discriminated");

    public DiscriminatedUnionTrait(String value, SourceLocation sourceLocation) {
        super(ID, value, sourceLocation);
    }

    public DiscriminatedUnionTrait(String value) {
        this(value, SourceLocation.NONE);
    }

    public static final class Provider extends StringTrait.Provider<DiscriminatedUnionTrait> {
        public Provider() {
            super(ID, DiscriminatedUnionTrait::new);
        }
    }
}
