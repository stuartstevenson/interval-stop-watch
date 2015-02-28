package io.github.stuartstevenson;

import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class IntervalStopwatch {
    private Stopwatch stopwatch;
    private List<Long> splits;

    public IntervalStopwatch(Stopwatch stopwatch) {
        this.stopwatch = stopwatch;
        splits = new ArrayList<Long>();
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
        splits.add(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    public List<Long> getSplits() {
        return splits;
    }
}
