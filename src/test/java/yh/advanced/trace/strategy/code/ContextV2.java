package yh.advanced.trace.strategy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV2 {
    public void execute(Strategy strategy){
        long startTimeMs = System.currentTimeMillis();
        strategy.call();
        long endTimeMs = System.currentTimeMillis();
        long resultTime = endTimeMs - startTimeMs;
        log.info("resultTime = {}", resultTime);
    }
}
