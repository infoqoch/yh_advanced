package yh.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import yh.advanced.trace.strategy.code.ContextV1;
import yh.advanced.trace.strategy.code.Strategy;
import yh.advanced.trace.strategy.code.StrategyLogic1;
import yh.advanced.trace.strategy.code.StrategyLogic2;

@Slf4j
public class StrategyTestV1 {

    @Test
    void test(){
        StrategyLogic1 strategy1 = new StrategyLogic1();
        ContextV1 context1 = new ContextV1(strategy1);
        context1.execute();

        StrategyLogic2 strategy2 = new StrategyLogic2();
        ContextV1 context2 = new ContextV1(strategy2);
        context2.execute();
    }

    @Test
    void test2(){
        Strategy strategy = new Strategy() {
            @Override
            public void call() {
                log.info("익명함수를 통해 객체 생성");
            }
        };
        ContextV1 contextV1 = new ContextV1(strategy);
        contextV1.execute();

        ContextV1 contextV12 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("익명함수를 변수 없이 생성");
            }
        });
        contextV12.execute();
    }

    @Test
    void test3(){
        ContextV1 contextV1 = new ContextV1(() -> log.info("람다를 통한 동작"));
        contextV1.execute();
    }

}
