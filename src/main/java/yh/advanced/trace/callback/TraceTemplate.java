package yh.advanced.trace.callback;

import yh.advanced.trace.LogTrace;
import yh.advanced.trace.TraceStatus;

public class TraceTemplate {
    private final LogTrace logTrace;

    public TraceTemplate(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    public <T> T execute(String message, TraceCallback<T> callback){
        TraceStatus status = null;
        try{
            status = logTrace.begin(message);
            T result = callback.call();
            logTrace.end(status);
            return result;
        }catch (Exception e){
            logTrace.exception(status, e);
            throw e;
        }
    }
}
