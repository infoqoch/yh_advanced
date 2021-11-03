package yh.advanced;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yh.advanced.trace.FieldLogTrace;

@Configuration
public class LogTraceConfig {

    @Bean
    public FieldLogTrace logTrace(){
        return new FieldLogTrace();
    }
}
