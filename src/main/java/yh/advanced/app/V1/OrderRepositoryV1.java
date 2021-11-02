package yh.advanced.app.V1;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yh.advanced.trace.TraceStatus;
import yh.advanced.trace.hellotrace.HelloTraceV1;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {
    private final HelloTraceV1 helloTraceV1;

    public void save(String itemId){
        TraceStatus begin = null;
        try{
            begin = helloTraceV1.begin("OrderRepositoryV1.save");
            if(itemId.equals("ex")){
                throw new IllegalStateException("예외 발생!!");
            }
            sleep(1000);
            helloTraceV1.end(begin);
        }catch (Exception e){
            helloTraceV1.exception(begin, e);
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
