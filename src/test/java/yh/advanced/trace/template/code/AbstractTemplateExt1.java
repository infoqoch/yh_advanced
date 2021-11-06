package yh.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;
import yh.advanced.trace.LogTrace;
import yh.advanced.trace.template.AbstractTemplate;

@Slf4j
public class AbstractTemplateExt1 extends AbstractTemplate {


    public AbstractTemplateExt1(LogTrace logTrace) {
        super(logTrace);
    }

    @Override
    protected String call() {
        log.info("첫 번째 비지니스 로직 작동");
        return "good job";
    }

}
