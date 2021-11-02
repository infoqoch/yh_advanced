package yh.advanced.app.V1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yh.advanced.trace.TraceStatus;
import yh.advanced.trace.hellotrace.HelloTraceV1;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {
    private final OrderRepositoryV1 orderRepository;
    private final HelloTraceV1 helloTraceV1;

    public void orderItem(String itemId){
        TraceStatus begin = null;
        try{
            begin = helloTraceV1.begin("OrderServiceV1.orderItem");
            orderRepository.save(itemId);
            helloTraceV1.end(begin);
        }catch (Exception e){
            helloTraceV1.exception(begin, e);
            throw e;
        }

    }
}
