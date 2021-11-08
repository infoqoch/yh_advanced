package yh.advanced.app.V5;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yh.advanced.trace.LogTrace;
import yh.advanced.trace.callback.TraceCallback;
import yh.advanced.trace.callback.TraceTemplate;
import yh.advanced.trace.template.AbstractTemplate;

@Service
public class OrderServiceV5 {
    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository,LogTrace logTrace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(logTrace);
    }

    public void orderItem(String itemId){
        template.execute("OrderService.orderItem",() -> {
            orderRepository.save(itemId);
            return null;
        });

    }
}
