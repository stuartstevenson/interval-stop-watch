package io.github.stuartstevenson;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class IntervalStopwatch {
    private Stopwatch stopwatch;

    public IntervalStopwatch(Stopwatch stopwatch) {
        this.stopwatch = stopwatch;
    }

    public static IntervalStopwatch createUnstarted() {
        return new IntervalStopwatch(Stopwatch.createUnstarted());
    }

    public void start() {
        stopwatch.start();
    }

    public void stop() {
        stopwatch.stop();
    }

    public long elapsed(TimeUnit timeUnit) {
        return stopwatch.elapsed(timeUnit);
    }

    public void split() {

    }
}
