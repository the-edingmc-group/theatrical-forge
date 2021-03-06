/*
 * Copyright 2018 Theatrical Team (James Conway (615283) & Stuart (Rushmead)) and it's contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.theatricalmod.theatrical.api.dmx;

public class DMXValueOutOfBoundsException extends IllegalArgumentException {

    public DMXValueOutOfBoundsException() {
        super();
    }

    public DMXValueOutOfBoundsException(String message) {
        super(message);
    }

    public DMXValueOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DMXValueOutOfBoundsException(Throwable cause) {
        super(cause);
    }

}
