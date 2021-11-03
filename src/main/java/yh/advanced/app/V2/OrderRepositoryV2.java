package yh.advanced.app.V2;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yh.advanced.trace.TraceStatus;
import yh.advanced.trace.hellotrace.HelloTraceV1;
import yh.advanced.trace.hellotrace.HelloTraceV2;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {
    private final HelloTraceV2 trace;

    public void save(String itemId, TraceStatus beforeStatus){
        TraceStatus status = null;
        try{
            status = trace.beginSync(beforeStatus, "OrderRepository.save");
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
