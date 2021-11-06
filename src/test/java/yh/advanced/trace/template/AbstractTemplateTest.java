package yh.advanced.trace.template;

import org.junit.jupiter.api.Test;
import yh.advanced.trace.ThreadLocalLogTrace;
import yh.advanced.trace.template.code.AbstractTemplateExt1;

public class AbstractTemplateTest {

    @Test
    void test(){
        ThreadLocalLogTrace threadLocalLogTrace = new ThreadLocalLogTrace();
        AbstractTemplateExt1 ext1 = new AbstractTemplateExt1(threadLocalLogTrace);
        ext1.execute("TESTER");
    }
}
