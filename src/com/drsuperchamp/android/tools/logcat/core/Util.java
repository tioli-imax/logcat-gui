/*
 * Copyright (C) 2011 Dr.SuperChamp
 *
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
 */

package com.drsuperchamp.android.tools.logcat.core;

public class Util {
    private static DebugOutput mOutputInterface = null;

    public static void DbgLog(String ... msg) {
        String s = null;
        if (msg.length == 0) {
            s = getMethod();
        } else {
            s = getMethod() + ": " + msg[0];
        }

        if (mOutputInterface != null) {
            mOutputInterface.out(s);
        } else {
            // default is 'console'
            System.out.println(s);
        }
    }

    public static void setDebugOutput(DebugOutput outInterface) {
        mOutputInterface = outInterface;
    }

    private static String getMethod()
    {
        StackTraceElement[] stacks = new Throwable().getStackTrace();
        StackTraceElement currentStack = stacks[2];
        return currentStack.getMethodName();
    }
}
