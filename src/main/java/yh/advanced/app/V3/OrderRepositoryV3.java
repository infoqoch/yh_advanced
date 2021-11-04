package yh.advanced.app.V3;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yh.advanced.trace.FieldLogTrace;
import yh.advanced.trace.LogTrace;
import yh.advanced.trace.TraceStatus;
import yh.advanced.trace.hellotrace.HelloTraceV2;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {
    private final LogTrace trace;

    public void save(String itemId){
        TraceStatus status = null;
        try{
            status = trace.begin("OrderRepository.save");
            if(itemId.equals("ex")){
                throw new IllegalStateException("예외 발생!!");
            }
            sleep(1000);
            trace.end(status);
        }catch (Exception e){
            trace.exception(status, e);
            throw e;

        }

    }

    private void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
