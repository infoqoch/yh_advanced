package yh.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import yh.advanced.trace.strategy.code.ContextV2;

@Slf4j
public class StrategyTestV2 {

    @Test
    void test(){
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(() -> log.info("생성자가 아닌 매개변수를 통한 값 주입"));
    }
}
