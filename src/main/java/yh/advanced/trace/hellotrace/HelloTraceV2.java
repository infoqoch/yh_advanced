package yh.advanced.trace.hellotrace;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import yh.advanced.trace.TraceId;
import yh.advanced.trace.TraceStatus;

@Slf4j
@Component
public class HelloTraceV2 {
    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EX_PREFIX = "<X-";

    public TraceStatus begin(String message){
        TraceId traceId = new TraceId();
        long startTimeMs = System.currentTimeMillis();
        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message);
        return new TraceStatus(traceId, startTimeMs, message);
    }

    private String addSpace(String prefix, int level) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<level; i++){
            sb.append(i==level-1?"|"+prefix:"|    ");
        }
        return sb.toString();

    }
    public TraceStatus beginSync(TraceStatus beforeTraceId, String message){
        TraceId traceId = beforeTraceId.getTraceId().createNextId();
        long startTimeMs = System.currentTimeMillis();
        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message);
        return new TraceStatus(traceId, startTimeMs, message);
    }


    public void end(TraceStatus traceStatus){
        complete(traceStatus, null);
    }

    public void exception(TraceStatus traceStatus, Exception e){
        complete(traceStatus, e);
    }

    private void complete(TraceStatus traceStatus, Exception e) {
        long resultTimeMs = System.currentTimeMillis() - traceStatus.getStartTimeMs();
        TraceId traceId = traceStatus.getTraceId();
        if(e==null){
            log.info("[{}] {}{} time={}ms", traceId.getId(), addSpace(COMPLETE_PREFIX, traceId.getLevel()), traceStatus.getMessage(), resultTimeMs);
        } else {
            log.info("[{}] {}{} time={}ms ex={}", traceId.getId(), addSpace(COMPLETE_PREFIX, traceId.getLevel()), traceStatus.getMessage(), resultTimeMs, e.toString());
        }
    }
}
