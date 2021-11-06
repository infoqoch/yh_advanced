package yh.advanced.trace.template;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import yh.advanced.trace.LogTrace;
import yh.advanced.trace.ThreadLocalLogTrace;
import yh.advanced.trace.TraceStatus;

@Slf4j
public abstract class AbstractTemplate<T> {
    private final LogTrace logTrace;

    public AbstractTemplate(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    public T execute(String message){
        TraceStatus status = null;
        try{
            status = logTrace.begin(message);
            T call = call();
            logTrace.end(status);
            return call;
        }catch (Exception e){
            logTrace.exception(status, e);
            throw e;
        }
    }
    protected abstract T call();

}
