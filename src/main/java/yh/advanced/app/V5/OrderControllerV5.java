package yh.advanced.app.V5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yh.advanced.trace.LogTrace;
import yh.advanced.trace.callback.TraceCallback;
import yh.advanced.trace.callback.TraceTemplate;

@RestController
public class OrderControllerV5 {
    private final OrderServiceV5 orderService;
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace logTrace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(logTrace);
    }

    @GetMapping("v5/request")
    public String request(String itemId) {

        return template.execute("OrderController.request", new TraceCallback<String>() {
            @Override
            public String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        });
    }
}
