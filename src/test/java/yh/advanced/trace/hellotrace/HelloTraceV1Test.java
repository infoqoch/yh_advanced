package yh.advanced.trace.hellotrace;

import org.junit.jupiter.api.Test;
import yh.advanced.trace.TraceStatus;

import static org.junit.jupiter.api.Assertions.*;

class HelloTraceV1Test {

    @Test
    void begin_end(){
        HelloTraceV1 helloTraceV1 = new HelloTraceV1();
        TraceStatus traceStatus = helloTraceV1.begin("시작");
        helloTraceV1.end(traceStatus);
    }


    @Test
    void begin_exception(){
        HelloTraceV1 helloTraceV1 = new HelloTraceV1();
        TraceStatus traceStatus = helloTraceV1.begin("시작");
        helloTraceV1.exception(traceStatus, new IllegalStateException());
    }

}