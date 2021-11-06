package yh.advanced.trace.strategy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV1 {
    private Strategy strategy;

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute(){
        long startTimeMs = System.currentTimeMillis();
        strategy.call();
        long endTimeMs = System.currentTimeMillis();
        long resultTime = endTimeMs - startTimeMs;
        log.info("resultTime = {}", resultTime);
    }

}
