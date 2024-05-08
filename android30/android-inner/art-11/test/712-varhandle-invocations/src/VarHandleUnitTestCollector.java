/*
 * Copyright (C) 2018 The Android Open Source Project
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

import java.io.PrintStream;

// Results collector for VarHandle Unit tests
public final class VarHandleUnitTestCollector {
    private final PrintStream out = System.out;
    private final boolean verbose = false;

    private int numberOfSuccesses;
    private int numberOfSkips;
    private int numberOfFailures;
    private int consecutiveResults = 0;
    private String current;
    private long startMillis;

    public void start(String testName) {
        out.append(testName)
                .append("...");
        consecutiveResults = 0;
        current = testName;
        startMillis = System.currentTimeMillis();
    }

    private void printStatus(String status) {
        out.print(status);
        if (verbose) {
            out.print('[');
            out.print(System.currentTimeMillis() - startMillis);
            out.print(']');
        }
        out.println();
    }

    public void skip() {
        numberOfSkips += 1;
        printStatus("SKIP");
        consecutiveResults++;
    }

    public void success() {
        numberOfSuccesses += 1;
        printStatus("OK");
        if (consecutiveResults++ > 1) {
            throw new AssertionError("Oops: " + consecutiveResults);
        }
    }

    public void fail(String errorMessage) {
        numberOfFailures += 1;
        printStatus("FAIL");
        out.print(errorMessage);
        consecutiveResults++;
    }

    public void printSummary() {
        out.append(Integer.toString(numberOfSuccesses))
                .append(" successes, ")
                .append(Integer.toString(numberOfSkips))
                .append(" skips, ")
                .append(Integer.toString(numberOfFailures))
                .append(" failures.");
        out.println();
    }

    boolean failuresOccurred() {
        return numberOfFailures != 0;
    }
}
