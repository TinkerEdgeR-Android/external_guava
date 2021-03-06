/*
 * Copyright (C) 2009 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

import java.lang.reflect.Array;

// TODO(kevinb): guava javadoc path seems set wrong, doesn't find that last
// import
/**
 * Version of {@link GwtPlatform} used in hosted-mode.  It includes methods in
 * {@link Platform} that requires different implementions in web mode and
 * hosted mode.  It is factored out from {@link Platform} because {@code
 * GwtScriptOnly} (which is applied to the emul version) supports only public
 * classes and methods.
 *
 * @author Hayward Chan
 */
// TODO(hhchan): Once we start using server-side source in hosted mode, we won't
// need this.
@GwtCompatible(emulated = true)
public final class GwtPlatform {

  private GwtPlatform() {}

  /** See {@link Platform#newArray(Object[], int)} */
  public static <T> T[] newArray(T[] reference, int length) {
    Class<?> type = reference.getClass().getComponentType();

    // the cast is safe because
    // result.getClass() == reference.getClass().getComponentType()
    @SuppressWarnings("unchecked")
    T[] result = (T[]) Array.newInstance(type, length);
    return result;
  }
}
