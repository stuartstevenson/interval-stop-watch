package io.github.stuartstevenson;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.fest.assertions.api.Assertions.assertThat;

public class IntervalStopwatchTest {

    @Test
    public void shouldRecordOnEachIteration() throws Exception{
        IntervalStopwatch stopwatch = IntervalStopwatch.createUnstarted();

        stopwatch.start();
        for (int i = 0; i < 5; i++) {
            Thread.sleep(500);
            stopwatch.split();
        }
        stopwatch.stop();

        assertThat(stopwatch.elapsed(TimeUnit.MILLISECONDS)).isGreaterThan(2500);
        assertThat(stopwatch.getSplits()).hasSize(5);
        long lastSplit = 0;
        for (Long split : stopwatch.getSplits()) {
            assertThat(split).isGreaterThan(lastSplit);
            lastSplit = split;
        }
    }
}
