package yh.advanced.trace.logtrace;

import org.junit.jupiter.api.Test;
import yh.advanced.trace.ThreadLocalLogTrace;
import yh.advanced.trace.TraceStatus;

public class ThreadLocalTraceTest {

    @Test
    void test(){
        ThreadLocalLogTrace logTraceA = new ThreadLocalLogTrace();
        TraceStatus status1 = logTraceA.begin("controller");
        TraceStatus status2 = logTraceA.begin("service");
        TraceStatus status3 = logTraceA.begin("repository");
        logTraceA.end(status3);
        logTraceA.end(status2);
        logTraceA.end(status1);

    }
}
