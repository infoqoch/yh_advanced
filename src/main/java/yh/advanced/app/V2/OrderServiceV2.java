package yh.advanced.app.V2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yh.advanced.trace.TraceStatus;
import yh.advanced.trace.hellotrace.HelloTraceV1;
import yh.advanced.trace.hellotrace.HelloTraceV2;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {
    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(String itemId, TraceStatus beforeStatus){
        TraceStatus status = null;
        try{
            status = trace.beginSync( beforeStatus, "OrderService.orderItem");
            orderRepository.save(itemId, status);
            trace.end(status);
        }catch (Exception e){
            trace.exception(status, e);
            throw e;
        }

    }
}
