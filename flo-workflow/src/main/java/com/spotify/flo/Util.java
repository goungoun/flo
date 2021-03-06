/*-
 * -\-\-
 * Flo Workflow Definition
 * --
 * Copyright (C) 2016 - 2017 Spotify AB
 * --
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * -/-/-
 */

package com.spotify.flo;

import static org.fusesource.jansi.Ansi.Color.CYAN;
import static org.fusesource.jansi.Ansi.Color.WHITE;
import static org.fusesource.jansi.Ansi.ansi;

import org.fusesource.jansi.Ansi;

public final class Util {

  private Util() {
  }

  public static Ansi colored(TaskId taskId) {
    final String id = taskId.toString();
    final int openParen = id.indexOf('(');
    final int closeParen = id.lastIndexOf(')');
    final int hashPos = id.lastIndexOf('#');

    return ansi()
        .fg(CYAN).a(id.substring(0, openParen + 1))
        .reset().a(id.substring(openParen + 1, closeParen))
        .fg(CYAN).a(id.substring(closeParen, hashPos))
        .fg(WHITE).a(id.substring(hashPos))
        .reset();
  }

  public static Ansi colored(Ansi.Color color, String string) {
    return ansi().fg(color).a(string).reset();
  }
}
