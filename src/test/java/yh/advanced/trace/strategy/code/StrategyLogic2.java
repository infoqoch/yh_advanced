package yh.advanced.trace.strategy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyLogic2 implements  Strategy{
    @Override
    public void call() {
        log.info("StrategyLogic2 비지니스 로직 작동");

    }
}
