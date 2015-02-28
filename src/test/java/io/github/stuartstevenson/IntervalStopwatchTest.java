package io.github.stuartstevenson;

import com.google.common.base.Stopwatch;
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
    }
}
