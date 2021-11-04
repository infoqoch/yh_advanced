package yh.advanced.trace;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalLogTrace implements LogTrace{
    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EX_PREFIX = "<X-";

    private ThreadLocal<TraceId> traceId = new ThreadLocal<>();

    @Override
    public TraceStatus begin(String message) {
        syncTraceId();
        long startTimeMs = System.currentTimeMillis();
        log.info("[{}] {}{}", traceId.get().getId(), addSpace(START_PREFIX, traceId.get().getLevel()), message);
        return new TraceStatus(traceId.get(), startTimeMs, message);
    }

    private String addSpace(String prefix, int level) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<level; i++){
            sb.append(i==level-1?"|"+prefix:"|    ");
        }
        return sb.toString();

    }

    private void syncTraceId() {
        if(traceId.get()==null){
            traceId.set(new TraceId());
        }else{
            traceId.set(traceId.get().createNextId());
        }
    }

    @Override
    public void end(TraceStatus status) {
        complete(status, null);
    }

    @Override
    public void exception(TraceStatus status, Exception e) {
        complete(status, e);
    }


    private void complete(TraceStatus status, Exception e) {
        Long stopTimeMs = System.currentTimeMillis();
        long resultTimeMs = stopTimeMs - status.getStartTimeMs();
        TraceId traceId = status.getTraceId();

        if (e == null) {
            log.info("[{}] {}{} time={}ms", traceId.getId(),
                    addSpace(COMPLETE_PREFIX, traceId.getLevel()), status.getMessage(),
                    resultTimeMs);
        } else {
            log.info("[{}] {}{} time={}ms ex={}", traceId.getId(),
                    addSpace(EX_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs,
                    e.toString());
        }
        releaseTraceId();
    }

    private void releaseTraceId() {
        if(traceId.get().isFirstLevel()){
            traceId.remove();
        }else{
            traceId.set(traceId.get().createPreviousId());
        }
    }
}
