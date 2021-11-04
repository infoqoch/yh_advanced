package yh.advanced.trace.threadlocal;

import org.junit.jupiter.api.Test;
import yh.advanced.trace.threadlocal.code.FieldService;

public class FieldServiceTest {

    @Test
    void test() throws InterruptedException {
        FieldService fieldService = new FieldService();
        Runnable userA = () -> fieldService.logic("userA");
        Runnable userB = () -> fieldService.logic("userB");

        Thread threadA = new Thread(userA);
        threadA.setName("threadA");

        Thread threadB = new Thread(userB);
        threadB.setName("threadA");

        threadA.start();

//        Thread.sleep(100);
        Thread.sleep(2000);

        threadB.start();

        Thread.sleep(2000);
    }
}
