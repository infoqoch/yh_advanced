package yh.advanced.trace.hellotrace;

import org.junit.jupiter.api.Test;
import yh.advanced.trace.TraceStatus;

import static org.junit.jupiter.api.Assertions.*;

class HelloTraceV2Test {

    @Test
    void begin_end(){
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status1 = trace.begin("controller");
        TraceStatus status2 = trace.beginSync(status1, "service");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception(){
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status1 = trace.begin("controller");
        TraceStatus status2 = trace.beginSync(status1, "service");
        trace.exception(status2, new IllegalStateException("예외 발생!"));
        trace.exception(status1, new IllegalStateException("예외 발생!"));
    }
}
