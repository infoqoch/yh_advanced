package yh.advanced.app.V4;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yh.advanced.trace.LogTrace;
import yh.advanced.trace.TraceStatus;
import yh.advanced.trace.template.AbstractTemplate;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {
    private final OrderRepositoryV4 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId){
        AbstractTemplate<Void>  template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                orderRepository.save(itemId);;
                return null;
            }
        };
        template.excute("OrderService.orderItem");

    }
}
