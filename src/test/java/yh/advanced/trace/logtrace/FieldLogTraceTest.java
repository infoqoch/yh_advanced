package yh.advanced.trace.logtrace;

import org.junit.jupiter.api.Test;
import yh.advanced.trace.FieldLogTrace;
import yh.advanced.trace.TraceStatus;

import static org.junit.jupiter.api.Assertions.*;

class FieldLogTraceTest {

    FieldLogTrace fieldLogTrace = new FieldLogTrace();

    @Test
    void begin_end(){
        TraceStatus status1 = fieldLogTrace.begin("controller");
        TraceStatus status2 = fieldLogTrace.begin("service");
        fieldLogTrace.end(status2);
        fieldLogTrace.end(status1);
        TraceStatus status3 = fieldLogTrace.begin("controller");
        TraceStatus status4 = fieldLogTrace.begin("service");
        fieldLogTrace.end(status4);
        fieldLogTrace.end(status3);

    }

    @Test
    void begin_exception(){
        TraceStatus status1 = fieldLogTrace.begin("controller");
        TraceStatus status2 = fieldLogTrace.begin("service");
        fieldLogTrace.exception(status2, new IllegalStateException("예외 발생"));
        fieldLogTrace.exception(status1, new IllegalStateException("예외 발생"));
    }
}