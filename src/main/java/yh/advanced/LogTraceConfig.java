package yh.advanced;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yh.advanced.trace.FieldLogTrace;
import yh.advanced.trace.LogTrace;
import yh.advanced.trace.ThreadLocalLogTrace;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace trace(){
        return new ThreadLocalLogTrace();
//        return new FieldLogTrace();
    }


}
